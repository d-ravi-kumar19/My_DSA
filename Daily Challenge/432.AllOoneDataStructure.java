// 432. All O`one Data Structure

// Design a data structure to store the strings' count with the ability to return the strings with minimum and maximum counts.

// Implement the AllOne class:

// AllOne() Initializes the object of the data structure.
// inc(String key) Increments the count of the string key by 1. If key does not exist in the data structure, insert it with count 1.
// dec(String key) Decrements the count of the string key by 1. If the count of key is 0 after the decrement, remove it from the data structure. It is guaranteed that key exists in the data structure before the decrement.
// getMaxKey() Returns one of the keys with the maximal count. If no element exists, return an empty string "".
// getMinKey() Returns one of the keys with the minimum count. If no element exists, return an empty string "".
// Note that each function must run in O(1) average time complexity.

 

// Example 1:

// Input
// ["AllOne", "inc", "inc", "getMaxKey", "getMinKey", "inc", "getMaxKey", "getMinKey"]
// [[], ["hello"], ["hello"], [], [], ["leet"], [], []]
// Output
// [null, null, null, "hello", "hello", null, "hello", "leet"]

// Explanation
// AllOne allOne = new AllOne();
// allOne.inc("hello");
// allOne.inc("hello");
// allOne.getMaxKey(); // return "hello"
// allOne.getMinKey(); // return "hello"
// allOne.inc("leet");
// allOne.getMaxKey(); // return "hello"
// allOne.getMinKey(); // return "leet"
 

// Constraints:

// 1 <= key.length <= 10
// key consists of lowercase English letters.
// It is guaranteed that for each call to dec, key is existing in the data structure.
// At most 5 * 104 calls will be made to inc, dec, getMaxKey, and getMinKey.


import java.util.*; 

class Node{
    Node next;             // Pointer to the next node in the list
    Node prev;             // Pointer to the previous node in the list
    int freq;              // Frequency count of keys in this node
    HashSet<String> keys;  // Set of keys that have this frequency

    // Constructor to initialize a node with a given frequency
    Node(int f) {
        next = null;       // Initially, next and prev are null
        prev = null;
        freq = f;         // Set frequency
        keys = new HashSet<>(); // Initialize the set of keys
    }
}

class AllOne {
    HashMap<String, Node> map;  // 
    Node head;  // pointer for min key
    Node tail;  // pointer for max key

    public AllOne() {
        map = new HashMap<>();
        head = new Node(0);
        tail = new Node(0);
        head.next = tail;
        tail.prev = head;
    }

    
    // Increment the frequency of a given key
    public void inc(String key) {
        Node curr = head;                 // Start at the head
        int newFreq = 1;                  // New frequency starts at 1

        // If the key already exists, update its frequency
        if (map.containsKey(key)) {
            curr = map.get(key);           // Get the current node for the key
            newFreq = curr.freq + 1;      // Increment frequency
            curr.keys.remove(key);         // Remove key from its old frequency node
        }

        // Check if a node with the new frequency already exists
        if (curr.next.freq == newFreq) {  // If the next node has the new frequency
            curr.next.keys.add(key);       // Add key to the existing node
        } else {                            // Otherwise, create a new node
            Node newNode = new Node(newFreq); // Create new node for new frequency
            newNode.keys.add(key);         // Add the key to the new node

            // Link the new node into the list
            Node nextNode = curr.next;
            newNode.next = nextNode;       // Point new node to the next node
            nextNode.prev = newNode;       // Point next node back to new node
            curr.next = newNode;           // Point current node to new node
            newNode.prev = curr;           // Point new node back to current node
        }

        // Update the map with the new node
        map.put(key, curr.next);

        // If the old frequency node is now empty, remove it
        if (curr.keys.size() == 0 && curr != head) {
            removeNode(curr);
        }
    }
    
    public void dec(String key) {
       
        // we need to go the node that matches with the key
        // then we need to insert new node with incremented freq
    
        Node curr = map.get(key);          // Get the current node for the key
        int newFreq = curr.freq - 1;       // Decrement frequency
        curr.keys.remove(key);              // Remove the key from its old frequency node

        // If frequency drops to 0, remove the key entirely
        if (newFreq == 0) {
            if (curr.keys.size() == 0) {   // If no other keys remain, remove the node
                removeNode(curr);
            }
            map.remove(key);               // Remove the key from the map
            return;                        // Exit early
        }

        // Check if a node with the new frequency already exists
        if (curr.prev.freq == newFreq) {   // If the previous node has the new frequency
            curr.prev.keys.add(key);        // Add key to the existing node
        } else {                             // Otherwise, create a new node
            Node newNode = new Node(newFreq); // Create new node for new frequency
            newNode.keys.add(key);          // Add the key to the new node

            // Link the new node into the list
            Node prevNode = curr.prev;
            newNode.prev = prevNode;        // Point new node back to previous node
            prevNode.next = newNode;        // Point previous node to new node
            newNode.next = curr;            // Point new node to current node
            curr.prev = newNode;            // Point current node back to new node
        }

        map.put(key, curr.prev);
        // now if node with empty keys present we need to delete the node
        // but check if it is head, otherwise we'll endup by deleting head

        if(curr.keys.size() == 0 && curr != head){
            removeNode(curr);
        }
    }
    
    // Get the key with the maximum frequency
    public String getMaxKey() {
        if (tail.prev == head) {           // If the list is empty
            return "";
        }
        return tail.prev.keys.iterator().next(); // Return any key from the max frequency node
    }
    
    // Get the key with the minimum frequency
    public String getMinKey() {
        if (head.next == tail) {           // If the list is empty
            return "";
        }
        return head.next.keys.iterator().next(); // Return any key from the min frequency node
    }
    // Remove a node from the doubly linked list
    private void removeNode(Node node) {
        Node nextNode = node.next;         // Get the next node
        Node prevNode = node.prev;         // Get the previous node

        // Re-link the previous and next nodes to remove the current node
        prevNode.next = nextNode;
        nextNode.prev = prevNode;
        node.next = null;                   // Clean up references
        node.prev = null;
    }
}

/**
 * Your AllOne object will be instantiated and called as such:
 * AllOne obj = new AllOne();
 * obj.inc(key);
 * obj.dec(key);
 * String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */