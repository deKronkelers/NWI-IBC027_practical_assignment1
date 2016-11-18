package model;

/**
 * @author Hendrik Werner // s4549775
 */
public class SwapCountVisitor implements Visitor {
    private int swaps;
    private int redLeft;

    public SwapCountVisitor(int red) {
        redLeft = red;
    }

    public int getSwaps() {
        return swaps;
    }

    @Override
    public void visit(MobileLeaf leaf) {
        if (redLeft > 1) {
            throw new IllegalArgumentException("discard");
        }
        if (redLeft == 1 && leaf.getColor() == MobileLeaf.Color.Black) {
            swaps++;
        }
    }

    @Override
    public void visit(Mobile mobile) {
        int lessRed = redLeft / 2;
        int moreRed = -Math.floorDiv(-redLeft, 2);
        if (lessRed == moreRed) {
            recurse(mobile.getRightChild(), lessRed, mobile.getLeftChild(), moreRed);
            return;
        }
        tryBoth(mobile, lessRed, moreRed);
    }

    private void recurse(
            MobileNode lessRedChild, int lessRed,
            MobileNode moreRedChild, int moreRed
    ) {
        redLeft = lessRed;
        lessRedChild.accept(this);
        redLeft = moreRed;
        moreRedChild.accept(this);
    }

    private void tryBoth(Mobile mobile, int lessRed, int moreRed) {
        int currentSwaps = swaps;
        int swapsLeft;
        int swapsRight;
        boolean leftFailed = false;
        try {
            recurse(mobile.getRightChild(), lessRed, mobile.getLeftChild(), moreRed);
            swapsLeft = swaps;
        } catch (IllegalArgumentException ex) {
            leftFailed = true;
            swapsLeft = Integer.MAX_VALUE;
            // do not abort here, we have to try another split below
        }
        swaps = currentSwaps;
        try {
            recurse(mobile.getLeftChild(), lessRed, mobile.getRightChild(), moreRed);
            swapsRight = swaps;
        } catch (IllegalArgumentException ex) {
            swapsRight = Integer.MAX_VALUE;
            if (leftFailed) {
                throw ex;
            }
        }
        swaps = Math.min(swapsLeft, swapsRight);
    }
}
