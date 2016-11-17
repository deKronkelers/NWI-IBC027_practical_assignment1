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
        if (
                redLeft == 0 && leaf.getColor() == MobileLeaf.Color.Red
                || redLeft == 1 && leaf.getColor() == MobileLeaf.Color.Black
            ) {
            wrongLeafs++;
        }
    }

    @Override
    public void visit(Mobile mobile) {
        ColorCountVisitor colorLeft = new ColorCountVisitor();
        ColorCountVisitor colorRight = new ColorCountVisitor();
        mobile.getLeftChild().accept(colorLeft);
        mobile.getRightChild().accept(colorRight);
        int diff = colorLeft.getRed() - colorRight.getRed();
        if (diff > 1) {
            splitRed(
                    mobile.getRightChild(), colorRight,
                    mobile.getLeftChild(),
                    diff
            );
        } else if (diff < -1) {
            splitRed(
                    mobile.getLeftChild(), colorLeft,
                    mobile.getRightChild(),
                    diff
            );
        } else {
            mobile.getLeftChild().accept(this);
            mobile.getRightChild().accept(this);
        }
    }

    private void splitRed(
            MobileNode lessRedChild, ColorCountVisitor lessRed,
            MobileNode moreRedChild,
            int diff
    ) {
        int absDiff = Math.abs(diff);
        if (lessRed.getBlack() >= absDiff / 2) {
            redLeft = absDiff / 2;
            lessRedChild.accept(this);

            redLeft = -Math.floorDiv(-absDiff, 2);
            moreRedChild.accept(this);
        } else {
            throw new IllegalArgumentException("discard");
        }
    }
}
