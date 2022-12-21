import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.util.concurrent.TimeUnit; 

public class Howtoplay extends JPanel
{
   private JLabel o, object, controls1, controls2, img1, img2;
   private JButton back;  
   public Howtoplay(JFrame frame)
   {
      setLayout(new FlowLayout()); 
      setBackground(Color.BLACK); 
      
      o=new JLabel("Obejctive:", SwingConstants.RIGHT);
      o.setForeground(Color.WHITE); 
      add(o); 
      object=new JLabel("To last longer than the other player by not running into your trail or the other player's trail."); 
      object.setForeground(Color.WHITE); 
      add(object); 
            
      controls1=new JLabel("Player 1 Controls:"); 
      controls1.setHorizontalAlignment(SwingConstants.RIGHT); 
      controls1.setForeground(Color.RED); 
      add(controls1); 
      
      ImageIcon icon = new ImageIcon("wasd.png"); 
      img1 = new JLabel();
      img1.setIcon(icon);
      add(img1);
      
      controls2=new JLabel("Player 2 Controls:"); 
      controls2.setHorizontalAlignment(SwingConstants.RIGHT); 
      controls2.setForeground(Color.BLUE); 
      add(controls2);
      
      ImageIcon icon2= new ImageIcon("up.png"); 
      img2 = new JLabel();
      img2.setIcon(icon2);
      add(img2); 
   }
      
}