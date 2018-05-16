package tank4thememories;




import java.awt.Color;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
 
public class Tank4TheMemories extends JFrame implements Runnable {
     boolean animateFirstTime = true;
     
    Image image;
    Image background;
    Image explosion;
    Graphics2D g;
    Image tank;
    Image tank2;
    Image rainbow;
    Image healthhh;
    WinBoard winboard;
    double frameRate = 40;
    int timeCount;
     int p1number=0;
     int p2number=0;
     double rot=0;
     double rot2=0;
     int power=0;
    boolean isPlayerTurn;
    double angle=0.001;
    int leftright=1;
    int leftrightp2=1;
    Color playercolor;
    Image bottomMenuBackground;
    Image fire;
    Image Missled;
    Image helpButton;
    playerTank player1;
    playerTank player2;
    Missile missile;
    Missile prmissile;
    int prtime;
    boolean missileleft;
    //menu
    Power health;
    int turn=1;
    FirstMenu menu;
    boolean activeMenu;
    Window windowmenu;
    Image starting;
    Image Help;
    Image menubottom;
    Color customBackgound = new Color(44, 56, 43);
    boolean win=false;
    boolean fired=false;
    static Tank4TheMemories frame1;




    public static void main(String[] args) {
        frame1 = new Tank4TheMemories();
        frame1.setSize(Window.WINDOW_WIDTH, Window.WINDOW_HEIGHT);
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.setVisible(true);
    }
    public Tank4TheMemories() {




        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                if (e.BUTTON1 == e.getButton()) {
                    if(win==false)
                    {
                    //left button
                    int xpos = e.getX();
                    int ypos = e.getY();
                    //help button when starting menu is active
                    if(windowmenu.isMenu())
                    if (xpos - 140 < 1820 && xpos + 140 > 1820 && ypos-15 < Window.getYNormal(40) && ypos+55 > Window.getYNormal(40) ){
                        activeMenu=true;
                    }
                    
                    if(!windowmenu.isMenu()){
                    //fire button clicked
                    if (xpos - 140 < 1000 && xpos + 140 > 1000 && ypos-15 < Window.getYNormal(40) && ypos+55 > Window.getYNormal(40) ){
                        if(windowmenu.activeMenu)
                        {
                            windowmenu.setActive(false);
                            activeMenu = false;
                        } 
                        else
                        {
                                if(missile==null)
                            {
                                if(isPlayerTurn)
                                    missile = new Missile(player1,missileleft,angle,power);
                                else
                                    missile = new Missile(player2,missileleft,angle,power);    
                                missile.setShow(true);
                                
                                WinBoard.strings.add("Angle " + (int)((angle)*1000));
                                WinBoard.strings.add("Power: " +power);
                                fired=true;
                                player1.resetFuel();
                                player2.resetFuel();
                            }
                        }
                    }
                        // help button 
                       if (xpos - 140 < 1720 && xpos + 140 > 1720 && ypos-15 < Window.getYNormal(25) && ypos+55 > Window.getYNormal(25) ){
                         System.out.println("i");
                           activeMenu=true;
                       }
                       //back button
                       
                    }
                    if(activeMenu)
                       {
                           if (xpos - 150 < 1730 && xpos + 150 > 1730 && ypos-15 < Window.getYNormal(Window.getHeight2()-60) && ypos+55 > Window.getYNormal(Window.getHeight2()+140) ){
                               activeMenu =false;
                           }
                       }
                }
                }
                if (e.BUTTON3 == e.getButton()) {
                    reset();
                }
                repaint();
                
            }
        });
    addMouseMotionListener(new MouseMotionAdapter() {
      public void mouseDragged(MouseEvent e) {
        repaint();
      }
    });
    addMouseMotionListener(new MouseMotionAdapter() {
      public void mouseMoved(MouseEvent e) {
        repaint();
      }
    });
        addKeyListener(new KeyAdapter() {
            
            public void keyPressed(KeyEvent e) {
             if(win==false )
              {
                  if(!fired)
                  {
                    if(isPlayerTurn && player1.getFuel() > 0 )
                    {
                        if (e.VK_D == e.getKeyCode())
                        {
                            //if the tank is not out of fuel move the tank right
                            if(player1.getXPos()<Window.getWidth2()-30)
                            player1.moveRight();
                            
                            if(player1.getXPos()>199 && player1.getXPos()<420)
                            {
                                p1number-=1;
                                if(p1number<=0)
                                {
                                player1.setXPos((int)(Math.cos((Math.PI*p1number)/18+Math.PI)*100)+315);
                                player1.setYPos((int)(Math.sin((Math.PI*p1number)/18+Math.PI)*100)+315);
                                rot=-(Math.sin((Math.PI*p1number)/18+Math.PI))*(180/Math.PI);
                                }
                            }
                            else if(player1.getXPos()>630 && player1.getXPos()<1230)
                                            {
                                                p1number-=1;
                                                if(p1number<=0)
                                                {
                                                player1.setXPos((int)(Math.cos((Math.PI*p1number)/35+Math.PI)*300)+925);
                                                player1.setYPos((int)(Math.sin((Math.PI*p1number)/35+Math.PI)*300)+315);
                                                rot=-(Math.sin((Math.PI*p1number)/35+Math.PI))*(180/Math.PI);
                                                }
                                            }
                            else
                            {
                                p1number=0;
                            }
                            if(player1.getXPos()<Window.getWidth2()-30)                            
                            player1.adjustFuel(-2);
                            
                            leftright=1;///changes physical direction
                            // WinBoard.strings.add("Player 1 moves right");
                        }
                        if (e.VK_A == e.getKeyCode())
                        {
                            //if the tank is not out of fuel move the tank left
                            
                            if(player1.getXPos()>199 && player1.getXPos()<420)
                            {
                                p1number+=1;
                                if(p1number <=0)
                                {
                                player1.setXPos((int)(Math.cos((Math.PI*p1number)/18+Math.PI)*100)+315);
                                player1.setYPos((int)(Math.sin((Math.PI*p1number)/18+Math.PI)*100)+315);
                                rot=(Math.sin((Math.PI*p1number)/18+Math.PI))*(180/Math.PI);
                                }
                            }
                            else if(player1.getXPos()>615 && player1.getXPos()<1230)
                                            {
                                                p1number+=1;
                                                if(p1number<=0)
                                                {
                                                player1.setXPos((int)(Math.cos((Math.PI*p1number)/35+Math.PI)*300)+925);
                                                player1.setYPos((int)(Math.sin((Math.PI*p1number)/35+Math.PI)*300)+315);
                                                rot=(Math.sin((Math.PI*p1number)/35+Math.PI))*(180/Math.PI);
                                                }
                                            }
                            else if(player1.getXPos()>=421&&player1.getXPos()<=440 )
                            {
                                p1number=-18;
                            }
                            else if(player1.getXPos()>=1231&&player1.getXPos()<=1240)
                            {
                                p1number=-35;
                            }
                            if(player1.getXPos()>30)
                            player1.moveLeft();
                           leftright=-1;///changes physical direction
                           if(player1.getXPos()>30)
                            player1.adjustFuel(-2);
                         //   WinBoard.strings.add("Player 1 moves left");
                        }
                    }
                    else if(!isPlayerTurn && player2.getFuel() > 0)
                    {
                        if (e.VK_D == e.getKeyCode())
                        {
                            //if the tank is not out of fuel move the tank right
                            if(player2.getXPos()<Window.getWidth2()-30)
                            player2.moveRight();
                            if(player2.getXPos()>199 && player2.getXPos()<420)
                            {
                            p2number-=1;
                            if(p2number <=0)
                                {
                            player2.setXPos((int)(Math.cos((Math.PI*p2number)/18+Math.PI)*100)+315);
                            player2.setYPos((int)(Math.sin((Math.PI*p2number)/18+Math.PI)*100)+315);
                            rot2=(Math.sin((Math.PI*p2number)/18+Math.PI))*(180/Math.PI);
                                }
                            }
                            else if(player2.getXPos()>630 && player2.getXPos()<1230)
                                            {
                                                p2number-=1;
                                                if(p2number<=0)
                                                {
                                                player2.setXPos((int)(Math.cos((Math.PI*p2number)/35+Math.PI)*300)+925);
                                                player2.setYPos((int)(Math.sin((Math.PI*p2number)/35+Math.PI)*300)+315);
                                                rot2=-(Math.sin((Math.PI*p2number)/35+Math.PI))*(180/Math.PI);
                                                }
                                            }
                            else
                            {
                                p2number=0;
                            }
                            if(player2.getXPos()<Window.getWidth2()-30)
                            player2.adjustFuel(-2);
                            leftrightp2=1;///changes physical direction
                         //    WinBoard.strings.add("Player 2 moves right");
                        }
                        if (e.VK_A == e.getKeyCode())
                        {
                            //if the tank is not out of fuel move the tank left
                            if(player2.getXPos()>199 && player2.getXPos()<420)
                            {
                                p2number+=1;
                                if(p2number <=0)
                                {
                                player2.setXPos((int)(Math.cos((Math.PI*p2number)/18+Math.PI)*100)+315);
                                player2.setYPos((int)(Math.sin((Math.PI*p2number)/18+Math.PI)*100)+315);
                                rot2=(Math.sin((Math.PI*p2number)/18))*(180/Math.PI);
                                }
                                
                            }else if(player2.getXPos()>615 && player2.getXPos()<1230)
                                            {
                                                p2number+=1;
                                                if(p2number<=0)
                                                {
                                                player2.setXPos((int)(Math.cos((Math.PI*p2number)/35+Math.PI)*300)+925);
                                                player2.setYPos((int)(Math.sin((Math.PI*p2number)/35+Math.PI)*300)+315);
                                                rot2=(Math.sin((Math.PI*p2number)/35+Math.PI))*(180/Math.PI);
                                                }
                                            }
                            else if(player2.getXPos()>=421&&player2.getXPos()<=440 )
                            {
                                p2number=-18;
                            }
                            else if(player2.getXPos()>=1231&&player2.getXPos()<=1240)
                            {
                                p2number=-35;
                            }
                            if(player2.getXPos()>30)
                            player2.moveLeft();
                           
                           if(player2.getXPos()>30)
                            player2.adjustFuel(-2);
                     //       WinBoard.strings.add("Player 2 moves left");
                            
                            leftrightp2=-1;///changes physical direction
                        }
                    }
                    
                    if(e.VK_SPACE == e.getKeyCode())
                    {
                        if(windowmenu.activeMenu)
                        {
                            windowmenu.setActive(false);
                            activeMenu = false;
                        } 
                        else
                        {
                                if(missile==null)
                            {
                                if(isPlayerTurn)
                                    missile = new Missile(player1,missileleft,angle,power);
                                else
                                    missile = new Missile(player2,missileleft,angle,power);    
                                missile.setShow(true);
                                
                                WinBoard.strings.add("Angle " + (int)((angle)*1000));
                                WinBoard.strings.add("Power: " +power);
                                fired=true;
                                player1.resetFuel();
                                player2.resetFuel();
                            }
                        }
                    }
                    
if (e.VK_UP == e.getKeyCode())
                        {
                            addPower();
                            if(power>500)
                            {
                                power=500;
                            }
                        }
                    if (e.VK_DOWN == e.getKeyCode())
                        {
                            subPower();
                            if(power<0)
                            {
                                power=0;
                            }
                        }
                    if (e.VK_RIGHT == e.getKeyCode())
                        {
                            if(angle<0.004)
                            addAngle();
                        }
                    if (e.VK_LEFT == e.getKeyCode())
                        {
                            if(angle>0.001)
                            subAngle();
                        }
                    if (e.VK_E == e.getKeyCode())
                        {
                            if(prmissile==null)
                            {
                            if(isPlayerTurn)
                    prmissile = new Missile(player1,missileleft,angle,power);
                            else
                    prmissile = new Missile(player2,missileleft,angle,power);
                            }
                        }
              }
      }
                repaint();
            }
        });
        init();
        start();
    }
    
    Thread relaxer;
////////////////////////////////////////////////////////////////////////////
    public void init() {
        requestFocus();
    }
////////////////////////////////////////////////////////////////////////////
    public void destroy() {
    }
////////////////////////////////////////////////////////////////////////////
    public void paint(Graphics gOld) {
        if (image == null || Window.xsize != getSize().width || Window.ysize != getSize().height) {
            Window.xsize = getSize().width;
            Window.ysize = getSize().height;
            image = createImage(Window.xsize, Window.ysize);
            g = (Graphics2D) image.getGraphics();
            g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);
        }
//fill background
        g.setColor(Color.black);
        g.fillRect(0, 0, Window.xsize, Window.ysize);








        int x[] = {Window.getX(0), Window.getX(Window.getWidth2()), Window.getX(Window.getWidth2()), Window.getX(0), Window.getX(0)};
        int y[] = {Window.getY(0), Window.getY(0), Window.getY(Window.getHeight2()), Window.getY(Window.getHeight2()), Window.getY(0)};
//fill border
        g.setColor(Color.white);
        g.fillPolygon(x, y, 4);
// draw border
        g.setColor(Color.red);
        g.drawPolyline(x, y, 5);




        if (animateFirstTime) {
            gOld.drawImage(image, 0, 0, null);
            return;
        }
            if(windowmenu.isMenu())
            {
                menu.draw(this, g, starting);
                if(activeMenu)
                    menu.drawpt3(this, g, Help);
            }
            else{
                //draw map
                
                menu.drawpt2(this, g, background);
                g.setColor(customBackgound);
                g.fillRect(0, 735, 1920, 200);
                g.fillOval(Window.getX(190), Window.getYNormal(390), 220, 220);
                g.fillOval(Window.getX((Window.getWidth2()/2)-310), Window.getYNormal(600), 620, 620);
                
                winboard.draw(g,playercolor);
                
                g.setColor(customBackgound);
                
                //draw player tank 
                if(health!=null)
                health.draw(g,tank, healthhh, 960,542,this, .1, .1,0,turn);
                player1.draw(g,tank, explosion, 960,542,this, leftright*.1, .1,rot);
                player2.draw(g,tank2, explosion, 960,542,this, leftrightp2*.1, .1,rot2);
                //draw bottom menu
                menu.drawpt5(this, g, menubottom);
                bottomMenu.draw(g,fire,1920,100,this, isPlayerTurn, player1, player2);
                if(missile!=null)
                {
                if(missile.getShow()!=false)
                missile.draw(this,g,Missled,false);
                }
               
                g.setColor(playercolor);
                if(prmissile!=null)
                prmissile.draw(this,g,Missled,true);
                
                g.setColor(Color.white);
                g.setFont(new Font("Arial Black",Font.PLAIN,20));
                if(isPlayerTurn)
                {
                g.drawString("P1 Turn",Window.getX(player1.xpos),Window.getYNormal(player1.ypos+ 50));
                g.drawString("P2",Window.getX(player2.xpos),Window.getYNormal(player2.ypos+ 50));
                }
                else
                {
                g.drawString("P1",Window.getX(player1.xpos),Window.getYNormal(player1.ypos+ 50));
                g.drawString("P2 Turn",Window.getX(player2.xpos),Window.getYNormal(player2.ypos+ 50));
                }




                if(player1.getHealth()<=0)
                {
                    g.drawString("Player 2 Wins",Window.getX(500),Window.getYNormal(400));
                    win = true;
                }
                if(player2.getHealth()<=0)
                {
                    g.drawString("Player 1 Wins",Window.getX(500),Window.getYNormal(400));
                    win = true;
                }
                if(activeMenu)
                    menu.drawpt3(this, g, Help);
            }
        gOld.drawImage(image, 0, 0, null);
    }
////////////////////////////////////////////////////////////////////////////
// needed for     implement runnable
    public void run() {
        while (true) {
            animate();
            repaint();
            double seconds = 1/frameRate;    //time that 1 frame takes.
            int miliseconds = (int) (1000.0 * seconds);
            try {
                Thread.sleep(miliseconds);
            } catch (InterruptedException e) {
            }
        }
    }
/////////////////////////////////////////////////////////////////////////
    public void reset() {   
        player1 = new playerTank(6, 150,false); //speed, xpos, isplayer1
        player2 = new playerTank(6, 1600,true); 
        isPlayerTurn = true;
        winboard = new WinBoard(Window.getWidth2()-100,Window.getHeight2()-100,"History");
        health = new Power();
        rot=0;
        rot2=0;
        power=10;
        angle=0.001;
        missile = null;
        prmissile=null;
        prtime=0;
        menu = new FirstMenu();
        windowmenu = new Window();
        activeMenu=false;
        win=false;
        fired=false;
        turn=1;
    }
/////////////////////////////////////////////////////////////////////////
    public void animate() {
        if (animateFirstTime) {
            animateFirstTime = false;
            if (Window.xsize != getSize().width || Window.ysize != getSize().height) {
                Window.xsize = getSize().width;
                Window.ysize = getSize().height;
            }
            //set images
            tank = Toolkit.getDefaultToolkit().getImage("./tank.png");
            tank2 = Toolkit.getDefaultToolkit().getImage("./tank2.png");
            fire = Toolkit.getDefaultToolkit().getImage("./fire.png");
            Missled = Toolkit.getDefaultToolkit().getImage("./missile.gif");
            starting = Toolkit.getDefaultToolkit().getImage("./Sparks-2.0.gif");
            background = Toolkit.getDefaultToolkit().getImage("./Sparks.gif");
            explosion = Toolkit.getDefaultToolkit().getImage("./explosion.gif-c200");
            Help = Toolkit.getDefaultToolkit().getImage("./Help-Menu.gif");
            helpButton = Toolkit.getDefaultToolkit().getImage("./HELP.png");
            menubottom = Toolkit.getDefaultToolkit().getImage("./bottomMenu.jpg");
            healthhh = Toolkit.getDefaultToolkit().getImage("./healthpack.png");
            reset();
        }
        if(health==null)
        {
            health = new Power();
            turn=1;
            health.setHit(false);
        }
        if(WinBoard.strings.size()>=8) 
            {
                WinBoard.strings.remove(0);
            }
        if(isPlayerTurn==false)
        {
            playercolor=Color.red;
        }
        else
        {
            playercolor=Color.white;
        }
        if(missile != null)
        {
            missile.move(-1);
        }
        if(prmissile != null)
        {
            if(!prmissile.move(prtime))
            {
                prtime++;
            }
            else
            {
               prmissile=null; 
            }
        }
        else
        {
            prtime=0;
        }
        if(prmissile!=null && prmissile.getY()<280)
        {
            prmissile=null;
            angle=0.001;
            power=10;
            isPlayerTurn=!isPlayerTurn;
            turn+=1;
            fired=false;
        }
        if(missile!=null && missile.getY()<280)
        {
            missile=null;
            angle=0.001;
            power=10;
            isPlayerTurn=!isPlayerTurn;
            turn+=1;
            fired=false;
        }
        if(isPlayerTurn)
        {
            if(leftright==-1)
            {
                missileleft=false;
            }
            else
            {
                missileleft=true;
            }
        }
        if(!isPlayerTurn)
        {
            if(leftrightp2==-1)
            {
                missileleft=false;
            }
            else
            {
                missileleft=true;
            }
        }
        
        if(missile!=null)
        {
            if(missile.getHit()==true && missile.collide(player1,health,turn)==1)
            {
                double val=getRandomVal();
                WinBoard.strings.add("p1 lost" +(val/100));
                player1.adjustHealth(val/100);
                angle=0.001;
                power=10;
                turn+=1;
                missile=null;
                isPlayerTurn=!isPlayerTurn;
                fired=false;
            }
            else if(missile.getHit()==true && missile.collide(player2,health,turn)==1)
            {
                double val=getRandomVal();
                WinBoard.strings.add("p2 lost" +(val/100));
                player2.adjustHealth(val/100);
                angle=0.001;
                power=10;
                turn+=1;
                missile=null;
                isPlayerTurn=!isPlayerTurn;
                fired=false;
            }
            else if(missile.getHit()==true && missile.collide(player2,health,turn)==2)
            {
                angle=0.001;
                power=10;
                turn+=1;
                missile=null;
                isPlayerTurn=!isPlayerTurn;
                fired=false;
            }
            else if(missile.getHit()==true && missile.collide(player1,health,turn)==2)
            {
                angle=0.001;
                power=10;
                turn+=1;
                missile=null;
                isPlayerTurn=!isPlayerTurn;
                fired=false;
            }
            else if(missile.getHit()==true && missile.collide(player1,health,turn)==4 && health.getHit()==false&& turn>11 && isPlayerTurn)
            {
                if(player1.getHealth()<1)
                player1.setHealth(1);
                missile=null;
                health.setHit(true);
                fired=false;
                isPlayerTurn=!isPlayerTurn;
                health=null;
            }
            else if(missile.getHit()==true && missile.collide(player2,health,turn)==4 && health.getHit()==false && turn>11)
            {
                if( player2.getHealth()<1)
                player2.setHealth(1);
                health.setHit(true);
                missile=null;
                fired=false;
                isPlayerTurn=!isPlayerTurn;
                health=null;
            }
        }
    }
    public int getRandomVal()
    {
        int val=0;
        if(power<100)
        val=(int)(Math.random()*20)+1;
        
        else if(power<200&&power>=100)
        val=(int)(Math.random()*20)+4;  
        
        else if(power<300&&power>=200)
        val=(int)(Math.random()*20)+7;  
        
        else if(power<400&&power>=300)
        val=(int)(Math.random()*20)+10; 
        
        else if(power<=500&&power>=400)
        val=(int)(Math.random()*20)+15;
        return val;
    }
    public void addPower()
    {
        power+=10;
    }
    public void subPower()
    {
        power-=10;
    }
    public void addAngle()
    {
        angle+=.001;
    }
    public void subAngle()
    {
        angle-=.001;
    }
////////////////////////////////////////////////////////////////////////////
    public void start() {
        if (relaxer == null) {
            relaxer = new Thread(this);
            relaxer.start();
        }
    }
////////////////////////////////////////////////////////////////////////////
    public void stop() {
        if (relaxer.isAlive()) {
            relaxer.stop();  
        }
        relaxer = null;
    }
}
