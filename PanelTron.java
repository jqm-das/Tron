import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;

import javax.swing.JButton;
import javax.swing.JSlider;
import javax.swing.Timer;

public class PanelTron extends JPanel
{
   //private ScoreboardTron scoreboard;
   private Gameboard2Tron gameboard; 
   private Timer time; 
   private int delay=50; 
   private JButton start; 
   public PanelTron()
   {
      //addKeyListener(new Key());
      //scoreboard=new ScoreboardTron(); 
      gameboard=new Gameboard2Tron(); 
      setLayout(new BorderLayout()); 
      //add(scoreboard, ); 
      add(gameboard, BorderLayout.CENTER); 
      
      start=new JButton("start"); 
      start.addActionListener(new TimerListener());
      add(start, BorderLayout.SOUTH); 
      
      time=new Timer(15, new Listener()); 
   }
   private class TimerListener implements java.awt.event.ActionListener {    
    public void actionPerformed(ActionEvent e) {
      if (time.isRunning())
      {
        time.stop();
        start.setText("Start");
      }
      else
      {
        time.start();
        start.setText("Pause");
      }
    }
  }
  private class Listener implements ActionListener
  {
   public void actionPerformed(ActionEvent e)
   {
      gameboard.animate(); 
   }
  }
  /*private class Key extends KeyAdapter
      {
         public void keyPressed(KeyEvent e)
         {
            if (e.getKeyCode()==KeyEvent.VK_W)
            {
                //code for when W key is pressed
                gameboard.W(1); 
            } 
            if (e.getKeyCode()==KeyEvent.VK_A)
            {
               //code for when A key is pressed     
               gameboard.A(1);        
            }
            if (e.getKeyCode()==KeyEvent.VK_S)
            {
                //code for when S key is pressed
                gameboard.S(1); 
            } 
            if (e.getKeyCode()==KeyEvent.VK_D)
            {
               //code for when D key is pressed   
               gameboard.D(1);                
            }
            if (e.getKeyCode()==KeyEvent.VK_UP)
            {
               //code for when UP key is pressed   
               gameboard.W(2); 
            } 
            if (e.getKeyCode()==KeyEvent.VK_DOWN)
            {
               //code for when DOWN key is pressed      
               gameboard.S(2);          
            }
            if (e.getKeyCode()==KeyEvent.VK_LEFT)
            {
               //code for when LEFT key is pressed   
               gameboard.A(2); 
            } 
            if (e.getKeyCode()==KeyEvent.VK_RIGHT)
            {
               //code for when RIGHT key is pressed   
               gameboard.D(2); 
            }

         }
      }*/
}