import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        if (!scanner.hasNextInt()) return;
        int q = scanner.nextInt();
        
        Stack<Integer> stackEnqueue = new Stack<>();
        Stack<Integer> stackDequeue = new Stack<>();
        
        for (int i = 0; i < q; i++) {
            int type = scanner.nextInt();
            
            if (type == 1) {
                int x = scanner.nextInt();
                stackEnqueue.push(x);
            } else {
                if (stackDequeue.isEmpty()) {
                    while (!stackEnqueue.isEmpty()) {
                        stackDequeue.push(stackEnqueue.pop());
                    }
                }
                
                if (type == 2) {
                    if (!stackDequeue.isEmpty()) {
                        stackDequeue.pop();
                    }
                } else if (type == 3) {
                    if (!stackDequeue.isEmpty()) {
                        System.out.println(stackDequeue.peek());
                    }
                }
            }
        }
        scanner.close();
    }
}