/*
 * Copyright 2013-2015 the original author or authors.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

package de.schildbach.wallet.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.net.Uri;
import android.support.v4.app.ShareCompat;
import android.support.v4.content.FileProvider;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import de.schildbach.wallet.Constants;
import de.schildbach.wallet.R;
import de.schildbach.wallet.util.CrashReporter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Nullable;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

//&begin[IssueReporter]
/**
 * @author Andreas Schildbach
 */
public abstract class ReportIssueDialogBuilder extends DialogBuilder implements OnClickListener {
    private final Activity activity;

    private EditText viewDescription;
    private CheckBox viewCollectDeviceInfo;	//&line[DeviceInfo]
    private CheckBox viewCollectInstalledPackages;	//&line[InstalledPackages]
    private CheckBox viewCollectApplicationLog;	//&line[AppLog]
    private CheckBox viewCollectWalletDump;	//&line[WalletDump]

    private static final Logger log = LoggerFactory.getLogger(ReportIssueDialogBuilder.class);

    public ReportIssueDialogBuilder(final Activity activity, final int titleResId, final int messageResId) {
        super(activity);

        this.activity = activity;

        final LayoutInflater inflater = LayoutInflater.from(activity);
        final View view = inflater.inflate(R.layout.report_issue_dialog, null);

        ((TextView) view.findViewById(R.id.report_issue_dialog_message)).setText(messageResId);

        viewDescription = (EditText) view.findViewById(R.id.report_issue_dialog_description);

        viewCollectDeviceInfo = (CheckBox) view.findViewById(R.id.report_issue_dialog_collect_device_info);	//&line[DeviceInfo]
        //&begin[InstalledPackages]
        viewCollectInstalledPackages = (CheckBox) view
                .findViewById(R.id.report_issue_dialog_collect_installed_packages);
        //&end[InstalledPackages]
        viewCollectApplicationLog = (CheckBox) view.findViewById(R.id.report_issue_dialog_collect_application_log);	//&line[AppLog]
        viewCollectWalletDump = (CheckBox) view.findViewById(R.id.report_issue_dialog_collect_wallet_dump);	//&line[WalletDump]

        setTitle(titleResId);
        setView(view);
        setPositiveButton(R.string.report_issue_dialog_report, this);
        setNegativeButton(R.string.button_cancel, null);
    }

    @Override
    public void onClick(final DialogInterface dialog, final int which) {
        final StringBuilder text = new StringBuilder();
        final List<Uri> attachments = new ArrayList<Uri>();
        final File cacheDir = activity.getCacheDir();
        final File reportDir = new File(cacheDir, "report");
        reportDir.mkdir();

        text.append(viewDescription.getText()).append('\n');

        try {
            final CharSequence contextualData = collectContextualData();
            if (contextualData != null) {
                text.append("\n\n\n=== contextual data ===\n\n");
                text.append(contextualData);
            }
        } catch (final IOException x) {
            text.append(x.toString()).append('\n');
        }

        try {
            text.append("\n\n\n=== application info ===\n\n");

            final CharSequence applicationInfo = collectApplicationInfo();

            text.append(applicationInfo);
        } catch (final IOException x) {
            text.append(x.toString()).append('\n');
        }

        try {
            final CharSequence stackTrace = collectStackTrace();

            if (stackTrace != null) {
                text.append("\n\n\n=== stack trace ===\n\n");
                text.append(stackTrace);
            }
        } catch (final IOException x) {
            text.append("\n\n\n=== stack trace ===\n\n");
            text.append(x.toString()).append('\n');
        }

        //&begin[DeviceInfo]
        if (viewCollectDeviceInfo.isChecked()) {
            try {
                text.append("\n\n\n=== device info ===\n\n");

                final CharSequence deviceInfo = collectDeviceInfo();

                text.append(deviceInfo);
            } catch (final IOException x) {
                text.append(x.toString()).append('\n');
            }
        }
        //&end[DeviceInfo]

        //&begin[InstalledPackages]
        if (viewCollectInstalledPackages.isChecked()) {
            try {
                text.append("\n\n\n=== installed packages ===\n\n");
                CrashReporter.appendInstalledPackages(text, activity);
            } catch (final IOException x) {
                text.append(x.toString()).append('\n');
            }
        }
        //&end[InstalledPackages]

        //&begin[AppLog]
        if (viewCollectApplicationLog.isChecked()) {
            final File logDir = new File(activity.getFilesDir(), "log");
            if (logDir.exists())
                for (final File logFile : logDir.listFiles())
                    if (logFile.isFile() && logFile.length() > 0)
                        attachments.add(FileProvider.getUriForFile(activity,
                                activity.getPackageName() + ".file_attachment", logFile));
        }
        //&end[AppLog]

        //&begin[WalletDump]
        if (viewCollectWalletDump.isChecked()) {
            try {
                final CharSequence walletDump = collectWalletDump();

                if (walletDump != null) {
                    final File file = File.createTempFile("wallet-dump.", ".txt", reportDir);

                    final Writer writer = new OutputStreamWriter(new FileOutputStream(file), StandardCharsets.UTF_8);
                    writer.write(walletDump.toString());
                    writer.close();

                    attachments.add(
                            FileProvider.getUriForFile(activity, activity.getPackageName() + ".file_attachment", file));
                }
            } catch (final IOException x) {
                log.info("problem writing attachment", x);
            }
        }
        //&end[WalletDump]

        try {
            final File savedBackgroundTraces = File.createTempFile("background-traces.", ".txt", reportDir);
            if (CrashReporter.collectSavedBackgroundTraces(savedBackgroundTraces)) {
                attachments.add(FileProvider.getUriForFile(activity, activity.getPackageName() + ".file_attachment",
                        savedBackgroundTraces));
            }
            savedBackgroundTraces.deleteOnExit();
        } catch (final IOException x) {
            log.info("problem writing attachment", x);
        }

        text.append("\n\nPUT ADDITIONAL COMMENTS TO THE TOP. DOWN HERE NOBODY WILL NOTICE.");

        startSend(subject(), text, attachments);
    }

    private void startSend(final String subject, final CharSequence text, final List<Uri> attachments) {
        final ShareCompat.IntentBuilder builder = ShareCompat.IntentBuilder.from(activity);
        for (final Uri attachment : attachments)
            builder.addStream(attachment);
        builder.addEmailTo(Constants.REPORT_EMAIL);
        if (subject != null)
            builder.setSubject(subject);
        builder.setText(text);
        builder.setType("text/plain");
        builder.setChooserTitle(R.string.report_issue_dialog_mail_intent_chooser);
        builder.startChooser();
        log.info("invoked chooser for sending issue report");
    }

    @Nullable
    protected abstract String subject();

    @Nullable
    protected CharSequence collectApplicationInfo() throws IOException {
        return null;
    }

    @Nullable
    protected CharSequence collectStackTrace() throws IOException {
        return null;
    }

    //&begin[DeviceInfo]
    @Nullable
    protected CharSequence collectDeviceInfo() throws IOException {
        return null;
    }
    //&end[DeviceInfo]

    @Nullable
    protected CharSequence collectContextualData() throws IOException {
        return null;
    }

    //&begin[WalletDump]
    @Nullable
    protected CharSequence collectWalletDump() throws IOException {
        return null;
    }
    //&end[WalletDump]
}
//&end[IssueReporter]