/**
*   (用一句话描述该文件做什么)
* @Filename Point.java
* @Package genericType
* @author neo
* @since 2018年2月9日 上午11:07:17
* @Version V1.0
*/
package genericType;

/**
 *   (这里用一句话描述这个类的作用)
 *    Point
 * @author neo
 * @since 2018年2月9日 上午11:07:17
 */
public class Point implements Comparable<Point>{
	protected int x;
	protected int y;
	
	public Point(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}

	@Override
	public int compareTo(Point o) {
		return o.getX() > this.x && o.getY()> this.y ? 1:0;
	}
}