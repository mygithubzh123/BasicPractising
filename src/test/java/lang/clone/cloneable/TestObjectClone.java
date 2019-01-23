package lang.clone.cloneable;

import org.junit.jupiter.api.Test;

/**
 *   (这里用一句话描述这个类的作用)
 *    TestObjectClone
 * @author neo
 * @since 2018年2月28日 上午9:49:07
 */
public class TestObjectClone {

	/**
	 * object.clone方法外部不可见，只能子类调用
	 * 子类需要使用到object.clone方法，必须在类上实现Clonable接口
	 * 
	 */
	@Test
	public void testObjectCloneWithProtectedOverrideMethod()throws Exception{
		NewObject o1 = new NewObject();
		System.out.println(o1);
		Object newO1 = o1.clone();
		System.out.println(newO1);
	}
	
	@Test
	public void testObjectCloneWithClonable()throws Exception{
		NewObject2 o2 = new NewObject2();
		System.out.println(o2);
		Object newO2 = o2.clone();
		System.out.println(newO2);
	}
}
