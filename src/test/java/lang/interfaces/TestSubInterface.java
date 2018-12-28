/**
*   (用一句话描述该文件做什么)
* @Filename TestSubInterface.java
* @Package lang.interfaces
* @author neo
* @since 2018年4月9日 下午12:33:48
* @Version V1.0
*/
package lang.interfaces;

interface A {
    void method() throws Exception;
}

interface B extends A {
    void method();  //这里没有抛出异常
}

public class TestSubInterface implements B {

    public static void main(String[] args)  {
        A a=new TestSubInterface();
        B b=new TestSubInterface();
        
        //捕获A类method方法的异常
        try {
            a.method();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        b.method();

    }

    @Override
    public void method() {
        System.out.println("method");
    }
}