package reflect;

import org.junit.jupiter.api.Test;

public class TestFieldAndDeclared {
	
	@Test
	public void getField() throws NoSuchFieldException, SecurityException{
		ClassA a = new ClassA(1,"abc");
		System.out.println(a.getClass().getField("id"));
		System.out.println(a.getClass().getField("name"));
	}
	
	/**
	 * 私有变量通过getField无法获取
	 */
	@Test
	public void getDeclaredField() throws NoSuchFieldException, SecurityException{
		ClassA a = new ClassA(1,"abc");
		System.out.println(a.getClass().getDeclaredField("id"));
		System.out.println(a.getClass().getDeclaredField("name"));
	}

}
class ClassA {
	
	private int id;
	String name;
	public ClassA(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}