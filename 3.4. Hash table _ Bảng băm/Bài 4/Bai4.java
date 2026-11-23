import java.io.*;
import java.util.*;

public class Solution {

    public static int pairs(int k, List<Integer> arr) {
        Set<Integer> set = new HashSet<>(arr);
        int count = 0;

        for (int num : arr) {
            if (set.contains(num + k)) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();
        int k = sc.nextInt();

        List<Integer> arr = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            arr.add(sc.nextInt());
        }

        System.out.println(pairs(k, arr));
        sc.close();
    }
}