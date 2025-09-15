package GreedyAlgorithm.MediumAndHardProblems;
import java.util.* ;
public class LRUCacheWithCapacity {
    // Represents a node in the doubly linked list for the LRU cache
    public static class CacheNode {
        public int key;
        public int value;
        public CacheNode next;
        public CacheNode prev;

        // Constructor to initialize node with key and value
        public CacheNode(int key, int value) {
            this.key = key;
            this.value = value;
            this.next = null;
            this.prev = null;
        }
    }

    // Implements a Least Recently Used (LRU) cache
    public static class LRUCache {
        private static CacheNode head; // Dummy head node of the doubly linked list
        private static CacheNode tail; // Dummy tail node of the doubly linked list
        private static HashMap<Integer, CacheNode> cacheMap; // Maps keys to nodes
        private static int capacity; // Maximum capacity of the cache

        // Initializes the LRU cache with given capacity
        LRUCache(int capacity) {
            this.capacity = capacity;
            this.head = new CacheNode(-1, -1); // Initialize dummy head
            this.tail = new CacheNode(-1, -1); // Initialize dummy tail
            this.cacheMap = new HashMap<>();
            linkNodes(head, tail); // Connect head and tail
        }

        // Links two nodes in the doubly linked list
        private static void linkNodes(CacheNode first, CacheNode second) {
            first.next = second;
            second.prev = first;
        }

        // Retrieves the value for a key if it exists, and moves node to front (most recently used)
        public static int get(int key) {
            if (!cacheMap.containsKey(key)) {
                // Key not found in cache
                return -1;
            }
            CacheNode node = cacheMap.get(key);
            removeNode(node); // Remove from current position
            addToFront(node); // Move to front (most recently used)
            return node.value;
        }

        // Removes a node from the doubly linked list
        private static void removeNode(CacheNode node) {
            CacheNode prevNode = node.prev;
            CacheNode nextNode = node.next;
            linkNodes(prevNode, nextNode); // Reconnect surrounding nodes
        }

        // Adds a node right after the head (most recently used position)
        private static void addToFront(CacheNode node) {
            CacheNode nextToHead = head.next;
            linkNodes(head, node); // Connect head to node
            linkNodes(node, nextToHead); // Connect node to next node
        }

        // Inserts or updates a key-value pair in the cache
        public static void put(int key, int value) {
            if (cacheMap.containsKey(key)) {
                // Update existing key
                CacheNode node = cacheMap.get(key);
                removeNode(node); // Remove from current position
                node.value = value; // Update value
                addToFront(node); // Move to front
            } else {
                // Add new key-value pair
                if (cacheMap.size() == capacity) {
                    // Cache is full, remove least recently used node
                    CacheNode lruNode = tail.prev;
                    removeNode(lruNode);
                    cacheMap.remove(lruNode.key);
                }
                // Add new node
                addNewNode(key, value);
            }
        }

        // Adds a new node with key-value pair to the cache
        private static void addNewNode(int key, int value) {
            CacheNode node = new CacheNode(key, value);
            cacheMap.put(key, node); // Add to map
            addToFront(node); // Add to front of list
        }
    }

    public static void main(String[] args) {
        // Main method for testing (empty in original code)
    }
}
