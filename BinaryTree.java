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