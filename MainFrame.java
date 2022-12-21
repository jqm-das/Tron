import javax.swing.*;
public class MainFrame extends JFrame
{
   public MainFrame(String s, JPanel p, int x, int y) 
   {
     super(s); 
     setSize(x, y);
     setLocation(200,100);
     setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     setContentPane(p);
     setVisible(true);
   }
   public MainFrame(String s, JPanel p, int x, int y, int j) 
   {
     super(s); 
     setSize(x, y);
     setLocation(200,j);
     setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     setContentPane(p);
     setVisible(true);
   }

}