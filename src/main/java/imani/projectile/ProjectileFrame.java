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
    private final JLabel xField;
    private final JLabel yField;
    private final JLabel peakYField;
    private final JLabel interceptXField;
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
        xField = new JLabel();
        west.add(xLabel);
        west.add(xField);

        JLabel yLabel = new JLabel("Y");
        yField = new JLabel();
        west.add(yLabel);
        west.add(yField);

        JLabel peakYLabel = new JLabel("Peak Y");
        peakYField = new JLabel();
        west.add(peakYLabel);
        west.add(peakYField);

        JLabel interceptXLabel = new JLabel("Intercept X");
        interceptXField = new JLabel();
        west.add(interceptXLabel);
        west.add(interceptXField);

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
        xField.setText(Double.toString(projectile.getX()));
        yField.setText(Double.toString(projectile.getY()));
        peakYField.setText(Double.toString(projectile.getPeakY()));
        interceptXField.setText(Double.toString(projectile.getInterceptX()));
        graph.setProjectile(projectile);
    }

}


