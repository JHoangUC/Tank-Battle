package tank4thememories;


import java.awt.*;
import tank4thememories.Tank4TheMemories;




class Power {
    int xpos;
    int ypos;
    boolean hit;
    Power()
    {
        xpos = 900;
        ypos = 645;
        hit=false;
    }
    public void draw(Graphics2D g,Image tank, Image explosion, int width,int height,Tank4TheMemories obj, double xscale, double yscale,double _rot,int nunmberturns)
    {
      if(nunmberturns>11)
      {
          drawTank(g,Window.getX(xpos+25),Window.getYNormal(ypos-20),_rot,xscale,yscale, explosion,  width,height,obj);
      }
    }
////////////////////////////////////////////////////////////////////////////
    public void drawTank(Graphics2D g,int xpos,int ypos,double rot,double xscale,double yscale, Image explosion,int width,int height, Tank4TheMemories obj)
    {
        g.translate(xpos,ypos);
        g.rotate(rot  * Math.PI/180.0);
        g.scale( xscale , yscale );
        
        g.drawImage(explosion,-width/2,-height/2,width,height,obj); 
        
        g.scale( 1.0/xscale,1.0/yscale );
        g.rotate(-rot  * Math.PI/180.0);
        g.translate(-xpos,-ypos);
    }
    
    public int getXPos()
    {return (xpos);}
    
    public void setXPos(int _xpos)
    {xpos=_xpos;}
    
    public int getYPos()
    {return (ypos);}
    
    public void setYPos(int _ypos)
    {ypos=_ypos;}
    
    public int getLeft()
    {
        return (xpos-35);
    }
    public int getRight()
    {
        return (xpos+35);
    } 
    public int getTop()
    {
        return (ypos+20);
    } 
    public int getBottom()
    {
        return (ypos-20);
    }     
    public void setHit(boolean _hit)
    {hit=_hit;}
    public boolean getHit()
    {return (hit);}
}
