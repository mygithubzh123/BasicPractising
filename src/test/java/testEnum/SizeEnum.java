/**
*   (用一句话描述该文件做什么)
* @Filename SizeEnum.java
* @Package testEnum
* @author neo
* @since 2018年2月26日 下午4:56:38
* @Version V1.0
*/
package testEnum;

/**
 *   (这里用一句话描述这个类的作用)
 *    SizeEnum
 * @author neo
 * @since 2018年2月26日 下午4:56:38
 */
public enum SizeEnum {
	
	SMALL("S"),
	
	MIDDLE("M"),
	
	LARGE("L"),
	
	EXTRALARGE("XL");
	
	private String size;

	private SizeEnum(String size){
		this.size = size;
	}

	public String getSize() {
		return size;
	}
}
