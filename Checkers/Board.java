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
        tiles[i * SIZE + j] = new Tile(j, i, is_black);
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
    for (int i = SIZE - 1; i >= 0; i--) {
      for (int j = 0; j < SIZE; j++) {
        Tile tile = tiles[i * SIZE + j];
        Checker ch = tile.getCheck();
        if (tile.getIsBlack() == true) {
          String str = "b(" + tile.getPosX() + ", " + tile.getPosY();
          if (ch != null) {
            str += ch.getIsBlack() == true ? ", cb) " : ", cw) ";
          } else {
            str += ", nt) ";
          }
          System.out.print(str);
        } else {
          String str = "w(" + tile.getPosX() + ", " + tile.getPosY();
          if (ch != null) {
            str += ch.getIsBlack() == true ? ", cb) " : ", cw) ";
          } else {
            str += ", nt) ";
          }
          System.out.print(str);
        }
      }
      System.out.println();
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

  boolean helperForNextFunction(Checker ch, int x, int y) {
    Tile t = tiles[y * SIZE + x];
    Checker chec = t.getCheck();
    if (t.getCheck() != null && chec.getIsBlack() != ch.getIsBlack()) {
      return true;
    }
    return false;
  }

  boolean checkIfCheckerOfDifferentColorInTheArea(Checker ch) {
    int chX = ch.getPosX();
    int chY = ch.getPosY();

    int[] dirX = { -1, -1, 1, 1 };
    int[] dirY = { -1, 1, 1, -1 };

    for (int i = 0; i < 4; i++) {
      int targetX = chX + dirX[i];
      int targetY = chY + dirY[i];

      if (pointInBorders(targetX, targetY)) {
        if (helperForNextFunction(ch, targetX, targetY)) {
          return true;
        }
      }
    }
    return false;
  }

  public boolean moveChecker(Checker ch, int toX, int toY) {
    if (!pointInBorders(toX, toY)) {
      System.out.println("Coordinates are out of bounds!");
      return false;
    }
    if (checkIfCheckerOfDifferentColorInTheArea(ch)) {
      System.out.println("Here is a different color checker in the area");
      return false;
    }
    int chX = ch.getPosX();
    int chY = ch.getPosY();
    Tile bef = tiles[chY * SIZE + chX];
    Tile to = tiles[toY * SIZE + toX];
    if (pointInBorders(toX, toY)) {
      bef.setCheck(null);
      to.setCheck(ch);
      ch.setPosX(toX);
      ch.setPosY(toY);
    } else {
      System.out.println("Tile is white");
    }
    return true;
  }
}
