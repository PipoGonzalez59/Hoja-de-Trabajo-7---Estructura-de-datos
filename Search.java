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

    if (word.compareTo(key) < 0) {
        return searchRec(current.left, word);
    } else {
        return searchRec(current.right, word);
    }
}