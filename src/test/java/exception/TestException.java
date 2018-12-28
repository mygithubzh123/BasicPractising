package exception;
/**
 *   (用一句话描述该文件做什么)
 * @Filename TestException.java
 * @Package 
 * @author neo
 * @since 2017年5月16日 下午6:19:18
 * @Version V1.0
 */

/**
 *   (这里用一句话描述这个类的作用)
 *    TestException
 * @author neo
 * @since 2017年5月16日 下午6:19:18
 */
public class TestException {
	public static void main(String[] args) {
		int i = 0;
		try{
			int b = 1/i;
			System.out.println(b);
		}catch(ArithmeticException e){
			e.printStackTrace();
			throw e;
		} catch(Exception e){
			System.out.println("b");
		}
	}

}
