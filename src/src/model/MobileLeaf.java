package model;

/**
 * @author Hendrik Werner // s4549775
 * @author Constantin Blach // s4329872
 */
public class MobileLeaf implements MobileNode {
    private Color color;

    public MobileLeaf(Color color) {
        this.color = color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    @Override
    public String toString() {
        return color == Color.Black ? "B" : "R";
    }

    public enum Color {
        Black,
        Red;
    }
}
