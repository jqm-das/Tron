import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.util.concurrent.TimeUnit; 

public class Settings extends JPanel
{
   private int p; 
   private JLabel title, color, bac; 
   private JButton changeP; 
   private JPanel panel1, panel2, panel3, panel4, panel5, panel6; 
   private Color color1 = Color.RED, color2 = Color.BLUE, backg = Color.BLACK; 
   public Settings()
   {   
      p=1; 
      setLayout(new GridLayout(5, 1)); 
      setBackground(Color.BLACK); 
      panel1=new JPanel(); 
      panel1.setLayout(new GridLayout(1,2)); 
      
      title=new JLabel("Settings for Player 1:                 "); 
      title.setHorizontalAlignment(SwingConstants.CENTER); 
      title.setForeground(Color.WHITE); 
      title.setFont(new Font("Calibri", Font.BOLD, 20));
      panel1.add(title); 
      
      changeP=new JButton("Player 2 Settings"); 
      changeP.addActionListener(new Listener1()); 
      changeP.setForeground(Color.WHITE); 
      changeP.setBackground(Color.BLACK); 
      panel1.add(changeP); 
      
      panel1.setBackground(Color.BLACK); 
      add(panel1); 
      
      panel4=new JPanel(); 
      panel4.setLayout(new GridLayout(2, 1)); 
      
      color=new JLabel("Color of the player:"); 
      color.setBackground(Color.BLACK); 
      color.setForeground(Color.WHITE); 
      panel4.add(color); 
      
      panel2=new JPanel(); 
      panel2.setLayout(new GridLayout(1, 7)); 
      
      colorButton(panel2, Color.RED, "Red"); 
      colorButton(panel2, Color.ORANGE, "Orange");
      colorButton(panel2, Color.YELLOW, "Yellow"); 
      colorButton(panel2, Color.GREEN, "Green"); 
      colorButton(panel2, Color.BLUE, "Blue"); 
      colorButton(panel2, new Color(225, 34, 193), "Pink"); 
      colorButton(panel2, new Color(132, 38, 255), "Purple");
      panel4.add(panel2); 
      panel4.setBackground(Color.BLACK); 
      add(panel4); 
      
      panel5=new JPanel(); 
      panel5.setLayout(new GridLayout(2, 1)); 
      bac=new JLabel("Background of Game: "); 
      bac.setBackground(Color.BLACK); 
      bac.setForeground(Color.WHITE);
      panel5.add(bac); 
      
      panel3=new JPanel(); 
      panel3.setLayout(new GridLayout(1, 7)); 
      
      colorButton2(panel3, Color.RED, "Red"); 
      colorButton2(panel3, Color.ORANGE, "Orange");
      colorButton2(panel3, Color.YELLOW, "Yellow"); 
      colorButton2(panel3, Color.GREEN, "Green"); 
      colorButton2(panel3, Color.BLUE, "Blue"); 
      colorButton2(panel3, new Color(225, 34, 193), "Pink");
      colorButton2(panel3, new Color(132, 38, 255), "Purple");
      panel5.add(panel3); 
      panel5.setBackground(Color.BLACK); 
      add(panel5); 
      
      JButton backToDefault=new JButton("Reset to Default"); 
      backToDefault.addActionListener(new Listener8()); 
      backToDefault.setBackground(Color.BLACK); 
      backToDefault.setForeground(Color.WHITE); 
      add(backToDefault); 
   }
   public Color getColor(int p)
   {
      if(p==1)
         return color1;    
      return color2; 
   }
   public Color getBackg() 
   {
      return backg; 
   }
   private class Listener1 implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         if(p==1)
         {
            p=2; 
            title.setText("Settings for Player 2:                 "); 
            changeP.setText("Player 1 Settings"); 
         }
         else if(p==2)
         {
            p=1; 
            title.setText("Settings for Player 1:                 "); 
            changeP.setText("Player 2 Settings");
         }
      }
   }
   private void colorButton(JPanel panel, Color c, String name)
   {
      JButton b=new JButton(name); 
      b.setForeground(Color.BLACK); 
      b.setBackground(c); 
      b.addActionListener(new Listener2(c)); 
      panel.add(b); 
   }
   private void colorButton2(JPanel panel, Color c, String name)
   {
      JButton b=new JButton(name); 
      b.setForeground(Color.BLACK); 
      b.setBackground(c); 
      b.addActionListener(new Listener3(c)); 
      panel.add(b); 
   }
   private class Listener2 implements ActionListener
   {
      private Color col; 
      private Listener2(Color c)
      {
         col=c; 
      }
      public void actionPerformed(ActionEvent e)
      {
          if(p==1)
            color1=col; 
          if(p==2)
            color2=col; 
      }
      
   }
   private class Listener3 implements ActionListener
   {
      private Color col; 
      private Listener3(Color c)
      {
         col=c; 
      }
      public void actionPerformed(ActionEvent e)
      {
         backg=col; 
      }
   }
   private class Listener8 implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         backg=Color.BLACK; 
         color1=Color.RED; 
         color2=Color.BLUE; 
      }
   }

}