import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TemperatureConverterApp {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Temperature Converter");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2));

        JLabel celsiusLabel = new JLabel("Celsius:");
        JTextField celsiusField = new JTextField();

        JLabel fahrenheitLabel = new JLabel("Fahrenheit:");
        JTextField fahrenheitField = new JTextField();

        JButton celsiusToFahrenheitButton = new JButton("C to F");
        JButton fahrenheitToCelsiusButton = new JButton("F to C");

        panel.add(celsiusLabel);
        panel.add(celsiusField);
        panel.add(fahrenheitLabel);
        panel.add(fahrenheitField);
        panel.add(celsiusToFahrenheitButton);
        panel.add(fahrenheitToCelsiusButton);

        celsiusToFahrenheitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    double celsius = Double.parseDouble(celsiusField.getText());
                    double fahrenheit = (celsius * 9 / 5) + 32;
                    fahrenheitField.setText(Double.toString(fahrenheit));
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Invalid input. Please enter a valid number.");
                }
            }
        });

        fahrenheitToCelsiusButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    double fahrenheit = Double.parseDouble(fahrenheitField.getText());
                    double celsius = (fahrenheit - 32) * 5 / 9;
                    celsiusField.setText(Double.toString(celsius));
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Invalid input. Please enter a valid number.");
                }
            }
        });

        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
    }
}
