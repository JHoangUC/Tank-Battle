package tank4thememories;

import java.awt.Graphics2D;
import java.awt.Image;

public class FirstMenu {
    FirstMenu(){
    
}
    public void draw(Tank4TheMemories obj,Graphics2D g,Image image)
    {   
        
        menu(obj, g, image,Window.getX(935),Window.getYNormal(510),0,1,1); 
        
    }
     public void drawpt3(Tank4TheMemories obj,Graphics2D g,Image image)
    {   
        
        menu(obj, g, image,Window.getX(935),Window.getYNormal(470),0,1,1); 
        
    }
     public void drawpt4(Tank4TheMemories obj,Graphics2D g,Image image)
    {   
        
        menu(obj, g, image,Window.getX(1770),Window.getYNormal(60),0,1,1); 
        
    }
      public void drawpt5(Tank4TheMemories obj,Graphics2D g,Image image)
    {   
        
        menu(obj, g, image,Window.getX(940),Window.getYNormal(70),0,.99,.8); 
        
    }
    public void menu(Tank4TheMemories obj,Graphics2D g,Image image,int xpos,int ypos,double rot,double xscale,
            double yscale) {
        int width = image.getWidth(obj);
        int height = image.getHeight(obj);
        g.translate(xpos,ypos);
        g.rotate(rot  * Math.PI/180.0);
        g.scale( xscale , yscale );

        g.drawImage(image,-width/2,-height/2,
        width,height,obj);

        g.scale( 1.0/xscale,1.0/yscale );
        g.rotate(-rot  * Math.PI/180.0);
        g.translate(-xpos,-ypos);
    }    
     
    public void drawpt2(Tank4TheMemories obj,Graphics2D g,Image image)
    {   
        
        menupt2(obj, g, image,Window.getX(935),Window.getYNormal(500),0,4,4); 
        
    }
    public void menupt2(Tank4TheMemories obj,Graphics2D g,Image image,int xpos,int ypos,double rot,double xscale,
            double yscale) {
        int width = image.getWidth(obj);
        int height = image.getHeight(obj);
        g.translate(xpos,ypos);
        g.rotate(rot  * Math.PI/180.0);
        g.scale( xscale , yscale );

        g.drawImage(image,-width/2,-height/2,
        width,height,obj);

        g.scale( 1.0/xscale,1.0/yscale );
        g.rotate(-rot  * Math.PI/180.0);
        g.translate(-xpos,-ypos);
    }    
}




















