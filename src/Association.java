public class Association<K, V> {

    public K key;
    public V value;

    public Association(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    public String toString() {
        return "(" + key + ", " + value + ")";
    }
}