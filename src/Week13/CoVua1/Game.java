import java.util.ArrayList;

public class Game {
    private Board board;
    private ArrayList<Move> moveHistory = new ArrayList<>();

    /**
     * Moves a chess piece to a new position on the board.
     */
    public void movePiece(Piece piece, int x, int y) {
        if (piece.canMove(board, x, y)) {
            Move move = new Move(piece.getCoordinatesX(), x, piece.getCoordinatesY(), y, piece);
            moveHistory.add(move);

            // Check and remove the piece at the destination if it exists
            Piece killedPiece = board.getAt(x, y);
            if (killedPiece != null) {
                move.setKilledPiece(killedPiece); // Sửa đổi đối tượng Move hiện tại
                board.removeAt(x, y);
            }

            // Update the piece's position on the board
            piece.setCoordinatesX(x);
            piece.setCoordinatesY(y);
        }
    }


    public Game(Board board) {
        this.board = board;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public ArrayList<Move> getMoveHistory() {
        return moveHistory;
    }

}
