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
			int leftFlag=1, rightFlag=1,upFlag=1, downFlag=1;	//标记量
			Image currentImg,bossImg;
			Image heroImg[][]=new Image[4][3];		//创建二维数组：形式：数据类型 数组名[][]=new 数据类型[行长度][列长度]
	public MainCanvas()       
	{
		try
		{
			for(int i = 0;i < heroImg.length;i++){              //i取值的含义：0：表示left、1：right、2：up、3：down
				for(int j = 0;j < heroImg[i].length;j++){			//j取值的含义：0：正立、1：左摆、2：右摆
					heroImg[i][j]=Image.createImage("/sayo"+i+j+".png");
				}
			}
			bossImg=Image.createImage("/zuzu000.png");
			currentImg=heroImg[3][0];//下方向为当前图
			thread=new Thread(this);
			thread.start();
		}
		catch (IOException e){
			e.printStackTrace();
		}
	}
		/*
		在多线程里写一个死循环，不停地比较boss和hero的坐标
		*/
		public void run(){
			while (true){
				try
				{
					Thread.sleep(200);//FPS:屏幕刷新率
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
		g.setColor(0,255,0);	//绿色屏幕；（0,0,0）->黑色；（255,255,255）->白色   (0,255,255)->水绿色
		g.fillRect(0,0,getWidth(),getHeight());
		g.drawImage(currentImg,heroX,heroY,0);
		g.drawImage(bossImg,bossX,bossY,0);

	}
	/*
	创建方法
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
		repaint();//刷新屏幕
	}
	public void keyPressed(int keyCode){

		int action=getGameAction(keyCode);
		/*实现左方向
		的动作切换*/
		if(action==LEFT){
			//调用方法
			changePicAndDirect(0);
			heroX = heroX - 10;		   
		}
		/*实现右方向
		的动作切换*/
		if(action == RIGHT){
			changePicAndDirect(1);
			heroX = heroX + 10;
		}
		/*实现上方向
		的动作切换*/
		if(action == UP){
			changePicAndDirect(2);  		 
			heroY = heroY - 10;
		}
		/*实现下方向
		的动作切换*/
		if(action==DOWN){
			changePicAndDirect(3);
			heroY = heroY + 10;
		}
	}
}
