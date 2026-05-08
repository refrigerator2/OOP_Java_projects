public class WektoryRoznejDlugosciException extends Exception
{
  private final int v1Size;
  private final int v2Size;

  public WektoryRoznejDlugosciException(int fSize, int sSize)
  {
    this.v1Size = fSize;
    this.v2Size = sSize;
  }

  public int getSizeOfFirst()
  {
    return v1Size;
  }

  public int getSizeOfSecond()
  {
    return v2Size;
  }
}
