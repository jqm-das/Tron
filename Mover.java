import java.awt.*;
  
public abstract class Mover
{
   private int myX;   // x and y coordinates of  left bottom of head
   private int myY;
   private int myDX;
   private int myDY;   
   private int myBase; //width of head
   private Color myColor; //color of body
 	// constructors
   public Mover() 	//default constructor
   {
      myX = 200;
      myY = 200;
      myBase = 20;
      myColor = Color.RED;
      myDY = 15;
      myDX = 0;
   }
   public Mover(int x, int y, int b, Color c,int dx,int dy)
   {
      myX = x;
      myY = y;
      myBase = b;
      myColor = c;
      myDX = dx;
      myDY = dy;
   }
	// accessor methods
   public int getX()
   {
      return myX;
   }
   public int getY()  	
   {
      return myY;
   }
   public int getBase()
   {
      return myBase;
   }
   public Color getColor()
   {
      return myColor;
   }
   public int getDX()
   {
      return myDX;
   } 
   public int getDY()
   {
      return myDY;
   }   
   // modifier methods
   public void setX(int x)
   {
      myX = x;
   }
   public void setY(int y)
   {
      myY = y;
   }
   public void setColor(Color c)
   {
      myColor = c;
   }
   public void setBase(int b)
   {
      myBase = b;
   }
   public void setDX(int s)
   {
      myDX = s;
   }
   public void setDY(int s)
   {
      myDY = s;
   }
	//  instance methods
   public void draw(Graphics myBuffer)
   {
      myBuffer.setColor(myColor);
      myBuffer.fillRect(myX, myY, myBase, myBase);
   }
   public void moveForward(int rightEdge, int bottomEdge)
   {
      setX(getX() + myDX);
      setY(getY() - myDY);//if you add dy you go down
      if(getX() > rightEdge - getBase())  //hit right edge
      {
        setX(1);
      }
      else if(getX() <= 0)  //hit left edge
      {
         setX(rightEdge-getBase());
      }
      if(getY() > bottomEdge)//hit bottom
      {
         setY(getBase());
      }
      else if (getY() < getBase()+1)//hit top
      {
         setY(bottomEdge);
      }
      }
      public void goUp()
      {
         if(myDX!=0)
         {
            int k; 
            if(myDX!=0)
               k=Math.abs(myDX); 
            else
               k=Math.abs(myDY); 
            myDX=0; 
            myDY=k; 
         }
      }
      public void goDown()
      {
         if(myDX!=0)
         {
            int k; 
            if(myDX!=0)
               k=Math.abs(myDX); 
            else
               k=Math.abs(myDY); 
            myDX=0; 
            myDY=-k;
         }
      }
      public void goRight()
      {
         if(myDY!=0)
         {
            int k; 
            if(myDX!=0)
               k=Math.abs(myDX); 
            else
               k=Math.abs(myDY); 
            myDX=k; 
            myDY=0;
         }
      }
      public void goLeft()
      {
         if(myDY!=0)
         {
            int k; 
            if(myDX!=0)
               k=Math.abs(myDX); 
            else
               k=Math.abs(myDY); 
            myDX=-k; 
            myDY=0;
         }
      }

   }