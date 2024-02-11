package component;


public abstract class Piece {
    private final COLOR color;

    public Piece(COLOR color) {
        this.color = color;
    }
    public COLOR getColor() {
        return color;
    }

    public abstract boolean canMove(Board board,int x1,int y1,int x2,int y2);
}
