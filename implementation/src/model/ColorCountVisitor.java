package model;

/**
 * @author Hendrik Werner // s4549775
 * @author Constantin Blach // s4329872
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

    public int getTotal() {
        return red + black;
    }

    @Override
    public void visit(MobileLeaf leaf) {
        switch (leaf.getColor()) {
            case Black:
                black++;
                break;
            case Red:
                red++;
                break;
        }
    }

    @Override
    public void visit(Mobile mobile) {
        mobile.getLeftChild().accept(this);
        mobile.getRightChild().accept(this);
    }
}
