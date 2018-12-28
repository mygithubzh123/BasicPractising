/**
*   (用一句话描述该文件做什么)
* @Filename ObjectWrite.java
* @Package support.serializable
* @author neo
* @since 2016年1月27日 下午12:57:32
* @Version V1.0
*/
package serialization.objIO;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;

/**
 *   (这里用一句话描述这个类的作用)
 *    ObjectWrite
 * @author neo
 * @since 2016年1月27日 下午12:57:32
 */
public class TestObjectStream{
	
	private String outputPath;
	
	private String inputPath;
	
	ObjectWrite objectWrite;
	
	@BeforeEach
	public void setup() throws FileNotFoundException, IOException{
		//输出流保存的文件名为objectOut;ObjectOutputStream能把Object输出成Byte流
		outputPath = "D:\\test-files\\objectOut";
		inputPath = "D:\\test-files\\objectOut";
		objectWrite =new ObjectWrite(23,123);
		
	}

	@Test
	public void testWrite() throws Exception {
		 ObjectOutputStream oos  = new ObjectOutputStream(new FileOutputStream(outputPath));
	     oos.writeObject(objectWrite); 
	     oos.writeObject(objectWrite); 
	     oos.flush();  //缓冲流 
	     oos.close(); //关闭流
	}
	
	@Test
	public void testRead()throws Exception {
	     ObjectInputStream ois = new ObjectInputStream(new FileInputStream(inputPath));
	     ObjectWrite objectWrite1 =(ObjectWrite) ois.readObject();
	     ObjectWrite objectWrite2 =(ObjectWrite) ois.readObject();
	     System.out.println(objectWrite1);
	     System.out.println(objectWrite2);
	     System.out.println(objectWrite == objectWrite1);
	     ois.close();
	}

}
class  ObjectWrite implements Serializable{
	/**
	*   (用一句话描述这个变量表示什么)
	* @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
	*/
	private static final long serialVersionUID = 1L;
	private int x;
	private int y;
	
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

	/**
	*   ObjectWrite构造方法
	* @param x
	* @param y
	*/
	public ObjectWrite(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
}
