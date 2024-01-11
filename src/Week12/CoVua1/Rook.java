public class Rook extends Piece {
    public Rook(int coordinatesX, int coordinatesY, String color) {
        super(coordinatesX, coordinatesY, color);
    }

    public Rook(int coordinatesX, int coordinatesY) {
        super(coordinatesX, coordinatesY);
    }

    @Override
    public String getSymbol() {
        return "R";
    }

    @Override
    public boolean canMove(Board board, int x, int y) {
        if (!board.validate(x, y)) {
            return false;
        }

        if (x == this.getCoordinatesX() && y == this.getCoordinatesY()) {
            return false;
        }

        if (x != this.getCoordinatesX() && y != this.getCoordinatesY()) {
            return false;
        }

        for (Piece piece : board.getPieces()) {
            if (piece.getCoordinatesX() == this.getCoordinatesX()
                    && piece.getCoordinatesY() == this.getCoordinatesY()) {
                continue;
            }

            if (piece.getCoordinatesX() == x && piece.getCoordinatesY() == y) {
                if (piece.getColor().equals(this.getColor())) {
                    return false;
                }
            }

            if (x == this.getCoordinatesX()) {
                // Rook moving vertically
                if (piece.getCoordinatesX() == x
                        && isBetween(piece.getCoordinatesY(), this.getCoordinatesY(), y)) {
                    return false;
                }
            } else if (y == this.getCoordinatesY()) {
                // Rook moving horizontally
                if (piece.getCoordinatesY() == y
                        && isBetween(piece.getCoordinatesX(), this.getCoordinatesX(), x)) {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean isBetween(int value, int start, int end) {
        return value > Math.min(start, end) && value < Math.max(start, end);
    }
}

