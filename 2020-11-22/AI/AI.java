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
class MainCanvas extends Canvas{
			int x=120,
				y=120;
			int leftFlag=1, rightFlag=1,upFlag=1, downFlag=1;	//标记量
			Image currentImg;
			Image heroImg[][]=new Image[4][3];		//创建二维数组：形式：数据类型 数组名[][]=new 数据类型[行长度][列长度]
	public MainCanvas()       
	{
		try
		{
			for(int i=0;i<heroImg.length;i++){              //i取值的含义：0：表示left、1：right、2：up、3：down
				for(int j=0;j<heroImg[i].length;j++){			//j取值的含义：0：正立、1：左摆、2：右摆
					heroImg[i][j]=Image.createImage("/sayo"+i+j+".png");
				}
			}
			currentImg=heroImg[3][0];		//下方向为当前图
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	public void paint(Graphics g){
		g.setColor(0,255,0);	//绿色屏幕；（0,0,0）->黑色；（255,255,255）->白色   (0,255,255)->水绿色
		g.fillRect(0,0,getWidth(),getHeight());
		g.drawImage(currentImg,x,y,0);

	}
	public void keyPressed(int keyCode){

		int action=getGameAction(keyCode);
/*实现左方向
的动作切换*/
		if(action==LEFT){
			
			System.out.println("liu");	//打印

			currentImg=heroImg[0][0];
			if(leftFlag==1){
				currentImg=heroImg[0][1];
				leftFlag++;		//继续移动，更新为标记2
			}
			 
			else if(leftFlag==2){
               currentImg=heroImg[0][2]; 
			   leftFlag=1;		//还原回标记1
			} 
			   x=x-1;		   
		}
/*实现右方向
的动作切换*/
		if(action==RIGHT){
			
			System.out.println("liu");
			currentImg=heroImg[1][0];
			 if(rightFlag==1){
               currentImg=heroImg[1][1];
			   rightFlag++;
			  }
			  
			   else if(rightFlag==2){
               currentImg=heroImg[1][2];
			   rightFlag=1;
			   }   
			x=x+1;
		}
/*实现上方向
的动作切换*/
		if(action==UP){
			
			System.out.println("liu");
			currentImg=heroImg[2][0];
			 if(upFlag==1){
               currentImg=heroImg[2][1]; 
			   upFlag++;
			  }
			  
			   else if(upFlag==2){
               currentImg=heroImg[2][2];
			   upFlag=1;
			   }
			  		 
			y=y-1;
		}
/*实现下方向
的动作切换*/
	if(action==DOWN){
		System.out.println("liu");
		currentImg=heroImg[3][0];
			if(downFlag==1){
				currentImg=heroImg[3][1];
				downFlag++;
			  }
			 else if(downFlag==2){
				currentImg=heroImg[3][2];
			   downFlag=1;	  		   
			   } 
			   
			y=y+1;			
		}
		repaint();		//刷新屏幕
	}
}