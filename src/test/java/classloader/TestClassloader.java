package classloader;

import org.junit.jupiter.api.Test;

public class TestClassloader {

	@Test
	public void getClassloader1(){
		ClassLoader classloader = this.getClass().getClassLoader();
		System.out.println(classloader);
	}
	
	@Test
	public void getClassloader2(){
		ClassLoader classloader = Class.class.getClassLoader();
		System.out.println(classloader);
		
		ClassLoader classloader1 = Object.class.getClassLoader();
		System.out.println(classloader1);
	}
	
	@Test
	public void getClassloader3(){
		System.out.println(ClassLoader.getSystemClassLoader());
	}
	
	@Test
	public void getClassloader4(){
		System.out.println(Thread.currentThread().getContextClassLoader());
	}
}
