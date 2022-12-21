import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;      
import java.util.*;    
import java.util.concurrent.TimeUnit; 
import javax.sound.sampled.Clip;  
import javax.sound.sampled.AudioSystem;  

public class Titlescreen extends JPanel
{
   private JButton startGame; 
   private JButton howToPlay, settings;
   private JLabel back; 
   private JPanel panel;
   private boolean t = true, hasDone = true;
   private MainFrame frame, frame2, sets; 
   private Gameboard2Tron gameboard; 
   private int a = 255,b =0,c= 0,x =0,y= 0,z=255;
   private Scanner infile;
   private Color p1, p2, background; 
   private Settings set; 
   public Titlescreen()
   {
      setLayout(new BorderLayout());
      ImageIcon icon = new ImageIcon("tront.png"); 
      back = new JLabel();
      back.setIcon(icon);
      add(back, BorderLayout.CENTER); 
      
      p1=Color.RED; 
      p2=Color.BLUE; 
      background=Color.BLACK; 
      
      panel=new JPanel(); 
      panel.setLayout(new GridLayout(1, 3)); 
      
      startGame=new JButton("Start");
      startGame.addActionListener(new Listener1()); 
      panel.add(startGame); 
      
      howToPlay=new JButton("How to Play"); 
      howToPlay.addActionListener(new Listener2()); 
      panel.add(howToPlay); 
      
      settings=new JButton("Settings"); 
      settings.addActionListener(new Listener5());
      panel.add(settings); 
      
      add(panel, BorderLayout.SOUTH); 
      
   }
   private class Listener1 implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         gameboard=new Gameboard2Tron(p1, p2, background); 
         frame=new MainFrame("Tron", gameboard, 600, 600); 
         JButton back2=new JButton("Restart"); 
         back2.addActionListener(new Listener4()); 
         frame.add(back2);  
         JButton save=new JButton("Save Scores"); 
         save.addActionListener(new Listener6());
         frame.add(save);
         Scanner infile = null;
         try{
            infile = new Scanner(new File("data.txt"));
         }
         catch(FileNotFoundException b)
         {
            t = false;
         }
         if(t == true)
         {
            a = infile.nextInt();
            b = infile.nextInt();
            c = infile.nextInt();
            x = infile.nextInt();
            y = infile.nextInt();
            z = infile.nextInt();
         }
         if(hasDone == true)
         {
            gameboard.hasData(t,a,b,c,x,y,z);
            hasDone = false;
         }
      }
   }
   private class Listener2 implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         frame2=new MainFrame("How To Play", new Howtoplay(frame2), 525, 700, 50);
         JButton back=new JButton("Back to Titlescreen"); 
         back.addActionListener(new Listener3()); 
         frame2.add(back); 
         
      }
   }
   private class Listener3 implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         frame2.dispose(); 
      }
   }
   private class Listener4 implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         frame.dispose(); 
      }
   }
   private class Listener5 implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         set=new Settings(); 
         sets=new MainFrame("Settings", set, 700, 500);
         JButton back2=new JButton("Back to Titlescreen"); 
         back2.setBackground(Color.BLACK); 
         back2.setForeground(Color.WHITE); 
         back2.addActionListener(new Listener7()); 
         sets.add(back2); 
      }
   }
   private class Listener6 implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         PrintStream outfile = null;
         try{
            outfile = new PrintStream(new FileOutputStream("score.txt"));
         }
             catch(FileNotFoundException b)
            {
               JOptionPane.showMessageDialog(null,"The file could not be created.");
            }
         outfile.println("Player One: " + gameboard.getScorePlayerOne());
         outfile.println("Player Two: " + gameboard.getScorePlayerTwo());
      }
   }
   private class Listener7 implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         p1=set.getColor(1); 
         p2=set.getColor(2); 
         background=set.getBackg(); 
         sets.dispose(); 
      }
   }
}