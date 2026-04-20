import java.util.Scanner;

public class ShoppingApp {
  private final ShopList masterList;
  private final ShopList userList;
  private final String userFile;
  private final Scanner sc;

  public ShoppingApp(ShopList masterList, ShopList userList, String userFile) {
    this.masterList = masterList;
    this.userList = userList;
    this.userFile = userFile;
    this.sc = new Scanner(System.in);
  }

  public void run() {
    while (true) {
      printMainMenu();
      int choice = getCorrectNumber(1, 7);

      switch (choice) {
        case 1 -> addProductFlow();
        case 2 -> System.out.println(userList.asString());
        case 3 -> displayByCategoryFlow();
        case 4 -> clearAllFlow();
        case 5 -> clearCategoryFlow();
        case 6 -> removeProductFlow();
        case 7 -> {
          saveAndExit();
          return;
        }
      }
    }
  }

  private void printMainMenu() {
    System.out.println("\n--- MAIN MENU ---");
    System.out.println("1. Add product to your list");
    System.out.println("2. Display your shopping list");
    System.out.println("3. Display products by category");
    System.out.println("4. Clear your list");
    System.out.println("5. Clear entire category");
    System.out.println("6. Remove single product");
    System.out.println("7. Save and Exit");
    System.out.print("Choose an option: ");
  }

  private void addProductFlow() {
    System.out.println("\n--- AVAILABLE CATEGORIES ---");
    masterList.displayCats();
    System.out.print("Select category number: ");
    int cId = getCorrectNumber(1, masterList.getSize()) - 1;

    System.out.println("\n--- PRODUCTS IN CATEGORY ---");
    masterList.displaySingleCategory(cId);
    System.out.print("Select product number to add: ");
    int pId = getCorrectNumber(1, masterList.getCatSize(cId)) - 1;

    userList.addProduct(masterList.getProductName(cId, pId), cId);
    System.out.println("Added successfully!");
  }

  private void displayByCategoryFlow() {
    System.out.println("\n--- SELECT CATEGORY TO VIEW ---");
    userList.displayCats();
    System.out.print("Enter number: ");
    int catId = getCorrectNumber(1, userList.getSize()) - 1;
    System.out.println(userList.getCategoryString(catId));
  }

  private void clearAllFlow() {
    userList.clearAll();
    System.out.println("Your shopping list is now empty.");
  }

  private void clearCategoryFlow() {
    userList.displayCats();
    System.out.print("Select category to clear: ");
    int clearId = getCorrectNumber(1, userList.getSize()) - 1;
    userList.clearCategory(clearId);
    System.out.println("Category cleared.");
  }

  private void removeProductFlow() {
    if (userList.isEmpty()) {
      System.out.println("Nothing to remove, list is empty.");
      return;
    }
    userList.displayCats();
    System.out.print("Select category: ");
    int remCatId = getCorrectNumber(1, userList.getSize()) - 1;

    if (userList.getCatSize(remCatId) == 0) {
      System.out.println("This category is already empty.");
      return;
    }
    userList.displaySingleCategory(remCatId);
    System.out.print("Select product to remove: ");
    int remProdId = getCorrectNumber(1, userList.getCatSize(remCatId)) - 1;
    userList.removeOneProduct(remCatId, remProdId);
    System.out.println("Removed!");
  }

  private void saveAndExit() {
    FileHandler.save(userFile, userList);
    System.out.println("Successfully saved to: " + userFile);
  }

  private int getCorrectNumber(int leftBound, int rightBound) {
    while (true) {
      if (sc.hasNextInt()) {
        int temp = sc.nextInt();
        if (temp >= leftBound && temp <= rightBound) {
          return temp;
        }
        System.out.println("The entered value is out of range");
      } else {
        sc.next();
        System.out.println("Please input a number");
      }
    }
  }
}
