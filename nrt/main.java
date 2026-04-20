import java.util.*;

public class Main {
  public static void main(String[] args) {
    TreeMap<NrTelefoniczny, Wpis> ksiazka = new TreeMap<>();
    ksiazka.put(new NrTelefoniczny("48", "123456789"), new Osoba("Jan", "Kowalski", "ul. Pilsudsiego 67"));
    ksiazka.put(new NrTelefoniczny("48", "987654321"), new Osoba("Maciej", "Nowak", "aleje Politechniki 1"));
    ksiazka.put(new NrTelefoniczny("1", "999988881"), new Firma("Biedronka", "aleje Politechniki 1"));
    System.out.println("Pelna ksiazka: ");
    display(ksiazka);
    deleteDuplicates(ksiazka);
    System.out.println("\nBez duplikatow: ");
    display(ksiazka);
  }

  public static void display(TreeMap<NrTelefoniczny, Wpis> map) {
    Iterator<Map.Entry<NrTelefoniczny, Wpis>> it = map.entrySet().iterator();
    while (it.hasNext()) {
      Map.Entry<NrTelefoniczny, Wpis> temp = it.next();
      System.out.println(temp.getKey() + " -> ");
      temp.getValue().opisz();
    }
  }

  public static void deleteDuplicates(TreeMap<NrTelefoniczny, Wpis> map) {
    HashSet<String> uniq = new HashSet<>();
    Iterator<Map.Entry<NrTelefoniczny, Wpis>> it = map.entrySet().iterator();
    while (it.hasNext()) {
      Map.Entry<NrTelefoniczny, Wpis> temp = it.next();
      String ul = temp.getValue().getAdres();
      if (uniq.contains(ul)) {
        it.remove();
      } else {
        uniq.add(ul);
      }
    }
  }
}

abstract class Wpis {
  abstract void opisz();

  abstract String getAdres();
}

class Osoba extends Wpis {
  private String imie;
  private String nazwisko;
  private String adres;

  public Osoba(String imie, String nazwisko, String adres) {
    this.imie = imie;
    this.nazwisko = nazwisko;
    this.adres = adres;
  }

  @Override
  public void opisz() {
    System.out.println("Osoba: " + imie + " " + nazwisko + ", Adres: " + adres);
  }

  @Override
  String getAdres() {
    return adres;
  }
}

class Firma extends Wpis {
  private String nazwa;
  private String adres;

  public Firma(String nazwa, String adres) {
    this.nazwa = nazwa;
    this.adres = adres;
  }

  @Override
  public void opisz() {
    System.out.println("Firma: " + nazwa + ", Adres: " + adres);
  }

  @Override
  String getAdres() {
    return adres;
  }
}

class NrTelefoniczny implements Comparable<NrTelefoniczny> {
  private String nrKierunkowy;
  private String nrTelefonu;

  public NrTelefoniczny(String nrKierunkowy, String nrTelefonu) {
    this.nrKierunkowy = nrKierunkowy;
    this.nrTelefonu = nrTelefonu;
  }

  @Override
  public int compareTo(NrTelefoniczny o) {
    int res = this.nrKierunkowy.compareTo(o.nrKierunkowy);
    if (res == 0) {
      return this.nrTelefonu.compareTo(o.nrTelefonu);
    }
    return res;
  }

  @Override
  public String toString() {
    return "(" + nrKierunkowy + ") " + nrTelefonu;
  }
}
