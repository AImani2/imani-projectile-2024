package imani.projectile;

import javax.swing.*;
import java.awt.*;

public class ProjectileGraph extends JComponent {

    Projectile projectile = new Projectile(35, 65);

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.translate(0, getHeight());

        double totalTime = (projectile.getApexTime() * 2);
        projectile.setSeconds(0);

        // increment by 1/8 each time
        for (double i = 0; i <= totalTime; i += .125)
        {
            int startX = (int) projectile.getX();
            int startY = (int) projectile.getY();
            projectile.setSeconds(i + .125);
            g.drawLine(startX, - startY, (int) projectile.getX(), (int) - projectile.getY());

        }

        g.fillOval((int) projectile.getInterceptX() / 2 - 5, - (int) projectile.getPeakY() - 5, 10,  10);
    }

    public void setProjectile(Projectile projectile) {
        this.projectile = projectile;
        //this tells the os to call paintComponent() again
        repaint();
    }
}

