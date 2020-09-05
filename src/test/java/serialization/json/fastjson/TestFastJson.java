package serialization.json.fastjson;

import com.alibaba.fastjson.JSON;
import generictype.vo.Person;

/**
 * test fastjson api
 *
 * @author neo
 * 2020/9/5 8:17 PM
 */
public class TestFastJson {

	public static void main(String[] args) {
		Person p = new Person();
		System.out.println(JSON.toJSON(p));
	}
}
