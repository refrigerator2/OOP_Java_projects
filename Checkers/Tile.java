public class Tile {
  private int posX;
  private int posY;
  private boolean isBlack;
  private Checker check;

  public Tile(int x, int y, boolean ib) {
    posX = x;
    posY = y;
    isBlack = ib;
    check = null;
  }

  int getPosX() {
    return posX;
  }

  int getPosY() {
    return posY;
  }

  boolean getIsBlack() {
    return isBlack;
  }

  Checker getCheck() {
    return check;
  }

  void setCheck(Checker ch) {
    this.check = ch;
  }
}
