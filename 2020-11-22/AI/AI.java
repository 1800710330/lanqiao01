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
			int leftFlag=1, rightFlag=1,upFlag=1, downFlag=1;	//�����
			Image currentImg;
			Image heroImg[][]=new Image[4][3];		//������ά���飺��ʽ���������� ������[][]=new ��������[�г���][�г���]
	public MainCanvas()       
	{
		try
		{
			for(int i=0;i<heroImg.length;i++){              //iȡֵ�ĺ��壺0����ʾleft��1��right��2��up��3��down
				for(int j=0;j<heroImg[i].length;j++){			//jȡֵ�ĺ��壺0��������1����ڡ�2���Ұ�
					heroImg[i][j]=Image.createImage("/sayo"+i+j+".png");
				}
			}
			currentImg=heroImg[3][0];		//�·���Ϊ��ǰͼ
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	public void paint(Graphics g){
		g.setColor(0,255,0);	//��ɫ��Ļ����0,0,0��->��ɫ����255,255,255��->��ɫ   (0,255,255)->ˮ��ɫ
		g.fillRect(0,0,getWidth(),getHeight());
		g.drawImage(currentImg,x,y,0);

	}
	public void keyPressed(int keyCode){

		int action=getGameAction(keyCode);
/*ʵ������
�Ķ����л�*/
		if(action==LEFT){
			
			System.out.println("liu");	//��ӡ

			currentImg=heroImg[0][0];
			if(leftFlag==1){
				currentImg=heroImg[0][1];
				leftFlag++;		//�����ƶ�������Ϊ���2
			}
			 
			else if(leftFlag==2){
               currentImg=heroImg[0][2]; 
			   leftFlag=1;		//��ԭ�ر��1
			} 
			   x=x-1;		   
		}
/*ʵ���ҷ���
�Ķ����л�*/
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
/*ʵ���Ϸ���
�Ķ����л�*/
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
/*ʵ���·���
�Ķ����л�*/
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
		repaint();		//ˢ����Ļ
	}
}