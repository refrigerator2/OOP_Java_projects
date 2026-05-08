class Message {
  private final String msg;
  private final String time;

  public Message(String msg, String time) {
    this.msg = msg;
    this.time = time;
  }

  public String toString() {
    StringBuilder sb = new StringBuilder(msg);
    sb.append("|");
    sb.append(time);
    String res = sb.toString();
    return res;
  }
}
