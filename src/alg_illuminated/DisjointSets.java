package alg_illuminated;

import java.util.HashMap;
import java.util.Map;

public class DisjointSets<T> {

    final private Map<T, Item<T>> itemByValue = new HashMap<>();

    public void insertItem(T v) {
        if (itemByValue.containsKey(v)) {
            throw new IllegalArgumentException("Value is already present in the set");
        }
        Item<T> item = new Item<>(null, v);
        itemByValue.put(v, item);
    }

    public T find(T v) {
        if (v == null || !itemByValue.containsKey(v))
            return null;

        Item<T> x = itemByValue.get(v);
        // base case
        if (x.parent == x)
            return v;

        T parentVal = find(x.parent.value);
        x.parent = itemByValue.get(parentVal);
        return x.parent.value;
    }

    public T union(T xv, T yv) {
        T xRootVal = find(xv);
        T yRootVal = find(yv);
        if (xRootVal == null && yRootVal == null) {
            return null;
        }
        Item<T> xRoot = itemByValue.get(xRootVal);
        Item<T> yRoot = itemByValue.get(yRootVal);

        // both are in same set
        if (xRoot == yRoot) {
            return xRootVal;
        }
        if (xRoot.rank < yRoot.rank) {
            xRoot.parent = yRoot;
            return yRootVal;
        } else if (yRoot.rank < xRoot.rank) {
            yRoot.parent = xRoot;
            return xRootVal;
        }

        // they're both same rank
        yRoot.parent = xRoot;
        xRoot.rank += 1; // increment rank
        return xRootVal;
    }

    public static void main(String[] args) {
        DisjointSets<String> dset = new DisjointSets<>();
        dset.insertItem("s");
        dset.insertItem("v");
        dset.insertItem("w");
        dset.insertItem("t");
        System.out.println(dset.find("w"));
        System.out.println(dset.union("v", "w"));
        System.out.println(dset.find("w"));
        System.out.println(dset.union("s", "t"));
    }


     static class Item<V> {
        Item<V> parent;
        final V value;

        int rank;

        public Item(Item<V> parent, V value) {
            if (parent == null) {
                this.parent = this;
            } else {
                this.parent = parent;
            }
            this.value = value;
            this.rank = 0;
        }
    }
}
