public class Game {
  private Player white;
  private Player black;
  private Board board;

  public Game() {
    board = new Board();
    white = new Player(board, false);
    black = new Player(board, true);
  }

  public void play() {
    white.setChecksOnBoard();
    black.setChecksOnBoard();
    board.displayBoard();
    boolean whiteTurn = true;
    while (true) {
      if (whiteTurn) {
        System.out.println();
        white.moveCheck(0, 0, 1, 1);
        board.displayBoard();
        whiteTurn = false;
      } else {
        System.out.println();
        System.out.println();

        black.moveCheck(1, 5, 0, 4);
        board.displayBoard();
        break;
      }
    }
  }
}
