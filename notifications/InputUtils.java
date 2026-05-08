import java.util.Scanner;
import java.time.format.*;
import java.time.*;

public class InputUtils {
  private final Scanner sc;
  private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

  public InputUtils(Scanner sc) {
    this.sc = sc;
  }

  public Message getInput() {
    System.out.print("Enter message to server: ");
    String msg = sc.nextLine();
    String time = getTime();
    return new Message(msg, time);
  }

  private String getTime() {
    while (true) {
      System.out.print("Input date (yyyy-MM-dd HH:mm): ");
      String input = sc.nextLine();

      try {
        LocalDateTime userTime = LocalDateTime.parse(input, formatter);

        if (userTime.isBefore(LocalDateTime.now())) {
          System.out.println("Error: time is in the past!");
        } else {
          return userTime.toString();
        }
      } catch (DateTimeParseException e) {
        System.out.println("Error: wrong format! Use: yyyy-MM-dd HH:mm");
      }
    }
  }
}
