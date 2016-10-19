package model;

/**
 * @author Hendrik Werner // s4549775
 * @author Constantin Blach // s4329872
 */
public class Mobile implements MobileNode {
    private static int calcSplit(String seed) {
        for (int i = 0, braces = 0; i < seed.length(); i++) {
            switch (seed.charAt(i)) {
                case '(': braces++; break;
                case ')': braces--; break;
            }
            if (braces == 0) {
                return ++i;
            }
        }
        throw new IllegalArgumentException("Invalid seed: Couldn't calculate splitting index.");
    }

    private MobileNode leftChild;
    private MobileNode rightChild;

    public Mobile(MobileNode leftChild, MobileNode rightChild) {
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }

    public Mobile(String seed) {
        String prunedSeed = seed.substring(1, seed.length() - 1);
        int split = calcSplit(prunedSeed);
        String left = prunedSeed.substring(0, split);
        String right = prunedSeed.substring(split, prunedSeed.length());
        leftChild = left.length() == 1 ? new MobileLeaf(left.charAt(0)) : new Mobile(left);
        rightChild = right.length() == 1 ? new MobileLeaf(right.charAt(0)) : new Mobile(right);
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
