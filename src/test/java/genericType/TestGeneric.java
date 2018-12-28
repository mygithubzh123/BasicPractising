package genericType;
import java.util.ArrayList;
import java.util.List;

/**
 *   (用一句话描述该文件做什么)
 * @Filename TestGeneric.java
 * @Package 
 * @author neo
 * @since 2016年3月15日 下午3:06:44
 * @Version V1.0
 */

/**
 *   (这里用一句话描述这个类的作用)
 *    TestGeneric
 * @author neo
 * @since 2016年3月15日 下午3:06:44
 */
public class TestGeneric <T,S>{
	
	T t;
	/**
	*   TestGeneric构造方法
	* @param t
	* @param s
	*/
	public TestGeneric(T t) {
		super();
		this.t = t;
	}
	public T getT() {
		return t;
	}
	public void setT(T t) {
		this.t = t;
	}
	
	public static void main(String[] args) {
		List<? extends Number> list = new ArrayList<>();
		System.out.println(list);
		TestGeneric<String,String> tg = new TestGeneric<String,String>("a");
		System.out.println(tg);
		Car<Integer,String> cowCar = new Car<Integer,String>(1,"go");
		System.out.println(cowCar);
		Car<Long,Boolean> eCar = new Car<Long,Boolean>(1l,true);
		System.out.println(eCar);
		
	}
}
class Car<T,S>{
	
	T driver;
	
	S power;

	/**
	*   Car构造方法
	* @param driver
	* @param power
	*/
	public Car(T driver, S power) {
		super();
		this.driver = driver;
		this.power = power;
	}

	public T getDriver() {
		return driver;
	}

	public void setDriver(T driver) {
		this.driver = driver;
	}

	public S getPower() {
		return power;
	}

	public void setPower(S power) {
		this.power = power;
	}
	
	
}