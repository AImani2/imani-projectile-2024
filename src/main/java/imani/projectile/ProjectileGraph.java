package imani.projectile;

import javax.swing.*;
import java.awt.*;

public class ProjectileGraph extends JComponent {

    Projectile projectile = new Projectile(0,0);

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.black);
        g.drawArc((int) projectile.getX(), (int) projectile.getY(), getWidth(), (int) projectile.getPeakY(), 0, (int) projectile.getAngle());
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