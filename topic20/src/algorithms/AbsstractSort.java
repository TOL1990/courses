package algorithms;

/**
 * Created by Leonid on 26.04.2016.
 */
public abstract class AbsstractSort  implements Runnable{
   public int [] arr;


    protected void print() {
        for (int i=0; i<arr.length-1; i++) {
            System.out.print(arr[i] + ", ");
        }
        System.out.println(arr[arr.length-1]);

    }

    /**
     * Вывод для внешних класов
     * return int[]
     */
    public int[] outPrintIntArr()
    {
       return arr;

    }
    /**
     * Вывод для внешних класов
     * return String
     */
    public String outPrintStr()
    {
        StringBuffer buffer= new StringBuffer();
        for (int i=0; i<arr.length-1; i++) {
//            System.out.print(arr[i] + ", ");
            buffer.append(arr[i] + ", ");
        }
        return buffer.toString();

    }
}
