
public class LocalMinimumMatrix {

    public static int[] findLocalMinimum(int[][] matrix) {
        int n = matrix.length;
        return findLocalMinHelper(matrix, 0, n - 1, 0, n - 1);
    }

    private static int[] findLocalMinHelper(int[][] a, int rowStart, int rowEnd, int colStart, int colEnd) {
        // Trường hợp cơ sở: Vùng tìm kiếm quá nhỏ
        if (rowStart > rowEnd || colStart > colEnd) {
            return null;
        }

        int midRow = rowStart + (rowEnd - rowStart) / 2;
        int midCol = colStart + (colEnd - colStart) / 2;

        int minR = -1;
        int minC = -1;
        int minVal = Integer.MAX_VALUE;

        // 1. Tìm phần tử nhỏ nhất trên hàng giữa
        for (int j = colStart; j <= colEnd; j++) {
            if (a[midRow][j] < minVal) {
                minVal = a[midRow][j];
                minR = midRow;
                minC = j;
            }
        }

        // 2. Tìm phần tử nhỏ nhất trên cột giữa
        for (int i = rowStart; i <= rowEnd; i++) {
            if (a[i][midCol] < minVal) {
                minVal = a[i][midCol];
                minR = i;
                minC = midCol;
            }
        }

        // 3. Tìm phần tử nhỏ nhất trên 4 cạnh viền
        for (int j = colStart; j <= colEnd; j++) {
            if (a[rowStart][j] < minVal) {
                minVal = a[rowStart][j];
                minR = rowStart;
                minC = j;
            }
            if (a[rowEnd][j] < minVal) {
                minVal = a[rowEnd][j];
                minR = rowEnd;
                minC = j;
            }
        }
        for (int i = rowStart; i <= rowEnd; i++) {
            if (a[i][colStart] < minVal) {
                minVal = a[i][colStart];
                minR = i;
                minC = colStart;
            }
            if (a[i][colEnd] < minVal) {
                minVal = a[i][colEnd];
                minR = i;
                minC = colEnd;
            }
        }

        // 4. Kiểm tra các hàng xóm xung quanh minVal
        int smallestR = minR;
        int smallestC = minC;

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        for (int k = 0; k < 4; k++) {
            int nr = minR + dr[k];
            int nc = minC + dc[k];

            if (nr >= 0 && nr < a.length && nc >= 0 && nc < a.length) {
                if (a[nr][nc] < a[smallestR][smallestC]) {
                    smallestR = nr;
                    smallestC = nc;
                }
            }
        }

        // Nếu minVal nhỏ hơn tất cả hàng xóm kề cạnh -> Đây là Local Minimum
        if (smallestR == minR && smallestC == minC) {
            return new int[]{minR, minC};
        }

        // 5. Nếu không, đệ quy vào 1 trong 4 góc chứa phần tử nhỏ hơn
        if (smallestR < midRow && smallestC < midCol) {
            return findLocalMinHelper(a, rowStart + 1, midRow - 1, colStart + 1, midCol - 1);
        } else if (smallestR < midRow && smallestC > midCol) {
            return findLocalMinHelper(a, rowStart + 1, midRow - 1, midCol + 1, colEnd - 1);
        } else if (smallestR > midRow && smallestC < midCol) {
            return findLocalMinHelper(a, midRow + 1, rowEnd - 1, colStart + 1, midCol - 1);
        } else {
            return findLocalMinHelper(a, midRow + 1, rowEnd - 1, midCol + 1, colEnd - 1);
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {
            {30, 100, 20, 19, 18},
            {29,  80, 27, 81, 17},
            {28,  14, 13, 22, 16},
            {25,  85, 86, 87, 15},
            {24,  23, 22, 21,  2}
        };

        int[] result = findLocalMinimum(matrix);
        if (result != null) {
            System.out.println("Local minimum at index: [" + result[0] + "][" + result[1] + "]");
            System.out.println("Value: " + matrix[result[0]][result[1]]);
        }
    }
}