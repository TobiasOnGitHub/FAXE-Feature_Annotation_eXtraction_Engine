package se.gu.faxe.commands;

import org.testng.annotations.Test;
import picocli.CommandLine;

import java.io.File;
import java.io.PrintWriter;
import java.io.StringWriter;

import static org.testng.Assert.*;

public class CommandLineUtilityCheckConsistencyTest {

    @Test
    public void testCall_checkConsistency_WalletTransactionsFragment() {
        CommandLineUtility app = new CommandLineUtility();
        CommandLine cmd = new CommandLine(app);

        StringWriter sw = new StringWriter();
        cmd.setOut(new PrintWriter(sw));

        int exitCode = cmd.execute("checkConsistency", new File("").getAbsolutePath().concat("/src/test/testdata/bitcoin-wallet/ui/WalletTransactionsFragment.java"));
        assertEquals(0, exitCode);
    }

    @Test
    public void testCall_checkConsistency_ui() {
        CommandLineUtility app = new CommandLineUtility();
        CommandLine cmd = new CommandLine(app);

        StringWriter sw = new StringWriter();
        cmd.setOut(new PrintWriter(sw));

        int exitCode = cmd.execute("checkConsistency", new File("").getAbsolutePath().concat("/src/test/testdata/bitcoin-wallet/ui"));
        assertEquals(0, exitCode);
    }

}