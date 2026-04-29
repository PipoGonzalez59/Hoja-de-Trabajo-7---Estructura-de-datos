public class BinaryTree {

    Node root;

    public BinaryTree() {
        root = null;
    }

    // insertar
    public void insert(String english, String spanish) {
        Association<String, String> newData = new Association<>(english, spanish);
        root = insertRec(root, newData);
    }

    private Node insertRec(Node current, Association<String, String> data) {

        if (current == null) {
            return new Node(data);
        }

        String currentKey = current.data.getKey();
        String newKey = data.getKey();

        if (newKey.compareToIgnoreCase(currentKey) < 0) {
            current.left = insertRec(current.left, data);
        } else {
            current.right = insertRec(current.right, data);
        }

        return current;
    }

    public String search(String word) {
        return searchRec(root, word.toLowerCase());
    }

    private String searchRec(Node current, String word) {

        if (current == null) {
            return null;
        }

        String key = current.data.getKey().toLowerCase();

        if (word.equals(key)) {
            return current.data.getValue();
        }

        if (word.compareToIgnoreCase(key) < 0) {
            return searchRec(current.left, word);
        } else {
            return searchRec(current.right, word);
        }
    }

    public void inOrder() {
        inOrderRec(root);
    }

    private void inOrderRec(Node current) {
        if (current != null) {
            inOrderRec(current.left);
            System.out.println(current.data);
            inOrderRec(current.right);
        }
    }
}