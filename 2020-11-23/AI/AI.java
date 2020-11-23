import javax.microedition.lcdui.*;
import javax.microedition.midlet.*;
import java.io.*;
public class AI extends MIDlet
	{
	Display display;
	MainCanvas mc;
	public AI(){
		display=Display.getDisplay(this);
		mc=new MainCanvas();
		display.setCurrent(mc);
	}
	public void startApp(){
	}
	public void destroyApp(boolean unc){
	}
	public void pauseApp(){
	}
}
class MainCanvas extends Canvas implements Runnable{
			int flag=1;
			Thread thread;
			int heroX=120,heroY=120,bossX=0,bossY=0;
			int leftFlag=1, rightFlag=1,upFlag=1, downFlag=1;	//�����
			Image currentImg,bossImg;
			Image heroImg[][]=new Image[4][3];		//������ά���飺��ʽ���������� ������[][]=new ��������[�г���][�г���]
	public MainCanvas()       
	{
		try
		{
			for(int i = 0;i < heroImg.length;i++){              //iȡֵ�ĺ��壺0����ʾleft��1��right��2��up��3��down
				for(int j = 0;j < heroImg[i].length;j++){			//jȡֵ�ĺ��壺0��������1����ڡ�2���Ұ�
					heroImg[i][j]=Image.createImage("/sayo"+i+j+".png");
				}
			}
			bossImg=Image.createImage("/zuzu000.png");
			currentImg=heroImg[3][0];//�·���Ϊ��ǰͼ
			thread=new Thread(this);
			thread.start();
		}
		catch (IOException e){
			e.printStackTrace();
		}
	}
		/*
		�ڶ��߳���дһ����ѭ������ͣ�رȽ�boss��hero������
		*/
		public void run(){
			while (true){
				try
				{
					Thread.sleep(200);//FPS:��Ļˢ����
				}
				catch (InterruptedException e){
					e.printStackTrace();
				}
				if(bossX<heroX){
					bossX++;
				}
				else{
					bossX--;
				}
				if(bossY<heroY){
					bossY++;
				}
				else{
					bossY--;
				}
				repaint();
			}		
		}
	public void paint(Graphics g){
		g.setColor(0,255,0);	//��ɫ��Ļ����0,0,0��->��ɫ����255,255,255��->��ɫ   (0,255,255)->ˮ��ɫ
		g.fillRect(0,0,getWidth(),getHeight());
		g.drawImage(currentImg,heroX,heroY,0);
		g.drawImage(bossImg,bossX,bossY,0);

	}
	/*
	��������
	*/
	public void changePicAndDirect(int direction){
		if(flag == 1){
			currentImg=heroImg[direction][1];
			flag++;
		}
		else if(flag == 2){
			currentImg = heroImg[direction][2];
			flag = 1;
		}
		repaint();//ˢ����Ļ
	}
	public void keyPressed(int keyCode){

		int action=getGameAction(keyCode);
		/*ʵ������
		�Ķ����л�*/
		if(action==LEFT){
			//���÷���
			changePicAndDirect(0);
			heroX = heroX - 10;		   
		}
		/*ʵ���ҷ���
		�Ķ����л�*/
		if(action == RIGHT){
			changePicAndDirect(1);
			heroX = heroX + 10;
		}
		/*ʵ���Ϸ���
		�Ķ����л�*/
		if(action == UP){
			changePicAndDirect(2);  		 
			heroY = heroY - 10;
		}
		/*ʵ���·���
		�Ķ����л�*/
		if(action==DOWN){
			changePicAndDirect(3);
			heroY = heroY + 10;
		}
	}
}
