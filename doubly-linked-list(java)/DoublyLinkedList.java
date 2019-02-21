package practice;

import java.util.Scanner;

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
		else {
			ListNode<E> node = new ListNode<E>(data);
			node.next = head.next;
			node.prev = head;
			node.next.prev = node;
			head.next = node;
			size++;
			System.out.println("Added successfully");
		}
	}
	
	public void addAtEnd(E data) {
		if(data == null) {
			throw new NullPointerException("Null can't be added");
		}
		else {
			ListNode<E> node = new ListNode<E>(data);
			node.prev = tail.prev;
			node.next = tail;
			node.prev.next = node;
			tail.prev = node;
			size++;
			System.out.println("Added successfully");
		}
	}
	
	public void addAtIndex(int index, E data) {
		if(data == null) {
			throw new NullPointerException("Null can't be added");
		}
		else if(index == 0) {
			addAtFront(data);
		}
		else if(index == size - 1) {
			addAtEnd(data);
		}
		else if(index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("Out Of Bounds");
		}
		else {
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
			System.out.println("Added successfully");
		}
	}
	
	public E removeFromFront() {
		if(size <= 0) {
			System.out.println("Linked list is already empty. Can't delete");
			return null;
		}
		else {
			ListNode<E> retData = head.next;
			head = head.next;
			size--;
			System.out.println("Removed successfully");
			return retData.data;
		}
	}
	
	public E removeFromEnd() {
		if(size <= 0) {
			System.out.println("Linked list is already empty. Can't delete");
			return null;
		}
		else {
			ListNode<E> retData = tail.prev;
			tail = tail.prev;		
			size--;
			System.out.println("Removed successfully");
			return retData.data;
		}
	}
	
	public E removeFromIndex(int index) {
		if(size <= 0) {
			System.out.println("Linked list is already empty. Can't delete");
			return null;
		}
		else if(index == 0) {
			return removeFromFront();
		}
		else if(index == size - 1) {
			return removeFromEnd();
		}
		else if(index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("Out Of Bounds");
		}
		else {
			ListNode<E> node = head;
			for (int i = 0; i <= index; i++) {
				node = node.next;
			}
			ListNode<E> retData = node;
			node.prev.next = node.next;
			node.next.prev = node.prev;
			size--;
			System.out.println("Removed successfully");
			return retData.data;
		}
	}
	
	public E get(int index) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("Invalid index!");
		} 
		else {
			ListNode<E> node = head;
			for (int i = 0; i <= index; i++) {
				node = node.next;
			}
			return node.data;
		}
	}
	
	public E replaceAt(int index, E data) {
		if(data == null) {
			throw new NullPointerException("Null can't be added");
		}
		else if(index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("Out Of Bounds");
		}
		else {
			ListNode<E> node = head;
			for (int i = 0; i <= index; i++) {
				node = node.next;
			}
			node.data = data;
			System.out.println("Replaced successfully");
			return data;
		}
	}
	
	public int size() {
		return this.size;
	}
	
	public void printList() {
		ListNode<E> node = head;
		System.out.println("Linked list is :-");
		for(int i = 0; i < size; i++) {
			System.out.println(node.next.data);
			node = node.next;
		}
		System.out.println("\n\n");
	}
	
	public static void main(String args[]) {
		DoublyLinkedList<Integer> dll = new DoublyLinkedList<Integer>();
		Scanner S = new Scanner(System.in);
		int data, pos;
		while(true) {
			System.out.println("* * * * MENU * * * *");
			System.out.println("1.Add at front");
			System.out.println("2.Add at end");
			System.out.println("3.Add at postion");
			System.out.println("4.Remove from front");
			System.out.println("5.Remove from end");
			System.out.println("6.Remove from position");
			System.out.println("7.Get value of position");
			System.out.println("8.Display size");
			System.out.println("9.Replace element");
			System.out.println("0.Exit");
			System.out.println("ENTER YOUR CHOICE");
			int choice = S.nextInt();
			switch(choice) {
			case 0: System.out.println("Terminated");
					System.exit(0);
			case 1: 
				System.out.println("Enter data");
				data = S.nextInt();
				dll.addAtFront(data);
				dll.printList();
				break;
			case 2: 
				System.out.println("Enter data");
				data = S.nextInt();
				dll.addAtEnd(data);
				dll.printList();
				break;
			case 3: 
				System.out.println("Enter position");
				pos = S.nextInt();
				System.out.println("Enter data");
				data = S.nextInt();
				dll.addAtIndex(pos,data);
				dll.printList();
				break;
			case 4:
				dll.removeFromFront();
				dll.printList();
				break;
			case 5:
				dll.removeFromEnd();
				dll.printList();
				break;
			case 6: 
				System.out.println("Enter position");
				pos = S.nextInt();
				dll.removeFromIndex(pos);
				dll.printList();
				break;
			case 7: 
				System.out.println("Enter position");
				pos = S.nextInt();		
				System.out.println(dll.get(pos));
				System.out.println("\n\n");
				break;
			case 8:
				System.out.println(dll.size);
				System.out.println("\n\n");
				break;
			case 9:
				System.out.println("Enter position");
				pos = S.nextInt();
				System.out.println("Enter data");
				data = S.nextInt();
				dll.replaceAt(pos, data);
				dll.printList();
				break;
			default:
				System.out.println("Invalid choice. Enter a valid choice.\n\n");
			}
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