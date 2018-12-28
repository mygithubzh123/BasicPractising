package classloader;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class TestClass {

	@Test
	public void testClassToString(){
		//class
		String[] strs = new String[5];
		byte[] bs = new byte[5];
		System.out.println(strs.getClass());
		System.out.println(bs.getClass());

		TestClass t = new TestClass();
		TestClass[] ts = new TestClass[5];

		System.out.println(t.getClass());
		System.out.println(ts.getClass());
		System.out.println(TestClass.class);
		//接口
		System.out.println(InterfaceA.class);
		//基础类型
		System.out.println(int.class);
	}

	@Test
	public void testClassToGenericString(){
		//class
		TestClass t = new TestClass();
		System.out.println(t.getClass().toGenericString());
		//接口
		System.out.println(InterfaceA.class.toGenericString());
		//基础类型
		System.out.println(int.class.toGenericString());
	}

	@Test
	public void testClassAndObject()  throws Exception {
		//object from class
		Class<?> ttt = Class.forName("classloader.TestClass");
		System.out.println(ttt);
		TestClass tni = (TestClass)ttt.newInstance();
		System.out.println(tni);

		//if object if from class
		System.out.println(ttt.isInstance(tni));

		//if class is isAssignable from class
		System.out.println(CharSequence.class.isAssignableFrom(String.class));


		System.out.println(String.class.getSuperclass());
		System.out.println(String.class.getGenericSuperclass());
	}

	@Test
	public void testTypeVari(){
		List<String> a = new ArrayList<>();
		Class c = a.getClass();
		System.out.println(c);
		System.out.println(c.getTypeName());
		System.out.println(c.getComponentType());
		System.out.println(c.getTypeParameters());
	}

	@Test
	public void testClassLoader(){
		System.out.println(TestClass.class.getClassLoader());
	}

	@Test
	public void testCLassTools(){
		Class<TestClass> clazz = TestClass.class;
		clazz.getClassLoader();
	}

}
interface InterfaceA {

	void display();
}