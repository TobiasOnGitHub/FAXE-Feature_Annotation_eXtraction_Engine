import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class codeAnnotationsTest {

    @DataProvider
    public Object[][] provide_StrUnderTest_ExpResult_VALID(){
        return new Object[][]{
                // BEGINMARKER
                {"&begin a", new ArrayList(){{
                        add(new EmbeddedAnnotation(EmbeddedAnnotation.eEAType.eaType_BEGIN, 1, -1, "a"));
                    }}
                },
                {"&begin[a] source", new ArrayList(){{
                        add(new EmbeddedAnnotation(EmbeddedAnnotation.eEAType.eaType_BEGIN, 1, -1, "a"));
                    }}
                },
                {"&begin[a]source", new ArrayList(){{
                        add(new EmbeddedAnnotation(EmbeddedAnnotation.eEAType.eaType_BEGIN, 1, -1, "a"));
                    }}
                },
                {"source&begin(a)", new ArrayList(){{
                        add(new EmbeddedAnnotation(EmbeddedAnnotation.eEAType.eaType_BEGIN, 1, -1, "a"));
                    }}
                },
                {"source &line(a)", new ArrayList(){{
                        add(new EmbeddedAnnotation(EmbeddedAnnotation.eEAType.eaType_LINE,  1, 1, "a"));
                    }}
                },
                {"&begin a", new ArrayList(){{
                        add(new EmbeddedAnnotation(EmbeddedAnnotation.eEAType.eaType_BEGIN, 1, -1, "a"));
                    }}
                },
                {"&end a", new ArrayList(){{
                        add(new EmbeddedAnnotation(EmbeddedAnnotation.eEAType.eaType_END, -1, 1, "a"));
                    }}
                },
                {"&line a", new ArrayList(){{
                        add(new EmbeddedAnnotation(EmbeddedAnnotation.eEAType.eaType_LINE,  1, 1, "a"));
                    }}
                },
                {"&begin(a)", new ArrayList(){{
                        add(new EmbeddedAnnotation(EmbeddedAnnotation.eEAType.eaType_BEGIN, 1, -1, "a"));
                    }}
                },
                {"&begin[a]", new ArrayList(){{
                        add(new EmbeddedAnnotation(EmbeddedAnnotation.eEAType.eaType_BEGIN, 1, -1, "a"));
                    }}
                },
                {"&begin{a}", new ArrayList(){{
                        add(new EmbeddedAnnotation(EmbeddedAnnotation.eEAType.eaType_BEGIN, 1, -1, "a"));
                    }}
                },
                {"&end (a1)", new ArrayList(){{
                        add(new EmbeddedAnnotation(EmbeddedAnnotation.eEAType.eaType_END,   -1, 1, "a1"));
                    }}
                },
                {"&end  (a2)", new ArrayList(){{
                        add(new EmbeddedAnnotation(EmbeddedAnnotation.eEAType.eaType_END,   -1, 1, "a2"));
                    }}
                },
                {"&end (a3) ", new ArrayList(){{
                        add(new EmbeddedAnnotation(EmbeddedAnnotation.eEAType.eaType_END,   -1, 1, "a3"));
                    }}
                },
                {"&end (a4)  ", new ArrayList(){{
                        add(new EmbeddedAnnotation(EmbeddedAnnotation.eEAType.eaType_END,   -1, 1, "a4"));
                    }}
                },
                {"&line(a,b)",        new ArrayList(){{
                        add(new EmbeddedAnnotation(EmbeddedAnnotation.eEAType.eaType_LINE, 1, 1, "a"));
                        add(new EmbeddedAnnotation(EmbeddedAnnotation.eEAType.eaType_LINE, 1, 1, "b"));
                    }}
                },
//                {"&line(a b)",        new ArrayList(){{       // TODO - How to change Grammar to support space a separator character?!
//                      add(new EmbeddedAnnotation(EmbeddedAnnotation.eEAType.eaType_LINE, 1, 1, "a"));
//                      add(new EmbeddedAnnotation(EmbeddedAnnotation.eEAType.eaType_LINE, 1, 1, "b"));
//                  }}
//                },
//                {"&line(a  b)",        new ArrayList(){{       // TODO - How to change Grammar to support space a separator character?!
//                      add(new EmbeddedAnnotation(EmbeddedAnnotation.eEAType.eaType_LINE, 1, 1, "a"));
//                      add(new EmbeddedAnnotation(EmbeddedAnnotation.eEAType.eaType_LINE, 1, 1, "b"));
//                  }}
//                },
//                {"&line(a b    )",        new ArrayList(){{       // TODO - How to change Grammar to support space a separator character?!
//                      add(new EmbeddedAnnotation(EmbeddedAnnotation.eEAType.eaType_LINE, 1, 1, "a"));
//                      add(new EmbeddedAnnotation(EmbeddedAnnotation.eEAType.eaType_LINE, 1, 1, "b"));
//                  }}
//                },
//                {"&line(    a b)",        new ArrayList(){{       // TODO - How to change Grammar to support space a separator character?!
//                      add(new EmbeddedAnnotation(EmbeddedAnnotation.eEAType.eaType_LINE, 1, 1, "a"));
//                      add(new EmbeddedAnnotation(EmbeddedAnnotation.eEAType.eaType_LINE, 1, 1, "b"));
//                  }}
//                },
//                {"&line(a b c)", new ArrayList() {{
//                    add(new EmbeddedAnnotation(EmbeddedAnnotation.eEAType.eaType_LINE, 1, 1, "a"));
//                    add(new EmbeddedAnnotation(EmbeddedAnnotation.eEAType.eaType_LINE, 1, 1, "b"));
//                    add(new EmbeddedAnnotation(EmbeddedAnnotation.eEAType.eaType_LINE, 1, 1, "c"));
//                }}
//                },
                {"&line(a,b,c)", new ArrayList() {{
                    add(new EmbeddedAnnotation(EmbeddedAnnotation.eEAType.eaType_LINE, 1, 1, "a"));
                    add(new EmbeddedAnnotation(EmbeddedAnnotation.eEAType.eaType_LINE, 1, 1, "b"));
                    add(new EmbeddedAnnotation(EmbeddedAnnotation.eEAType.eaType_LINE, 1, 1, "c"));
                }}
                },
                {"&begin(feature)", new ArrayList() {{
                    add(new EmbeddedAnnotation(EmbeddedAnnotation.eEAType.eaType_BEGIN, 1, -1, "feature"));
                }}
                },
                {"&begin(fEATURE)", new ArrayList(){{
                    add(new EmbeddedAnnotation(EmbeddedAnnotation.eEAType.eaType_BEGIN,   1, -1, "fEATURE"));
                }}
                },
                {"&begin(f1)", new ArrayList(){{
                    add(new EmbeddedAnnotation(EmbeddedAnnotation.eEAType.eaType_BEGIN,   1, -1, "f1"));
                }}
                },
                {"&begin(1F)", new ArrayList(){{
                    add(new EmbeddedAnnotation(EmbeddedAnnotation.eEAType.eaType_BEGIN,   1, -1, "1F"));
                }}
                },
                {"&begin(thisIsALongFeatureName)", new ArrayList(){{
                    add(new EmbeddedAnnotation(EmbeddedAnnotation.eEAType.eaType_BEGIN,   1, -1, "thisIsALongFeatureName"));
                }}
                },
//                {"&begin(feature FEATURE)", new ArrayList(){{
//                    add(new EmbeddedAnnotation(EmbeddedAnnotation.eEAType.eaType_BEGIN,   1, -1, "thisIsALongFeatureName"));
//                }}
//                },
                {"&begin(f1,f2,f3)", new ArrayList(){{
                    add(new EmbeddedAnnotation(EmbeddedAnnotation.eEAType.eaType_BEGIN,   1, -1, "f1"));
                    add(new EmbeddedAnnotation(EmbeddedAnnotation.eEAType.eaType_BEGIN,   1, -1, "f2"));
                    add(new EmbeddedAnnotation(EmbeddedAnnotation.eEAType.eaType_BEGIN,   1, -1, "f3"));
                }}
                },
//                {"&begin(aBcD1Ef fE2DcBa)", new EmbeddedAnnotation(EmbeddedAnnotation.eEAType.eaType_BEGIN,1, -1, "a")},
//                {"&begin(abcdefghijklmnopqrstuvwxyz 0123456789)", new EmbeddedAnnotation(EmbeddedAnnotation.eEAType.eaType_BEGIN,1, -1, "a")},
//                {"&begin(Parent::Child)", new EmbeddedAnnotation(EmbeddedAnnotation.eEAType.eaType_BEGIN,1, -1, "a")},
//                {"&begin(Parent::Child::Grandchild)", new EmbeddedAnnotation(EmbeddedAnnotation.eEAType.eaType_BEGIN,1, -1, "a")},
//                {"&begin(Parent::Child::GrandChild::GrandGrandChild)", true}{"&begin(Child::Grandchild)", new EmbeddedAnnotation(EmbeddedAnnotation.eEAType.eaType_BEGIN,1, -1, "a")},
//                {"&begin(Parent::Child Child::Grandchild)", new EmbeddedAnnotation(EmbeddedAnnotation.eEAType.eaType_BEGIN,1, -1, "a")},
//                {"&end(Parent::Child,Child::Grandchild)", new EmbeddedAnnotation(EmbeddedAnnotation.eEAType.eaType_BEGIN,1, -1, "a")},
//                {"&end(Parent::Child, Child::Grandchild)", new EmbeddedAnnotation(EmbeddedAnnotation.eEAType.eaType_BEGIN,1, -1, "a")},
//                {"&line(Parent::Child ,Child::Grandchild)", new EmbeddedAnnotation(EmbeddedAnnotation.eEAType.eaType_BEGIN,1, -1, "a")},
//                {"&line(Parent::Child    ,        Child::Grandchild   )", new EmbeddedAnnotation(EmbeddedAnnotation.eEAType.eaType_BEGIN,1, -1, "a")},
//                {"&end(Parent::Child,Child::Grandchild     )", new EmbeddedAnnotation(EmbeddedAnnotation.eEAType.eaType_BEGIN,1, -1, "a")},
//                {"&end(     Parent::Child,Child::Grandchild)", new EmbeddedAnnotation(EmbeddedAnnotation.eEAType.eaType_BEGIN,1, -1, "a")},
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

        Assert.assertEquals(eaList,null);
    }
}
