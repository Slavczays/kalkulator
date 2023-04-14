import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


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

    private double a;
    private double b;
    private double wynik;
    private String operator; //chociaż można by się pokusić o zastosowanie char zamiast String'a

    public Kalkulator() {
        acButton.addActionListener(new ActionListener() {
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
                if(calcDisplay.getText().contains("."))
                {
                    double plusMinus = Double.parseDouble(calcDisplay.getText());
                    plusMinus = plusMinus*-1;
                    calcDisplay.setText(String.valueOf(plusMinus));
                } else
                {
                    long plusMinusL = Long.parseLong(calcDisplay.getText());
                    plusMinusL = plusMinusL*-1;
                    calcDisplay.setText(String.valueOf(plusMinusL));
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
                a = Double.parseDouble(calcDisplay.getText());
                operator = "+";
                calcDisplay.setText("");
            }
        });
        minusButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                a = Double.parseDouble(calcDisplay.getText());
                operator = "-";
                calcDisplay.setText("");
            }
        });
        multiplyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                a = Double.parseDouble(calcDisplay.getText());
                operator = "*";
                calcDisplay.setText("");
            }
        });
        divideButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                a = Double.parseDouble(calcDisplay.getText());
                operator = "/";
                calcDisplay.setText(""); //zastanawiałem się czy nie wstawić tutaj wyłąpywania wyjątku dzielenia przez 0 (try catch) ale z tego co zaobserwowałem to java nie rzuca tutaj wyjątkiem bo nie traktuje dzielenia przez 0 jako klasycznego błędu a zwraca wartość Infinity (i taka włąśnie wartość wyświetla sie na wyświetlaczu mojego kalkulatora
            }
        });
        backspaceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               String backspace = null;

               if(calcDisplay.getText().length() > 0)
               {
                   StringBuilder strB = new StringBuilder(calcDisplay.getText());
                   strB.deleteCharAt(calcDisplay.getText().length() - 1);
                   backspace = String.valueOf(strB);
                   calcDisplay.setText(backspace);
               }
            }
        });
        equalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              b = Double.parseDouble(calcDisplay.getText()); //tutaj zdecydowałem się na użycie instrukcji if ale mógłbym użyć też switch

              if (operator == "+")
              {
                  wynik = a + b;
                  calcDisplay.setText(String.valueOf(wynik));
              } else if (operator == "-") {
                  wynik = a - b;
                  calcDisplay.setText(String.valueOf(wynik));
              } else if (operator == "*") {
                  wynik = a * b;
                  calcDisplay.setText(String.valueOf(wynik));
              } else if (operator == "/") {
                  wynik = a / b;
                  calcDisplay.setText(String.valueOf(wynik));
              }
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
