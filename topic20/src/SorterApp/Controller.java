package SorterApp;

import algorithms.AbsstractSort;
import algorithms.BubleSort;
import algorithms.QuickSort;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Leonid on 24.04.2016.
 */
public class Controller {
    private int[] unsortedArr;
    private List<AbsstractSort> algorithms;
    private BubleSort bubleSort;
    private QuickSort quickSort;

    public static Boolean waitFlag;

    private final int ARRAY_LENGTH = 100;

    public Controller() {
        init();
    }

    private void init() {
        waitFlag = false;
        unsortedArr = CreateAndMix();
        algorithms = new ArrayList<>();
        algorithms.add(new BubleSort(unsortedArr));
        algorithms.add(new QuickSort(unsortedArr));
    }

    public void generateArr() {
        unsortedArr = CreateAndMix();
        algorithms.add(new BubleSort(unsortedArr));
        algorithms.add(new QuickSort(unsortedArr));
//        bubleSort = new BubleSort(unsortedArr);
//        quickSort = new QuickSort(unsortedArr);
    }

    public void start() {
        if(waitFlag == false) {
            Thread bubleTread = new Thread(algorithms.get(1));// 1       bubleSort
            Thread quickTread = new Thread(algorithms.get(2));// 2      quickSort
            bubleTread.start();
//            quickTread.start();
        }

        //if run
        synchronized (Flag.wait) {
            Flag.wait.notifyAll();
            waitFlag = false;
        }

    }

    public void pause() {
        try {
            Flag.wait.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        waitFlag = true;

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
        return algorithms.get(1).outPrintIntArr(); //1 - Bublesort
//     return bubleSort.outPrintIntArr();
    }

    public String getBubleArrStr() {
        return algorithms.get(1).outPrintStr(); //1 - Bublesort
//        return bubleSort.outPrintStr();
    }

    public int[] getQuickArr() {
        return algorithms.get(2).outPrintIntArr(); //2 - Quicksort
//        return quickSort.outPrintIntArr();
    }

    public String getQuickArrStr() {
        return algorithms.get(2).outPrintStr(); //2 - Quicksort
//        return quickSort.outPrintStr();
    }

    public List<AbsstractSort> getAlgorithms() {
        return algorithms;
    }

    public void setAlgorithms(List<AbsstractSort> algorithms) {
        this.algorithms = algorithms;
    }
}
