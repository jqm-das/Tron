import javax.swing.*;
public class DriverTron 
   {
      public static void main (String args [])
         {
            JFrame frame = new JFrame ("Tron");
            frame.setSize(600, 600);
            frame.setLocation(200,100);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setContentPane(new PanelTron());
            frame.setVisible(true);
         }
   }