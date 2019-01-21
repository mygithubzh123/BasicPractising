package collection.list.linkedlist;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.LinkedList;

/**
 * 测试LinkedList
 *
 * @author neo
 * 2019/1/11 10:53 AM
 */
public class TestLinkedList {

	private LinkedList<String> linkedList = new LinkedList<>();

	@BeforeEach
	void setup(){
		linkedList.addAll(Collections.singletonList("abc"));
	}

	@Test
	void test1(){
		System.out.println(linkedList);
		linkedList.addFirst("aaa");
		linkedList.addLast("zzz");
		System.out.println(linkedList);
	}
}
