package tank4thememories;




import java.awt.*;
import tank4thememories.Tank4TheMemories;




class playerTank {
    int xpos;
    int ypos;
    double fuel;
    double health;
    private int speed;
    private boolean isp2;
    
    playerTank(int _speed, int _xpos, boolean _isp2)
    {
        speed = _speed;
        xpos = _xpos;
        ypos = 315;
        isp2=_isp2;
        health=1;
        fuel=100;
    }
    public void move(int speed)
    {xpos += speed;}
    
    public void draw(Graphics2D g,Image tank, Image explosion, int width,int height,Tank4TheMemories obj, double xscale, double yscale,double _rot)
    {drawTank(g,Window.getX(xpos),Window.getYNormal(ypos),_rot,xscale,yscale, tank, explosion, width,height,obj);
//    g.setColor(Color.yellow);
//    g.fillRect(Window.getX(xpos-35),Window.getYNormal(ypos+20),70,40); here
    }
////////////////////////////////////////////////////////////////////////////
    public void drawTank(Graphics2D g,int xpos,int ypos,double rot,double xscale,double yscale, Image tank, Image explosion,int width,int height, Tank4TheMemories obj)
    {
        g.translate(xpos,ypos);
        g.rotate(rot  * Math.PI/180.0);
        g.scale( xscale , yscale );
        
        g.drawImage(tank,-width/2,-height/2,width,height,obj); 
        if(health <= 0)
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
    public void moveRight()
    {xpos += speed;}
    
    public void moveLeft()
    {xpos -= speed;}
    
    public void moveUp()
    {ypos += speed;}
    
    public void moveDown()
    {ypos -= speed;}
    
    public void setHealth(double _health)
    {health=_health;}
    
    public double getFuel()
    {return fuel;}
    
    public double getHealth()
    {return health;}
    
    public void adjustFuel(double adjustAmount)
    {fuel += adjustAmount;}
    
    public void resetFuel()
    {fuel = 100;}
    
    public void adjustHealth(double adjustAmount)
    {health -= adjustAmount;}
}




