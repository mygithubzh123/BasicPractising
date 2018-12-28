/**
*   (用一句话描述该文件做什么)
* @Filename Person.java
* @Package genericType.vo
* @author neo
* @since 2018年3月8日 上午10:37:46
* @Version V1.0
*/
package genericType.vo;

/**
 *   (这里用一句话描述这个类的作用)
 *    Person
 * @author neo
 * @since 2018年3月8日 上午10:37:46
 */
public class Person {
	
	private String idNo;
	
	private String name;
	
	private int age;
	
	private int gender;

	public String getIdNo() {
		return idNo;
	}

	public void setIdNo(String idNo) {
		this.idNo = idNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}
	
}
