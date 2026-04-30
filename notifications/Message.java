import java.time.LocalDateTime;
import java.time.format.*;

class Message {
  private final String msg;
  private final String time;

  public Message(String msg) {
    this.msg = msg;
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    LocalDateTime now = LocalDateTime.now();
    this.time = now.format(formatter);
  }

  public String toString() {
    StringBuilder sb = new StringBuilder(msg);
    sb.append("|");
    sb.append(time);
    String res = sb.toString();
    return res;
  }
}
