package imani.projectile;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProjectileFrame extends JFrame {
    private JTextField velocityField;
    private JTextField secondsField;
    private JSlider angleSlider;
    private JLabel xField;
    private JLabel yField;
    private JLabel peakYField;
    private JLabel interceptXField;

    public ProjectileFrame() {
        setSize(400, 600);
        setTitle("Projectile Calculator");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setLayout(new GridLayout(7, 2));

        JLabel velocityLabel = new JLabel("Velocity");
        velocityField = new JTextField();
        add(velocityLabel);
        add(velocityField);

        JLabel angleLabel = new JLabel("Angle");
        angleSlider = new JSlider(JSlider.HORIZONTAL, 0, 90, 0);
        add(angleLabel);
        add(angleSlider);

        angleSlider.setMajorTickSpacing(10);
        angleSlider.setMinorTickSpacing(1);
        angleSlider.setPaintTicks(true);
        angleSlider.setPaintLabels(true);

        JLabel secondsLabel = new JLabel("Seconds");
        secondsField = new JTextField();
        add(secondsLabel);
        add(secondsField);

        JLabel xLabel = new JLabel("X");
        xField = new JLabel();
        add(xLabel);
        add(xField);

        JLabel yLabel = new JLabel("Y");
        yField = new JLabel();
        add(yLabel);
        add(yField);

        JLabel peakYLabel = new JLabel("Peak Y");
        peakYField = new JLabel();
        add(peakYLabel);
        add(peakYField);

        JLabel interceptXLabel = new JLabel("Intercept X");
        interceptXField = new JLabel();
        add(interceptXLabel);
        add(interceptXField);

        angleSlider.addChangeListener(e -> updateProjectile());
        velocityField.getDocument().addDocumentListener((SimpleDocumentListener) e -> updateProjectile());
        secondsField.getDocument().addDocumentListener((SimpleDocumentListener) e -> updateProjectile());
    }

    public void updateProjectile()
    {
        Projectile projectile = new Projectile(
                Double.parseDouble(velocityField.getText()), Double.parseDouble(String.valueOf(angleSlider.getValue()))
        );
        projectile.setSeconds(Double.parseDouble(secondsField.getText()));
        xField.setText(Double.toString(projectile.getX()));
        yField.setText(Double.toString(projectile.getY()));
        peakYField.setText(Double.toString(projectile.getPeakY()));
        interceptXField.setText(Double.toString(projectile.getInterceptX()));
    }
}


