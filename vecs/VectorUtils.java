import java.util.Vector;

public class VectorUtils
{
    public static Vector<Integer> addVectors(Vector<Integer> firstVec, Vector<Integer> secVec)
            throws WektoryRoznejDlugosciException
    {
        if (firstVec.size() != secVec.size())
        {
            throw new WektoryRoznejDlugosciException(firstVec.size(), secVec.size());
        }

        Vector<Integer> res = new Vector<>(firstVec.size());

        for (int i = 0; i < firstVec.size(); i++)
        {
            res.add(firstVec.get(i) + secVec.get(i));
        }
        return res;
    }
}
