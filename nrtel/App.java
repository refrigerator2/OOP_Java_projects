import java.util.*;

public class App {
  public static void run()
  {
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

  private static void display(TreeMap<NrTelefoniczny, Wpis> map) 
  {
    Iterator<Map.Entry<NrTelefoniczny, Wpis>> it = map.entrySet().iterator();
    while (it.hasNext()) {
      Map.Entry<NrTelefoniczny, Wpis> temp = it.next();
      System.out.println(temp.getKey() + " -> ");
      temp.getValue().opisz();
    }
  }

  private static void deleteDuplicates(TreeMap<NrTelefoniczny, Wpis> map) 
  {
    HashSet<String> uniq = new HashSet<>();
    Iterator<Map.Entry<NrTelefoniczny, Wpis>> it = map.entrySet().iterator();
    while (it.hasNext()) 
    {
      Map.Entry<NrTelefoniczny, Wpis> temp = it.next();
      String ul = temp.getValue().getAdres();
      if (uniq.contains(ul)) 
      {
        it.remove();
      } else 
      {
        uniq.add(ul);
      }
    }
  }
}
