package practice;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class DoublyLinkedListTester {
	
	DoublyLinkedList<Integer> list;
	
	@Before
	public void setUp() throws Exception {
		list = new DoublyLinkedList<Integer>();
		list.addAtEnd(5);
		list.addAtEnd(10);
		list.addAtEnd(15);
		list.addAtEnd(20);
	}
	
	@Test
	public void testAddFront() {
		try {
			list.addAtFront(null);
			fail("Null can't be added");
		} catch(NullPointerException e) {}
		
		list.addAtFront(30);
		int a = list.get(0);
		assertEquals("testAddFront: check if element added at end", 30, a);
		assertEquals("testAddFront: check if size increased", 5, list.size());
	}
	
	@Test
	public void testAddEnd() {
		try {
			list.addAtEnd(null);
			fail("Null can't be added");
		} catch(NullPointerException e) {}
		
		list.addAtEnd(30);
		int a = list.get(list.size()-1);
		assertEquals("testAddEnd: check if element added at end", 30, a);
		assertEquals("testAddEnd: check if size increased", 5, list.size());
	}
	
	@Test
	public void testAddAtIndex() {
		try {
			list.addAtIndex(2, null);
			fail("Null can't be added");
		} catch(NullPointerException e) {}
		
		try {
			list.addAtIndex(-1, 50);
			fail("Out Of Bounds");
		} catch(IndexOutOfBoundsException e) {}
		
		try {
			list.addAtIndex(list.size(), 50);
			fail("Out Of Bounds");
		} catch(IndexOutOfBoundsException e) {}
		
		list.addAtIndex(2, 50);
		int added = list.get(2);
		assertEquals("testAddAtIndex: check if element added at the index", 50, added);
		assertEquals("testAddAtIndex: check if size of list increased", 5, list.size());
	}
	
	@Test
	public void testRemoveFront() {
		int removed = list.removeFromFront();
		assertEquals("testRemoveFront: check if element removed from front", 5, removed);
		assertEquals("testRemoveFront: check if size decreased", 3, list.size());
	}
	
	@Test
	public void testRemoveEnd() {
		int removed = list.removeFromEnd();
		assertEquals("testRemoveEnd: check if element removed from end", 20, removed);
		assertEquals("testRemoveEnd: check if size decreased", 3, list.size());
	}
	
	@Test
	public void testRemoveFromIndex() {		
		try {
			list.removeFromIndex(-1);
			fail("Out Of Bounds");
		} catch(IndexOutOfBoundsException e) {}
		
		try {
			list.removeFromIndex(list.size());
			fail("Out Of Bounds");
		} catch(IndexOutOfBoundsException e) {}
		
		int removed = list.removeFromIndex(3);
		assertEquals("testRemoveEnd: check if element removed from end", 20, removed);
		assertEquals("testRemoveEnd: check if size decreased", 3, list.size());
	}

	@Test
	public void testGet() {
		try {
			list.get(-1);
			fail("Out Of Bounds");
		} catch(IndexOutOfBoundsException e) {}
		
		try {
			list.get(list.size());
			fail("Out Of Bounds");
		} catch(IndexOutOfBoundsException e) {}
		
		int a = list.get(0);
		assertEquals("testGet: check if list returns correct element", 5, a);
	}
	
	@Test
	public void testReplaceAt() {
		try {
			list.replaceAt(2, null);
			fail("Null can't be added");
		} catch(NullPointerException e) {}
		
		try {
			list.replaceAt(-1, 50);
			fail("Out Of Bounds");
		} catch(IndexOutOfBoundsException e) {}
		
		int replaced = list.replaceAt(3, 50);
		assertEquals("testReplaceAt: check if element is replaced", 50, replaced);
	}
	
	@Test
	public void testSize() {
		assertEquals("testSize: check size of list", 4, list.size());
	}
}