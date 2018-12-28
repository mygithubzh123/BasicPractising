/**
*   (用一句话描述该文件做什么)
* @Filename Employee.java
* @Package genericType.vo
* @author neo
* @since 2018年3月8日 上午10:38:56
* @Version V1.0
*/
package genericType.vo;

/**
 *   (这里用一句话描述这个类的作用)
 *    Employee
 * @author neo
 * @since 2018年3月8日 上午10:38:56
 */
public class Employee extends Person{

	private String comName;
	
	private String occupation;

	public String getComName() {
		return comName;
	}

	public void setComName(String comName) {
		this.comName = comName;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}
	
	
}
