
package collection.map;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class TestHashMap {

	static final int MAXIMUM_CAPACITY = 1 << 30;
	
    static final int tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }
    
    @Test
    public void testSize()throws Exception{
    	for(int i = 0;i<100000;i+=10){
    		System.out.println("cap为"+i+"的HashMap 的内部的桶大小为"+tableSizeFor(i));	
    	}
    }
    
    @Test
    public void testNew()throws Exception{
    	Map<String,Object> map = new HashMap<>();
    	map.put("abc", new Object());
    }
    
    
    /**
     * 实例化一个HashMap时
     * 默认capacity 16 加载因子0.75 Node链表转treeNode 阈值 8/treeNode转Node链表 阈值6
     * capacity -> 2^n tableSize
     * threshold -> 2^n*0.75
     * 
     * Put【K,V】
     * K k 对 tableSize 散列 -> index in range [0,tableSize-1]
     * index <-> NodeList
     * 		        添加【K,V】,index对应的位置没有Node时，新生成Node，next指针为空
     * 		再次添加【K,V】,index不重复时,继续在散列的index上新增Node，同上
     * 				     index重复时,找到散列位置的Node,建立新Node,设置前一个Node的next指针
     * 
     * 
     * get【K】
     * K k 对 tableSize 散列 ,获取Node
     * 循环判断nextNode {nextNode.getK == k || nextNode.getK.equals(k)} 找到对应Node
     * 找到为null停止
     * 
     */
    @Test
    public void testHashCrash()throws Exception{
    	Map<Integer,Object> map = new HashMap<>();
    	map.put(1, new Object());
    	map.put(17, new Object());
    	map.get(17);
    }
}
