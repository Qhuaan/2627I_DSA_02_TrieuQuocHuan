public class BitonicSearch {

    public static int search(int[] a, int key) {
        if (a == null || a.length == 0) return -1;

        int peak = findPeak(a, 0, a.length - 1);

        if (a[peak] == key) {
            return peak;
        }

        int indexLeft = binarySearchAscending(a, 0, peak - 1, key);
        if (indexLeft != -1) {
            return indexLeft;
        }

        return binarySearchDescending(a, peak + 1, a.length - 1, key);
    }

    private static int findPeak(int[] a, int low, int high) {
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (a[mid] < a[mid + 1]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

    private static int binarySearchAscending(int[] a, int low, int high, int key) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (a[mid] == key) {
                return mid;
            } else if (a[mid] < key) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    private static int binarySearchDescending(int[] a, int low, int high, int key) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (a[mid] == key) {
                return mid;
            } else if (a[mid] > key) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] bitonicArray = {1, 3, 8, 12, 20, 15, 11, 9, 6, 2};
        
        int key1 = 11;
        int key2 = 8;
        int key3 = 100;

        System.out.println("Vị trí của " + key1 + ": " + search(bitonicArray, key1));
        System.out.println("Vị trí của " + key2 + ": " + search(bitonicArray, key2));
        System.out.println("Vị trí của " + key3 + ": " + search(bitonicArray, key3));
    }
}