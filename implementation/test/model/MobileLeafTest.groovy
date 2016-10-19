package model

/**
 * @author hendrik
 */
class MobileLeafTest extends GroovyTestCase {
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