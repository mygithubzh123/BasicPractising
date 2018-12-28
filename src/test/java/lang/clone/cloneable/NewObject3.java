/**
*   (用一句话描述该文件做什么)
* @Filename NewObject2.java
* @Package lang.clone.cloneable
* @author neo
* @since 2018年2月28日 上午10:27:51
* @Version V1.0
*/
package lang.clone.cloneable;

/**
 *   (这里用一句话描述这个类的作用)
 *    NewObject2
 * @author neo
 * @since 2018年2月28日 上午10:27:51
 */
public class NewObject3 implements Cloneable{

	/**
	 * 子类重新实现父类的方法称重写；重写时可以修改访问权限修饰符和返回值，方法名和参数类型及个数都不可以修改；
	 * 返回值为类类型时，重写的方法才可以修改返回值类型，且必须是父类方法返回值的子类；
	 */
	@Override
	public String clone() throws CloneNotSupportedException {
		return (String)super.clone();
	}
}
