package collection;

import java.lang.ref.WeakReference;

public class TestRefrence {

	public static void main(String[] args) {
		
		System.out.println("开始");

		A a = new A();

		WeakReference<A> sr = new WeakReference<A>(a);
		a = null;
		if (sr != null) {
			Object newObj = sr.get();
			System.out.println(newObj);
		}
		a = null;
		// System.gc();
	}
}

class A {
	int[] a;
	int 我;

	public A() {
		a = new int[100000000];
		我 = 123;
	}
}