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
    private final JTextField velocityField;
    private final JTextField secondsField;
    private final JSlider angleSlider;
    private final JLabel fieldX;
    private final JLabel fieldy;
    private final JLabel peakyField;
    private final JLabel interceptxField;
    private final ProjectileGraph graph = new ProjectileGraph();

    public ProjectileFrame() {
        setSize(1000, 600);
        setTitle("Projectile Calculator");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel main = new JPanel();
        main.setLayout(new BorderLayout());

        JPanel west = new JPanel();
        main.add(west, BorderLayout.WEST);

        //tells the JFrame to use this JPanel
        setContentPane(main);

        west.setLayout(new GridLayout(7, 2));

        JLabel velocityLabel = new JLabel("Velocity");
        velocityField = new JTextField();
        west.add(velocityLabel);
        west.add(velocityField);

        JLabel angleLabel = new JLabel("Angle");
        angleSlider = new JSlider(JSlider.HORIZONTAL, 0, 90, 0);
        west.add(angleLabel);
        west.add(angleSlider);

        angleSlider.setMajorTickSpacing(10);
        angleSlider.setMinorTickSpacing(1);
        angleSlider.setPaintTicks(true);
        angleSlider.setPaintLabels(true);

        JLabel secondsLabel = new JLabel("Seconds");
        secondsField = new JTextField();
        west.add(secondsLabel);
        west.add(secondsField);

        JLabel xLabel = new JLabel("X");
        fieldX = new JLabel();
        west.add(xLabel);
        west.add(fieldX);

        JLabel yLabel = new JLabel("Y");
        fieldy = new JLabel();
        west.add(yLabel);
        west.add(fieldy);

        JLabel peakYLabel = new JLabel("Peak Y");
        peakyField = new JLabel();
        west.add(peakYLabel);
        west.add(peakyField);

        JLabel interceptXLabel = new JLabel("Intercept X");
        interceptxField = new JLabel();
        west.add(interceptXLabel);
        west.add(interceptxField);

        angleSlider.addChangeListener(e -> updateProjectile());
        velocityField.getDocument().addDocumentListener((SimpleDocumentListener) e -> updateProjectile());
        secondsField.getDocument().addDocumentListener((SimpleDocumentListener) e -> updateProjectile());
        main.add(graph, BorderLayout.CENTER);

    }

    public void updateProjectile()
    {
        Projectile projectile = new Projectile(
                Double.parseDouble(velocityField.getText()), Double.parseDouble(String.valueOf(angleSlider.getValue()))
        );
        projectile.setSeconds(Double.parseDouble(secondsField.getText()));
        fieldX.setText(Double.toString(projectile.getX()));
        fieldy.setText(Double.toString(projectile.getY()));
        peakyField.setText(Double.toString(projectile.getPeakY()));
        interceptxField.setText(Double.toString(projectile.getInterceptX()));
        graph.setProjectile(projectile);
    }

}


