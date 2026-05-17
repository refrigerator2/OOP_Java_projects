class Firma extends Wpis
{
  private String nazwa;
  private String adres;

  public Firma(String nazwa, String adres)
  {
    this.nazwa = nazwa;
    this.adres = adres;
  }

  @Override
  public void opisz()
  {
    System.out.println("Firma: " + nazwa + ", Adres: " + adres);
  }

  @Override
  String getAdres() 
  {
    return adres;
  }
}
