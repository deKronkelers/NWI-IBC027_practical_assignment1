package model

import groovy.transform.CompileStatic

/**
 * @author Hendrik Werner // s4549775
 */
@CompileStatic
class MobileTest extends GroovyTestCase {
    static final List<String> testMobiles = []
    static final List<String> mobileSolutions = []

    private static File[] getFilesEndingIn(String path, String ending) {
        new File(path).listFiles(new FilenameFilter() {
            @Override
            boolean accept(File file, String s) {
                s.endsWith ending
            }
        }).sort { File f1, File f2 ->
            (f1.name.substring(0, f1.name.lastIndexOf(".")) as int) -
                    (f2.name.substring(0, f2.name.lastIndexOf(".")) as int)

        }
    }

    static {
        for (File sample in getFilesEndingIn("../samples/", ".in")) {
            testMobiles << new BufferedReader(new FileReader(sample)).readLine()
        }
        for (File solution in getFilesEndingIn("../samples/", ".out")) {
            mobileSolutions << new BufferedReader(new FileReader(solution)).readLine()
        }
    }

    void testToString() {
        assert new Mobile(
                new MobileLeaf(MobileLeaf.Color.Black),
                new MobileLeaf(MobileLeaf.Color.Red)
        ).toString() == "(BR)"
        assert new Mobile(
                new Mobile(
                        new MobileLeaf(MobileLeaf.Color.Red),
                        new MobileLeaf(MobileLeaf.Color.Red)
                ),
                new MobileLeaf(MobileLeaf.Color.Red)
        ).toString() == "((RR)R)"
    }

    void testSeedConstructor() {
        for (String testMobile in testMobiles) {
            new Mobile(testMobile)
        }
        shouldFail { new Mobile("((RR)") }
    }

    void testIntegration() {
        for (String testMobile in testMobiles) {
            assert new Mobile(testMobile).toString() == testMobile
        }
    }

    void testSwaps() {
        for (int i in 0..<testMobiles.size()) {
            if (mobileSolutions.get(i) != "discard") {
                println "Solving Mobile ${i + 1}"
                Mobile mobile = new Mobile(testMobiles.get(i));
                def colorCountVisitor = new ColorCountVisitor();
                mobile.accept colorCountVisitor
                def swapCountVisitor = new SwapCountVisitor(colorCountVisitor.red)
                mobile.accept swapCountVisitor
                assert mobileSolutions.get(i) == swapCountVisitor.swaps as String
            }
        }
    }

    void testDiscard() {
        for (int i in 0..<testMobiles.size()) {
            if (mobileSolutions[i] == "discard") {
                println "Solving Mobile ${i + 1}"
                Mobile mobile = new Mobile(testMobiles.get(i));
                def colorCountVisitor = new ColorCountVisitor();
                mobile.accept colorCountVisitor
                def swapCountVisitor = new SwapCountVisitor(colorCountVisitor.red)
                shouldFail {
                    mobile.accept swapCountVisitor
                }
            }
        }
    }
}
