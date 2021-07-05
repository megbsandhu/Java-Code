import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.String;
class ThreadDemo extends KeyAdapter implements Runnable
{
	JFrame f;
	JPanel jp;
	JTextField tf;
	JLabel l1[];
	char l2[];
	String str[]=new String[9];
	Thread th;
	ThreadDemo()
	{
	
	f=new JFrame();
	jp=new JPanel();
	tf=new JTextField("Enter key here");
	l1=new JLabel[9];
	l2=new char[]{'a','b','c','a','e','h','k','q','o'};
	f.add(jp);
	for(int i=0;i<9;i++)
	{l1[i]=new JLabel();
		
		jp.add(l1[i]);
	}
	
	jp.setLayout(null);
	jp.add(tf);
	tf.setBounds(0,600,500,100);
	//l2.setBounds(300,400,100,20);
	f.setVisible(true);
	f.setSize(500,700);
	f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	th=new Thread(this);
	th.start();
	for(int i=0;i<9;i++)
	{
	tf.addKeyListener(new KeyAdapter()
	{	
		public void keyPressed(KeyEvent ke)
		{
			
			for(int i=0;i<9;i++)
			{
				str[i]=l1[i].getText();
				if(ke.getKeyChar()==str[i].charAt(0))
				{
				l2[i]=' ';
				}
			}			
		}
	}
	);
	}
		
	}
		int y=30,y1=20;
		public void run()
		{
		while(th!=null)
		{	
			try{
				
				display();
				th.sleep(1000);	
				
			}
			catch(Exception e)
			{
				System.out.println("Error");
			}
		}
		
		
		}
		
		void display()
		{
			int x=30;
			for(int i=0;i<9;i++)
			{
			l1[i].setText(Character.toString(l2[i]));
			l1[i].setFont(new Font("Arial",Font.BOLD,30));
			
			if(i%2==0)
			{
			l1[i].setBounds(x,y,20,30);
			}
			else
			{
			l1[i].setBounds(x,y1,20,30);
			}
			x+=50;
			}
			if(y<=600)
			{	
			y+=50;
			}
			if(y1<=700)
			{
			y1+=40;
			}
		}			
		public static void main(String args[])
		{
			ThreadDemo obj=new ThreadDemo();
			obj.run();
		}
}