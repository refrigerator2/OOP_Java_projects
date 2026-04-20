public class Main {
  public static void main(String[] args) {
    if (args.length > 1) {
      System.out.println("Too many arguments");
      return;
    }

    String productListFile = "products.txt";
    String userFile = args.length > 0 ? args[0] : "list.txt";

    ShopList masterList = FileHandler.load(productListFile);
    if (masterList == null) {
      System.out.println("Could not load products.txt. Check if the file exists.");
      return;
    }

    String existingData = FileHandler.readRaw(userFile);
    ShopList userList = (existingData == null) ? new ShopList(masterList) : FileHandler.parse(existingData);

    ShoppingApp app = new ShoppingApp(masterList, userList, userFile);
    app.run();
  }
}
