import java.util.ArrayList;

public class Player {
  private final int NUMBER_OF_CHECKERS = 12;
  private ArrayList<Checker> checks;
  private Board board;
  private boolean isBlackChecks;

  public Player(Board b, boolean isBlack) {
    this.board = b;
    checks = new ArrayList<>(NUMBER_OF_CHECKERS);
    isBlackChecks = isBlack;
    for (int i = 0; i < NUMBER_OF_CHECKERS; i++) {
      checks.add(new Checker(isBlack));
    }
  }

  public boolean getIsBlackChecks() {
    return isBlackChecks;
  }

  public ArrayList<Checker> getChecks() {
    return checks;
  }

  public Checker getCheckerByIndex(int idx) {
    if (idx >= NUMBER_OF_CHECKERS) {
      return null;
    }
    return checks.get(idx);
  }

  public Checker getCheckerByPos(int x, int y) {
    for (Checker ch : checks) {
      if (ch.getPosX() == x && ch.getPosY() == y) {
        return ch;
      }
    }
    return null;
  }

  public void setChecksOnBoard() {
    int startRow = this.isBlackChecks ? 5 : 0;
    int endRow = this.isBlackChecks ? 8 : 3;
    board.setPlayersChecks(checks, startRow, endRow);
  }

  public void moveCheck(int fromX, int fromY, int toX, int toY) {
    Checker check = getCheckerByPos(fromX, fromY);
    if (check == null) {
      System.out.println("You dont have checker here");
      return;
    } else if (!board.checkerCanBeHere(toX, toY)) {
      System.out.println("You cant move here");
      return;
    } else if (getCheckerByPos(toX, toY) != null) {
      System.out.println("Tile is taken by one of your checkers");
      return;
    }
    board.moveChecker(check, toX, toY);
  }
}
