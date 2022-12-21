 import java.awt.*;
   /*********************
   The Trail class extends the Mover class and represents the trail each player leaves behind.
   *********************/
    public class Trail extends Mover
   {
    //private fields, all ints, for a Trail
    //hint: the "location" of the bumper begins at its top left corner.      
     //constructors
      private boolean[][] xy; 
      private int FRAME; 
   /*********************
   Basic trail
   *********************/     
       public Trail()         //default constructor
      {
         super();
         FRAME=600; 
         xy = new boolean[600][600];
         for(int x=0; x<FRAME; x++)
            for(int y=0; y<FRAME; y++)
            {
               xy[x][y]=false;  
            }
      }
     /*********************
   Overloaded Constructor
   *********************/
       public Trail(int x, int y, int b,Color c, int dx,int dy, int frame)
      {
         super(x,y,b,c,dx,dy);
         FRAME=frame;
         xy = new boolean[FRAME][FRAME];
         for(int xx=0; xx<FRAME; xx++)
            for(int yy=0; yy<FRAME; yy++)
            {
               xy[xx][yy]=false;  
            }
      }
      public void setxy(int x, int y, boolean b)
      {
         xy[x][y]=b; 
      }
      public boolean getxy(int x, int y)
      {
         return xy[x][y]; 
      }
         /*********************
   This checks if any players have hit a trail.
   *********************/
       public boolean inTrail(Player p)
      {
               if(p.getDX()>0)//if the player is going right
               {
                  for(int k=p.getY()-p.getBase(); k<=p.getY();k++) //goes through pixels on the right of head of player
                  {
                     if(xy[k-1][p.getX()+p.getBase()-1-1]==true)//if any pixels are a trail, return true
                        return true; 
                  }
               }
               else if(p.getDX()<0)//if the player is going left
               {
                  for(int k=p.getY()-p.getBase(); k<=p.getY();k++) //goes through pixels on the left of head of player
                  {
                     if(xy[k][p.getX()-1])//if any pixels are a trail, return true
                        return true; 
                  }
               }
               else if(p.getDY()>0)//if the player is going up **may need to be changed to <0**
               {
                  for(int k=p.getX(); k<=p.getX()+p.getBase()-1;k++) //goes through pixels on top of head of player
                  {
                     if(xy[p.getY()-p.getBase()-1][k])//may need to be changed
                        return true; //if any pixels are a trail, return true
                  }
               }
               else if(p.getDY()<0)//if the player is going down **may need to be changed to >0**
               {
                  for(int k=p.getX(); k<=p.getX()+p.getBase()-1;k++) //goes through pixels on bottom of head of player
                  {
                     if(xy[p.getY()-1][k-1])//if any pixels are a trail, return true
                        return true; 
                  }
               }
               return false; 
      }  
      // returns distance between (x1, y1) and (x2, y2)
         /*********************
   This is a helper method to help find if a player is in a trail.
   *********************/
}

