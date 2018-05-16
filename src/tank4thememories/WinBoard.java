/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tank4thememories;




import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.util.ArrayList;




public class WinBoard {
    private int xpos;
    private int ypos;
    private String str;
    private Color Color1= Color.blue;
    private Color Color2 = Color.red;
    static ArrayList<String> strings = new ArrayList<String>();
    
    WinBoard(int _xp, int _yp, String _str)
    {
        xpos=_xp;
        ypos=_yp;
        str=_str;
        strings.clear();
    }
    public int getX()
    {
        return xpos;
    }
    public int getY()
    {
        return ypos;
    }
    public void setX(int _xpos)
    {
        xpos = _xpos;
    }
    public void setY(int _ypos)
    {
        ypos = _ypos;
    }
    public void draw(Graphics2D g,Color _color)
    {
        drawFrog(g,Window.getX(xpos),
        Window.getYNormal(ypos),0,10,10,_color);
      
        g.setFont(new Font("Arial Black",Font.PLAIN,20));
        g.drawString("" + str ,Window.getX(xpos-90),Window.getYNormal(ypos+65));
        String cst="";
        for(int i=0;i<strings.size();i++)
        {
            cst = strings.get(i);
            g.drawString("" + cst ,Window.getX(xpos-90),Window.getYNormal(ypos+i*(20)-93));
        }
    }
////////////////////////////////////////////////////////////////////////////
    public void drawFrog(Graphics2D g,double xpos,double ypos,double rot,double xscale,double yscale,Color _color)
    {
        g.translate(xpos,ypos);
        g.rotate(rot  * Math.PI/180.0);
        g.scale( xscale , yscale );
        
        g.setColor(Color.BLACK);
        g.fillRect(-10,-10,20,20);
        g.setColor(_color);
        g.drawLine(-9, -9, 9, -9);
        
        g.scale( 1.0/xscale,1.0/yscale );
        g.rotate(-rot  * Math.PI/180.0);
        g.translate(-xpos,-ypos);
    }
}
















