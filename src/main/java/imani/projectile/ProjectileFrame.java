package imani.projectile;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;

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

        setLayout(new GridLayout(8, 2));

        JLabel velocityLabel = new JLabel("Velocity");
        JLabel angleLabel = new JLabel("Angle");
        JLabel secondsLabel = new JLabel("Seconds");
        JLabel xLabel = new JLabel("X");
        JLabel yLabel = new JLabel("Y");
        JLabel peakYLabel = new JLabel("Peak Y");
        JLabel interceptXLabel = new JLabel("Intercept X");
        JLabel nothingLabel = new JLabel(" ");

        velocityField = new JTextField();

        angleSlider = new JSlider(JSlider.HORIZONTAL, 0, 90, 0);
        angleSlider.setMajorTickSpacing(10);
        angleSlider.setMinorTickSpacing(1);
        angleSlider.setPaintTicks(true);
        angleSlider.setPaintLabels(true);

        secondsField = new JTextField();
        xField = new JLabel();
        yField = new JLabel();
        peakYField = new JLabel();
        interceptXField = new JLabel();

        //add a row that displays peak y and x intercept and further instructions to changing the value of velocity
        //the fields automatically get updated without pressing calculate

        JButton calculate = new JButton("Calculate");

        add(velocityLabel);
        add(velocityField);

        add(angleLabel);
        add(angleSlider);

        add(secondsLabel);
        add(secondsField);

        add(xLabel);
        add(xField);

        add(yLabel);
        add(yField);

        add(peakYLabel);
        add(peakYField);

        add(interceptXLabel);
        add(interceptXField);

        add(nothingLabel);
        add(calculate);

        calculate.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //this is how you get a button to do something
                Projectile projectile = new Projectile(
                        Double.parseDouble(velocityField.getText()), Double.parseDouble(String.valueOf(angleSlider.getValue()))
                );
                projectile.setSeconds(Double.parseDouble(secondsField.getText()));
                xField.setText(Double.toString(projectile.getX()));
                yField.setText(Double.toString(projectile.getY()));
                peakYField.setText(Double.toString(projectile.getPeakY()));
                interceptXField.setText(Double.toString(projectile.getInterceptX()));
            }
        });

//        ChangeListener listener = new ChangeListener() {
//            public void stateChanged(ChangeEvent e) {
//                JSlider source = (JSlider) e.getSource();
//                // Check if the user is still adjusting the slider
//                if (!source.getValueIsAdjusting()) {
//                    // Get the current value of the slider
//                    int value = source.getValue();
//                    // Print the value to the console
//                    System.out.println(value);
//                }
//            }
//        };

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


