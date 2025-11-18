package core.basesyntax;

public class Storage<K, V> {

    private static final int MAX_CAPACITY = 10;

    private final Object[] keys;
    private final Object[] values;
    private int size;

    public Storage() {
        keys = new Object[MAX_CAPACITY];
        values = new Object[MAX_CAPACITY];
        size = 0;
    }

    public void put(K key, V value) {
        for (int i = 0; i < size; i++) {
            K currentKey = (K) keys[i];

            if ((key == null && currentKey == null)
                    || (key != null && key.equals(currentKey))) {
                values[i] = value; // replace existing value
                return;
            }
        }

        if (size < MAX_CAPACITY) {
            keys[size] = key;
            values[size] = value;
            size++;
        }
    }

    public V get(K key) {
        for (int i = 0; i < size; i++) {
            K currentKey = (K) keys[i];

            if ((key == null && currentKey == null)
                    || (key != null && key.equals(currentKey))) {
                return (V) values[i];
            }
        }
        return null;
    }

    public int size() {
        return size;
    }
}
