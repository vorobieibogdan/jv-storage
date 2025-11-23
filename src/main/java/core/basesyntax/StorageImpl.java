package core.basesyntax;

public class StorageImpl<K, V> implements Storage<K, V> {

    private static final int MAX_CAPACITY = 10;

    private final Object[] keys = new Object[MAX_CAPACITY];
    private final Object[] values = new Object[MAX_CAPACITY];
    private int size = 0;

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < size; i++) {
            K currentKey = (K) keys[i];
            if ((currentKey == null && key == null)
                    || (currentKey != null && currentKey.equals(key))) {
                values[i] = value;
                return;
            }
        }
        keys[size] = key;
        values[size] = value;
        size++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            K currentKey = (K) keys[i];
            if ((currentKey == null && key == null)
                    || (currentKey != null && currentKey.equals(key))) {
                return (V) values[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}
