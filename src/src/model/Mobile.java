package model;

/**
 * @author Hendrik Werner // s4549775
 * @author Constantin Blach // s4329872
 */
public class Mobile implements MobileNode {
    private MobileNode leftChild;
    private MobileNode rightChild;

    public Mobile(MobileNode leftChild, MobileNode rightChild) {
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }

    public MobileNode getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(MobileNode leftChild) {
        this.leftChild = leftChild;
    }

    public MobileNode getRightChild() {
        return rightChild;
    }

    public void setRightChild(MobileNode rightChild) {
        this.rightChild = rightChild;
    }

    @Override
    public String toString() {
        return new StringBuilder("(")
                .append(leftChild)
                .append(rightChild)
                .append(')')
                .toString();
    }
}
