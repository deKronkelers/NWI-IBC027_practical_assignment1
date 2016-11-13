package model;

/**
 * @author Hendrik Werner // s4549775
 */
public interface Visitor {
    void visit(MobileLeaf leaf);

    void visit(Mobile mobile);
}
