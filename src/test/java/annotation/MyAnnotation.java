package annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;


public class MyAnnotation{
	TestAnnotation t = new TestAnnotation();
}

@Target(ElementType.TYPE)
@interface Nnotation {
	public String getStringName();
	
}

@Nnotation(getStringName = "test")
class TestAnnotation{
	
}