package HashTable;

import java.lang.reflect.Array;
import java.util.LinkedList;

public class HashTable {
    private static class Entry {
        private final int key;
        private String value;

        public Entry(int key, String value) {
            this.key = key;
            this.value = value;
        }

    }

    private final LinkedList<Entry>[] items;

    @SuppressWarnings("unchecked")
    public HashTable(int size) {
        this.items = (LinkedList<Entry>[]) Array.newInstance(LinkedList.class, size);
    }

    public void put(int key, String value) {
        var entry = getEntry(key);
        if (entry != null) {
            entry.value = value;
            return;
        }

        getOrCreateBucket(key).addLast(new Entry(key, value));
    }

    public String get(int key) {
        var entry = getEntry(key);
        return (entry == null) ? null : entry.value;
    }

    public void remove(int key) {
        var entry = getEntry(key);
        if (entry == null) throw new IllegalStateException();
        getBucket(key).remove(entry);
    }

    private LinkedList<Entry> getOrCreateBucket(int key) {
        var index = hash(key);
        var bucket = items[index];
        if (bucket == null) {
            bucket = items[index] = new LinkedList<>();
        }

        return bucket;
    }

    private LinkedList<Entry> getBucket(int key) {
        return items[hash(key)];
    }

    private Entry getEntry(int key) {
        var bucket = getBucket(key);
        if (bucket != null) {
            for (var entry : bucket)
                if (entry.key == key)
                    return entry;
        }
        return null;
    }

    private int hash(int key) {
        return key % items.length;
    }

    /**
      Returns a brief description of this hashtable. The exact details
      of the representation are unspecified and subject to change,
      but the following may be regarded as typical:

      "{5=abc}{6=def}{2=ghi}"
     */
   @Override public String toString() {
        StringBuilder str = new StringBuilder();
        for (LinkedList<Entry> entry : items) {
            for (var item : entry) {
                str.append(String.format("{%s=%s}", item.key, item.value));
            }
        }

        return str.toString();
    }
}
