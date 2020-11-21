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
			int leftFlag=1, rightFlag=1,	//�����
				  upFlag=1, downFlag=1;
				Image currentImg,
				leftImg,leftImg2,leftImg3,
		rightImg,rightImg2,rightImg3,
		upImg,upImg2,upImg3,
		downImg,downImg2,downImg3;
	public MainCanvas()
	{
		try
		{
			leftImg=Image.createImage("/sayo12.png");	//����
            leftImg2=Image.createImage("/sayo22.png");	//�������    
			leftImg3=Image.createImage("/sayo02.png");	//�����Ұ�
			rightImg=Image.createImage("/sayo16.png");	//�ҷ���
            rightImg2=Image.createImage("/sayo26.png");	//�ҷ������
			rightImg3=Image.createImage("/sayo06.png");	//�ҷ����Ұ�
			upImg=Image.createImage("/sayo14.png");		//�Ϸ���
			upImg2=Image.createImage("/sayo24.png");	//�Ϸ������
			upImg3=Image.createImage("/sayo04.png");	//�Ϸ����Ұ�
			downImg=Image.createImage("/sayo10.png");	//�·���
			downImg2=Image.createImage("/sayo20.png");	//�·������
			downImg3=Image.createImage("/sayo00.png");	//�·����Ұ�
			currentImg=downImg;		//�·���Ϊ��ǰͼ
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	public void paint(Graphics g){
		g.setColor(0,255,0);	//��ɫ��Ļ����0,0,0��->��ɫ����255,255,255��->��ɫ
		g.fillRect(0,0,getWidth(),getHeight());
		g.drawImage(currentImg,x,y,0);

	}
	public void keyPressed(int keyCode){

		int action=getGameAction(keyCode);
/*ʵ������
�Ķ����л�*/
		if(action==LEFT){
			
			System.out.println("liu");	//��ӡ

			currentImg=leftImg;
			if(leftFlag==1){
				currentImg=leftImg2;
				leftFlag++;		//�����ƶ�������Ϊ���2
			}
			 
			else if(leftFlag==2){
               currentImg=leftImg3; 
			   leftFlag=1;		//��ԭ�ر��1
			} 
			   x=x-1;		   
		}
/*ʵ���ҷ���
�Ķ����л�*/
		if(action==RIGHT){
			
			System.out.println("liu");
			currentImg=rightImg;
			 if(rightFlag==1){
               currentImg=rightImg2;
			   rightFlag++;
			  }
			  
			   else if(rightFlag==2){
               currentImg=rightImg3;
			   rightFlag=1;
			   }   
			x=x+1;
		}
/*ʵ���Ϸ���
�Ķ����л�*/
		if(action==UP){
			
			System.out.println("liu");
			currentImg=upImg;
			 if(upFlag==1){
               currentImg=upImg2; 
			   upFlag++;
			  }
			  
			   else if(upFlag==2){
               currentImg=upImg3;
			   upFlag=1;
			   }
			  		 
			y=y-1;
		}
/*ʵ���·���
�Ķ����л�*/
		if(action==DOWN){
			
			System.out.println("liu");
			currentImg=downImg;
			 if(downFlag==1){
               currentImg=downImg2;
			   downFlag++;
			  }
			 
			   else if(downFlag==2){
               currentImg=downImg3;
			   downFlag=1;	  		   
			   } 
			   
			y=y+1;
			
		}
		repaint();		//ˢ����Ļ
	}
}