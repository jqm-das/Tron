
import java.awt.*;
   /***********************
   * A Player is very similar to Mover, excpet it also has information about its
   * direction. It can return its direction, and set its direction, and calulate its speed. 
   
   * @author Jeremy West 
   * @version 2.0
   ***********************/
  
public class Player extends Mover
{
   
   private int myDirection;
   
   /***********************
   * Instantiates the default Player. A default Player
   * is a Mover with myDirection defined as 1. 
   ***********************/
   public Player() 	//default constructor
   {
      super();
      myDirection = 1;
   }
   
   /***********************
   * Constructs a Player with initial horizontal and vertical positions 
   * specified by x and y, the width of the Player specified by b, the
   * Color specified by c, the speed of the Player specified by dx and 
   * dy, and the direction of the Player specified by d. 
   * @param x     initial horizontal position
   * @param y     inital vertical position
   * @param b     initial width
   * @param c     initial Color
   * @param dx    initial horizontal speed
   * @param dy    initial vertical speed
   * @param d     initial direction
   ***********************/
   public Player(int x, int y, int b,Color c,int dx,int dy, int d)
   {
      super(x,y,b,c,dx,dy);
      myDirection = d;
   }
   
	// accessor methods
   /***********************
   * Returns the Player's direction.
   * @return      direction
   ***********************/
   public int getDirection()
   {
      return myDirection;
   }
   
   // modifier methods
   /***********************
   * Sets the direction of the Player to the input number. 
   * @param a     assigns a to myDirection
   ***********************/
   public void setDirection(int a)
   {
      myDirection = a;
   }
   
	//  instance methods
   /******************
   * Calculates and returns the Player's speed. 
   * @return   speed 
   ******************/
   public int change()
   {
      if(getDX()!=0)
         return Math.abs(getDX()); 
      else if(getDY()!=0)
         return Math.abs(getDY()); 
      return 1; 
   }
}
