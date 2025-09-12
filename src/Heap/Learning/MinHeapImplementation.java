package Heap.Learning;

public class MinHeapImplementation {
    static class MinHeap {
        private int[] heapArray;
        private int currentSize;

        // Constructor
        MinHeap(int capacity) {
            heapArray = new int[capacity];
            currentSize = 0;
        }

        // Insert a value into heap
        void insert(int val) {
            if (currentSize == heapArray.length) {
                System.out.println("Heap is full!");
                return;
            }
            heapArray[currentSize] = val;
            percolateUp(currentSize);
            currentSize++;
        }

        // Extract min element (root)
        int extractMinElement() {
            if (currentSize == 0) {
                return -1; // empty heap
            }
            int minValue = heapArray[0];
            heapArray[0] = heapArray[currentSize - 1];
            currentSize--;
            heapify(0);
            return minValue;
        }

        // Delete element at index
        void deleteElement(int ind) {
            if (ind < 0 || ind >= currentSize) {
                return;
            }
            heapArray[ind] = heapArray[currentSize - 1];
            currentSize--;
            heapify(ind);
        }

        // Move a node up until heap property is restored
        private void percolateUp(int index) {
            int parent = (index - 1) / 2;
            while (index > 0 && heapArray[index] < heapArray[parent]) {
                swap(index, parent);
                index = parent;
                parent = (index - 1) / 2;
            }
        }

        // Heapify (move down)
        private void heapify(int index) {
            int smallest = index;
            int left = 2 * index + 1;
            int right = 2 * index + 2;

            if (left < currentSize && heapArray[left] < heapArray[smallest]) {
                smallest = left;
            }
            if (right < currentSize && heapArray[right] < heapArray[smallest]) {
                smallest = right;
            }

            if (smallest != index) {
                swap(index, smallest);
                heapify(smallest);
            }
        }

        // Swap helper
        private void swap(int i, int j) {
            int temp = heapArray[i];
            heapArray[i] = heapArray[j];
            heapArray[j] = temp;
        }
    }
    public static void main(String[] args) {

    }
}
