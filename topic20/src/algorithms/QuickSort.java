package algorithms;

import java.util.Random;

/**
 * Created by Leonid on 23.04.2016.
 */
public class QuickSort extends AbsstractSort{

    public  final int ARRAY_LENGTH = 100;
//    private  int[] array = new int[ARRAY_LENGTH];
    private  Random generator = new Random();

    public QuickSort(int[] currentArr)
    {
        super.arr = currentArr;
    }

    @Override
    public void run() {
        sort();
    }

    private void sort() {
        int startIndex = 0;
        int endIndex = ARRAY_LENGTH - 1;
        doSort(startIndex, endIndex);
    }



//    public void print() {
//        for (int i=0; i<ARRAY_LENGTH-1; i++) {
//            System.out.print(arr[i] + ", ");
//        }
//        System.out.println((arr[ARRAY_LENGTH-1]);
//    }

    private void doSort(int start, int end) {
        if (start >= end)
            return;
        int i = start, j = end;
        int cur = i - (i - j) / 2;
        while (i < j) {
            while (i < cur && (arr[i] <= arr[cur])) {
                i++;
            }
            while (j > cur && (arr[cur] <= arr[j])) {
                j--;
            }
            if (i < j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                if (i == cur)
                    cur = j;
                else if (j == cur)
                    cur = i;
            }
            System.out.println("quick");
            print(); // print to console
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        doSort(start, cur);
        doSort(cur+1, end);
    }



}
