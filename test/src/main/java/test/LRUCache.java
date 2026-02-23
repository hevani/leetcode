package test;

import java.util.HashMap;

public class LRUCache {

	class Node {
		int key, value;
		Node prev, next;

		Node(int k, int v) {
			key = k;
			value = v;
		}
	}

	private final int capacity;
	private final HashMap<Integer, Node> map;
	private final Node head, tail;

	public LRUCache(int capacity) {
		this.capacity = capacity;
		this.map = new HashMap<>();
		head = new Node(0, 0);
		tail = new Node(0, 0);
		head.next = tail;
		tail.prev = head;
	}

	public int get(int key) {
		if (!map.containsKey(key))
			return -1;
		Node node = map.get(key);
		remove(node);
		insertToFront(node);
		return node.value;
	}

	public void put(int key, int value) {
		if (map.containsKey(key)) {
			remove(map.get(key));
		}
		Node node = new Node(key, value);
		insertToFront(node);
		map.put(key, node);
		if (map.size() > capacity) {
			Node lru = tail.prev;
			remove(lru);
			map.remove(lru.key);
		}
	}

	private void remove(Node node) {
		node.prev.next = node.next;
		node.next.prev = node.prev;
	}

	private void insertToFront(Node node) {
		node.next = head.next;
		node.prev = head;
		head.next.prev = node;
		head.next = node;
	}

	public static void main(String[] args) {
		LRUCache cache = new LRUCache(3);

		cache.put(1, 10); // Cache: 1
		cache.put(2, 20); // Cache: 1,2
		cache.put(3, 30); // Cache: 1,2,3

		System.out.println(cache.get(1)); // Access 1 → moves to front
		cache.put(4, 40); // Evicts key 2 (least recently used)

		System.out.println(cache.get(2)); // Should be -1 (evicted)
		System.out.println(cache.get(3)); // Should be 30
		System.out.println(cache.get(4)); // Should be 40
	}

}




