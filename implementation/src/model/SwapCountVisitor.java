package model;

/**
 * @author Hendrik Werner // s4549775
 * @author Constantin Blach // s4329872
 */
public class SwapCountVisitor implements Visitor {
    private int wrongLeafs;
    private int redLeft;

    public SwapCountVisitor(int red) {
        redLeft = red;
    }

    public int getSwaps() {
        return wrongLeafs / 2;
    }

    @Override
    public void visit(MobileLeaf leaf) {
        if (redLeft > 1) {
            throw new IllegalArgumentException("discard");
        }
        if (
                redLeft == 0 && leaf.getColor() == MobileLeaf.Color.Red
                || redLeft == 1 && leaf.getColor() == MobileLeaf.Color.Black
            ) {
            wrongLeafs++;
        }
    }

    @Override
    public void visit(Mobile mobile) {
        int lessRed = redLeft / 2;
        int moreRed = -Math.floorDiv(-redLeft, 2);
        int currentWrongLeafs = wrongLeafs;
        int wrongLeafs1;
        int wrongLeafs2;
        boolean leftFailed = false;
        try {
            d(
                    mobile.getRightChild(), lessRed,
                    mobile.getLeftChild(), moreRed
            );
            wrongLeafs1 = wrongLeafs;
        } catch (IllegalArgumentException ex) {
            leftFailed = true;
            wrongLeafs1 = Integer.MAX_VALUE;
            // do not abort here, we have to try another split below
        }
        wrongLeafs = currentWrongLeafs;
        try {
            d(
                    mobile.getLeftChild(), lessRed,
                    mobile.getRightChild(), moreRed
            );
            wrongLeafs2 = wrongLeafs;
        } catch (IllegalArgumentException ex) {
            wrongLeafs2 = Integer.MAX_VALUE;
            if (leftFailed) {
                throw ex;
            }
        }
        wrongLeafs = Math.min(wrongLeafs1, wrongLeafs2);
    }

    private void d(
            MobileNode lessRedChild, int lessRed,
            MobileNode moreRedChild, int moreRed
    ) {
        redLeft = lessRed;
        lessRedChild.accept(this);
        redLeft = moreRed;
        moreRedChild.accept(this);
    }
}
