package se.gu.faxe;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import se.gu.faxe.Grammar.codeAnnotationLexer;
import se.gu.faxe.Grammar.codeAnnotationParser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class codeAnnotationsTest {

    @DataProvider
    public Object[][] provide_StrUnderTest_ExpResult_VALID(){
        return new Object[][]{
                // BEGINMARKER
                {"&begin a", new ArrayList(){{
                        add(new EmbeddedAnnotation(EmbeddedAnnotation.eEAType.BEGIN, null, 1, -1, "a"));
                    }}
                },
                {"&begin[a] source", new ArrayList(){{
                        add(new EmbeddedAnnotation(EmbeddedAnnotation.eEAType.BEGIN, null, 1, -1, "a"));
                    }}
                },
                {"&begin[a]source", new ArrayList(){{
                        add(new EmbeddedAnnotation(EmbeddedAnnotation.eEAType.BEGIN, null, 1, -1, "a"));
                    }}
                },
                {"source&begin(a)", new ArrayList(){{
                        add(new EmbeddedAnnotation(EmbeddedAnnotation.eEAType.BEGIN, null, 1, -1, "a"));
                    }}
                },
                {"source &line(a)", new ArrayList(){{
                        add(new EmbeddedAnnotation(EmbeddedAnnotation.eEAType.LINE,  null, 1, 1, "a"));
                    }}
                },
                {"&begin a", new ArrayList(){{
                        add(new EmbeddedAnnotation(EmbeddedAnnotation.eEAType.BEGIN, null, 1, -1, "a"));
                    }}
                },
                {"&end a", new ArrayList(){{
                        add(new EmbeddedAnnotation(EmbeddedAnnotation.eEAType.END, null, -1, 1, "a"));
                    }}
                },
                {"&line a", new ArrayList(){{
                        add(new EmbeddedAnnotation(EmbeddedAnnotation.eEAType.LINE, null,  1, 1, "a"));
                    }}
                },
                {"&begin(a)", new ArrayList(){{
                        add(new EmbeddedAnnotation(EmbeddedAnnotation.eEAType.BEGIN, null, 1, -1, "a"));
                    }}
                },
                {"&begin[a]", new ArrayList(){{
                        add(new EmbeddedAnnotation(EmbeddedAnnotation.eEAType.BEGIN, null, 1, -1, "a"));
                    }}
                },
                {"&begin{a}", new ArrayList(){{
                        add(new EmbeddedAnnotation(EmbeddedAnnotation.eEAType.BEGIN, null, 1, -1, "a"));
                    }}
                },
                {"&end (a1)", new ArrayList(){{
                        add(new EmbeddedAnnotation(EmbeddedAnnotation.eEAType.END, null,   -1, 1, "a1"));
                    }}
                },
                {"&end  (a2)", new ArrayList(){{
                        add(new EmbeddedAnnotation(EmbeddedAnnotation.eEAType.END, null,   -1, 1, "a2"));
                    }}
                },
                {"&end (a3) ", new ArrayList(){{
                        add(new EmbeddedAnnotation(EmbeddedAnnotation.eEAType.END, null,   -1, 1, "a3"));
                    }}
                },
                {"&end (a4)  ", new ArrayList(){{
                        add(new EmbeddedAnnotation(EmbeddedAnnotation.eEAType.END, null,   -1, 1, "a4"));
                    }}
                },
                {"&line(a,b)",        new ArrayList(){{
                        add(new EmbeddedAnnotation(EmbeddedAnnotation.eEAType.LINE, null, 1, 1, "a"));
                        add(new EmbeddedAnnotation(EmbeddedAnnotation.eEAType.LINE, null, 1, 1, "b"));
                    }}
                },
//                {"&line(a b)",        new ArrayList(){{       // TODO - How to change Grammar to support space a separator character?!
//                      add(new FAXE.EmbeddedAnnotation(FAXE.EmbeddedAnnotation.eEAType.eaType_LINE, 1, 1, "a"));
//                      add(new FAXE.EmbeddedAnnotation(FAXE.EmbeddedAnnotation.eEAType.eaType_LINE, 1, 1, "b"));
//                  }}
//                },
//                {"&line(a  b)",        new ArrayList(){{       // TODO - How to change Grammar to support space a separator character?!
//                      add(new FAXE.EmbeddedAnnotation(FAXE.EmbeddedAnnotation.eEAType.eaType_LINE, 1, 1, "a"));
//                      add(new FAXE.EmbeddedAnnotation(FAXE.EmbeddedAnnotation.eEAType.eaType_LINE, 1, 1, "b"));
//                  }}
//                },
//                {"&line(a b    )",        new ArrayList(){{       // TODO - How to change Grammar to support space a separator character?!
//                      add(new FAXE.EmbeddedAnnotation(FAXE.EmbeddedAnnotation.eEAType.eaType_LINE, 1, 1, "a"));
//                      add(new FAXE.EmbeddedAnnotation(FAXE.EmbeddedAnnotation.eEAType.eaType_LINE, 1, 1, "b"));
//                  }}
//                },
//                {"&line(    a b)",        new ArrayList(){{       // TODO - How to change Grammar to support space a separator character?!
//                      add(new FAXE.EmbeddedAnnotation(FAXE.EmbeddedAnnotation.eEAType.eaType_LINE, 1, 1, "a"));
//                      add(new FAXE.EmbeddedAnnotation(FAXE.EmbeddedAnnotation.eEAType.eaType_LINE, 1, 1, "b"));
//                  }}
//                },
//                {"&line(a b c)", new ArrayList() {{
//                    add(new FAXE.EmbeddedAnnotation(FAXE.EmbeddedAnnotation.eEAType.eaType_LINE, 1, 1, "a"));
//                    add(new FAXE.EmbeddedAnnotation(FAXE.EmbeddedAnnotation.eEAType.eaType_LINE, 1, 1, "b"));
//                    add(new FAXE.EmbeddedAnnotation(FAXE.EmbeddedAnnotation.eEAType.eaType_LINE, 1, 1, "c"));
//                }}
//                },
                {"&line(a,b,c)", new ArrayList() {{
                    add(new EmbeddedAnnotation(EmbeddedAnnotation.eEAType.LINE, null, 1, 1, "a"));
                    add(new EmbeddedAnnotation(EmbeddedAnnotation.eEAType.LINE, null, 1, 1, "b"));
                    add(new EmbeddedAnnotation(EmbeddedAnnotation.eEAType.LINE, null, 1, 1, "c"));
                }}
                },
                {"&begin(feature)", new ArrayList() {{
                    add(new EmbeddedAnnotation(EmbeddedAnnotation.eEAType.BEGIN, null, 1, -1, "feature"));
                }}
                },
                {"&begin(fEATURE)", new ArrayList(){{
                    add(new EmbeddedAnnotation(EmbeddedAnnotation.eEAType.BEGIN, null,   1, -1, "fEATURE"));
                }}
                },
                {"&begin(f1)", new ArrayList(){{
                    add(new EmbeddedAnnotation(EmbeddedAnnotation.eEAType.BEGIN, null,   1, -1, "f1"));
                }}
                },
                {"&begin(1F)", new ArrayList(){{
                    add(new EmbeddedAnnotation(EmbeddedAnnotation.eEAType.BEGIN, null,   1, -1, "1F"));
                }}
                },
                {"&begin(thisIsALongFeatureName)", new ArrayList(){{
                    add(new EmbeddedAnnotation(EmbeddedAnnotation.eEAType.BEGIN, null,   1, -1, "thisIsALongFeatureName"));
                }}
                },
//                {"&begin(feature FEATURE)", new ArrayList(){{
//                    add(new FAXE.EmbeddedAnnotation(FAXE.EmbeddedAnnotation.eEAType.eaType_BEGIN,   1, -1, "thisIsALongFeatureName"));
//                }}
//                },
                {"&begin(f1,f2,f3)", new ArrayList(){{
                    add(new EmbeddedAnnotation(EmbeddedAnnotation.eEAType.BEGIN, null,   1, -1, "f1"));
                    add(new EmbeddedAnnotation(EmbeddedAnnotation.eEAType.BEGIN, null,   1, -1, "f2"));
                    add(new EmbeddedAnnotation(EmbeddedAnnotation.eEAType.BEGIN, null,   1, -1, "f3"));
                }}
                },
//                {"&begin(aBcD1Ef fE2DcBa)", new FAXE.EmbeddedAnnotation(FAXE.EmbeddedAnnotation.eEAType.eaType_BEGIN,1, -1, "a")},
//                {"&begin(abcdefghijklmnopqrstuvwxyz 0123456789)", new FAXE.EmbeddedAnnotation(FAXE.EmbeddedAnnotation.eEAType.eaType_BEGIN,1, -1, "a")},
//                {"&begin(Parent::Child)", new FAXE.EmbeddedAnnotation(FAXE.EmbeddedAnnotation.eEAType.eaType_BEGIN,1, -1, "a")},
//                {"&begin(Parent::Child::Grandchild)", new FAXE.EmbeddedAnnotation(FAXE.EmbeddedAnnotation.eEAType.eaType_BEGIN,1, -1, "a")},
//                {"&begin(Parent::Child::GrandChild::GrandGrandChild)", true}{"&begin(Child::Grandchild)", new FAXE.EmbeddedAnnotation(FAXE.EmbeddedAnnotation.eEAType.eaType_BEGIN,1, -1, "a")},
//                {"&begin(Parent::Child Child::Grandchild)", new FAXE.EmbeddedAnnotation(FAXE.EmbeddedAnnotation.eEAType.eaType_BEGIN,1, -1, "a")},
//                {"&end(Parent::Child,Child::Grandchild)", new FAXE.EmbeddedAnnotation(FAXE.EmbeddedAnnotation.eEAType.eaType_BEGIN,1, -1, "a")},
//                {"&end(Parent::Child, Child::Grandchild)", new FAXE.EmbeddedAnnotation(FAXE.EmbeddedAnnotation.eEAType.eaType_BEGIN,1, -1, "a")},
//                {"&line(Parent::Child ,Child::Grandchild)", new FAXE.EmbeddedAnnotation(FAXE.EmbeddedAnnotation.eEAType.eaType_BEGIN,1, -1, "a")},
//                {"&line(Parent::Child    ,        Child::Grandchild   )", new FAXE.EmbeddedAnnotation(FAXE.EmbeddedAnnotation.eEAType.eaType_BEGIN,1, -1, "a")},
//                {"&end(Parent::Child,Child::Grandchild     )", new FAXE.EmbeddedAnnotation(FAXE.EmbeddedAnnotation.eEAType.eaType_BEGIN,1, -1, "a")},
//                {"&end(     Parent::Child,Child::Grandchild)", new FAXE.EmbeddedAnnotation(FAXE.EmbeddedAnnotation.eEAType.eaType_BEGIN,1, -1, "a")},
                //TODO - Real world examples
        };
    }

//    @Test(dataProvider = "provide_StrUnderTest_ExpResult_VALID")
//    public void validEmbeddedCodeAnnotations(String strUnderTest, boolean expResult){
//
//        boolean ret = GrammarLaunch.parseCodeAnnotationLine(strUnderTest);
//
//        Assert.assertEquals(ret, expResult);
//    }

    @Test(dataProvider = "provide_StrUnderTest_ExpResult_VALID")
    public void testCodeAnnotation_GrammarCheck_SingleLine_VALID(String strUnderTest, List<EmbeddedAnnotation> expResult){

        CharStream in = CharStreams.fromString(strUnderTest);
        codeAnnotationLexer lexer = new codeAnnotationLexer(in);
        lexer.addErrorListener(ThrowingErrorListener.INSTANCE);
        CommonTokenStream token = new CommonTokenStream(lexer);
        codeAnnotationParser parser = new codeAnnotationParser(token);
        parser.removeErrorListeners();
        parser.addErrorListener(ThrowingErrorListener.INSTANCE);
        ParseTree tree = parser.marker();

        MyCodeAnnotationsVisitor visitor = new MyCodeAnnotationsVisitor();
        List<EmbeddedAnnotation> eaList = (List<EmbeddedAnnotation>) visitor.visit(tree);

        if(eaList.size()!=expResult.size()){
            System.out.println("eaList   : " +eaList.toString());
            System.out.println("expResult: " +expResult.toString());
        }

        Assert.assertEquals(eaList.size(),expResult.size());

        boolean bCompareLists = eaList.equals(expResult);
        if(!bCompareLists){
            System.out.println("Difference between elements:");
        }
        Assert.assertTrue(bCompareLists);

        System.out.println("After Test");
    }




    @DataProvider
    public Object[][] provide_StrUnderTest_ExpResult_INVALID(){
        return new Object[][]{
                // MARKERS UNKNOWN
                {"&fun a", false},
                {"&aun a", false},
                {"Bla a", false},

                // BEGINMARKER
                {"begin a", false},
                {"&begin", false},
                {"&begin ", false},
                {" &begin ", false},

                // ENDMARKER
                {"end b", false},

                // LINEMARKER
                {"line a", false},

                // PARAMETER

                // ANNOSEPARATOR

                // COMMENT

                // LPQ

                // STRING
        };
    }

//    @Test(dataProvider = "provide_StrUnderTest_ExpResult_INVALID")
//    public void invalidEmbeddedCodeAnnotations(String strUnderTest, boolean expResult){
//
//        boolean ret = GrammarLaunch.parseCodeAnnotationLine(strUnderTest);
//
//        Assert.assertEquals(ret, expResult);
//    }

    @Test(dataProvider = "provide_StrUnderTest_ExpResult_INVALID")
    public void testCodeAnnotation_GrammarCheck_SingleLine_INVALID(String strUnderTest, boolean expResult){

        CharStream in = CharStreams.fromString(strUnderTest);
        codeAnnotationLexer lexer = new codeAnnotationLexer(in);
        lexer.addErrorListener(ThrowingErrorListener.INSTANCE);
        CommonTokenStream token = new CommonTokenStream(lexer);
        codeAnnotationParser parser = new codeAnnotationParser(token);
        parser.removeErrorListeners();
        parser.addErrorListener(ThrowingErrorListener.INSTANCE);
        ParseTree tree = parser.marker();

        MyCodeAnnotationsVisitor visitor = new MyCodeAnnotationsVisitor();
        List<EmbeddedAnnotation> eaList = (List<EmbeddedAnnotation>) visitor.visit(tree);

        Assert.assertEquals(eaList.size(),0);
    }


    @Test
    public void testCodeAnnotation_GrammarCheck_File_testData_codeAnnotations(){
        CharStream in = null;
        try {
            in = CharStreams.fromFileName("test/testData_codeAnnotations.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
        codeAnnotationLexer lexer = new codeAnnotationLexer(in);
        lexer.addErrorListener(ThrowingErrorListener.INSTANCE);
        CommonTokenStream token = new CommonTokenStream(lexer);
        codeAnnotationParser parser = new codeAnnotationParser(token);
        parser.removeErrorListeners();
        parser.addErrorListener(ThrowingErrorListener.INSTANCE);
        ParseTree tree = parser.marker();

        MyCodeAnnotationsVisitor visitor = new MyCodeAnnotationsVisitor();
        List<EmbeddedAnnotation> eaList = (List<EmbeddedAnnotation>) visitor.visit(tree);


        List<EmbeddedAnnotation> expResult = new ArrayList(){{
            add(new EmbeddedAnnotation(EmbeddedAnnotation.eEAType.FRAGMENT, null,   2, 4, "featureA"));
            add(new EmbeddedAnnotation(EmbeddedAnnotation.eEAType.FRAGMENT, null,   2, 7, "featureB"));
            add(new EmbeddedAnnotation(EmbeddedAnnotation.eEAType.LINE, null,       6, 6, "featureLine1"));
            add(new EmbeddedAnnotation(EmbeddedAnnotation.eEAType.LINE, null,       8, 8, "featureLine2"));
            add(new EmbeddedAnnotation(EmbeddedAnnotation.eEAType.LINE, null,       8, 8, "featureLine3"));
            add(new EmbeddedAnnotation(EmbeddedAnnotation.eEAType.LINE, null,       8, 8, "featureLine4"));
        }};

        Assert.assertEquals(eaList.size(),expResult.size());

        boolean bCompareLists = eaList.equals(expResult);
        if(!bCompareLists){
            System.out.println("Difference between elements:");
        }
        Assert.assertTrue(bCompareLists);
    }


    @Test
    public void testCodeAnnotation_GrammarCheck_File_Configuration(){
        CharStream in = null;
        try {
            in = CharStreams.fromFileName("test/testProjectBitcoinWallet/src/de/schildbach/wallet/Configuration.java");
        } catch (IOException e) {
            e.printStackTrace();
        }
        codeAnnotationLexer lexer = new codeAnnotationLexer(in);
        lexer.addErrorListener(ThrowingErrorListener.INSTANCE);
        CommonTokenStream token = new CommonTokenStream(lexer);
        codeAnnotationParser parser = new codeAnnotationParser(token);
        parser.removeErrorListeners();
        parser.addErrorListener(ThrowingErrorListener.INSTANCE);
        ParseTree tree = parser.marker();

        MyCodeAnnotationsVisitor visitor = new MyCodeAnnotationsVisitor();
        List<EmbeddedAnnotation> eaList = (List<EmbeddedAnnotation>) visitor.visit(tree);

        List<EmbeddedAnnotation> expResult = new ArrayList(){{
            add(new EmbeddedAnnotation(EmbeddedAnnotation.eEAType.LINE,     null,   46, 46, "Denomination"));
            add(new EmbeddedAnnotation(EmbeddedAnnotation.eEAType.LINE,     null,   49, 49, "AutoCloseSendDialog"));
            add(new EmbeddedAnnotation(EmbeddedAnnotation.eEAType.LINE,      null,  51, 51, "ConnectivityIndicator"));
            add(new EmbeddedAnnotation(EmbeddedAnnotation.eEAType.LINE,     null,   53, 53, "ExchangeRates"));
            add(new EmbeddedAnnotation(EmbeddedAnnotation.eEAType.FRAGMENT, null,   54, 57, "TrustedPeer"));
            add(new EmbeddedAnnotation(EmbeddedAnnotation.eEAType.LINE,     null,   59, 59, "BlockExplorer"));
            add(new EmbeddedAnnotation(EmbeddedAnnotation.eEAType.LINE,     null,   61, 61, "DataUsage"));
            add(new EmbeddedAnnotation(EmbeddedAnnotation.eEAType.LINE,     null,   63, 63, "BalanceReminder"));
            add(new EmbeddedAnnotation(EmbeddedAnnotation.eEAType.LINE,     null,   65, 65, "ShowDisclaimer"));
            add(new EmbeddedAnnotation(EmbeddedAnnotation.eEAType.FRAGMENT, null,   70, 75, "ExchangeRates"));
            add(new EmbeddedAnnotation(EmbeddedAnnotation.eEAType.FRAGMENT,   null, 77, 80, "BackupReminder"));
            add(new EmbeddedAnnotation(EmbeddedAnnotation.eEAType.LINE,      null,  82, 82, "Bluetooth"));
            add(new EmbeddedAnnotation(EmbeddedAnnotation.eEAType.FRAGMENT,  null,  84, 87, "Denomination"));
            add(new EmbeddedAnnotation(EmbeddedAnnotation.eEAType.FRAGMENT,  null,  98, 144, "Denomination"));
            add(new EmbeddedAnnotation(EmbeddedAnnotation.eEAType.FRAGMENT,   null, 146, 150, "OwnName"));
            add(new EmbeddedAnnotation(EmbeddedAnnotation.eEAType.FRAGMENT,   null, 152, 156, "AutoCloseSendDialog"));
            add(new EmbeddedAnnotation(EmbeddedAnnotation.eEAType.FRAGMENT,   null, 158, 162, "ConnectivityIndicator"));
            add(new EmbeddedAnnotation(EmbeddedAnnotation.eEAType.FRAGMENT,   null, 164, 172, "TrustedPeer"));
            add(new EmbeddedAnnotation(EmbeddedAnnotation.eEAType.FRAGMENT,   null, 174, 179, "BlockExplorer"));
            add(new EmbeddedAnnotation(EmbeddedAnnotation.eEAType.FRAGMENT,   null, 181, 189, "BalanceReminder"));
            add(new EmbeddedAnnotation(EmbeddedAnnotation.eEAType.FRAGMENT,   null, 191, 208, "BackupReminder"));
            add(new EmbeddedAnnotation(EmbeddedAnnotation.eEAType.FRAGMENT,   null, 210, 214, "ShowDisclaimer"));
            add(new EmbeddedAnnotation(EmbeddedAnnotation.eEAType.FRAGMENT,    null,216, 224, "ExchangeRates"));
            add(new EmbeddedAnnotation(EmbeddedAnnotation.eEAType.FRAGMENT,    null,258, 260, "Log"));
            add(new EmbeddedAnnotation(EmbeddedAnnotation.eEAType.FRAGMENT,    null,272, 302, "ExchangeRates"));
            add(new EmbeddedAnnotation(EmbeddedAnnotation.eEAType.FRAGMENT,    null,316, 321, "Bluetooth"));
        }};

        Assert.assertEquals(eaList.size(),expResult.size());

        boolean bCompareLists = eaList.equals(expResult);
        if(!bCompareLists){
            System.out.println("Difference between elements:");
            int size = (eaList.size()>expResult.size()? eaList.size(): expResult.size());
            for(int i=0; i<size; i++){
                if(!eaList.get(i).equals(expResult.get(i))){
                    System.out.println("eaList=" +eaList.get(i).toString() +" --- expResult=" +expResult.get(i).toString());
                }

            }
        }
        Assert.assertTrue(bCompareLists);
    }

    @Test
    public void testCodeAnnotation_extractEAfromSourceCode(){

        String filePath = "test\\testData_codeAnnotations.txt";
        List<EmbeddedAnnotation> eaList = FAXE.extractEAfromSourceCode(filePath);

        System.out.println("x");
    }
}
