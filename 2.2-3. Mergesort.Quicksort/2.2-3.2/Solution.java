import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'insertionSort' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static void mergeSort(List<Integer> arr) {
        // Write your code here
        if (arr == null || arr.size() <= 1) {
            return;
        }
        sort(arr, 0, arr.size() - 1);
    }

    private static void sort(List<Integer> arr, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            sort(arr, left, mid);
            sort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    private static void merge(List<Integer> arr, int left, int mid, int right) {
        List<Integer> temp = new ArrayList<>(right - left + 1);
        int i = left;
        int j = mid + 1;

        while (i <= mid && j <= right) {
            if (arr.get(i) <= arr.get(j)) {
                temp.add(arr.get(i));
                i++;
            } else {
                temp.add(arr.get(j));
                j++;
            }
        }

        while (i <= mid) {
            temp.add(arr.get(i));
            i++;
        }

        while (j <= right) {
            temp.add(arr.get(j));
            j++;
        }

        for (int k = 0; k < temp.size(); k++) {
            arr.set(left + k, temp.get(k));
        }
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        Result.mergeSort(arr);

        bufferedWriter.write(
            arr.stream()
                .map(Object::toString)
                .collect(Collectors.joining(" "))
        );
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}