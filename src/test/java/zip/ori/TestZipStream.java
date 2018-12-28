/**
*   (用一句话描述该文件做什么)
* @Filename TestZipStream.java
* @Package zip
* @author neo
* @since 2018年3月19日 上午9:33:41
* @Version V1.0
*/
package zip.ori;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import system.PathUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;


/**
 *   (这里用一句话描述这个类的作用)
 *    TestZipStream
 * @author neo
 * @since 2018年3月19日 上午9:33:41
 */
public class TestZipStream {
	
	String folder = null;
	
	@BeforeEach
	public void setup()throws Exception{
		folder = PathUtils.getBasePath()+File.separator+"file"+File.separator+"zip";
	}
	
	/**
	 * 读到-1代表第一个条目读取完毕
	 * 需要关闭第一个条目,继续读取下一个条目
	 * 
	 * .available();只能在EOF时返回0,其他时候都是返回1
	 */
	@Test
	public void testRead()throws Exception{
		File zip = new File(folder+File.separator+"test.zip");
		if(!zip.exists()){
			throw new Exception();
		}
		try(ZipInputStream zin = new ZipInputStream(new FileInputStream(zip))){
			while(zin.getNextEntry() != null){
				byte[] bs = new byte[1024];
				while(zin.read(bs) != -1){
					System.out.println(new String(bs));
				}
				zin.closeEntry();
			}
		}
	}
	
	@Test
	public void testWrite()throws Exception{
		String file = folder+File.separator+"out.zip";
		try(ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(file))){
			File f = new File(folder + File.separator + "entryFile");
			for(File f0: f.listFiles()){
				byte[] bs = null;
				try(FileInputStream fis = new FileInputStream(f0)){
					int length = fis.available();
					bs = new byte[length];
					fis.read(bs);
				}
				ZipEntry z = new ZipEntry(f0.getName());
				zos.putNextEntry(z);
				zos.write(bs);
				zos.closeEntry();
			}
		}
	}
	
	@Test
	public void test()throws Exception{
		String file = folder+File.separator+"out.zip";
		try(ZipFile zf = new ZipFile(file)){
			System.out.println(zf.size());
		}
	}
}
