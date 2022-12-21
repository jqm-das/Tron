import javax.swing.*;
public class DriverTitlescreen
   {
      public static void main (String args [])
         {
            JFrame frame = new JFrame ("Tron");
            frame.setSize(700,450);
            frame.setLocation(200,100);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setContentPane(new Titlescreen());
            frame.setVisible(true);
         }
   }