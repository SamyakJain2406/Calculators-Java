import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator implements ActionListener {
    JFrame f;
    JPanel panel;
    Font sArt, sArt2;
    JTextField tf, t2;
    JRadioButton rb1, rb2;
    ButtonGroup group;
    JButton[] btnZahl;
    JButton cBtn, delBtn, wurzelBtn, sqrBtn, divxBtn, gleichBtn, kommaBtn;
    JButton divBtn, minusBtn, mulBtn, plusBtn;
    double summe = 0, zahl1 = 0, zahl2 = 0, zahl3 = 0;
    String del;
    char operator;

    public Calculator() {
        f = new JFrame("Calculator - By SamyakJain");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(455, 690);
        f.setLayout(null);
        f.setResizable(false);

        sArt = new Font("Times New Roman", Font.BOLD, 30);
        tf = new JTextField();
        tf.setBounds(10, 50, 430, 60);
        f.add(tf);
        tf.setFont(sArt);
        tf.setEditable(false);
        tf.setBackground(Color.WHITE);
        tf.setHorizontalAlignment(SwingConstants.RIGHT);

        sArt2 = new Font("Times New Roman", Font.BOLD, 20);
        t2 = new JTextField();
        t2.setBounds(10, 20, 430, 30);
        f.add(t2);
        t2.setFont(sArt2);
        t2.setEditable(false);
        t2.setBackground(Color.BLACK);
        t2.setForeground(Color.YELLOW);
        t2.setHorizontalAlignment(SwingConstants.RIGHT);

        rb1 = new JRadioButton("on");
        rb1.setBounds(10, 130, 100, 30);
        rb2 = new JRadioButton("off");
        rb2.setBounds(10, 160, 100, 30);
        group = new ButtonGroup();
        group.add(rb1);
        group.add(rb2);
        rb1.setBackground(Color.BLACK);
        rb2.setBackground(Color.BLACK);
        rb1.setForeground(Color.WHITE);
        rb2.setForeground(Color.WHITE);
        rb1.setFont(rb1.getFont().deriveFont(21.0f));
        rb2.setFont(rb2.getFont().deriveFont(21.0f));
        f.add(rb1);
        f.add(rb2);

        btnZahl = new JButton[10];
        for (int i = 0; i < 10; i++) {
            btnZahl[i] = new JButton(String.valueOf(i));
            btnZahl[i].addActionListener(this);
            btnZahl[i].setFont(btnZahl[i].getFont().deriveFont(35.0f));
        }

        cBtn = new JButton("C");
        wurzelBtn = new JButton("\u221A");
        delBtn = new JButton("DEL");
        sqrBtn = new JButton("x\u00B2");
        divxBtn = new JButton("1/x");
        gleichBtn = new JButton("=");
        kommaBtn = new JButton(".");
        divBtn = new JButton("/");
        minusBtn = new JButton("-");
        mulBtn = new JButton("x");
        plusBtn = new JButton("+");

        // Define the size, color of the buttons and the numbers (0-9)
        int[][] buttonPositions = {
            {10, 580, 210, 60}, {120, 490, 100, 60}, {10, 490, 100, 60}, {230, 490, 100, 60},
            {10, 400, 100, 60}, {120, 400, 100, 60}, {230, 400, 100, 60}, {10, 310, 100, 60},
            {120, 310, 100, 60}, {230, 310, 100, 60}
        };

        for (int i = 0; i < 10; i++) {
            btnZahl[i].setBounds(buttonPositions[i][0], buttonPositions[i][1], buttonPositions[i][2], buttonPositions[i][3]);
            btnZahl[i].setBackground(new Color(100, 100, 255));
            btnZahl[i].setForeground(Color.WHITE);
            f.add(btnZahl[i]);
        }

        kommaBtn.setBounds(230, 580, 100, 60);
        kommaBtn.setBackground(new Color(100, 100, 255));
        kommaBtn.setForeground(Color.WHITE);
        f.add(kommaBtn);

        gleichBtn.setBounds(340, 490, 100, 150);
        gleichBtn.setBackground(new Color(255, 165, 0));
        gleichBtn.setForeground(Color.WHITE);
        f.add(gleichBtn);

        plusBtn.setBounds(340, 400, 100, 60);
        plusBtn.setBackground(new Color(255, 165, 0));
        plusBtn.setForeground(Color.WHITE);
        f.add(plusBtn);

        mulBtn.setBounds(340, 310, 100, 60);
        mulBtn.setBackground(new Color(255, 165, 0));
        mulBtn.setForeground(Color.WHITE);
        f.add(mulBtn);

        cBtn.setBounds(120, 130, 100, 60);
        cBtn.setBackground(new Color(255, 69, 0));
        cBtn.setForeground(Color.WHITE);
        f.add(cBtn);

        delBtn.setBounds(230, 130, 100, 60);
        delBtn.setBackground(new Color(255, 69, 0));
        delBtn.setForeground(Color.WHITE);
        f.add(delBtn);

        divBtn.setBounds(340, 130, 100, 60);
        divBtn.setBackground(new Color(255, 165, 0));
        divBtn.setForeground(Color.WHITE);
        f.add(divBtn);

        wurzelBtn.setBounds(10, 220, 100, 60);
        wurzelBtn.setBackground(new Color(50, 50, 200));
        wurzelBtn.setForeground(Color.WHITE);
        f.add(wurzelBtn);

        sqrBtn.setBounds(120, 220, 100, 60);
        sqrBtn.setBackground(new Color(50, 50, 200));
        sqrBtn.setForeground(Color.WHITE);
        f.add(sqrBtn);

        divxBtn.setBounds(230, 220, 100, 60);
        divxBtn.setBackground(new Color(50, 50, 200));
        divxBtn.setForeground(Color.WHITE);
        f.add(divxBtn);

        minusBtn.setBounds(340, 220, 100, 60);
        minusBtn.setBackground(new Color(255, 165, 0));
        minusBtn.setForeground(Color.WHITE);
        f.add(minusBtn);

        kommaBtn.addActionListener(this);
        gleichBtn.addActionListener(this);
        plusBtn.addActionListener(this);
        mulBtn.addActionListener(this);
        minusBtn.addActionListener(this);
        divxBtn.addActionListener(this);
        sqrBtn.addActionListener(this);
        wurzelBtn.addActionListener(this);
        cBtn.addActionListener(this);
        delBtn.addActionListener(this);
        divBtn.addActionListener(this);

        panel = new JPanel();
        panel.setBounds(0, 0, 450, 690);
        panel.setBackground(Color.BLACK);
        f.add(panel);

        f.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (rb1.isSelected()) {
            // Set colors, after turning on the calculator
            for (JButton btn : new JButton[]{gleichBtn, mulBtn, plusBtn, minusBtn, divBtn, cBtn, delBtn}) {
                btn.setBackground(btn.getBackground().brighter());
            }
            for (JButton btn : new JButton[]{divxBtn, wurzelBtn, sqrBtn, kommaBtn}) {
                btn.setBackground(btn.getBackground().brighter());
            }
            tf.setBackground(Color.WHITE);
            for (int i = 0; i < 10; i++) {
                btnZahl[i].setBackground(btnZahl[i].getBackground().brighter());
            }

            for (int i = 0; i < 10; i++) {
                if (actionEvent.getSource() == btnZahl[i]) {
                    animateButton(btnZahl[i]);
                    tf.setText(tf.getText().concat(String.valueOf(i)));
                }
            }
            if (actionEvent.getSource() == cBtn) {
                animateButton(cBtn);
                tf.setText("");
                t2.setText("");
            }
            if (actionEvent.getSource() == delBtn) {
                animateButton(delBtn);
                del = tf.getText();
                tf.setText("");
                for (int i = 0; i < del.length() - 1; i++) {
                    tf.setText(tf.getText() + del.charAt(i));
                }
            }
            if (actionEvent.getSource() == kommaBtn) {
                animateButton(kommaBtn);
                tf.setText(tf.getText().concat("."));
            }
            if (actionEvent.getSource() == plusBtn) {
                animateButton(plusBtn);
                zahl1 = Double.parseDouble(tf.getText());
                operator = '+';
                tf.setText("");
            }
            if (actionEvent.getSource() == minusBtn) {
                animateButton(minusBtn);
                zahl1 = Double.parseDouble(tf.getText());
                operator = '-';
                tf.setText("");
            }
            if (actionEvent.getSource() == mulBtn) {
                animateButton(mulBtn);
                zahl1 = Double.parseDouble(tf.getText());
                operator = '*';
                tf.setText("");
            }
            if (actionEvent.getSource() == divBtn) {
                animateButton(divBtn);
                zahl1 = Double.parseDouble(tf.getText());
                operator = '/';
                tf.setText("");
            }
            if (actionEvent.getSource() == wurzelBtn) {
                animateButton(wurzelBtn);
                zahl1 = Double.parseDouble(tf.getText());
                operator = '\u221A'; // Square-root
                tf.setText("");
            }
            if (actionEvent.getSource() == sqrBtn) {
                animateButton(sqrBtn);
                zahl1 = Double.parseDouble(tf.getText());
                operator = '\u00B2'; // Power-math
                tf.setText("");
            }
            if (actionEvent.getSource() == divxBtn) {
                animateButton(divxBtn);
                zahl1 = Double.parseDouble(tf.getText());
                operator = 'x';
                tf.setText("");
            }
            if (actionEvent.getSource() == gleichBtn) {
                animateButton(gleichBtn);
                zahl3 = zahl1;
                if (operator == '\u221A') { // Square-root
                    summe = Math.sqrt(zahl1);
                    tf.setText(String.valueOf(summe));
                    t2.setText("\u221A" + zahl1);
                    zahl1 = summe;
                } else if (operator == '\u00B2') { // Power-math
                    summe = Math.pow(zahl1, 2);
                    tf.setText(String.valueOf(summe));
                    t2.setText(zahl1 + "\u00B2");
                    zahl1 = summe;
                } else if (operator == 'x') { // 1/x
                    summe = 1 / zahl1;
                    tf.setText(String.valueOf(summe));
                    t2.setText("1/" + zahl1);
                    zahl1 = summe;
                } else {
                    zahl2 = Double.parseDouble(tf.getText());
                    switch (operator) {
                        case '+':
                            summe = zahl1 + zahl2;
                            t2.setText(String.valueOf(zahl1) + operator + String.valueOf(zahl2));
                            break;
                        case '-':
                            summe = zahl1 - zahl2;
                            t2.setText(String.valueOf(zahl1) + operator + String.valueOf(zahl2));
                            break;
                        case '*':
                            summe = zahl1 * zahl2;
                            t2.setText(String.valueOf(zahl1) + operator + String.valueOf(zahl2));
                            break;
                        case '/':
                            summe = zahl1 / zahl2;
                            t2.setText(String.valueOf(zahl1) + operator + String.valueOf(zahl2));
                            break;
                    }
                    tf.setText(String.valueOf(summe));
                    zahl1 = summe;
                }
            }
        } else if (rb2.isSelected()) {
            // Calculator is off -> change colors
            for (JButton btn : new JButton[]{gleichBtn, mulBtn, plusBtn, minusBtn, divBtn, cBtn, delBtn}) {
                btn.setBackground(btn.getBackground().darker());
            }
            for (JButton btn : new JButton[]{divxBtn, wurzelBtn, sqrBtn, kommaBtn}) {
                btn.setBackground(Color.DARK_GRAY);
            }
            tf.setBackground(Color.DARK_GRAY);
            for (int i = 0; i < 10; i++) {
                btnZahl[i].setBackground(Color.DARK_GRAY);
            }
            // Calculator is off
            tf.setText("OFF");
            t2.setText("OFF");
        }
    }

    private void animateButton(JButton button) {
        Color originalColor = button.getBackground();
        Timer timer = new Timer(100, new ActionListener() {
            int count = 0;

            @Override
            public void actionPerformed(ActionEvent e) {
                if (count == 0) {
                    button.setBackground(Color.WHITE);
                    count++;
                } else {
                    button.setBackground(originalColor);
                    ((Timer) e.getSource()).stop();
                }
            }
        });
        timer.start();
    }

    public static void main(String[] args) {
        new Calculator();
    }
}
