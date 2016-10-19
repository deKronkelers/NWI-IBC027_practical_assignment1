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

    public Mobile(String seed) {
        String prunedSeed = seed.substring(1, seed.length() - 1);
        if (prunedSeed.length() == 2) {
            leftChild = new MobileLeaf(prunedSeed.charAt(0));
            rightChild = new MobileLeaf(prunedSeed.charAt(1));
        } else {
            int split = prunedSeed.indexOf('(');
            String left = prunedSeed.substring(0, split);
            String right = prunedSeed.substring(split, prunedSeed.length());
            leftChild = left.length() == 1 ? new MobileLeaf(left.charAt(0)) : new Mobile(left);
            rightChild = right.length() == 1 ? new MobileLeaf(right.charAt(0)) : new Mobile(right);

        }
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
