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
class MainCanvas extends Canvas
{   int x,y;
	Image currentTmg,img1,img2,img3,img4;
    public MainCanvas()
	{
		try
		{
			img1=Image.createImage("/sayo10.png");
			img2=Image.createImage("/sayo12.png");
			img3=Image.createImage("/sayo16.png");
            img4=Image.createImage("/sayo14.png");
			currentTmg=img1;
			x=120;
			y=120;
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	public void paint(Graphics g){
		g.setColor(0,0,0);
		g.fillRect(0,0,getWidth(),getHeight());
		g.drawImage(currentTmg,x,y,0);

	}
	public void keyPressed(int keyCode){

		int action=getGameAction(keyCode);

		if(action==LEFT){
			
			System.out.println("liu");
			currentTmg=img2;
			x=x-1;
			
			
		}
		if(action==RIGHT){
			
			System.out.println("liu");
			currentTmg=img3;
			x=x+1;
			
		}
		if(action==UP){
			
			System.out.println("liu");
			currentTmg=img4;
			y=y-1;
			
		}
		if(action==DOWN){
			
			System.out.println("liu");
			currentTmg=img1;
			y=y+1;
			
		}
		repaint();
	}
	
}