package lang;

public class TestInner {
	
	private String name;
	
	public static int count=0;
	
	public TestInner(String name) {
		super();
		this.name = name;
	}

	class Inner{
		
		
		public Inner() {
			super();
		}

		public String getOuterName(){
			return name;
		}
		
		public int getOutCount(){
			return count;
		}
	}
	
	public static void main(String[] args) {
		TestInner out = new TestInner("abc");
		Inner inner = out.new Inner();
		System.out.println(inner.getOutCount());
		System.out.println(inner.getOuterName());
	}
}
