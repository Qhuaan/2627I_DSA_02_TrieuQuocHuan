public class Bai3a_LinearProbing {
    private static final int SIZE = 17;
    private Integer[] table = new Integer[SIZE];

    private int hash(int key) {
        return key % SIZE;
    }

    public void insert(int key) {
        int index = hash(key);
        int startIdx = index;
        System.out.print("Chèn " + key + " (hash=" + index + "): ");

        while (table[index] != null) {
            System.out.print("đụng độ tại [" + index + "] -> ");
            index = (index + 1) % SIZE;
            if (index == startIdx) {
                System.out.println("Bảng đầy!");
                return;
            }
        }
        table[index] = key;
        System.out.println("đặt vào [" + index + "]");
    }

    public void search(int key) {
        int index = hash(key);
        int startIdx = index;
        int steps = 0;

        while (table[index] != null) {
            steps++;
            if (table[index] == key) {
                System.out.println("Tìm " + key + ": THẤY tại index [" + index + "] sau " + steps + " bước.");
                return;
            }
            index = (index + 1) % SIZE;
            if (index == startIdx) break;
        }
        System.out.println("Tìm " + key + ": KHÔNG THẤY (dừng sau " + (steps + 1) + " lần kiểm tra).");
    }

    public void printTable() {
        System.out.println("\n--- TRẠNG THÁI BẢNG BĂM (LINEAR PROBING) ---");
        for (int i = 0; i < SIZE; i++) {
            System.out.printf("[%2d]: %s\n", i, (table[i] == null ? "null" : table[i]));
        }
    }

    public static void main(String[] args) {
        Bai3a_LinearProbing ht = new Bai3a_LinearProbing();
        int[] keys = {3, 13, 6, 7, 23, 16, 33};

        for (int k : keys) ht.insert(k);
        ht.printTable();

        System.out.println("\n--- TÌM KIẾM ---");
        ht.search(6);
        ht.search(33);
        ht.search(40);
    }
}