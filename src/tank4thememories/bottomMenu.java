package tank4thememories;




import java.awt.Color;
import java.awt.*;
import tank4thememories.Tank4TheMemories;




class bottomMenu {
    public static boolean isPlayerTurn;
    public static playerTank player1;
    public static playerTank player2;
    public static Tank4TheMemories obj;
    
    public static void draw(Graphics2D g,Image fire,int width,int height,Tank4TheMemories _obj, boolean _isplayerturn, playerTank _player1, playerTank _player2)
    {
        isPlayerTurn = _isplayerturn;
        player1 = _player1;
        player2 = _player2;
        obj = _obj;
        
        drawFuel(g, 16,Window.getYNormal(129),0,1,1, true);
        drawFuel(g, 1208,Window.getYNormal(131),0,.99,.99, false);
        drawPower(g, 550,Window.getYNormal(130),0,1,1, false);
        drawAngle(g, 387,Window.getYNormal(130),0,1,1, false);
        drawHealth(g, 184,Window.getYNormal(129),0,1,1,true);
        drawHealth(g, 1376,Window.getYNormal(130),0,1,1,false); 
    }
/////////////////////////////////////////////////////////////////////////
    public static void drawFuel(Graphics2D g,int xpos,int ypos,double rot,double xscale,double yscale, boolean isp1)
    {
        g.translate(xpos,ypos);
        g.rotate(rot  * Math.PI/180.0);
        g.scale( xscale , yscale );
        
        //amount full
        g.setColor(Color.green);
        if (isp1) 
            g.fillRect(10, 40, (int)((player1.getFuel())*1.35), 67);
        else
            g.fillRect(10, 40, (int)((player2.getFuel())*1.35), 67);
        
        g.scale( 1.0/xscale,1.0/yscale );
        g.rotate(-rot  * Math.PI/180.0);
        g.translate(-xpos,-ypos);
    }
    
    public static void drawHealth(Graphics2D g,int xpos,int ypos,double rot,double xscale,double yscale, boolean isp2)
    {
        g.translate(xpos,ypos);
        g.rotate(rot  * Math.PI/180.0);
        g.scale( xscale , yscale );
        
        //amount full
        g.setColor(Color.red);
        if(!isp2)
            g.fillRect(10, 40, (int) (player2.getHealth() * 134), 67);
        else
            g.fillRect(10, 40, (int) (player1.getHealth() * 134), 66);
        
        g.scale( 1.0/xscale,1.0/yscale );
        g.rotate(-rot  * Math.PI/180.0);
        g.translate(-xpos,-ypos);
    }
    
    public static void drawPower(Graphics2D g,int xpos,int ypos,double rot,double xscale,double yscale, boolean isp2)
    {
        g.translate(xpos,ypos);
        g.rotate(rot  * Math.PI/180.0);
        g.scale( xscale , yscale );
        
        g.setColor(Color.red);
        g.fillRect(10, 40, (int) (obj.power*.258), 67);
        
        g.scale( 1.0/xscale,1.0/yscale );
        g.rotate(-rot  * Math.PI/180.0);
        g.translate(-xpos,-ypos);
    }
    
    public static void drawAngle(Graphics2D g,int xpos,int ypos,double rot,double xscale,double yscale, boolean isp2)
    {
        g.translate(xpos,ypos);
        g.rotate(rot  * Math.PI/180.0);
        g.scale( xscale , yscale );
         
        
        g.setColor(Color.red);
        g.fillRect(10, 40, (int) (obj.angle*32000), 67);
        
        g.scale( 1.0/xscale,1.0/yscale );
        g.rotate(-rot  * Math.PI/180.0);
        g.translate(-xpos,-ypos);
    }
    
}
















