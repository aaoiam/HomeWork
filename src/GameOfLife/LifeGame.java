package GameOfLife;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class LifeGame extends JFrame implements MouseMotionListener{
	private final Main  main;
	//JButton button = new JButton ("button");
	static JMenu location=new JMenu();
	public LifeGame(int rows,int columns)
	{
		main=new Main(rows, columns);
		main.setBackground(Color.LIGHT_GRAY);
		new Thread(main).start();
		add(main);
	}
	public static void main(String[]args)
	{
		LifeGame frame=new LifeGame(40, 50);
		
		frame.addMouseMotionListener(frame);
		JMenuBar menu=new JMenuBar();
		frame.setJMenuBar(menu);
		
		
		JMenu options =new JMenu("选项");
		menu.add(options);

		JMenuItem open=options.add("选择文件");
		open.addActionListener(frame.new OpenActionListener());
		JMenuItem start=options.add("开始");
		start.addActionListener(frame.new StartActionListener());
		JMenuItem stop=options.add("停止");
		stop.addActionListener(frame.new StopActionListener());
		JMenuItem pause=options.add("暂停");
		pause.addActionListener(frame.new PauseActionListener());
	
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1007,859);
		frame.setTitle("生命游戏");
		frame.setVisible(true);
		frame.setResizable(false);
	}

   class OpenActionListener implements ActionListener{

		 public void actionPerformed(ActionEvent e) 
			{
				//world.begintime=System.currentTimeMillis();
				main.setBackground(Color.LIGHT_GRAY);
				main.diy=false;
				main.clean=false;
				main.setOpen();
			}
		
		
	}
	class StartActionListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e) 
		{
			//world.begintime=System.currentTimeMillis();
			main.setBackground(Color.LIGHT_GRAY);
			main.diy=false;
			main.clean=false;
			main.setShape();
		}
	}
	class StopActionListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e) 
		{
			//world.time=0;
			main.setBackground(Color.LIGHT_GRAY);
			main.diy=false;
			main.clean=false;
			main.setStop();
		}
	}
    class PauseActionListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e) 
		{
			main.setBackground(Color.LIGHT_GRAY);
			main.diy=false;
			main.clean=false;
			main.setPause();
		}
	}

	class CleanActionListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e) 
		{
			main.setPause();
			main.clean=true;
			main.diy=false;
			main.setBackground(Color.orange);
		}
	}
	class DIYActionListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e) 
		{
			main.setPause();
			main.diy=true;
			main.clean=false;
			main.setBackground(Color.cyan);
		}
	}
	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		if(main.diy){
		int x=e.getX();
		int y=e.getY();
		//button.setText("x:"+x+"y:"+y);
		Main.pauseshape[(y-50)/20][x/20]=1;
		main.setDiy();
		}
	}
	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		if(main.clean){
		int x=e.getX();
		int y=e.getY();
		//button.setText("x:"+x+"y:"+y);
		Main.pauseshape[(y-50)/20][x/20]=0;
		main.setDiy();
		}
	}
}

