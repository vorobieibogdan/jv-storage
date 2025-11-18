package core.basesyntax;

public interface Storage<K, V> {
    void put(K key, V value);

    V get(K key);

    int size();


    class StorageImpl<K, V> implements Storage<K, V> {
        private static final int MAX_CAPACITY = 10;

        private final Object[] keys = new Object[MAX_CAPACITY];
        private final Object[] values = new Object[MAX_CAPACITY];
        private int size = 0;

        @Override
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

        @Override
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

        @Override
        public int size() {
            return size;
        }
    }
}
