import java.util.LinkedList;

public class Bai3b_SeparateChaining {
    private static final int SIZE = 17;
    private LinkedList<Integer>[] table;

    @SuppressWarnings("unchecked")
    public Bai3b_SeparateChaining() {
        table = new LinkedList[SIZE];
        for (int i = 0; i < SIZE; i++) {
            table[i] = new LinkedList<>();
        }
    }

    private int hash(int key) {
        return key % SIZE;
    }

    public void insert(int key) {
        int index = hash(key);
        table[index].add(key);
        System.out.println("Chèn " + key + " -> bucket [" + index + "]");
    }

    public void search(int key) {
        int index = hash(key);
        int pos = table[index].indexOf(key);
        if (pos != -1) {
            System.out.println("Tìm " + key + ": THẤY tại bucket [" + index + "], vị trí thứ " + pos + " trong danh sách.");
        } else {
            System.out.println("Tìm " + key + ": KHÔNG THẤY tại bucket [" + index + "].");
        }
    }

    public void printTable() {
        System.out.println("\n--- TRẠNG THÁI BẢNG BĂM (SEPARATE CHAINING) ---");
        for (int i = 0; i < SIZE; i++) {
            System.out.printf("[%2d]: %s\n", i, table[i]);
        }
    }

    public static void main(String[] args) {
        Bai3b_SeparateChaining ht = new Bai3b_SeparateChaining();
        int[] keys = {3, 13, 6, 7, 23, 16, 33};

        for (int k : keys) ht.insert(k);
        ht.printTable();

        System.out.println("\n--- TÌM KIẾM ---");
        ht.search(6);
        ht.search(33);
        ht.search(40);
    }
}