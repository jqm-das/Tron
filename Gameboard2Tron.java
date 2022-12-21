import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.util.concurrent.TimeUnit;  
import java.io.*;      //the File class
public class Gameboard2Tron extends JPanel
{
   private static final int FRAME = 600;
   private static Color BACKGROUND; 
   private static Color SNAKE1_COLOR;
   private static Color SNAKE2_COLOR;
   private int alive = 3;
   private boolean b = true, c = true, d = true;
   
   private BufferedImage myImage;
   private Graphics myBuffer;
   private Trail trail; 
   private Player player1;
   //private Trail trail2;
   private Player player2,player3;
   private int score1; 
   private int score2, color=1;
   private boolean col=false;
   private Timer timer;  
   
   public Gameboard2Tron(Color p1, Color p2, Color background)
   {
      addKeyListener(new Key());
      
      BACKGROUND=background; 
      SNAKE1_COLOR=p1; 
      SNAKE2_COLOR=p2; 
      
      myImage =  new BufferedImage(FRAME, FRAME, BufferedImage.TYPE_INT_RGB);
      myBuffer = myImage.getGraphics();
      myBuffer.setColor(BACKGROUND);
      myBuffer.fillRect(0,0,FRAME,FRAME);
      myBuffer.setColor(Color.WHITE); 
      myBuffer.setFont(new Font("Times New Roman", Font.BOLD, 13));
      myBuffer.drawString("Click the spacebar to start and stop", 200, 560); 
         // create ball and jump
      player1 = new Player(100, 300, 4, SNAKE1_COLOR,0, 1, 3);
      player2 = new Player(500, 300, 4, SNAKE2_COLOR,0, 1, 3);
      player3 = new Player(300, 300, 4, Color.WHITE,0,1,3);
      trail=new Trail(); 
      setFocusable(true); 
      score1 = 0;
      score2 = 0; 
      timer= new Timer(8, new Listener());
   }
   private class Listener implements ActionListener
      {
         public void actionPerformed(ActionEvent e)
         {         
            if(col)
            {
               color++; 
               switch(color){
                  case 1:
                     player1.setColor(Color.RED); 
                     break; 
                  case 2: 
                     player1.setColor(Color.ORANGE);
                     break; 
                  case 3: 
                     player1.setColor(Color.YELLOW); 
                     break; 
                  case 4: 
                     player1.setColor(Color.GREEN);
                     break; 
                  case 5: 
                     player1.setColor(Color.BLUE);
                     break;
                  case 6: 
                     player1.setColor(new Color(200, 0, 200));
                     color=1; 
                     break; 
               }
            }
            player1.moveForward(600, 600); 
            player2.moveForward(600, 600); 
            player3.moveForward(600, 600);
            if(trail.inTrail(player1) && b == true)
            {
               alive = alive - 1;
               player1.setDX(0);
               player1.setDY(0);
               if(alive == 2)
                  b = false;
               if((alive == 1)&&(b == true))
               {
               b = true;
               c = true;
               d = true;
               alive = 3;
               myBuffer.setColor(BACKGROUND); 
               myBuffer.fillRect(0, 0, FRAME, FRAME); 
               score2++; 
               player1.setDX(0); 
               player1.setDY(player1.change());
               player1.setX(100); 
               player1.setY(300); 
               player2.setDX(0); 
               player2.setDY(player2.change());
               player2.setX(500); 
               player2.setY(300); 
               player3.setDY(player2.change());
               player3.setDX(0);
               player3.setX(300);
               player3.setY(300);               
               for(int xx=0; xx<FRAME; xx++)
                  for(int yy=0; yy<FRAME; yy++)
                  {
                     trail.setxy(xx,yy, false);
                  }
               System.out.println(1); 
               timer.stop(); 
               }
            }
            if(trail.inTrail(player2) && c == true)
            {
               alive = alive - 1;
               player2.setDX(0);
               player2.setDY(0);
               if(alive == 2)
                  c = false;
               if((alive == 1)&&(c == true))
               {
               b = true;
               c = true;
               d = true;
               alive = 3;
               myBuffer.setColor(BACKGROUND); 
               myBuffer.fillRect(0, 0, FRAME, FRAME); 
               score1++;
               player1.setDY(player1.change()); 
               player1.setDX(0); 
               player1.setX(100); 
               player1.setY(300); 
               player2.setDY(player2.change());
               player2.setDX(0); 
               player2.setX(500); 
               player2.setY(300); 
               player3.setDY(player2.change());
               player3.setDX(0);
               player3.setX(300);
               player3.setY(300);
               for(int xx=0; xx<FRAME; xx++)
                  for(int yy=0; yy<FRAME; yy++)
                  {
                     trail.setxy(xx,yy, false);
                  }
               System.out.println(2); 
               timer.stop();
               }               
               
            }
            if(trail.inTrail(player3) && d == true)
            {
               alive = alive - 1;
               player3.setDX(0);
               player3.setDY(0);
               if(alive == 2)
                  d = false;
               if((alive == 1)&&(d == true))
               {
               b = true;
               c = true;
               d = true;
               alive = 3;
               myBuffer.setColor(BACKGROUND); 
               myBuffer.fillRect(0, 0, FRAME, FRAME); 
               score1++;
               player1.setDY(player1.change()); 
               player1.setDX(0); 
               player1.setX(100); 
               player1.setY(300); 
               player2.setDY(player2.change());
               player2.setDX(0); 
               player2.setX(500); 
               player2.setY(300); 
               player3.setDY(player2.change());
               player3.setDX(0);
               player3.setX(300);
               player3.setY(300);
               for(int xx=0; xx<FRAME; xx++)
                  for(int yy=0; yy<FRAME; yy++)
                  {
                     trail.setxy(xx,yy, false);
                  }
               System.out.println(2); 
               timer.stop();  
               }             
               
            }
            for(int m=player1.getX(); m<=player1.getX()+player1.getBase()-1; m++)
               for(int n=player1.getY(); n>=player1.getY()-player1.getBase()+1; n--)
                  trail.setxy(n-1, m-1, true); 
            for(int mo=player2.getX(); mo<=player2.getX()+player2.getBase()-1; mo++)
               for(int no=player2.getY(); no>=player2.getY()-player2.getBase()+1; no--)
                  trail.setxy(no-1, mo-1, true);
            for(int mo=player3.getX(); mo<=player3.getX()+player3.getBase()-1; mo++)
               for(int no=player3.getY(); no>=player3.getY()-player3.getBase()+1; no--)
                  trail.setxy(no-1, mo-1, true);
            player1.draw(myBuffer);
            player2.draw(myBuffer);
            player3.draw(myBuffer);
            myBuffer.setColor(SNAKE1_COLOR);
            myBuffer.setFont(new Font("Calibri", Font.BOLD, 13));
            myBuffer.drawString("P1 Score: " + score1, 100, 25);
            myBuffer.setFont(new Font("Calibri", Font.BOLD, 13));
            myBuffer.setColor(SNAKE2_COLOR);
            myBuffer.drawString("P2 Score: " + score2, 440, 25);
            myBuffer.setFont(new Font("Times New Roman", Font.BOLD, 13));
            myBuffer.setColor(Color.WHITE); 
            myBuffer.drawString("Click the spacebar to start and stop", 200, 560);
            repaint();
         }
      }
      public void hasData(boolean t, int a, int b, int c, int x, int y, int z)
      {
         if(t == true)
         {
            player1.setColor(new Color(a,b,c));
            player2.setColor(new Color(x,y,z));
         }
      }
      public void paintComponent(Graphics g)
      {
         g.drawImage(myImage, 0, 0, getWidth(), getHeight(), null);
      }
      public void setColor(Color c, int p)
      {
         if(p==1)
            player1.setColor(c); 
         else
            player2.setColor(c); 
      }
      public void setWidth(int k, int p)
      {
         if(p==1)
            player1.setBase(k); 
         else
            player2.setBase(k); 
      }
      public int getScorePlayerOne()
      {
         return score1;
      }
      public int getScorePlayerTwo()
      {
         return score2;
      }
      private class Key extends KeyAdapter
      {
         public void keyPressed(KeyEvent e)
         {
            if (e.getKeyCode()==KeyEvent.VK_W)
            {
                //code for when W key is pressed
                player1.goUp(); 
            } 
            if (e.getKeyCode()==KeyEvent.VK_A)
            {
               //code for when A key is pressed     
               player1.goLeft();        
            }
            if (e.getKeyCode()==KeyEvent.VK_S)
            {
                //code for when S key is pressed
                player1.goDown(); 
            } 
            if (e.getKeyCode()==KeyEvent.VK_D)
            {
               //code for when D key is pressed   
               player1.goRight();                
            }
            if (e.getKeyCode()==KeyEvent.VK_UP)
            {
               //code for when UP key is pressed   
               player2.goUp(); 
            } 
            if (e.getKeyCode()==KeyEvent.VK_DOWN)
            {
               //code for when DOWN key is pressed      
               player2.goDown();          
            }
            if (e.getKeyCode()==KeyEvent.VK_LEFT)
            {
               //code for when LEFT key is pressed   
               player2.goLeft(); 
            } 
            if (e.getKeyCode()==KeyEvent.VK_RIGHT)
            {
               //code for when RIGHT key is pressed   
               player2.goRight(); 
            }
            if (e.getKeyCode()==KeyEvent.VK_U)
            {
               //code for when UP key is pressed   
               player3.goUp(); 
            } 
            if (e.getKeyCode()==KeyEvent.VK_J)
            {
               //code for when DOWN key is pressed      
               player3.goDown();          
            }
            if (e.getKeyCode()==KeyEvent.VK_H)
            {
               //code for when LEFT key is pressed   
               player3.goLeft(); 
            } 
            if (e.getKeyCode()==KeyEvent.VK_K)
            {
               //code for when RIGHT key is pressed   
               player3.goRight(); 
            }
            if (e.getKeyCode()==KeyEvent.VK_SPACE)
            {
               if(timer.isRunning())
                  timer.stop();
               else
                   timer.start(); 
            }

         }
      }
      public int getScore1()
      {
         return score1; 
      }
      public int getScore2()
      {
         return score2; 
      }
      public void setScore1(int s)
      {
         score1=s; 
      }
      public void setScore2(int s)
      {
         score2=s; 
      }
  }

