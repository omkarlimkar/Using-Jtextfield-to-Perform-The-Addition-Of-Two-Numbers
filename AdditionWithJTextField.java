import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AdditionWithJTextField extends JFrame implements ActionListener {
    private JTextField num1Field, num2Field, resultField;
    private JButton addButton;

    public AdditionWithJTextField() {
        setTitle("Addition with JTextField");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(4, 2));

        // Create JLabels for input fields
        JLabel num1Label = new JLabel("Number 1:");
        JLabel num2Label = new JLabel("Number 2:");
        JLabel resultLabel = new JLabel("Result:");

        // Create JTextFields for input and result
        num1Field = new JTextField(10);
        num2Field = new JTextField(10);
        resultField = new JTextField(10);
        resultField.setEditable(false); // Make result field read-only

        // Create JButton for addition operation
        addButton = new JButton("Add");
        addButton.addActionListener(this); // Register action listener for button

        // Add components to the frame
        add(num1Label);
        add(num1Field);
        add(num2Label);
        add(num2Field);
        add(resultLabel);
        add(resultField);
        add(addButton);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addButton) {
            // Parse input from text fields
            try {
                int num1 = Integer.parseInt(num1Field.getText());
                int num2 = Integer.parseInt(num2Field.getText());

                // Perform addition
                int result = num1 + num2;

                // Display result in resultField
                resultField.setText(Integer.toString(result));
            } catch (NumberFormatException ex) {
                // Handle invalid input
                JOptionPane.showMessageDialog(this, "Please enter valid numbers", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new AdditionWithJTextField();
            }
        });
    }
}