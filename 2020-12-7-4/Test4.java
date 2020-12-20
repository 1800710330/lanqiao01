public class Test4{
	public static void main(String args[]){
		
		int a=3;	//成员变量(全局变量)
		//if(a++==3){//等第5行代码执行后a的值才会加1
		if(++a==3){
			System.out.println("AAAAA");
		}
		System.out.println(a);
		

		int b=4;
		//if(true && b++==4){
		//if(false && b++==4){
		if(false & b++==4){		//&,判断前一个,前一个否,就不再去判断下一个;&&,前后两个都进行判断
			System.out.println("KKKKK");
		}
		System.out.println(b);
	}
}