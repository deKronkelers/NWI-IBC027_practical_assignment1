package model

/**
 * @author Hendrik Werner // s4549775
 */
class MobileTest extends GroovyTestCase {
    static final List<String> testMobiles = [
            "(BR)"
            , "(RR)"
            , "((RR)R)"
            , "((BB)(RR))"
            , "((R(RR))R)"
            , "(R((RB)(RR)))"
            , "((((R(BB))(B(BB)))(B(BB)))R)"
            , "((B((B((R((R(BR))B))B))B))B)"
            , "(((R((RR)R))(R(RB)))((BB)R))"
            , "((((RR)(RR))(RR))((RR)(RR)))"
            , "(((B(BB))(BB))((((RR)((RR)R))B)R))"
            , "(((((BB)(BB))(R(BB)))(R(((BB)R)(BR))))(((BR)(B((R(BR))B)))((BB)((BR)B))))"
            , "((((B(BB))(B(BB)))((B(BR))(R(RR))))(((R(RB))(B(BR)))((R(RB))((RR)(RR)))))"
            , "((((R(RR))(R(RR)))((R(RR))(R(RR))))(((R(RR))(R(RR)))((R(RR))((RR)(RR)))))"
            , "(((((RR)(B((RR)B)))((R(RR))((BB)(BB))))((((BR)(RB))((((RR)(R(BR)))B)R))(((RB)B)(RR))))((((RB)(RR))(((RB)R)((RB)(R(RB)))))(((R(RR))((RB)B))((RR)(R(B(RR)))))))"
            , "((R((B((B((B((B((B((B((B((B((B((B((B((B((B((B((B((B((B((B((B((B((B((B((B((B((B((B((B((B((B((B((B((B((B((B((B((B((B((B((B((B((B((B((B((B((B((B((B((B(RR))B))B))B))B))B))B))B))B))B))B))B))B))B))B))B))B))B))B))B))B))B))B))B))B))B))B))B))B))B))B))B))B))B))B))B))B))B))B))B))B))B))B))B))B))B))B))B))B))B)"
            , "((((BB)(((RB)((((BB)((RB)((B(BR))B)))B)B))(((RB)B)B)))(B((B(B(B(BB))))(B(B((BB)(BR)))))))((((BB)(B(((RB)B)((BB)(B((BB)B))))))(B(((B(BB))B)(((B(((BB)B)B))((((BR)(BR))B)(R(BB))))(BB)))))(((((((((B((RB)(BB)))(B((B(RB))B)))B)(((BB)B)B))((B(BB))((BB)(BR))))(BB))((BB)(((((BB)B)B)(BB))(((RB)B)B))))B)R)))"
            , "(((((B((BB)(B(((BB)B)(BB)))))B)((((R(BB))R)B)((BB)(B(BB)))))(((((R((BB)B))((((((BB)(((BB)(BB))B))(BB))R)((B(BR))(BB)))(((BR)B)R)))(B((B(BB))(BB))))((B(B(BB)))(((BB)((BB)(BB)))(BB))))(BB)))(((((BB)((B(BB))B))((BB)((BR)(((((BB)((BB)(((RB)B)B)))(BB))B)R))))(((((((B((BB)(BB)))((BB)B))(((B(BB))((B(B(BB)))(((BB)(BB))(BB))))(RB)))B)((B(((RR)(BB))B))(B(BB))))((((R((BB)((((BB)B)B)((BB)R))))((BB)(((BB)B)((((R(BB))R)(((BB)B)B))B))))((((((B(B(BB)))(RB))(((BB)B)B))((B(BB))B))(((((BB)B)B)B)((((B((BB)B))(BR))B)B)))((B(B(B(B(BB)))))((B((B(BB))(BB)))(BB)))))((BB)B)))(B(((B(BB))(BB))(BB)))))((B(((BB)((BR)(BB)))(((B(((BB)B)B))(BB))(B(BR)))))((B(B(BB)))((((R((((BB)B)B)((BB)(((BB)B)B))))B)B)((((BB)((BB)B))((B(BR))((BB)(((BB)B)B))))((B((BB)B))((B(BB))B))))))))"
            , "(((((((((R(RR))(R(RB)))((R(RR))(R(RB))))(((R(RR))(R(RR)))((RR)(B(BB)))))((((R(RR))(R(BB)))(((RB)(RB))((RB)(B((RR)(RR))))))(((R(RR))(R(BB)))((R(RR))(R(RB))))))(((((R(RR))(R(BB)))(((RB)(RB))((RB)(B((RR)(RR))))))(((R(RR))(R(BB)))((R(RR))(R(RB)))))((((R(RR))(R(BB)))((R(RR))(R(RB))))(((R(RR))(R(RB)))((R(RR))(R(RB)))))))(((((((RB)(RB))((RB)(B(R(RR)))))((R(RR))(R(BB))))(((R(RR))(R(BB)))((R(RR))(R(RB)))))((((R(RR))(R(BB)))((R(RR))(R(RB))))((((RB)(RB))((RB)(RB)))(((RB)(RB))((RB)((RB)(B((R(RR))(R(RR))))))))))(((((R(RR))(R(RB)))((R(RR))(R(RB))))(((R(RR))(R(RR)))((RR)(B(BB)))))((((R(RR))(R(BB)))(((RB)(RB))((RB)(B((RR)(RR))))))(((R(RR))(R(BB)))((R(RR))(R(RB))))))))(((((((R(RR))(R(RB)))((R(RR))(R(RB))))(((R(RR))(R(RR)))((RR)(B(BB)))))((((R(RR))(R(BB)))(((RB)(RB))((RB)(B((RR)(RR))))))(((R(RR))(R(BB)))((R(RR))(R(RB))))))(((((R(RR))(R(BB)))(((RB)(RB))((RB)(B((RR)(RR))))))(((R(RR))(R(BB)))((R(RR))(R(RB)))))((((R(RR))(R(BB)))((R(RR))(R(RB))))(((R(RR))(R(RB)))((R(RR))(R(RB)))))))((((((R(RR))(R(BB)))(((RB)(RB))((RB)(B((RR)(RR))))))(((R(RR))(R(BB)))((R(RR))(R(RB)))))((((R(RR))(R(BB)))((R(RR))(R(RB))))(((R(RR))(R(RB)))((R(RR))(R(RB))))))(((((R(RR))(R(BB)))(((RB)(RB))((RB)(B((RR)(RR))))))(((R(RR))(R(BB)))((R(RR))(R(RB)))))((((R(RR))(R(BB)))((R(RR))(R(RB))))(((R(RR))(R(RB)))((R(RR))(R(RB)))))))))((((((((R(RR))(R(RB)))((R(RR))(R(RB))))(((R(RR))(R(RR)))((RR)(B(BB)))))((((R(RR))(R(BB)))(((RB)(RB))((RB)(B((RR)(RR))))))(((R(RR))(R(BB)))((R(RR))(R(RB))))))(((((R(RR))(R(BB)))(((RB)(RB))((RB)(B((RR)(RR))))))(((R(RR))(R(BB)))((R(RR))(R(RB)))))((((R(RR))(R(BB)))((R(RR))(R(RB))))(((R(RR))(R(RB)))((R(RR))(R(RB)))))))((((((R(RR))(R(BB)))(((RB)(RB))((RB)(B((RR)(RR))))))(((R(RR))(R(BB)))((R(RR))(R(RB)))))((((R(RR))(R(BB)))((R(RR))(R(RB))))(((R(RR))(R(RB)))((R(RR))(R(RB))))))(((((R(RR))(R(BB)))(((RB)(RB))((RB)(B((RR)(RR))))))(((R(RR))(R(BB)))((R(RR))(R(RB)))))((((R(RR))(R(BB)))((R(RR))(R(RB))))(((R(RR))(R(RB)))((R(RR))(R(RB))))))))(((((((R(RR))(R(BB)))(((RB)(RB))((RB)(B((RR)(RR))))))(((R(RR))(R(BB)))((R(RR))(R(RB)))))((((R(RR))(R(BB)))((R(RR))(R(RB))))(((R(RR))(R(RB)))((R(RR))(R(RB))))))(((((R(RR))(R(BB)))(((RB)(RB))((RB)(B((RR)(RR))))))(((R(RR))(R(BB)))((R(RR))(R(RB)))))((((R(RR))(R(BB)))((R(RR))(R(RB))))(((R(RR))(R(RB)))((R(RR))(R(RB)))))))((((((R(RR))(R(BB)))(((RB)(RB))((RB)(B((RR)(RR))))))(((R(RR))(R(BB)))((R(RR))(R(RB)))))((((R(RR))(R(BB)))((R(RR))(R(RB))))(((R(RR))(R(RB)))((R(RR))(R(RB))))))(((((R(RR))(R(BB)))(((RB)(RB))((RB)(B((RR)(RR))))))(((R(RR))(R(BB)))((R(RR))(R(RB)))))((((R(RR))(R(BB)))((R(RR))(R(RB))))(((R(RR))(R(RB)))((R(RR))(R(RB))))))))))"
            , "(((((((((B(BB))((BB)(BB)))(((BB)(BB))((BB)(BB))))((((BB)(BB))((BB)(BB)))(((BB)(BB))((BB)(BB)))))((((B(BB))((BB)(BB)))(((BB)(BB))((BB)(BB))))((((BB)(BB))((BB)(BB)))(((BB)(BB))((BB)(BB))))))(((((B(BB))((BB)(BB)))(((BB)(BB))((BB)(BB))))((((BB)(BB))((BB)(BB)))(((BB)(BB))((BB)(BB)))))(((((BB)(BB))((BB)(BB)))(((BB)(BB))((BB)(BB))))((((BB)(BB))((BB)(BB)))(((BB)(BB))((BB)(BB)))))))((((((B(BB))((BB)(BB)))(((BB)(BB))((BB)(BB))))((((BB)(BB))((BB)(BB)))(((BB)(BB))((BB)(BB)))))((((B(BB))((BB)(BB)))(((BB)(BB))((BB)(BB))))((((BB)(BB))((BB)(BB)))(((BB)(BB))((BB)(BB))))))(((((B(BB))((BB)(BB)))(((BB)(BB))((BB)(BB))))((((BB)(BB))((BB)(BB)))(((BB)(BB))((BB)(BB)))))(((((BB)(BB))((BB)(BB)))(((BB)(BB))((BB)(BB))))((((BB)(BB))((BB)(BB)))(((BB)(BB))((BB)(BB))))))))(((((((B(BB))((BB)(BB)))(((BB)(BB))((BB)(BB))))((((BB)(BB))((BB)(BB)))(((BB)(BB))((BB)(BB)))))((((B(BB))((BB)(BB)))(((BB)(BB))((BB)(BB))))((((BB)(BB))((BB)(BB)))(((BB)(BB))((BB)(BB))))))(((((B(BB))((BB)(BB)))(((BB)(BB))((BB)(BB))))((((BB)(BB))((BB)(RR)))(((RR)(RR))((RR)(RR)))))(((((RR)(RR))((RR)(RR)))(((RR)(RR))((RR)(RR))))((((RR)(RR))((RR)(RR)))(((RR)(RR))((RR)(RR)))))))((((((R(RR))((RR)(RR)))(((RR)(RR))((RR)(RR))))((((RR)(RR))((RR)(RR)))(((RR)(RR))((RR)(RR)))))((((R(RR))((RR)(RR)))(((RR)(RR))((RR)(RR))))((((RR)(RR))((RR)(RR)))(((RR)(RR))((RR)(RR))))))(((((R(RR))((RR)(RR)))(((RR)(RR))((RR)(RR))))((((RR)(RR))((RR)(RR)))(((RR)(RR))((RR)(RR)))))(((((RR)(RR))((RR)(RR)))(((RR)(RR))((RR)(RR))))((((RR)(RR))((RR)(RR)))(((RR)(RR))((RR)(RR)))))))))((((((((R(RR))((RR)(RR)))(((RR)(RR))((RR)(RR))))((((RR)(RR))((RR)(RR)))(((RR)(RR))((RR)(RR)))))((((R(RR))((RR)(RR)))(((RR)(RR))((RR)(RR))))((((RR)(RR))((RR)(RR)))(((RR)(BB))((BB)(BB))))))(((((B(BB))((BB)(BB)))(((BB)(BB))((BB)(BB))))((((BB)(BB))((BB)(BB)))(((BB)(BB))((BB)(BB)))))(((((BB)(BB))((BB)(BB)))(((BB)(BB))((BB)(BB))))((((BB)(BB))((BB)(BB)))(((BB)(BB))((BB)(BB)))))))((((((B(BB))((BB)(BB)))(((BB)(BB))((BB)(BB))))((((BB)(BB))((BB)(BB)))(((BB)(BB))((BB)(BB)))))((((B(BB))((BB)(BB)))(((BB)(BB))((BB)(BB))))((((BB)(BB))((BB)(BB)))(((BB)(BB))((BB)(BB))))))(((((B(BB))((BB)(BB)))(((BB)(BB))((BB)(BB))))((((BB)(RR))((RR)(RR)))(((RR)(RR))((RR)(RR)))))(((((RR)(RR))((RR)(RR)))(((RR)(RR))((RR)(RR))))((((RR)(RR))((RR)(RR)))(((RR)(RR))((RR)(RR))))))))(((((((R(RR))((RR)(RR)))(((RR)(RR))((RR)(RR))))((((RR)(RR))((RR)(RR)))(((RR)(RR))((RR)(RR)))))((((R(RR))((RR)(RR)))(((RR)(RR))((RR)(RR))))((((RR)(RR))((RR)(RB)))(((BB)(BB))((BB)(BB))))))(((((B(BB))((BB)(BB)))(((BB)(BB))((BB)(BB))))((((BB)(BB))((BB)(BB)))(((BB)(BB))((BB)(BB)))))(((((BB)(BB))((BB)(BB)))(((BB)(BB))((BB)(BB))))((((BB)(BB))((BB)(BB)))(((BR)(RR))((RR)(RR)))))))((((((R(RR))((RR)(RR)))(((RR)(RR))((RR)(RR))))((((RR)(RR))((RR)(RR)))(((RR)(RR))((RR)(RR)))))((((R(RR))((RR)(RB)))(((BB)(BB))((BB)(BB))))((((BB)(BB))((BB)(BB)))(((BB)(BB))((BB)(BB))))))(((((B(BB))((BR)(RR)))(((RR)(RR))((RR)(RR))))((((RR)(RR))((RR)(RR)))(((RB)(BB))((BB)(BB)))))(((((BB)(BB))((BB)(RR)))(((RR)(RR))((RR)(RB))))((((BB)(BB))((RR)(RR)))(((BB)(RR))((BR)(RR))))))))))"
    ]

    void testToString() {
        assert new Mobile(
                new MobileLeaf(MobileLeaf.Color.Black),
                new MobileLeaf(MobileLeaf.Color.Red)
        ).toString() == testMobiles[0]
        assert new Mobile(
                new Mobile(
                        new MobileLeaf(MobileLeaf.Color.Red),
                        new MobileLeaf(MobileLeaf.Color.Red)
                ),
                new MobileLeaf(MobileLeaf.Color.Red)
        ).toString() == testMobiles[2]
    }

    void testSeedConstructor() {
        for (String testMobile in testMobiles) {
            new Mobile(testMobile)
        }
    }

    void testIntegration() {
        for (String testMobile in testMobiles) {
            assert new Mobile(testMobile).toString() == testMobile
        }
    }
}
