package test;

public class Stack {

	Node top;
	int height;
	
	public class Node {
		int value;
		Node next;
		public Node(int value) {
			this.value = value;	
		}
	}
	 
	public Stack(int value) {
		top = new Node(value);	
		height = 1;
	}
	public void printStack() {
		Node temp = top;
		while(temp != null) {
			System.out.println(temp.value);
			temp = temp.next;
		}
	}
	public void push(int value) {
		Node newNode = new Node(value);
		if(height == 0) {
			top = newNode;
		} else { 
			newNode.next = top;
			top = newNode;
		}
		height++;
	}
	public Node pop() {
		if(height == 0) return null;
		else if(height ==1) {
			top = null;
			height = 0;
			return null;
		}else {
			Node temp = top;
			top = top.next;
			temp.next = null;
			height--;
			return temp;
		}			
	}
	
	public static void main(String args[]) {
		Stack stack = new Stack(10);
		stack.push(20);
		stack.push(30);
		stack.pop();
		stack.push(40);
		stack.printStack();
		
	}
}
