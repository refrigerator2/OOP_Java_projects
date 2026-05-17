import java.util.ArrayList;

public class Board {
  private final int SIZE = 8;
  private Tile[] tiles;

  public Board() {
    tiles = new Tile[SIZE * SIZE];
    for (int i = 0; i < SIZE; i++) {
      for (int j = 0; j < SIZE; j++) {
        boolean is_black = false;
        if (checkerCanBeHere(j, i)) {
          is_black = true;
        }
        tiles[i * SIZE + j] = new Tile(i, j, is_black);
      }
    }
  }

  boolean checkerCanBeHere(int x, int y) {
    if ((x % 2 != 0 && y % 2 != 0) || (x % 2 == 0 && y % 2 == 0)) {
      return true;
    }
    ;
    return false;
  }

  public void displayBoard() {
    for (int i = 0; i < SIZE * SIZE; i++) {
      if (i % SIZE == 0 && i != 0) {
        System.out.println();
      }
      Tile tile = tiles[i];
      if (tile.getIsBlack() == true) {
        String str = "b(" + tile.getPosX() + ", " + tile.getPosY() + ", taken: ";
        str += tile.getCheck() == null ? "n) " : "y) ";
        System.out.print(str);
      } else {
        String str = "w(" + tile.getPosX() + ", " + tile.getPosY() + ", taken: ";
        str += tile.getCheck() == null ? "n) " : "y) ";
        System.out.print(str);
      }
    }
  }

  public void setPlayersChecks(ArrayList<Checker> checks, int startRow, int endRow) {
    int checksId = 0;
    for (int i = startRow; i < endRow; i++) {
      for (int j = 0; j < SIZE; j++) {
        if (checkerCanBeHere(j, i)) {
          Checker check = checks.get(checksId);
          tiles[i * SIZE + j].setCheck(check);
          check.setPosX(j);
          check.setPosY(i);
          checksId += 1;
        }
      }
    }
  }

  boolean pointInBorders(int x, int y) {
    if (x >= 0 && x < SIZE && y >= 0 && y < SIZE) {
      return true;
    } else {
      return false;
    }
  }

  public void moveChecker(Checker ch, int toX, int toY) {
    int chX = ch.getPosX();
    int chY = ch.getPosY();
    Tile bef = tiles[chY * SIZE + chX];
    Tile to = tiles[toY * SIZE + toX];
    if (to.getIsBlack() && pointInBorders(toX, toY)) {
      bef.setCheck(null);
      tiles[chY * SIZE + chX].setCheck(ch);
    } else {
      System.out.println("Tile is white");
    }
  }
}
