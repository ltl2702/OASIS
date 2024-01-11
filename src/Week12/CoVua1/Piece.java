public abstract class Piece {
    private int coordinatesX;
    private int coordinatesY;
    private String color;

    /**
     * Constructs a chess piece with specified coordinates and color.
     */
    public Piece(int coordinatesX, int coordinatesY, String color) {
        if (!(isValidCoordinate(coordinatesX) && isValidCoordinate(coordinatesY))) {
            throw new IllegalArgumentException("Invalid coordinates");
        }
        if (!(color.equals("white") || color.equals("black"))) {
            throw new IllegalArgumentException("Invalid color");
        }

        this.coordinatesX = coordinatesX;
        this.coordinatesY = coordinatesY;
        this.color = color;
    }

    /**
     * Constructs a chess piece with specified coordinates.
     */
    public Piece(int coordinatesX, int coordinatesY) {
        if (!(isValidCoordinate(coordinatesX) && isValidCoordinate(coordinatesY))) {
            throw new IllegalArgumentException("Invalid coordinates");
        }

        // Default color is set to "white" if not specified
        this.coordinatesX = coordinatesX;
        this.coordinatesY = coordinatesY;
        this.color = "white";
    }

    public int getCoordinatesX() {
        return coordinatesX;
    }

    public int getCoordinatesY() {
        return coordinatesY;
    }

    public String getColor() {
        return color;
    }

    public void setCoordinatesX(int coordinatesX) {
        this.coordinatesX = coordinatesX;
    }

    public void setCoordinatesY(int coordinatesY) {
        this.coordinatesY = coordinatesY;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public abstract String getSymbol();

    public abstract boolean canMove(Board board, int x, int y);

    private boolean isValidCoordinate(int coordinate) {
        return coordinate >= 1 && coordinate <= 8;
    }

    public boolean checkPosition(Piece otherPiece) {
        return this.coordinatesX == otherPiece.getCoordinatesX()
                && this.coordinatesY == otherPiece.getCoordinatesY();
    }
}
