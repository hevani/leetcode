package test;

public class Queue {
	private Node first;
	private Node last;
	private int length;

	class Node {
		Node next;
		int value;
		Node(int value) {
			this.value = value;			
		}
	}
	public Queue(int value) {
		Node newNode = new Node(value);
		first = newNode;
		last = newNode;
		length++;
		
	}
	public void printQueue() {
		Node temp = first;
		while(temp != null) {
			temp = temp.next;
		}
	}
	public Node getFirst() {
		return first;
	}
	public Node getLast() {
		return last;
	}
	public void getLength() {
		System.out.println("Length:" + length);
	}
	 
	public void push(int value) {
		Node newNode = new Node(value);
		if(length == 0) {
			first = newNode;
			last = newNode;
		} else {
			last.next = newNode;
			last = newNode;
		}
		length++;
	}
	
	public Node pop() {
		if (length == 0)
			return null;
		else if (length == 1) {
			first = null;
			last = null;
			length = 0;
			return null;
		} else {
			Node temp = first;
			first = first.next;
			temp.next = null;
			length--;
			return temp;
		}
	
	}
	public static void main(String[] args) {
		 	Queue queue = new Queue(10);
	        queue.push(20);
	        queue.push(30);
	        queue.push(40);

	        System.out.println("Queue contents:");
	        queue.printQueue();

	        System.out.println("pop: " + queue.pop().value);
	        System.out.println("pop: " + queue.pop().value);
	        System.out.println("First: " + queue.getFirst().value);
	        System.out.println("Last: " + queue.getLast().value);
	        System.out.println("Length: " + queue.length);
		
	}
}
