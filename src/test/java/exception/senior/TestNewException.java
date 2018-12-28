/**
*   (用一句话描述该文件做什么)
* @Filename TestNewException.java
* @Package exception.senior
* @author neo
* @since 2018年3月7日 下午5:07:05
* @Version V1.0
*/
package exception.senior;

import org.junit.jupiter.api.Test;

import java.sql.SQLException;

/**
 *   (这里用一句话描述这个类的作用)
 *    TestNewException
 * @author neo
 * @since 2018年3月7日 下午5:07:05
 */
public class TestNewException {
	
	@Test
	public void test1()throws Exception{
		try{
			throw new SQLException();
		} catch (SQLException e){
			throw new Exception("系统错误：数据库错误");
		}
	}

	/**
	 * 对比test1中
	 * 最终抛出的异常包含更多原始的异常信息
	 */
	@Test
	public void test2()throws Exception{
		try{
			throw new SQLException();
		} catch (SQLException e){
			Exception t = new Exception("系统错误");
			t.initCause(e);
			throw t;
		}
	}
}
