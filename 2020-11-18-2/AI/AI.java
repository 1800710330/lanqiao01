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
			Image heroLeftImg[]=new Image[3];
			Image heroRightImg[]=new Image[3];
			Image heroUpImg[]=new Image[3];
			Image heroDownImg[]=new Image[3];
			Image currentImg;
		/*Image leftImg,leftImg2,leftImg3,
		rightImg,rightImg2,rightImg3,
		upImg,upImg2,upImg3,
		downImg,downImg2,downImg3;*/
	public MainCanvas()
	{
		try
		{
			for(int i=0;i<3;i++){
			heroLeftImg[i]=Image.createImage("/sayo"+i+"2.png");		//左
			}

			for(int i=0;i<3;i++){
			heroRightImg[i]=Image.createImage("/sayo"+i+"6.png");		//右
			}
            
			for(int i=0;i<3;i++){
			heroUpImg[i]=Image.createImage("/sayo"+i+"4.png");		//上
			}

			for(int i=0;i<3;i++){
			heroDownImg[i]=Image.createImage("/sayo"+i+"0.png");		//下
			}

			/*leftImg=Image.createImage("/sayo12.png");	//左方向
            leftImg2=Image.createImage("/sayo22.png");	//左方向左摆    
			leftImg3=Image.createImage("/sayo02.png");	//左方向右摆

			rightImg=Image.createImage("/sayo16.png");	//右方向
            rightImg2=Image.createImage("/sayo26.png");	//右方向左摆
			rightImg3=Image.createImage("/sayo06.png");	//右方向右摆

			upImg=Image.createImage("/sayo14.png");		//上方向
			upImg2=Image.createImage("/sayo24.png");	//上方向左摆
			upImg3=Image.createImage("/sayo04.png");	//上方向右摆

			downImg=Image.createImage("/sayo10.png");	//下方向
			downImg2=Image.createImage("/sayo20.png");	//下方向左摆
			downImg3=Image.createImage("/sayo00.png");*/	//下方向右摆
			currentImg=heroDownImg[1];		//下方向为当前图
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	public void paint(Graphics g){
		g.setColor(0,255,0);	//绿色屏幕；（0,0,0）->黑色；（255,255,255）->白色
		g.fillRect(0,0,getWidth(),getHeight());
		g.drawImage(currentImg,x,y,0);

	}
	public void keyPressed(int keyCode){

		int action=getGameAction(keyCode);
/*实现左方向
的动作切换*/
		if(action==LEFT){
			
			System.out.println("liu");	//打印

			currentImg=heroLeftImg[1];
			if(leftFlag==1){
				currentImg=heroLeftImg[2];
				leftFlag++;		//继续移动，更新为标记2
			}
			 
			else if(leftFlag==2){
               currentImg=heroLeftImg[0]; 
			   leftFlag=1;		//还原回标记1
			} 
			   x=x-1;		   
		}
/*实现右方向
的动作切换*/
		if(action==RIGHT){
			
			System.out.println("liu");
			currentImg=heroRightImg[1];
			 if(rightFlag==1){
               currentImg=heroRightImg[2];
			   rightFlag++;
			  }
			  
			   else if(rightFlag==2){
               currentImg=heroRightImg[0];
			   rightFlag=1;
			   }   
			x=x+1;
		}
/*实现上方向
的动作切换*/
		if(action==UP){
			
			System.out.println("liu");
			currentImg=heroUpImg[1];
			 if(upFlag==1){
               currentImg=heroUpImg[2]; 
			   upFlag++;
			  }
			  
			   else if(upFlag==2){
               currentImg=heroUpImg[0];
			   upFlag=1;
			   }
			  		 
			y=y-1;
		}
/*实现下方向
的动作切换*/
		if(action==DOWN){
			
			System.out.println("liu");
			currentImg=heroDownImg[1];
			 if(downFlag==1){
               currentImg=heroDownImg[2];
			   downFlag++;
			  }
			 
			   else if(downFlag==2){
               currentImg=heroDownImg[0];
			   downFlag=1;	  		   
			   } 
			   
			y=y+1;
			
		}
		repaint();		//刷新屏幕
	}
}