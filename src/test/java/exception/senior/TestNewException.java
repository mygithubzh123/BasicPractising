package exception.senior;

import org.junit.jupiter.api.Test;

import java.sql.SQLException;

/**
 * 异常信息的传递
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
