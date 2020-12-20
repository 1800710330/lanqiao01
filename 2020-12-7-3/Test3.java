public class Test3{
	public static void main(String args[]){
		int a=(120 >>1)<<8;
		System.out.println(a);

		//00000000 00000000 00000000 00111100
		/*
		右移1位相当于除2
		左移1位相当于乘2

		位运算的速度快

		如何把一个整型转成4个字节？
		*/
	}
	// int转换为byte[4]数组
	public static byte[] getByteArray(int i) {
		byte[] b = new byte[4];
		b[0] = (byte) ((i & 0xff000000) >> 24);
		b[1] = (byte) ((i & 0x00ff0000) >> 16);
		b[2] = (byte) ((i & 0x0000ff00) >> 8);
		b[3] = (byte)  (i & 0x000000ff);
		return b;
	}
}