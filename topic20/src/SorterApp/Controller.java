package SorterApp;

import algorithms.BubleSort;
import algorithms.QuickSort;

import java.util.Random;

/**
 * Created by Leonid on 24.04.2016.
 */
public class Controller {
    private int[] unsortedArr;
    private BubleSort bubleSort;
    private QuickSort quickSort;

    private final int ARRAY_LENGTH = 100;

    public Controller() {
        init();
    }

    private void init() {
        unsortedArr = CreateAndMix();
         bubleSort = new BubleSort(unsortedArr);
         quickSort = new QuickSort(unsortedArr);
    }

    private int[] arr;

    public void generateArr() {
        unsortedArr = CreateAndMix();
        bubleSort = new BubleSort(unsortedArr);
    }

    public void start() {


//        Thread bubleTread = new Thread(new BubleSort());
    }

    public void pause() {
    }

    public void clear() {
    }

    private int[] CreateAndMix() {
        int[] arr = new int[100];
        for (int i = 0; i < ARRAY_LENGTH; i++) {
            arr[i] = i + 1;
        }

        Random rnd = new Random();
        for (int i = 1; i < ARRAY_LENGTH; i++) {
            int j = rnd.nextInt(i);
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
        return arr;
    }


    public int[] getBubleArr() {
        return bubleSort.outPrintIntArr();
    }
    public String getBubleArrStr() {
      return bubleSort.outPrintStr();
    }

    public int[] getQuickArr() {
        return quickSort.outPrintIntArr();
    }
    public String getQuickArrStr() {
        return quickSort.outPrintStr();
    }

}
