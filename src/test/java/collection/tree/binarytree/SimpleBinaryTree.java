package collection.tree.binarytree;

/**
 * 二叉树的简单实现
 *
 * @author neo
 * 2019/1/14 11:24 AM
 */
public class SimpleBinaryTree<T> {

	private Node<T> root;

	public void add(T t){
		if(root == null){
			root = new Node<>(t);
		} else {
			Node<T> newNode = new Node<>(t);
			root.addNode(newNode);
		}
	}

	void preVisit(){
		root.preVisit();
	}

	int height(){
		return root.height();
	}

	class Node<T> implements Comparable<Node> {

		T t;

		int height;

		Node(T t) {
			this.t = t;
			this.height = 1;
		}

		Node<T> paraent;

		Node<T> left;

		Node<T> right;

		void preVisit(){
			System.out.print("m:");
			show();
			if(this.left != null){
				System.out.print("l:");
				left.preVisit();
			}
			if(right != null){
				System.out.print("r:");
				right.preVisit();
			}
		}

		void postVisit(){
			left.show();
			right.show();
			show();
		}

		void middleShow(){
			left.show();
			show();
			right.show();
		}

		void show(){
			System.out.println(t.toString());
		}

		void addNode(Node<T> newNode){
			newNode.paraent = this;
			newNode.height = this.height +1;
			if(this.compareTo(newNode) > 0){
				if(this.left == null){
					this.left = newNode;
				} else {
					this.left.addNode(newNode);
				}
			} else {
				if(this.right == null){
					this.right = newNode;
				} else {
					this.right.addNode(newNode);
				}
			}
		}

		int height(){
			if(this.isLeaf()){
				return height;
			} else {
				if(left != null){
					if(right != null){
						return left.height() > right.height() ? left.height():right.height();
					} else {
						return left.height();
					}
				} else {
					return right.height();
				}
			}
		}

		@Override
		public int compareTo(Node o) {
			return String.valueOf(this.t).compareTo(String.valueOf(o.t));
		}

		boolean isLeaf(){
			return this.left == null && this.right == null;
		}
	}
}
