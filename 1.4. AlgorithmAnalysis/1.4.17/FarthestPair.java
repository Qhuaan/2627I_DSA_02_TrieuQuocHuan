public class FarthestPair {
    public static void findFarthestPair(double[] a) {
        if (a == null || a.length < 2) return;

        double min = a[0];
        double max = a[0];

        // Duyệt mảng đúng 1 lần để tìm min và max
        for (int i = 1; i < a.length; i++) {
            if (a[i] < min) {
                min = a[i];
            }
            if (a[i] > max) {
                max = a[i];
            }
        }

        System.out.println("Cặp xa nhất là: (" + min + ", " + max + ")");
        System.out.println("Khoảng cách lớn nhất: " + (max - min));
    }

    public static void main(String[] args) {
        double[] a = {-21.5, 6.9, 123.0, 55.0, -73.0, 62.5};
        findFarthestPair(a);
    }
}