public class Test2{
	int a;//默认值0
	char c;
	byte b;
	short s;
	long l;

	float price;
	double d;

	boolean t;
	public static void main(String args[]){
		Test2 test=new Test2();
		test.m1();//调用m1方法
	}
	
	public void m1(){
		int a=2;
		System.out.println("调用局部变量FF："+a);//Java寻找变量是就近原则（从最近的作用域找，如果找到，则直接使用，否则扩大作用域）
	}
	//在某个方法里面声明的变量就是局部变量，如果要使用局部变量，那么必须先要给局部变量进行赋值
	//在类中声明的变量就是成员变量，成员变量都有默认值
}