import java.util.Scanner;
import java.util.Vector;

public class InputUtils
{
    public static void run()
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("Input first vector: ");
        Vector<Integer> firstVector = InputUtils.getVector(sc);

        System.out.println("Input second vector: ");
        Vector<Integer> secondVector = InputUtils.getVector(sc);

        try
        {
            Vector<Integer> res = VectorUtils.addVectors(firstVector, secondVector);
            System.out.println(res);
        }
        catch (WektoryRoznejDlugosciException e)
        {
            System.out.println("Długość pierwszego wektora to " + e.getSizeOfFirst() +
                    " a drugiego to " + e.getSizeOfSecond());
        }
    }
    private static Vector<Integer> getVector(Scanner sc)
    {
        Vector<Integer> vec = new Vector<>();
        String input = sc.nextLine();
        String[] strNums = input.trim().split("\\s+");
        parseStringToVec(vec, strNums);
        return vec;
    }

    private static void parseStringToVec(Vector<Integer> vec, String[] strNums)
    {
        for (String elem : strNums)
        {
            try
            {
                vec.add(Integer.parseInt(elem));
            }
            catch (Exception ignored)
            {
            }
        }
    }
}
