import java.util.*;

public class Category 
{
  private String name;
  private List<String> products;

  public Category(String name) 
  {
    this.name = name;
    this.products = new ArrayList<>();
  }

  public String getName() 
  {
    return this.name;
  }

  public String getProduct(int id) 
  {
    if (id >= 0 && id < this.products.size()) 
    {
      return this.products.get(id);
    }
    return null;
  }

  public void addProduct(String product) 
  {
    this.products.add(product);
  }

  public void removeProduct(int index) 
  {
    if (index >= 0 && index < products.size()) 
    {
      this.products.remove(index);
    }
  }

  public String asString() 
  {
    if (products.isEmpty())
      return name + ": (empty)";
    StringBuilder sb = new StringBuilder(name + ":\n");
    for (int i = 0; i < products.size(); i++) 
    {
      sb.append("  ").append(i + 1).append(". ").append(products.get(i)).append("\n");
    }
    return sb.toString();
  }

  public void clearProducts() 
  {
    this.products.clear();
  }

  public int getSize() 
  {
    return this.products.size();
  }
}