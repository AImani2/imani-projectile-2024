package imani.projectile;

import javax.swing.*;
import java.awt.*;

public class ProjectileGraph extends JComponent {

    Projectile projectile = new Projectile(0,0);

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int centerX = 150;
        int centerY = 150;
        int radius = 100;
        int startAngle = 45;
        int arcAngle = (int) projectile.getAngle();

        int startX = (int) projectile.getX();
        int startY = (int) projectile.getY();

        int endX = (int) (centerX + radius * Math.cos(Math.toRadians(startAngle + arcAngle)));
        int endY = (int) (centerY - radius * Math.sin(Math.toRadians(startAngle + arcAngle)));

        g.setColor(Color.black);
        for (int i = startAngle; i < startAngle + arcAngle; i++) {
            int nextX = (int) (centerX + radius * Math.cos(Math.toRadians(i + 1)));
            int nextY = (int) (centerY - radius * Math.sin(Math.toRadians(i + 1)));
            g.drawLine(startX, - startY, nextX, - nextY);
            startX = nextX;
            startY = nextY;
        }
        g.fillOval(100,(int) projectile.getY(),10, 10);
    }

    public void setProjectile(Projectile projectile){
        this.projectile = projectile;
        //this tells the os to call paintComponent() again
        repaint();
    }
}

// draw a graph
// the graph will be the path of the projectile - arch - a series of lines - try with a series of lines
// add one dot to the peak - thats it.
// PR need a screenshot. every UI work needs a screenshot - attach it to the description field in the PR
// label