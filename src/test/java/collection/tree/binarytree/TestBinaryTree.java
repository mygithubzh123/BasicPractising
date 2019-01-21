package collection.tree.binarytree;

import org.junit.jupiter.api.Test;

/**
 * 测试二叉树
 *
 * @author neo
 * 2019/1/14 12:02 PM
 */
public class TestBinaryTree {

	@Test
	void TestSimpleBinaryTree() {
		SimpleBinaryTree<String> stringSimpleBinaryTree = new SimpleBinaryTree<>();
		stringSimpleBinaryTree.add("d");
		stringSimpleBinaryTree.add("b");
//		stringSimpleBinaryTree.add("a");
//		stringSimpleBinaryTree.add("c");
		stringSimpleBinaryTree.add("f");
//		stringSimpleBinaryTree.add("e");
//		stringSimpleBinaryTree.add("g");

		stringSimpleBinaryTree.preVisit();

		System.out.println(stringSimpleBinaryTree.height());
	}
}
