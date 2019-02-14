package practice;

public class DoublyLinkedList<E> {
	private ListNode<E> head;
	private ListNode<E> tail;
	private int size;
	
	public DoublyLinkedList() {
		size = 0;
		head = new ListNode<E>(null);
		tail = new ListNode<E>(null);
		head.next = tail;
		tail.prev = head;
	}
	
	public void addAtFront(E data) {
		if(data == null) {
			throw new NullPointerException("Null can't be added");
		}
		ListNode<E> node = new ListNode<E>(data);
		node.next = head.next;
		node.prev = head;
		node.next.prev = node;
		head.next = node;
		size++;
	}
	
	public void addAtEnd(E data) {
		if(data == null) {
			throw new NullPointerException("Null can't be added");
		}
		ListNode<E> node = new ListNode<E>(data);
		node.prev = tail.prev;
		node.next = tail;
		node.prev.next = node;
		tail.prev = node;
		size++;
	}
	
	public void addAtIndex(int index, E data) {
		if(data == null) {
			throw new NullPointerException("Null can't be added");
		}
		if(index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("Out Of Bounds");
		}
		ListNode<E> node = head;
		for (int i = 0; i < index; i++) {
			node = node.next;
		}
		ListNode<E> newNode = new ListNode<E>(data);
		newNode.next = node.next;
		node.next = newNode;
		newNode.next.prev = newNode;
		newNode.prev = node;
		size++;
	}
	
	public E removeFromFront() {
		ListNode<E> retData = head.next;
		head.next = head.next.next;
		head.data = null;
		head.prev = null;
		size--;
		return retData.data;
	}
	
	public E removeFromEnd() {
		ListNode<E> retData = tail.prev;
		tail.prev = tail.prev.prev;
		tail.data = null;
		tail.next = null;
		size--;
		return retData.data;
	}
	
	public E removeFromIndex(int index) {	
		if(index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("Out Of Bounds");
		}
		ListNode<E> node = head;
		for (int i = 0; i <= index; i++) {
			node = node.next;
		}
		ListNode<E> retData = node;
		node.prev.next = node.next;
		node.next.prev = node.prev;
		size--;
		return retData.data;
	}
	
	public E get(int index) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("Invalid index!");
		} 
		ListNode<E> node = head;
		for (int i = 0; i <= index; i++) {
			node = node.next;
		}
		return node.data;
	}
	
	public E replaceAt(int index, E data) {
		if(data == null) {
			throw new NullPointerException("Null can't be added");
		}
		if(index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("Out Of Bounds");
		}
		ListNode<E> node = head;
		for (int i = 0; i <= index; i++) {
			node = node.next;
		}
		node.data = data;
		return data;
	}
	
	public int size() {
		return this.size;
	}
	
	public static void main(String args[]) {
		DoublyLinkedList<Integer> dll = new DoublyLinkedList<Integer>();
		for(int i = 10; i <= 50; i += 10) {
			dll.addAtEnd(i);
		}
		System.out.println("Size of Doubly Linked List = " + dll.size());
		System.out.println("Linked list is :-");
		for(int i = 0; i < dll.size(); i++) {
			System.out.println(dll.get(i));
		}
	}
}

class ListNode<E> {
	ListNode<E> next;
	ListNode<E> prev;
	E data;
	
	public ListNode(E theData) {
		this.data = theData;
	}
}