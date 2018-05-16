package tank4thememories;








import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;








public class Missile {
   
    private int xPos;
    private int yPos;
    private int xPos2;
    private int yPos2;
    playerTank tank;
    private boolean show=false;
    private boolean moveRight;
    int xspeed=20;
    int yspeed=20;
    int xx;
    int xxx;
    private int time;
    double angle=.001;
    int power=1;
    boolean caa;
    int cat=0;
    private boolean hit;
    boolean preview;
    Missile(playerTank _tank,boolean _moveRight, double _angle, int _power){
        tank = _tank;
        if(_moveRight)
        {
        xPos = tank.getXPos()+45;
        yPos = tank.getYPos()+20;
        xx=xPos;
        }
        else
        {
        xPos = tank.getXPos()-45;
        yPos = tank.getYPos()+20;
        xx=xPos;
        }
        show=false;
        moveRight = _moveRight;
        time=1;
        angle=_angle;
        power=_power;
        hit = true;
    }
    public boolean getPreview()
    {
        return preview;
    }
    public void setPrview(boolean _preview)
    {
        preview= _preview;
    }
    public int getX()
    {
        return xPos;
    }
    public int getY()
    {
        return yPos;
    }
    public void setX(int _xPos)
    {
        xPos= _xPos;
    }
    public void setY(int _yPos)
    {
        yPos= _yPos;
    }
    public boolean getShow()
    {
        return show;
    }
    public void setShow(boolean _show)
    {
        show=_show;
    }
    public double getAngle()
    {
        return angle;
    }
    public void addAngle(int _power)
    {
        angle+=_power;
    }
    public int getPower()
    {
        return power;
    }
    public void addPower(int _power)
    {
        power+=_power;
    }
   public void draw(Tank4TheMemories obj,Graphics2D g,Image image, boolean _preview)
    {   
         preview=_preview;
         if(preview)
         {
             show=true;
             g.fillOval(Window.getX(xPos), Window.getYNormal(yPos), 50, 50);
         }
         else
         {
            if(moveRight)
            drawMissile(obj, g, image,Window.getX(xPos),Window.getYNormal(yPos),0,.15,.15); 
            else
            drawMissile(obj, g, image,Window.getX(xPos),Window.getYNormal(yPos),0,-.15,.15); 
//            g.setColor(Color.yellow);
//    g.fillRect(Window.getX(xPos-35),Window.getYNormal(yPos+20),70,40); 
         }
    }
    public boolean move(int time)
    {
        if(time>=5)
        {
            return true;
        }
        if(moveRight)
           xPos+=xspeed;
        else
            xPos-=xspeed;
           if(moveRight)
           {
            if(angle==.001)
            {
            xxx=xPos-xx-power; 
            if(!caa)
            {
                     for(int i=300; i<1100;i++)
                     {
                      if(tank.getYPos()+20==(int)(-(angle*((xxx)*(xxx))))+i)
                      {
                          cat=i;
                          caa=true;
                          break;
                      }
                     }
            }
                 yPos=(int)(-(angle*((xxx)*(xxx))))+cat ;
            }
            else if(angle==.002)
            {
            xxx=xPos-xx-power; //350
            if(!caa)
            {
                     for(int i=300; i<1100;i++)
                     {
                      if(tank.getYPos()+20==(int)(-(angle*((xxx)*(xxx))))+i)
                      {
                          cat=i;
                          caa=true;
                          break;
                      }
                     }
            }
                 yPos=(int)(-(angle*((xxx)*(xxx))))+cat ;
            }
            else if(angle==.003)
            {
                 xxx=xPos-xx-power; 
                 if(!caa)
                 {
                     for(int i=300; i<1100;i++)
                     {
                      if(tank.getYPos()+20==(int)(-(angle*((xxx)*(xxx))))+i)
                      {
                          cat=i;
                          caa=true;
                          break;
                      }
                     }
                 }
                 yPos=(int)(-(angle*((xxx)*(xxx))))+cat;
            }
            else if(angle==.004)
            {
                 xxx=xPos-xx-power;  
                 if(!caa)
                 {
                     for(int i=300; i<1400;i++)
                     {
                      if(tank.getYPos()+20==(int)(-(angle*((xxx)*(xxx))))+i)
                      {
                          cat=i;
                          caa=true;
                          break;
                      }
                     }
                 }
                 yPos=(int)(-(angle*((xxx)*(xxx))))+cat;
            }
            //else if(power==.003)
//           {
//           xxx=xPos-xx-300;
//           yPos=(int)(-(power*((xxx)*(xxx))))+tank.getYPos()+250 ;
//           }








        }
           else //////////////////////////////////////////////////////////////////////////////// player 2
           {
               if(angle==.001)
            { 
            xxx=xPos-xx+power; 
            if(!caa)
            {
                     for(int i=300; i<1100;i++)
                     {
                      if(tank.getYPos()+20==(int)(-(angle*((xxx)*(xxx))))+i)
                      {
                          cat=i;
                          caa=true;
                          break;
                      }
                     }
            }
                 yPos=(int)(-(angle*((xxx)*(xxx))))+cat;
            }
            else if(angle==.002)
                {
                xxx=xPos-xx+power; 
                if(!caa)
                {
                         for(int i=300; i<1100;i++)
                         {
                          if(tank.getYPos()+20==(int)(-(angle*((xxx)*(xxx))))+i)
                          {
                              cat=i;
                              caa=true;
                              break;
                          }
                         }
                }
                     yPos=(int)(-(angle*((xxx)*(xxx))))+cat;
                }
            else if(angle==.003)
            {
                 xxx=xPos-xx+power; 
                 if(!caa)
                 {
                     for(int i=300; i<1100;i++)
                     {
                      if(tank.getYPos()+20==(int)(-(angle*((xxx)*(xxx))))+i)
                      {
                          cat=i;
                          caa=true;
                          break;
                      }
                     }
                 }
                 yPos=(int)(-(angle*((xxx)*(xxx))))+cat;
            }
            else if(angle==.004)
            {
                 xxx=xPos-xx+power;  
                 if(!caa)
                 {
                     for(int i=300; i<1400;i++)
                     {
                      if(tank.getYPos()+20==(int)(-(angle*((xxx)*(xxx))))+i)
                      {
                          cat=i;
                          caa=true;
                          break;
                      }
                     }
                 }
                 yPos=(int)(-(angle*((xxx)*(xxx))))+cat;
            }
           }
                 return false;
        }
    public boolean getHit()
    {
        return hit;
    }
    public int collide(playerTank frog, Power health,int turns)
    {
// top left of frog
        if(turns>11)
        {
        if (xPos-30 < health.getLeft() && 
        xPos+30 > health.getLeft() && 
        yPos-20 < health.getTop() && 
        yPos+20 > health.getTop() )
        {
            return (4);
        }
        if (xPos-30 < health.getRight() && 
        xPos+30 > health.getRight() && 
        yPos-20 < health.getTop() && 
        yPos+20 > health.getTop() )
             {
            return (4);
        }
        if (xPos-30 < health.getRight() && 
        xPos+30 > health.getRight() && 
        yPos-20 < health.getBottom() && 
        yPos+20 > health.getBottom() )
        {
            return (4);
        }
        if (xPos-30 < health.getLeft() && 
        xPos+30 > health.getLeft() && 
        yPos-20 < health.getBottom() && 
        yPos+20 > health.getBottom() )
             {
            return (4);
        }
        }
        if (xPos-30 < frog.getLeft() && 
        xPos+30 > frog.getLeft() && 
        yPos-20 < frog.getBottom() && 
        yPos+20 > frog.getBottom() )
             {
            hit = false;
            return (1);
        }
        if (xPos-30 < frog.getLeft() && 
        xPos+30 > frog.getLeft() && 
        yPos-20 < frog.getTop() && 
        yPos+20 > frog.getTop() )
        {
            hit = false;
            return (1);
        }
            
// top right of frog
        if (xPos-30 < frog.getRight() && 
        xPos+30 > frog.getRight() && 
        yPos-20 < frog.getTop() && 
        yPos+20 > frog.getTop() )
             {
            hit = false;
            return (1);
        }
// bottom left of frog
        if (xPos-30 < frog.getLeft() && 
        xPos+30 > frog.getLeft() && 
        yPos-20 < frog.getBottom() && 
        yPos+20 > frog.getBottom() )
             {
            hit = false;
            return (1);
        }
// bottom right of frog
        if (xPos-30 < frog.getRight() && 
        xPos+30 > frog.getRight() && 
        yPos-20 < frog.getBottom() && 
        yPos+20 > frog.getBottom() )
             {
            hit = false;
            return (1);
        }
        //here
        if(xPos>199 && yPos<420)
            {
                for(int p1number=-200;p1number<=0;p1number++)
                {
                    
                    for(int val=-18;val<=0;val++)
                    {
                        for(int val2=-10;val2<=0;val2++)
                        {
                            if(((int)(Math.cos((Math.PI*p1number)/200+Math.PI)*100)+315)==xPos+val  &&  ((int)(Math.sin((Math.PI*p1number)/200+Math.PI)*100)+315)==yPos+val2)
                            {
                                if(yPos+val2<=370)
                                {
//                                System.out.println("hit");
//                            System.out.println("x " + ((int)(Math.cos((Math.PI*p1number)/18+Math.PI)*100)+315) + " y " + ((int)(Math.sin((Math.PI*p1number)/18+Math.PI)*100)+315)
//                            + "   xPos " + xPos + " yPos " + yPos + " yPos2 " + yPos + val2);








                                return(2);  
                                }
                            } 
                        }
                    }
                    
                }
                
            }
        if(xPos>615 && xPos<1230)
        {
        for(int p1number=-1300;p1number<=0;p1number++)
                {
                for(int val=-10;val<=0;val++)
                    {
                        for(int val2=-10;val2<=0;val2++)
                        {
                            if(((int)(Math.cos((Math.PI*p1number)/1300+Math.PI)*300)+925)==xPos+val  && ((int)(Math.sin((Math.PI*p1number)/1300+Math.PI)*300)+300) ==yPos+val2)
                            {    
//                                player1.setXPos((int)(Math.cos((Math.PI*p1number)/35+Math.PI)*300)+925);
//                                                player1.setYPos((int)(Math.sin((Math.PI*p1number)/35+Math.PI)*300)+315);
//                                if(yPos+val2<=1200)
//                                {
                                return(2);  
//                                }
                            } 
                            
                        }
                    }
                }
        }
        return (0);
    }    
public void drawMissile(Tank4TheMemories obj,Graphics2D g,Image image,int xPos,int yPos,double rot,double xscale,
            double yscale) {
        int width = image.getWidth(obj);
        int height = image.getHeight(obj);
        g.translate(xPos,yPos);
        g.rotate(rot  * Math.PI/180.0);
        g.scale( xscale , yscale );
        
        g.drawImage(image,-width/2,-height/2,
        width,height,obj);
        
        g.scale( 1.0/xscale,1.0/yscale );
        g.rotate(-rot  * Math.PI/180.0);
        g.translate(-xPos,-yPos);
    }    
}






