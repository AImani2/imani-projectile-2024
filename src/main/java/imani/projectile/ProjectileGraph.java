package imani.projectile;

import javax.swing.*;
import java.awt.*;

public class ProjectileGraph extends JComponent {

    Projectile projectile = new Projectile(35, 65);

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // divide that time up in the for loop and call the projectile
        // function at each of those slots and get x and y there.
        // at those points draw an oval
        // at every other slot draw a line from start x and start y to end x and end y

        // im gonna try for 8 slots
        //getApexTime * 2
        // the projectile has to have all the same info except for the time
        double totalTime = (projectile.getApexTime() * 2);
        projectile.setSeconds(0);

        //double timeSlot = totalTime / 8;

        // increment by 1/8 each time
        for (int i = 0; i <= totalTime; i+= .125) //does this increment properly?
        {
            int startX = (int) projectile.getX();
            int startY = (int) projectile.getY();
            projectile.setSeconds(i + .125);
            g.drawLine(startX, - startY, (int) projectile.getX(), (int) - projectile.getY());

        }

        g.fillOval((int) projectile.getInterceptX() / 2 - 5,- (int) projectile.getPeakY() - 5,10, 10);
    }

    public void setProjectile(Projectile projectile){
        this.projectile = projectile;
        //this tells the os to call paintComponent() again
        repaint();
    }
}

