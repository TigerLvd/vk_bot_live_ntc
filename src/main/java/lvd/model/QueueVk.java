package lvd.model;

import java.util.LinkedList;
import java.util.List;

public class QueueVk {
    private int QUEUE_SIZE = 100;

    private List<Integer> arr = new LinkedList<Integer>();

    public QueueVk() {
    }

    public QueueVk(int size) {
        this.QUEUE_SIZE = size;
    }

    public void add(Integer x) {
        if (null == x || 0 == x || arr.contains(x)) {
            return;
        }
        if (arr.size() >= QUEUE_SIZE) {
            arr.remove(0);
        }
        arr.add(x);
    }

    public void clear() {
        arr.clear();
    }

    public boolean contains(Integer x) {
        if (null == x || 0 == x) {
            return false;
        }
        return arr.contains(x);
    }
}