public class Checker {
  private boolean isBlack;
  private int posX;
  private int posY;

  public Checker(boolean isBlack) {
    this.isBlack = isBlack;
    posX = -1;
    posY = -1;
  }

  public boolean getIsBlack() {
    return isBlack;
  }

  public int getPosX() {
    return posX;
  }

  public int getPosY() {
    return posY;
  }

  public void setPosX(int x) {
    posX = x;
  }

  public void setPosY(int y) {
    posY = y;
  }
}
