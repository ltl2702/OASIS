public class Bishop extends Piece {
    public Bishop(int coordinatesX, int coordinatesY, String color) {
        super(coordinatesX, coordinatesY, color);
    }

    public Bishop(int coordinatesX, int coordinatesY) {
        super(coordinatesX, coordinatesY);
    }

    @Override
    public String getSymbol() {
        return "B";
    }

    @Override
    public boolean canMove(Board board, int x, int y) {
        // Check if the move is along a diagonal
        if (Math.abs(getCoordinatesX() - x) != Math.abs(getCoordinatesY() - y)) {
            return false;
        }

        // Check if there is a piece of the same color at the destination
        Piece piece = board.getAt(x, y);
        if (piece != null && piece.getColor().equals(getColor())) {
            return false;
        }

        // Check if there are any pieces in the diagonal path
        int lx = (x - getCoordinatesX() > 0) ? 1 : -1;
        int ly = (y - getCoordinatesY() > 0) ? 1 : -1;

        int currentX = getCoordinatesX() + lx;
        int currentY = getCoordinatesY() + ly;

        while (currentX != x && currentY != y) {
            if (board.getAt(currentX, currentY) != null) {
                return false;
            }
            currentX += lx;
            currentY += ly;
        }

        return true;
    }
}

