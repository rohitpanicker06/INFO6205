package edu.neu.coe.info6205.sort.elementary;

import edu.neu.coe.info6205.util.Benchmark_Timer;

import java.util.*;
import java.util.function.Supplier;

public class BenchMarkingInsertionSort {



         public static Integer[] getRandomArray(int n)
         {
             Random rd = new Random();
             Integer[] arr = new Integer[n];
             for (int i = 0; i < arr.length; i++) {
                 arr[i] = rd.nextInt();

             }
             return arr;
         }


         public static Integer[] getOrdered(int n)
         {
             Random rd = new Random();
             Integer[] arr = new Integer[n];
             for (int i = 0; i < arr.length; i++) {
                 arr[i] = rd.nextInt();

             }
              Arrays.sort(arr);
             return arr;

         }

         public static Integer[] reverseOrdered(int n)
         {
             Random rd = new Random();
             Integer[] arr = new Integer[n];
             for (int i = 0; i < arr.length; i++) {
                 arr[i] = rd.nextInt();

             }
             Arrays.sort(arr, Collections.reverseOrder());
             return arr;
         }

         public static  Integer[] partiallyOrdered(int n)
         {
             Random r = new Random();
             Integer[] arr = new Integer[n];
             for (int i = 0; i < n / 4; i++) {
                 arr[i] = i + 1;
             }
             for (int j = n / 4; j < n * 3 / 4; j++) {
                 arr[j] = r.nextInt(n);
             }
             for (int k = n * 3 / 4; k < n; k++) {
                 arr[k] = k + 1;
             }
             return arr;
         }



    public static void main(String[] args) {

        int initial_count = 100;
        int totalTests = 5;
        int sizex = initial_count;
        for (int i = 0;  i < totalTests; i++) {

                if(i <=0) {
                     sizex = initial_count;
                }else{
                    sizex = sizex*2;
                }
                final int size = sizex;

                Map<String, Supplier<Integer[]>> supplierMap = new HashMap<>();

                Benchmark_Timer<Integer[]> bt = new Benchmark_Timer<>("InsertionSort", InsertionSort::sortConsumer);
                System.out.println("elements = " + size + ", " +  "random array: " + bt.runFromSupplier(() -> getRandomArray(size), 100));
                System.out.println("elements = " + size + ", "  + "ordered array: " + bt.runFromSupplier(() -> getOrdered(size), 100));
                System.out.println("elements = " + size + ", " +   " partially array: " + bt.runFromSupplier(() -> partiallyOrdered(size), 100));
                System.out.println("elements = " + size + ", " +   "reverse array: " + bt.runFromSupplier(() -> reverseOrdered(size), 100));

        }
    }


}
