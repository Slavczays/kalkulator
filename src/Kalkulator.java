import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Kalkulator {
    private JPanel Kalkulator;
    private JTextField calcDisplay;
    private JButton ACButton;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton a7Button;
    private JButton a8Button;
    private JButton a9Button;
    private JButton button8;
    private JButton a4Button;
    private JButton a5Button;
    private JButton a6Button;
    private JButton button12;
    private JButton a1Button;
    private JButton a2Button;
    private JButton a3Button;
    private JButton button16;
    private JButton a00Button;
    private JButton a0Button;
    private JButton button19;
    private JButton button20;

    public Kalkulator() {
        ACButton.addActionListener(new ActionListener() {
            /**
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                calcDisplay.setText("");
            }
        });
        a7Button.addActionListener(new ActionListener() {
            /**
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                calcDisplay.setText(calcDisplay.getText() + a7Button.getText());
            }
        });
        a8Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calcDisplay.setText(calcDisplay.getText() + a8Button.getText());
            }
        });
        a9Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calcDisplay.setText(calcDisplay.getText() + a9Button.getText());
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Kalkulator");
        frame.setContentPane(new Kalkulator().Kalkulator);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
