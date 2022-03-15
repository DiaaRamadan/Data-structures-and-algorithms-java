package HashTable;

import java.util.LinkedList;

public class HashTable {
    private class Entry {
        private int key;
        private String value;

        public Entry(int key, String value) {
            this.key = key;
            this.value = value;
        }

    }

    private LinkedList<Entry>[] items;

    public HashTable(int size) {
        this.items = new LinkedList[size];
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
        if (bucket == null) items[index] = new LinkedList<>();

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
}
