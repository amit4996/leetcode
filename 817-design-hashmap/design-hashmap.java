class Node {
    int key;
    int val;

    public Node(int key, int val) {
        this.key = key;
        this.val = val;
    }
}

class MyHashMap {

    LinkedList<Node>[] buckets;

    public MyHashMap() {
        int size = 10001;
        buckets = new LinkedList[size];
        for (int i = 0; i < size; i++) {
            buckets[i] = new LinkedList<>();
        }
    }

    private int hash(int key) {
        return Math.abs(key) % buckets.length;
    }

    public void put(int key, int value) {
        int idx = hash(key);

        for (Node node : buckets[idx]) {
            if (node.key == key) {
                node.val = value;
                return;
            }
        }

        buckets[idx].add(new Node(key, value));
    }

    public int get(int key) {
        int idx = hash(key);

        for (Node node : buckets[idx]) {
            if (node.key == key) {
                return node.val;
            }
        }

        return -1;
    }

    public void remove(int key) {
        int idx = hash(key);

        Iterator<Node> it = buckets[idx].iterator();
        while (it.hasNext()) {
            if (it.next().key == key) {
                it.remove();
                return;
            }
        }
    }
}
