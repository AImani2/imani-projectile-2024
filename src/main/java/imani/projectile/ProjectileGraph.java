package imani.projectile;

import javax.swing.*;
import java.awt.*;
import java.text.DecimalFormat;

public class ProjectileGraph extends JComponent {

    Projectile projectile = new Projectile(31, 65);

    private static final DecimalFormat FORMAT = new DecimalFormat("0.00");

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.white);
        g.fillRect(0, 0, getWidth(), getHeight());

        g.setColor(Color.lightGray);
        int rows = getHeight() / 30;
        int cols = getWidth() / 30;

        // Draw horizontal gridlines
        int y = 0;
        for (int x = 0; x <= getWidth(); x+= 30) {
            y = x + 30;
            g.drawLine(0, y, getWidth(), y);
        }

        // Draw vertical gridlines
        for (int ys = 0; ys <= getHeight(); ys+=30) {
            int x = ys + 30;
            g.drawLine(x, 0, x, getHeight());
        }

        g.setColor(Color.black);

        g.drawLine(30, 0, 30, getHeight());
        g.drawLine(0, getHeight() - 30, getWidth(), getHeight() - 30);
        g.translate(0, getHeight());

        double totalTime = (projectile.getApexTime() * 2);
        projectile.setSeconds(0);

        g.setColor(Color.black);
        // increment by 1/8 each time
        for (double i = 0; i <= totalTime; i += .125)
        {
            int startX = (int) projectile.getX();
            int startY = (int) projectile.getY();
            projectile.setSeconds(i + .125);
            g.drawLine(startX, - startY, (int) projectile.getX(), (int) - projectile.getY());

        }

        g.setColor(Color.blue);
        g.fillOval((int) projectile.getInterceptX() / 2 - 5, - (int) projectile.getPeakY() - 5, 10,  10);
        String peakY = ("(" + FORMAT.format(projectile.getInterceptX()) + ", " + FORMAT.format(projectile.getPeakY()) + ")");
        g.drawString(peakY, ((int) projectile.getInterceptX() / 2 - 50), - ((int) projectile.getPeakY() + 35));

        g.setColor(Color.red);
        Projectile projectileCopy = new Projectile(projectile);
        projectileCopy.setSeconds(2.7);

        g.fillOval((int) projectileCopy.getX(), - (int) projectileCopy.getY() - 5, 10, 10);
        String point = ("(" + FORMAT.format(projectileCopy.getX()) + ", " + FORMAT.format(projectileCopy.getY()) + ")");
        g.drawString(point, (int) projectileCopy.getX() - 50, - (int) projectileCopy.getY() - 20);
    }

    public void setProjectile(Projectile projectile) {
        this.projectile = projectile;
        //this tells the os to call paintComponent() again
        repaint();
    }
}

// red dot