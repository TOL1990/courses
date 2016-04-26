package algorithms;

/**
 * Created by Leonid on 23.04.2016.
 */
public class BubleSort extends AbsstractSort {

    public BubleSort(int[] currentArr) {

         super.arr = currentArr ;
    }

    @Override
    public void run() {
            sort();
    }

    private void sort() {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int t = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = t;
                    print();
                }
            }
        }
    }


}
