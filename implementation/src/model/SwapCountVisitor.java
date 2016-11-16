package model;

/**
 * @author Hendrik Werner // s4549775
 * @author Constantin Blach // s4329872
 */
public class SwapCountVisitor implements Visitor {
    private int swaps;
    private int redLeft;
    private int blackLeft;

    public SwapCountVisitor(int red, int black) {
        redLeft = red;
        blackLeft = black;
    }

    public int getSwaps() {
        return swaps;
    }

    @Override
    public void visit(MobileLeaf leaf) {

    }

    @Override
    public void visit(Mobile mobile) {
        ColorCountVisitor colorLeft = new ColorCountVisitor();
        ColorCountVisitor colorRight = new ColorCountVisitor();
        mobile.getLeftChild().accept(colorLeft);
        mobile.getRightChild().accept(colorRight);
        int diff = colorLeft.getRed() - colorRight.getRed();
        if (diff > 1) {
            // left must swap to right
        } else if (diff < -1) {
            // right must swap to left
        }
        mobile.getLeftChild().accept(this);
        mobile.getRightChild().accept(this);
    }
}
