package model

import groovy.transform.CompileStatic

/**
 * @author Hendrik Werner // s4549775
 */
@CompileStatic
class MobileTest extends GroovyTestCase {
    static final List<String> testMobiles = []

    static {
        File[] samples = new File("../samples/").listFiles(new FilenameFilter() {
            @Override
            boolean accept(File file, String s) {
                s.endsWith ".in"
            }
        })
        for (File sample in samples) {
            testMobiles << new BufferedReader(new FileReader(sample)).readLine()
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
}
