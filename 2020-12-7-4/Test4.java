public class Test4{
	public static void main(String args[]){
		
		int a=3;	//��Ա����(ȫ�ֱ���)
		//if(a++==3){//�ȵ�5�д���ִ�к�a��ֵ�Ż��1
		if(++a==3){
			System.out.println("AAAAA");
		}
		System.out.println(a);
		

		int b=4;
		//if(true && b++==4){
		//if(false && b++==4){
		if(false & b++==4){		//&,�ж�ǰһ��,ǰһ����,�Ͳ���ȥ�ж���һ��;&&,ǰ�������������ж�
			System.out.println("KKKKK");
		}
		System.out.println(b);
	}
}