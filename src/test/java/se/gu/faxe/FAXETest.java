package se.gu.faxe;

import org.testng.annotations.Test;

import java.io.File;

public class FAXETest {

    @Test
    public void FAXE(){
        File f = new File(new File("").getAbsolutePath().concat("\\src\\test\\testdata\\bitcoin-wallet"));

        FAXE2 faxe = new FAXE2(f);

        //System.out.println("x");
    }

}