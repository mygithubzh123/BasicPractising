package lang.main;

import sun.reflect.Reflection;

public class TestMain {

	public static void main(String[] args) {
		Class<?> clazz = Reflection.getCallerClass();
		if(clazz != null){
			System.out.println(clazz);
		}
	}
}
