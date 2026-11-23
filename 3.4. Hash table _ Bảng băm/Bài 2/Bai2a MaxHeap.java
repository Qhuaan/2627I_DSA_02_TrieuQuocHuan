import java.util.Arrays;

public class Bai2a_MaxHeap {
    private int[] heap;
    private int size;

    public Bai2a_MaxHeap(int capacity) {
        heap = new int[capacity];
        size = 0;
    }

    public void insert(int val) {
        heap[size] = val;
        int curr = size;
        size++;
        while (curr > 0) {
            int parent = (curr - 1) / 2;
            if (heap[curr] > heap[parent]) {
                swap(curr, parent);
                curr = parent;
            } else {
                break;
            }
        }
    }

    public int extractMax() {
        if (size == 0) throw new IllegalStateException("Heap rỗng");
        int max = heap[0];
        heap[0] = heap[size - 1];
        size--;
        int curr = 0;
        while (true) {
            int left = 2 * curr + 1;
            int right = 2 * curr + 2;
            int largest = curr;

            if (left < size && heap[left] > heap[largest]) largest = left;
            if (right < size && heap[right] > heap[largest]) largest = right;

            if (largest != curr) {
                swap(curr, largest);
                curr = largest;
            } else {
                break;
            }
        }
        return max;
    }

    private void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    public void printHeap() {
        System.out.println("Mảng Heap hiện tại: " + Arrays.toString(Arrays.copyOf(heap, size)));
    }

    public static void main(String[] args) {
        Bai2a_MaxHeap maxHeap = new Bai2a_MaxHeap(20);
        int[] values = {1, 3, 10, 9, 6, 7, 4, 5, 2, 8};

        System.out.println("--- THÊM PHẦN TỬ VÀO MAX-HEAP ---");
        for (int v : values) {
            maxHeap.insert(v);
            System.out.print("Thêm " + v + " -> ");
            maxHeap.printHeap();
        }

        System.out.println("\n--- LẤY VÀ XÓA MAX 4 LẦN LIÊN TIẾP ---");
        for (int i = 1; i <= 4; i++) {
            int max = maxHeap.extractMax();
            System.out.print("Lần " + i + " (lấy " + max + ") -> ");
            maxHeap.printHeap();
        }
    }
}