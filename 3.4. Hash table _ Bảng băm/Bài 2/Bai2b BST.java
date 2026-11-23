public class Bai2b_BST {
    static class Node {
        int key;
        Node left, right;
        Node(int key) { this.key = key; }
    }

    private Node root;

    public void insert(int key) {
        root = insertRec(root, key);
    }

    private Node insertRec(Node root, int key) {
        if (root == null) return new Node(key);
        if (key < root.key) root.left = insertRec(root.left, key);
        else if (key > root.key) root.right = insertRec(root.right, key);
        return root;
    }

    public void delete(int key) {
        root = deleteRec(root, key);
    }

    private Node deleteRec(Node root, int key) {
        if (root == null) return null;
        if (key < root.key) root.left = deleteRec(root.left, key);
        else if (key > root.key) root.right = deleteRec(root.right, key);
        else {
            if (root.left == null) return root.right;
            if (root.right == null) return root.left;
            root.key = minValue(root.right);
            root.right = deleteRec(root.right, root.key);
        }
        return root;
    }

    private int minValue(Node root) {
        while (root.left != null) root = root.left;
        return root.key;
    }

    public void printInOrder() {
        inOrderRec(root);
        System.out.println();
    }

    private void inOrderRec(Node root) {
        if (root != null) {
            inOrderRec(root.left);
            System.out.print(root.key + " ");
            inOrderRec(root.right);
        }
    }

    public static void main(String[] args) {
        Bai2b_BST bst = new Bai2b_BST();
        int[] values = {1, 3, 10, 9, 6, 7, 4, 5, 2, 8};

        for (int v : values) bst.insert(v);
        System.out.print("Cây BST sau khi thêm (duyệt trung thứ tự): ");
        bst.printInOrder();

        int[] delValues = {3, 5, 7, 9};
        for (int d : delValues) {
            bst.delete(d);
            System.out.print("Sau khi xóa " + d + ": ");
            bst.printInOrder();
        }
    }
}