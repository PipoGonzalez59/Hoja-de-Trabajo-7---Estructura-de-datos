class Node {
    Association<String, String> data;
    Node left;
    Node right;

    public Node(Association<String, String> data) {
        this.data = data;
        left = null;
        right = null;
    }
}