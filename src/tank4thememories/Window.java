package tank4thememories;

import java.awt.Color;
import java.awt.Graphics2D;

class Window
{
    boolean activeMenu = true;
    static final int XBORDER = 10;
    static final int YBORDER = 10;
    static final int YTITLE = 30;
    static final int WINDOW_BORDER = 8;
    static  int WINDOW_WIDTH = 1920;
    static  int WINDOW_HEIGHT = 1040;
    static int xsize = -1;
    static int ysize = -1;
    static boolean gameOver = false;
    public boolean isMenu(){
        if(activeMenu)
        {
           
            return true;
        }
        else 
        {
            
            return false;
        }
        
    }
    public void setActive(boolean y){
        activeMenu = y;
    }
    public static int getX(int x) {
        return (x + XBORDER + WINDOW_BORDER);
    }

    public static int getY(int y) {
        return (y + YBORDER + YTITLE );
    }

    public static int getYNormal(int y) {
        return (-y + YBORDER + YTITLE + getHeight2());
    }
    
    public static int getWidth2() {
        return (xsize - 2 * (XBORDER + WINDOW_BORDER));
    }

    public static int getHeight2() {
        return (ysize - 2 * YBORDER - WINDOW_BORDER - YTITLE);
    }    
}
