import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Kalkulator obsługujący podstawowe działania matematyczne a także zapis do pliku historii wykonanych operacji
 * @author Slawomir Ploszaj
 * @version 1.0
 */

public class Kalkulator {
    private JPanel Kalkulator;
    private JTextField calcDisplay;
    private JButton acButton;
    private JButton backspaceButton;
    private JButton plusMinusButton;
    private JButton plusButton;
    private JButton a7Button;
    private JButton a8Button;
    private JButton a9Button;
    private JButton minusButton;
    private JButton a4Button;
    private JButton a5Button;
    private JButton a6Button;
    private JButton multiplyButton;
    private JButton a1Button;
    private JButton a2Button;
    private JButton a3Button;
    private JButton divideButton;
    private JButton a00Button;
    private JButton a0Button;
    private JButton dpointButton;
    private JButton equalButton;
    private JButton zapiszDoPlikuButton;

    private double a;
    private double b;
    private double wynik;
    private String operator; //ewentualnie typ char

    /**
     * Konstruktor klasy Kalkulator.
     * Odpowiada za GUI i przypisuje poszczególnym przyciskom odpowiednie akcje.
     */
    public Kalkulator() {
        acButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                calcDisplay.setText("");
            }
        });
        a7Button.addActionListener(new ActionListener() {

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
        a4Button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                calcDisplay.setText(calcDisplay.getText() + a4Button.getText());
            }
        });
        a5Button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                calcDisplay.setText(calcDisplay.getText() + a5Button.getText());
            }
        });
        a6Button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                calcDisplay.setText(calcDisplay.getText() + a6Button.getText());
            }
        });
        a1Button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                calcDisplay.setText(calcDisplay.getText() + a1Button.getText());
            }
        });
        a2Button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                calcDisplay.setText(calcDisplay.getText() + a2Button.getText());
            }
        });
        a3Button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                calcDisplay.setText(calcDisplay.getText() + a3Button.getText());
            }
        });
        a00Button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                calcDisplay.setText(calcDisplay.getText() + a00Button.getText());
            }
        });
        a0Button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                calcDisplay.setText(calcDisplay.getText() + a0Button.getText());
            }
        });
        plusMinusButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try {                                           // try catch gdy dane z klawiatury nie są cyfrą
                    if (calcDisplay.getText().contains(".")) {
                        double plusMinusD = Double.parseDouble(calcDisplay.getText());
                        plusMinusD = plusMinusD * -1;
                        calcDisplay.setText(String.valueOf(plusMinusD));
                    } else {
                        long plusMinusL = Long.parseLong(calcDisplay.getText());
                        plusMinusL = plusMinusL * -1;
                        calcDisplay.setText(String.valueOf(plusMinusL));
                    }
                } catch (NumberFormatException ex) {
                    calcDisplay.setText("Błąd! Wprowadzono niepoprawne dane.");
                }
            }
        });
        dpointButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if(!calcDisplay.getText().contains("."))
                {
                    calcDisplay.setText(calcDisplay.getText() + dpointButton.getText());
                }
            }
        });
        plusButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                a = Double.parseDouble(calcDisplay.getText());
                operator = "+";
                calcDisplay.setText("");
                } catch (NumberFormatException ex) {
                    calcDisplay.setText("Błąd! Wprowadzono niepoprawne dane.");
                }
            }
        });
        minusButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                a = Double.parseDouble(calcDisplay.getText());
                operator = "-";
                calcDisplay.setText("");
                } catch (NumberFormatException ex) {
                    calcDisplay.setText("Błąd! Wprowadzono niepoprawne dane.");
                }
            }
        });
        multiplyButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                a = Double.parseDouble(calcDisplay.getText());
                operator = "*";
                calcDisplay.setText("");
                } catch (NumberFormatException ex) {
                    calcDisplay.setText("Błąd! Wprowadzono niepoprawne dane.");
                }
            }
        });
        divideButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                a = Double.parseDouble(calcDisplay.getText());
                operator = "/";
                calcDisplay.setText(""); // bez try  catch bo java wyrzuca Infinity
                } catch (NumberFormatException ex) {
                    calcDisplay.setText("Błąd! Wprowadzono niepoprawne dane.");
                }
            }
        });
        backspaceButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
               String backspace = null;

               if(calcDisplay.getText().length() > 0)
               {
                   StringBuilder stringB = new StringBuilder(calcDisplay.getText());
                   stringB.deleteCharAt(calcDisplay.getText().length() - 1);
                   backspace = String.valueOf(stringB);
                   calcDisplay.setText(backspace);
               }
            }
        });
        equalButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
              b = Double.parseDouble(calcDisplay.getText());

              if (operator.equals("+"))   //alternatywnie switch
              {
                  wynik = a + b;
                  calcDisplay.setText(String.valueOf(wynik));
              } else if (operator.equals("-")) {
                  wynik = a - b;
                  calcDisplay.setText(String.valueOf(wynik));
              } else if (operator.equals("*")) {
                  wynik = a * b;
                  calcDisplay.setText(String.valueOf(wynik));
              } else if (operator.equals("/")) {
                  wynik = a / b;
                  calcDisplay.setText(String.valueOf(wynik));
              }
                } catch (NumberFormatException ex) {
                    calcDisplay.setText("Błąd! Wprowadzono niepoprawne dane.");
                }
            }
        });
        zapiszDoPlikuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    File plik = new File("Historia operacji.txt");
                    if (!plik.exists()) {
                        FileWriter writer = new FileWriter(plik);
                        writer.write("Historia operacji matematycznych:");
                        writer.close();
                    }
                    FileWriter writer = new FileWriter(plik, true);
                    writer.write("\nWynik:" + wynik);
                    writer.close();
                    JOptionPane.showMessageDialog(null, "Zapisano do pliku historii");
                }
                catch(IOException f)
                {
                    JOptionPane.showMessageDialog(null,"Błąd zapisu do pliku historii");
                }
            }
        });
    }

    /**
     * Metoda główna klasy Kalkulator
     */

    public static void main(String[] args) {
        JFrame frame = new JFrame("Kalkulator");
        frame.setContentPane(new Kalkulator().Kalkulator);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
