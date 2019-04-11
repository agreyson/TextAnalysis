import java.util.ArrayList;
import java.util.Arrays;

public class SortingMethods {
    public SortingMethods() {
    }

    public static void sort(ArrayList<String> words){
        //SortingMethods.selectionSort(words);
        SortingMethods.insertionSort(words);

        // merge sort for instructional purposes, only; all the copying is very inefficient
//        String[] arr = new String[words.size()];
//        arr = words.toArray(arr);
//        SortingMethods.mergeSort(arr);
//        ArrayList<String> al = new ArrayList<String>(Arrays.asList(arr));
//        for (int i = 0; i < al.size(); i++){
//            words.set(i, al.get(i));
//        }
    }

    private static void selectionSort(ArrayList<String> words) {
        for (int curIndex = 0; curIndex < words.size() - 1; curIndex++) {
            int minIndex = findMin(words, curIndex);
            swap(words, curIndex, minIndex);
        }
    }

    private static int findMin(ArrayList<String> arr, int startingIndex) {
        int minIndex = startingIndex;

        for (int i = minIndex; i < arr.size(); i++) {
            if (arr.get(i).compareToIgnoreCase(arr.get(minIndex)) < 0) { // stringA.compareToIgnoreCase(stringB)
                minIndex = i;
            }
        }
        return minIndex;
    }

    private static void swap(ArrayList<String> arr, int x, int y) {
        String temp = arr.get(x);
        arr.set(x, arr.get(y));
        arr.set(y, temp);
    }

    private static void insertionSort(ArrayList<String> words) {
        for (int i = 1; i < words.size(); i++) {
            String curString = words.get(i);
            int curIndex = i - 1;
            while (curIndex >= 0 && words.get(curIndex).compareToIgnoreCase(curString) > 0) {
                // Shift the value at curIndex to the right one place
                words.set(curIndex + 1, words.get(curIndex));
                curIndex--;
            }

            // Put this string in the proper location
            words.set(curIndex + 1, curString);
        }
    }

    private static void mergeSort(String[] arr) {
        if (arr.length <= 1) {
            return;
        }

        String[] firstHalf = new String[arr.length / 2];
        String[] secondHalf = new String[arr.length - firstHalf.length];
        System.arraycopy(arr, 0, firstHalf, 0, firstHalf.length);
        System.arraycopy(arr, firstHalf.length, secondHalf, 0, secondHalf.length);

        SortingMethods.mergeSort(firstHalf);
        SortingMethods.mergeSort(secondHalf);
        SortingMethods.merge(firstHalf, secondHalf, arr);
    }

    private static void merge(String[] firstHalf, String[] secondHalf, String[] result) {
        int firstIndex = 0;
        int secondIndex = 0;
        int resultIndex = 0;
        while (firstIndex < firstHalf.length && secondIndex < secondHalf.length) {
            if (firstHalf[firstIndex].compareToIgnoreCase(secondHalf[secondIndex]) < 0) {
                result[resultIndex] = firstHalf[firstIndex];
                firstIndex++;
            } else {
                result[resultIndex] = secondHalf[secondIndex];
                secondIndex++;
            }
            resultIndex++;
        }
        System.arraycopy(firstHalf, firstIndex, result, resultIndex, firstHalf.length - firstIndex);
        System.arraycopy(secondHalf, secondIndex, result, resultIndex, secondHalf.length - secondIndex);
    }
}
