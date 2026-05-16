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
        System.out.print("b(" + tile.getPosX() + ", " + tile.getPosY() + ") ");
      } else {
        System.out.print("w(" + tile.getPosX() + ", " + tile.getPosY() + ") ");
      }
    }
  }

}
