import java.util.*;

public class ShopList {
  private List<Category> cats;

  public ShopList(ShopList other) {
    this.cats = new ArrayList<>();
    for (Category c : other.cats) {
      this.cats.add(new Category(c.getName()));
    }
    ;
  }

  public ShopList(List<Category> cats) {
    this.cats = cats;
  }

  public String asString() {
    StringBuilder sb = new StringBuilder("--- SHOPPING LIST ---\n");
    for (Category c : cats)
      sb.append(c.asString());
    return sb.toString();
  }

  public String asFileFormat() {
    StringBuilder sb = new StringBuilder();
    for (Category c : cats) {
      sb.append("[").append(c.getName()).append("]\n");
      for (int i = 0; i < c.getSize(); i++) {
        sb.append(c.getProduct(i)).append("\n");
      }
    }
    return sb.toString();
  }

  public void displayAll() {
    int id = 1;
    for (Category cat : cats) {
      System.out.println(cat.asString());
      id++;
    }
  }

  public void displayCats() {
    int id = 1;
    for (Category cat : this.cats) {
      String name = cat.getName();
      System.out.println(id + ". " + name);
      id++;
    }
  }

  public boolean isEmpty() {
    for (Category cat : this.cats) {
      if (cat.getSize() > 0) {
        return false;
      }
    }
    return true;
  }

  public void displaySingleCategory(int id) {
    if (id >= 0 && id < cats.size()) {
      System.out.println(cats.get(id).asString());
    }
  }

  public void clearCategory(int id) {
    if (id >= 0 && id < cats.size()) {
      cats.get(id).clearProducts();
    }
  }

  public void clearAll() {
    for (int i = 0; i < cats.size(); i++) {
      clearCategory(i);
    }
  }

  public void removeOneProduct(int cat_id, int prod_id) {
    if (cat_id >= 0 && cat_id < cats.size()) {
      cats.get(cat_id).removeProduct(prod_id);
    }
  }

  public void addProduct(String product_name, int cat_id) {
    if (cat_id >= 0 && cat_id < cats.size()) {
      cats.get(cat_id).addProduct(product_name);
    }
  }

  public int getSize() {
    return cats.size();
  }

  public int getCatSize(int id) {
    if (id >= 0 && id < cats.size()) {
      return cats.get(id).getSize();
    }
    return 0;
  }

  public String getCategoryString(int id) {
    return cats.get(id).asString();
  }

  public String getProductName(int cat_id, int product_id) {
    if (cat_id >= 0 && cat_id < cats.size()) {
      return cats.get(cat_id).getProduct(product_id);
    }
    return null;
  }
}
