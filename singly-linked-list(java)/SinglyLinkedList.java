package practice;

public class SinglyLinkedList<E> {
	private SLLNode<E> head;
	private SLLNode<E> tail;
	private int size;
	
	public SinglyLinkedList() {
		size = 0;
		head = new SLLNode<E>(null);
		tail = new SLLNode<E>(null);
		head.next = tail;
	}
	
	public void addAtFront(E data) {
		if(data == null) {
			throw new NullPointerException("Null can't be added");
		}
		SLLNode<E> newNode = new SLLNode<E>(data);
		newNode.next = head.next;
		head.next = newNode;
		size++;
	}
	
	public void addAtEnd(E data) {
		if(data == null) {
			throw new NullPointerException("Null can't be added");
		}
		SLLNode<E> node = head;
		for(int i = 0; i < size; i++) {
			node = node.next;
		}
		SLLNode<E> newNode = new SLLNode<E>(data);
		node.next = newNode;
		newNode.next = tail;
		size++;
	}
	
	public void addAtIndex(int index, E data) {
		if(data == null) {
			throw new NullPointerException("Null can't be added");
		}
		if(index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("Out Of Bounds");
		}
		if(index == 0) {
			addAtFront(data);
		}
		if(index == size - 1) {
			addAtEnd(data);
		}
		SLLNode<E> node = head;
		for(int i = 0; i < index; i++) {
			node = node.next;
		}
		SLLNode<E> newNode = new SLLNode<E>(data);
		newNode.next = node.next;
		node.next = newNode;
		size++;
	}
	
	public E removeFromFront() {
		SLLNode<E> retData = head.next;
		head = head.next;
		size--;
		return retData.data;
	}
	
	public E removeFromEnd() {
		SLLNode<E> node = head;
		for(int  i = 0; i < size - 1; i++) {
			node = node.next;
		}
		SLLNode<E> retData = node.next;
		node.next = tail;
		size--;
		return retData.data;
	}
	
	public E removeFromIndex(int index) {
		if(index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("Out Of Bounds");
		}
		if(index == 0) {
			return removeFromFront();
		}
		if(index == size - 1) {
			return removeFromEnd();
		}
		SLLNode<E> node = head;
		for(int i = 0; i < index; i++) {
			node = node.next;
		}
		SLLNode<E> retData = node.next;
		node.next = node.next.next;
		size--;
		return retData.data;
	}
	
	public E get(int index) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("Invalid index!");
		} 
		SLLNode<E> node = head;
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
		SLLNode<E> node = head;
		for(int i = 0; i <= index; i++) {
			node = node.next;
		}
		node.data = data;
		return data;
	}
	
	public int size() {
		return this.size;
	}

	public static void main(String[] args) {
		SinglyLinkedList<Integer> sll = new SinglyLinkedList<Integer>();
		for(int i = 10; i <= 50; i += 10) {
			sll.addAtEnd(i);
		}
		System.out.println("Size of Singly Linked List = " + sll.size());
		System.out.println("Linked list is :-");
		for(int i = 0; i < sll.size(); i++) {
			System.out.println(sll.get(i));
		}
	}
}

class SLLNode<E> {
	SLLNode<E> next;
	E data;
	
	public SLLNode(E theData) {
		this.data = theData;
	}
}