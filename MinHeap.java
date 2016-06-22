package test.mayuresh;

/**
 * Created by naiveCode on 22/6/16.
 */
public class MinHeap

{
    private int[] Heap;
    private int size;
    private int maxsize;
    private static final int FRONT = 1;
    int emptySlots;

    public MinHeap(int maxsize) {
        this.maxsize = maxsize;
        size = maxsize;
        Heap = new int[this.maxsize + 1];
        emptySlots = maxsize;
//        Heap[0] = Integer.MIN_VALUE;
        for (int i=1;i<=maxsize;i++){
            Heap[i] = i;
        }
    }

    private int parent(int pos) {
        return pos / 2;
    }

    private int leftChild(int pos) {
        return (2 * pos);
    }

    private int rightChild(int pos) {
        return (2 * pos) + 1;
    }

    private boolean isLeaf(int pos) {
        if (pos >= (size / 2) && pos <= size) {
            return true;
        }
        return false;
    }

    private void swap(int fpos, int spos) {
        int tmp;
        tmp = Heap[fpos];
        Heap[fpos] = Heap[spos];
        Heap[spos] = tmp;
    }

    private void minHeapify(int pos) {
        if (!isLeaf(pos)) {
            if (Heap[pos] > Heap[leftChild(pos)] || Heap[pos] > Heap[rightChild(pos)]) {
                if (Heap[leftChild(pos)] < Heap[rightChild(pos)]) {
                    swap(pos, leftChild(pos));
                    minHeapify(leftChild(pos));
                } else {
                    swap(pos, rightChild(pos));
                    minHeapify(rightChild(pos));
                }
            }
        }
    }

    public void insert(int element) {
        Heap[++size] = element;
        int current = size;
        while (Heap[current] < Heap[parent(current)]) {
            swap(current, parent(current));
            current = parent(current);
        }
        emptySlots++;
    }

    public void minHeap() {
        for (int pos = (size / 2); pos >= 1; pos--) {
            minHeapify(pos);
        }
    }

    public int extractMin() {
        if(size==0){
            return -1;
        }
        emptySlots--;
        int popped = Heap[FRONT];
        Heap[FRONT] = Heap[size--];
        if(size!=0)
        minHeapify(FRONT);
        return popped;
    }
}