package model;

/**
 * @author Hendrik Werner // s4549775
 * @author Constantin Blach // s4329872
 */
public class Mobile implements MobileNode {
    private static int calcSplit(String seed, int start, int end) {
        for (int i = start, depth = 0; i < end; i++) {
            switch (seed.charAt(i)) {
                case '(': depth++; break;
                case ')': depth--; break;
            }
            if (depth == 0) {
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
        this(seed, 1, seed.length() - 1);
    }

    private Mobile(String seed, int start, int end) {
        int split = calcSplit(seed, start, end);
        leftChild = split - start == 1 ? new MobileLeaf(seed.charAt(start)) : new Mobile(seed, start + 1, split - 1);
        rightChild = end - split == 1 ? new MobileLeaf(seed.charAt(split)) : new Mobile(seed, split + 1, end - 1);
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
        return "(" + leftChild + rightChild + ')';
    }
}
