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

    public MobileLeaf(char color) {
        this.color = Color.fromChar(color);
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

        public static Color fromChar(char c) {
            switch (c) {
                case 'B':
                case 'b':
                    return Black;
                case 'R':
                case 'r':
                    return Red;
                default:
                    throw new IllegalArgumentException("Color must be (B)lack or (R)ed.");
            }
        }

        @Override
        public abstract String toString();
    }
}
