public class Main{
    public static void main(String[] args){
      if(args.length != 3){
        System.out.println("Wrong number of arguments");
        return;
      }
      String word = args[0];
      int start, end;
      try{
        start = Integer.parseInt(args[1]);
        end = Integer.parseInt(args[2]);
      }
      catch(Exception e){
        System.out.println("Wrong arguments type");
        return;
      }
      String res = stringConversion(word, start, end+1);
      System.out.println(res);
    }
    public static String stringConversion(String str, int start, int end){
      if(start < 0) {
        start = 0;
      }
      if(end >= str.length()){
        end = str.length();
      }
      return str.substring(start, end);
    }
    
}
