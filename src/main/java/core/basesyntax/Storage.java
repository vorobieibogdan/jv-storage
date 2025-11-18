package core.basesyntax;

import java.util.Arrays;

public interface Storage<K, V> implements Storage<K, V> {
    private static final int MAX_CAPACITY = 10;

    private Object[] keys;
    private Object[] values;

    private int size;

    public StorageImpl() {
        this.keys = new Object[MAX_CAPACITY];
        this.values = new Object[MAX_CAPACITY];
        this.size = 0;
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < size; i++) {
            K currentKey = (K) keys[i];

            if ((key == null && currentKey == null) || (key != null && key.equals(currentKey))) {
                values[i] = value;
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

            if ((key == null && currentKey == null) || (key != null && key.equals(currentKey))) {
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

