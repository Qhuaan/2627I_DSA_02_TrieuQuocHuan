public class Bai2c_AVL {
    static class Node {
        int key, height;
        Node left, right;
        Node(int key) { this.key = key; this.height = 1; }
    }

    private Node root;

    private int height(Node n) { return (n == null) ? 0 : n.height; }
    private int getBalance(Node n) { return (n == null) ? 0 : height(n.left) - height(n.right); }

    private Node rightRotate(Node y) {
        Node x = y.left;
        Node T2 = x.right;
        x.right = y;
        y.left = T2;
        y.height = Math.max(height(y.left), height(y.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;
        return x;
    }

    private Node leftRotate(Node x) {
        Node y = x.right;
        Node T2 = y.left;
        y.left = x;
        x.right = T2;
        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;
        return y;
    }

    public void insert(int key) { root = insertRec(root, key); }

    private Node insertRec(Node node, int key) {
        if (node == null) return new Node(key);
        if (key < node.key) node.left = insertRec(node.left, key);
        else if (key > node.key) node.right = insertRec(node.right, key);
        else return node;

        node.height = 1 + Math.max(height(node.left), height(node.right));
        int balance = getBalance(node);

        if (balance > 1 && key < node.left.key) return rightRotate(node);
        if (balance < -1 && key > node.right.key) return leftRotate(node);
        if (balance > 1 && key > node.left.key) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }
        if (balance < -1 && key < node.right.key) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }
        return node;
    }

    public void delete(int key) { root = deleteRec(root, key); }

    private Node deleteRec(Node root, int key) {
        if (root == null) return null;
        if (key < root.key) root.left = deleteRec(root.left, key);
        else if (key > root.key) root.right = deleteRec(root.right, key);
        else {
            if (root.left == null || root.right == null) {
                root = (root.left != null) ? root.left : root.right;
            } else {
                Node temp = minValueNode(root.right);
                root.key = temp.key;
                root.right = deleteRec(root.right, temp.key);
            }
        }
        if (root == null) return null;

        root.height = Math.max(height(root.left), height(root.right)) + 1;
        int balance = getBalance(root);

        if (balance > 1 && getBalance(root.left) >= 0) return rightRotate(root);
        if (balance > 1 && getBalance(root.left) < 0) {
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }
        if (balance < -1 && getBalance(root.right) <= 0) return leftRotate(root);
        if (balance < -1 && getBalance(root.right) > 0) {
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }
        return root;
    }

    private Node minValueNode(Node node) {
        while (node.left != null) node = node.left;
        return node;
    }

    public void printPreOrder() {
        preOrderRec(root);
        System.out.println();
    }

    private void preOrderRec(Node node) {
        if (node != null) {
            System.out.print(node.key + "(h=" + node.height + ") ");
            preOrderRec(node.left);
            preOrderRec(node.right);
        }
    }

    public static void main(String[] args) {
        Bai2c_AVL avl = new Bai2c_AVL();
        int[] values = {1, 3, 10, 9, 6, 7, 4, 5, 2, 8};

        for (int v : values) avl.insert(v);
        System.out.print("Cây AVL sau khi thêm (Pre-order kèm chiều cao): ");
        avl.printPreOrder();

        int[] delValues = {3, 5, 7, 9};
        for (int d : delValues) {
            avl.delete(d);
            System.out.print("Sau khi xóa " + d + ": ");
            avl.printPreOrder();
        }
    }
}