package exception;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileInputStream;
import java.util.concurrent.TimeUnit;

/**
 *   (这里用一句话描述这个类的作用)
 *    TestException
 * @author neo
 * @since 2017年5月16日 下午6:19:18
 */
public class TestException {

	@Test
	void main(String[] args) {
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

	@Test
	void testThrowable() {
		Throwable throwable = new Throwable();
		System.out.println(throwable.toString());
		throwable.initCause(throwable);
	}

	@Test
	void testTryWithin(){
		try(final FileInputStream fileInputStream = new FileInputStream("/Users/neo/Downloads/ops.sql")){
			TimeUnit.SECONDS.sleep(30);
		} catch (Exception e){
			e.printStackTrace();
		}
	}

}
