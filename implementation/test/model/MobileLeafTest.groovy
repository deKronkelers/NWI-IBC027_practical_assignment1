package model

/**
 * @author Hendrik Werner // s4549775
 */
class MobileLeafTest extends GroovyTestCase {
    void testCharConstructor() {
        new MobileLeaf("B" as char)
        new MobileLeaf("b" as char)
        new MobileLeaf("R" as char)
        new MobileLeaf("r" as char)
        shouldFail { new MobileLeaf("A" as char) }
    }

    void testToString() {
        assert new MobileLeaf(MobileLeaf.Color.Black).toString() == "B"
        assert new MobileLeaf(MobileLeaf.Color.Red).toString() == "R"
    }

    void testIntegration() {
        assert new MobileLeaf('B' as char).toString() == new MobileLeaf(MobileLeaf.Color.Black).toString();
        assert new MobileLeaf('b' as char).toString() == new MobileLeaf(MobileLeaf.Color.Black).toString();
        assert new MobileLeaf('R' as char).toString() == new MobileLeaf(MobileLeaf.Color.Red).toString();
        assert new MobileLeaf('r' as char).toString() == new MobileLeaf(MobileLeaf.Color.Red).toString();
    }
}
