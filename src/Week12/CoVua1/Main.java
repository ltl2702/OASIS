public class Main {
    public static void main(String[] args) {
        // Example usage
        Board chessBoard = new Board();
        Game chessGame = new Game(chessBoard);

        Rook whiteRook = new Rook(1, 1, "white");
        chessBoard        .addPiece(whiteRook);

        Rook blackRook = new Rook(8, 8, "black");
        chessBoard.addPiece(blackRook);

        System.out.println("Initial Board:");
        printBoard(chessBoard);

        chessGame.movePiece(whiteRook, 1, 5);
        System.out.println("\nBoard after moving white rook to (1, 5):");
        printBoard(chessBoard);

        chessGame.movePiece(blackRook, 5, 5);
        System.out.println("\nBoard after moving black rook to (5, 5):");
        printBoard(chessBoard);

        System.out.println("\nMove History:");
        printMoveHistory(chessGame);
    }

    private static void printBoard(Board board) {
        for (int i = 1; i <= 8; i++) {
            for (int j = 1; j <= 8; j++) {
                Piece piece = board.getAt(i, j);
                if (piece == null) {
                    System.out.print("-\t");
                } else {
                    System.out.print(piece.getColor().charAt(0) + piece.getSymbol() + "\t");
                }
            }
            System.out.println();
        }
    }

    private static void printMoveHistory(Game game) {
        for (Move move : game.getMoveHistory()) {
            System.out.println(move.toString());
        }
    }
}
