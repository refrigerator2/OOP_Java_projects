import java.nio.file.*;
import java.util.Scanner;
import java.util.*;
import java.io.IOException;

public class FileHandler 
{
  public static String readRaw(String fname)
   {
    try
    {
      return Files.readString(Path.of(fname));
    } 
    catch (Exception e)
    {
      return null;
    }
  }

  public static ShopList load(String fname) 
  {
    String content = readRaw(fname);
    return (content == null) ? null : parse(content);
  }

  public static ShopList parse(String content) 
  {
    List<Category> cats = new ArrayList<>();
    String[] lines = content.split("\\R");
    Category currentCat = null;

    for (String line : lines) 
    {
      line = line.trim();
      if (line.isEmpty())
        continue;

      if (line.startsWith("[") && line.endsWith("]")) 
      {
        currentCat = new Category(line.substring(1, line.length() - 1));
        cats.add(currentCat);
      } 
      else if (currentCat != null) 
      {
        currentCat.addProduct(line);
      }
    }
    return new ShopList(cats);
  }

  public static void save(String fname, ShopList list) 
  {
    try 
    {
      Files.writeString(Path.of(fname), list.asFileFormat());
    } 
    catch (IOException e) 
    {
      System.out.println("Save error: " + e.getMessage());
    }
  }
}