package model;

/**
 * @author Hendrik Werner // s4549775
 */
public interface Visitable {
    void accept(Visitor visitor);
}
