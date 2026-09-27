import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution {

    static class Operation {
        int type;
        String text;

        public Operation(int type, String text) {
            this.type = type;
            this.text = text;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String firstLine = br.readLine();
        if (firstLine == null) return;
        int q = Integer.parseInt(firstLine.trim());

        StringBuilder s = new StringBuilder();
        Stack<Operation> history = new Stack<>();
        StringBuilder output = new StringBuilder();

        for (int i = 0; i < q; i++) {
            String line = br.readLine();
            if (line == null) break;
            st = new StringTokenizer(line);
            int type = Integer.parseInt(st.nextToken());

            if (type == 1) {
                String w = st.nextToken();
                s.append(w);
                history.push(new Operation(1, w));
            } 
            else if (type == 2) {
                int k = Integer.parseInt(st.nextToken());
                int len = s.length();
                String deleted = s.substring(len - k, len);
                s.delete(len - k, len);
                history.push(new Operation(2, deleted));
            } 
            else if (type == 3) {
                int k = Integer.parseInt(st.nextToken());
                output.append(s.charAt(k - 1)).append("\n");
            } 
            else if (type == 4) {
                Operation lastOp = history.pop();
                if (lastOp.type == 1) {
                    int wLen = lastOp.text.length();
                    s.delete(s.length() - wLen, s.length());
                } else if (lastOp.type == 2) {
                    s.append(lastOp.text);
                }
            }
        }

        System.out.print(output);
    }
}