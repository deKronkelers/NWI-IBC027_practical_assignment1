package model

/**
 * @author Hendrik Werner // s4549775
 */
class MobileTest extends GroovyTestCase {
    void testToString() {
        assert new Mobile(
                new MobileLeaf(MobileLeaf.Color.Red),
                new MobileLeaf(MobileLeaf.Color.Black)
        ).toString() == "(RB)"
        assert new Mobile(
                new MobileLeaf(MobileLeaf.Color.Black),
                new Mobile(
                        new MobileLeaf(MobileLeaf.Color.Black),
                        new MobileLeaf(MobileLeaf.Color.Red)
                )
        ).toString() == "(B(BR))"
    }
}
