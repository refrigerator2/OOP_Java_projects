class Osoba extends Wpis
{
  private String imie;
  private String nazwisko;
  private String adres;

  public Osoba(String imie, String nazwisko, String adres) 
  {
    this.imie = imie;
    this.nazwisko = nazwisko;
    this.adres = adres;
  }

  @Override
  public void opisz() 
  {
    System.out.println("Osoba: " + imie + " " + nazwisko + ", Adres: " + adres);
  }

  @Override
  String getAdres() 
  {
    return adres;
  }
}
