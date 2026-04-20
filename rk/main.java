public class Main{
  public static void main(String[] args){
    int size = args.length;
    if(size!=3){  
      System.out.println("Wrong number of arguments: " + size);
      return;
    }
    double[] parsedVars = parseStr(args);
    
    double delta = findD(parsedVars);
    if(delta<0){
      System.out.println("Zero solutions");
      return;
    }

    double[] solutions = solutionsFinder(parsedVars, delta);
    if(delta == 0){
      System.out.println("Solution: x= " + solutions[0]);
    }
    else{
    System.out.println("Solutions: x1=" + solutions[0] + " x2=" + solutions[1]);
    }
  }
  public static double[] parseStr(String[] val){
    double[] res = new double[3];
    for(int i = 0; i < 3; i++){
      res[i] = Double.parseDouble(val[i]);
    }
    return res;
  }
  public static double[] solutionsFinder(double[] vals, double delta){
    double[] sols =  new double[2];
    
    sols[0] = (-vals[1]-Math.sqrt(delta))/(2*vals[0]);
    sols[1] = (-vals[1]+Math.sqrt(delta))/(2*vals[0]);

    return sols;
  }
  public static double findD(double[] vals){
    double delta = Math.pow(vals[1], 2) - 4 * vals[0] * vals[2];
    return delta;
  }
}
