import java.io.*;
import java.util.*;

public class balancedBrackets {

    public static String isBalanced(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } 
            else if (c == ')' || c == '}' || c == ']') {
                if (stack.isEmpty()) {
                    return "NO";
                }
                
                char top = stack.pop();
                
                if (c == ')' && top != '(') return "NO";
                if (c == '}' && top != '{') return "NO";
                if (c == ']' && top != '[') return "NO";
            }
        }
        
        return stack.isEmpty() ? "YES" : "NO";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        if (scanner.hasNextInt()) {
            int n = scanner.nextInt();
            scanner.nextLine();
            
            for (int i = 0; i < n; i++) {
                if (scanner.hasNextLine()) {
                    String s = scanner.nextLine();
                    System.out.println(isBalanced(s));
                }
            }
        }
        scanner.close();
    }
}