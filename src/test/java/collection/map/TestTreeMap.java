package collection.map;

import org.junit.jupiter.api.Test;

import java.util.TreeMap;

/**
 * @author neo
 * @since 2018年3月8日 下午5:18:09
 */
public class TestTreeMap {
	
	/**
	 * TreeMap
	 * K必须是 Comparable
	 * 
	 * put【k,v】 第一个元素Entry 作为root
	 * 
	 * 非第一个元素
	 * 		用k比较，朝正/负方向一直比较直到叶节点,生成新的Entry放到末端
	 * 		用红黑树规则固定 TreeMap.fixAfterInsertion(Entry)
	 * 
	 */
	@Test
	public void test(){
		TreeMap<String,Object> map = new TreeMap<>(); 
		map.put("abc", new Object());
		map.put("ccc", new Object());
		
		System.out.println(map.ceilingKey("abc"));
		System.out.println(map.lastKey());
	}

	@Test
	void testRotate(){
		TreeMap<Integer,Object> map = new TreeMap<>();
		map.put(1, new Object());
		map.put(2, new Object());
		map.put(5, new Object());
		map.put(7, new Object());
		map.put(8, new Object());
		map.put(11, new Object());
		map.put(14, new Object());
		map.put(15,new Object());

		map.put(4, new Object());


	}

}
