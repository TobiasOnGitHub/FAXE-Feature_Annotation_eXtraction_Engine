package se.gu.faxe.commands;

import org.testng.annotations.Test;
import picocli.CommandLine;

import java.io.File;
import java.io.PrintWriter;
import java.io.StringWriter;

import static org.testng.Assert.*;

public class CommandLineUtilityRenameTest {

    @Test
    public void testCall_Rename_WalletTransactionsFragment() {
        CommandLineUtility app = new CommandLineUtility();
        CommandLine cmd = new CommandLine(app);

        StringWriter sw = new StringWriter();
        cmd.setOut(new PrintWriter(sw));

        int exitCode = cmd.execute("rename", new File("").getAbsolutePath().concat("\\src\\test\\testdata\\bitcoin-wallet\\ui\\WalletTransactionsFragment.java"), "FromFeatureName", "ToFeatureName");
        assertEquals(0, exitCode);
    }

    @Test
    public void testCall_Rename_ui() {
        CommandLineUtility app = new CommandLineUtility();
        CommandLine cmd = new CommandLine(app);

        StringWriter sw = new StringWriter();
        cmd.setOut(new PrintWriter(sw));

        int exitCode = cmd.execute("rename", new File("").getAbsolutePath().concat("\\src\\test\\testdata\\bitcoin-wallet\\ui"), "FromFeatureName", "ToFeatureName");
        assertEquals(0, exitCode);
    }
}