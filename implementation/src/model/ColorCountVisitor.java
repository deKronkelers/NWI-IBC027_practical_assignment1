package model;

/**
 * @author Hendrik Werner // s4549775
 */
public class ColorCountVisitor implements Visitor {
    private int red;
    private int black;

    public int getRed() {
        return red;
    }

    public int getBlack() {
        return black;
    }

    @Override
    public void visit(MobileLeaf leaf) {
        if (leaf.getColor() == MobileLeaf.Color.Black) {
            black++;
        } else {
            red++;
        }
    }

    @Override
    public void visit(Mobile mobile) {
        mobile.getLeftChild().accept(this);
        mobile.getRightChild().accept(this);
    }
}
