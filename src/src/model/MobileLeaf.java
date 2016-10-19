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
        return color.toString();
    }

    public enum Color {
        Black {
            @Override
            public String toString() {
                return "B";
            }
        },
        Red {
            @Override
            public String toString() {
                return "R";
            }
        };

        @Override
        public abstract String toString();
    }
}
