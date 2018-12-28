package regExp;

import org.junit.jupiter.api.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestGroup {

	String target = "abcdefg";
	
	/**
	 * (exp)
	 * 匹配exp并分组
	 */
	@Test
	public void test(){
		Pattern p = Pattern.compile("ab([a-z].+)g");
		Matcher m = p.matcher(target);
		if(m.matches()){
			System.out.println("match");
			System.out.println(m.group(0));
			System.out.println(m.group(1));
		}
	}
	
	/**
	 * (?<name>exp)
	 * 匹配exp并分组到名为name的组里面去
	 * 默认的序号分组不变
	 */
	@Test
	public void test1(){
		Pattern p = Pattern.compile("ab(?<groupp1>[a-z].+)g");
		Matcher m = p.matcher(target);
		if(m.matches()){
			System.out.println("match");
			System.out.println(m.group(0));
			System.out.println(m.group(1));
			System.out.println(m.group("groupp1"));
		}
	}
	
	/**
	 * 匹配exp但不分组
	 */
	@Test
	public void test2(){
		Pattern p = Pattern.compile("ab(?:[a-z].+)g");
		Matcher m = p.matcher(target);
		if(m.matches()){
			System.out.println("match");
			System.out.println(m.group());
			//System.out.println(m.group(1));
		}
	}
	
	/**
	 * (?=exp)零宽断言  表示匹配exp的位置
	 */
	@Test
	public void test3(){
		Pattern p = Pattern.compile(".+(?=efg)");
		Matcher m = p.matcher(target);
		if(m.find()){
			System.out.println("match");
			System.out.println(m.group());
			//System.out.println(m.group(1));
		}
	}
	
	/**
	 * (?<=exp)匹配exp并表示exp的后端位置
	 */
	@Test
	public void test4(){
		Pattern p = Pattern.compile(".+(?<=efg)");
		Matcher m = p.matcher(target);
		if(m.find()){
			System.out.println("match");
			System.out.println(m.group(0));
		}
	}
	
	@Test
	public void test5(){
		String a = "abc123efgabcdefg";
		Pattern p = Pattern.compile("abc.+(?!=123)efg");
		Matcher m = p.matcher(a);
		if(m.find()){
			System.out.println("match");
			System.out.println(m.group(0));
			System.out.println(m.group(2));
		}
	}
}
