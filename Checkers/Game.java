import java.util.Scanner;

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
    Scanner sc = new Scanner(System.in);
    white.setChecksOnBoard();
    black.setChecksOnBoard();
    board.displayBoard();

    boolean whiteTurn = true;

    while (true) {
      Player currentPlayer = whiteTurn ? white : black;
      String colorName = whiteTurn ? "White" : "Black";

      System.out.println(colorName + " move (format: fromX,fromY,toX,toY): ");

      boolean passed = false;

      while (!passed) {
        String input = sc.nextLine();

        if (input.trim().isEmpty()) {
          System.out.println("Input cannot be empty. Try again:");
          continue;
        }

        try {
          String[] temp = input.split(",");
          int[] numbers = new int[4];

          for (int i = 0; i < 4; i++) {
            numbers[i] = Integer.parseInt(temp[i].trim());
          }

          passed = currentPlayer.moveCheck(numbers[0], numbers[1], numbers[2], numbers[3]);

          if (!passed) {
            System.out.println("Invalid move. Try again:");
          }
        } catch (Exception e) {
          System.out.println("Error reading input. Please use 'x,y,x,y' format. Try again:");
        }
      }

      board.displayBoard();
      whiteTurn = !whiteTurn;
      System.out.println();
    }
  }
}
