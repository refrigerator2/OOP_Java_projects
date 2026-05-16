import java.util.ArrayList;

public abstract class Player {
  private final int NUMBER_OF_CHECKERS = 12;
  private ArrayList<Checker> checks;
  private Board board;

  public Player(Board b) {
    this.board = b;
    checks = new ArrayList<>(NUMBER_OF_CHECKERS);
  }
}
