import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator implements ActionListener {
	//Declaring variables
    JFrame f;
    JPanel panel;
    Font sArt, sArt2;
    JTextField tf, t2;
    JRadioButton rb1;
    JRadioButton rb2;
    ButtonGroup group;
    JButton[] btnZahl;
    JButton cBtn, delBtn, wurzelBtn, sqrBtn, divxBtn, gleichBtn, kommaBtn;
    JButton divBtn, minusBtn, mulBtn, plusBtn;
    int i;
    double summe = 0, zahl1 = 0, zahl2 = 0, zahl3 = 0;
    String del;
    char operator;
    boolean onoff;


    public Calculator() {
		//Create the window (frame) of the calculator
		//Define the size of the calculator
        f = new JFrame("Calculator - By ErsinSim");
        f.setDefaultCloseOperation(3);
        f.setSize(455, 690);
        f.setLayout(null);
        f.setResizable(false);

		//Add the font and a textfield
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

		//Create Radiobuttons on/off
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
		//create the buttons (0-9)
        for (i = 0; i < 10; i++) {
            btnZahl[i] = new JButton(String.valueOf(i));
            btnZahl[i].addActionListener(this);
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
		
		//Define the size, color of the buttons and the numbers (0-9)
        btnZahl[0].setBounds(10, 580, 210, 60);
        btnZahl[0].setFont(btnZahl[0].getFont().deriveFont(35.0f));
        kommaBtn.setBounds(230, 580, 100, 60);
        kommaBtn.setFont(kommaBtn.getFont().deriveFont(35.0f));
        btnZahl[1].setBounds(10, 490, 100, 60);
        btnZahl[1].setFont(btnZahl[1].getFont().deriveFont(35.0f));
        btnZahl[2].setBounds(120, 490, 100, 60);
        btnZahl[2].setFont(btnZahl[2].getFont().deriveFont(35.0f));
        btnZahl[3].setBounds(230, 490, 100, 60);
        btnZahl[3].setFont(btnZahl[3].getFont().deriveFont(35.0f));
        gleichBtn.setBounds(340, 490, 100, 150);
        gleichBtn.setBackground(Color.ORANGE);
        gleichBtn.setFont(gleichBtn.getFont().deriveFont(35.0f));
        btnZahl[4].setBounds(10, 400, 100, 60);
        btnZahl[4].setFont(btnZahl[4].getFont().deriveFont(35.0f));
        btnZahl[5].setBounds(120, 400, 100, 60);
        btnZahl[5].setFont(btnZahl[5].getFont().deriveFont(35.0f));
        btnZahl[6].setBounds(230, 400, 100, 60);
        btnZahl[6].setFont(btnZahl[6].getFont().deriveFont(35.0f));
        plusBtn.setBounds(340, 400, 100, 60);
        plusBtn.setBackground(Color.ORANGE);
        plusBtn.setFont(plusBtn.getFont().deriveFont(35.0f));
        btnZahl[7].setBounds(10, 310, 100, 60);
        btnZahl[7].setFont(btnZahl[7].getFont().deriveFont(35.0f));
        btnZahl[8].setBounds(120, 310, 100, 60);
        btnZahl[8].setFont(btnZahl[8].getFont().deriveFont(35.0f));
        btnZahl[9].setBounds(230, 310, 100, 60);
        btnZahl[9].setFont(btnZahl[9].getFont().deriveFont(35.0f));
        mulBtn.setBounds(340, 310, 100, 60);
        mulBtn.setBackground(Color.ORANGE);
        mulBtn.setFont(mulBtn.getFont().deriveFont(35.0f));
		
		//Add the buttons to the window
        f.add(btnZahl[0]);
        f.add(kommaBtn);
        f.add(btnZahl[1]);
        f.add(btnZahl[2]);
        f.add(btnZahl[3]);
        f.add(gleichBtn);
        f.add(btnZahl[4]);
        f.add(btnZahl[5]);
        f.add(btnZahl[6]);
        f.add(plusBtn);
        f.add(btnZahl[7]);
        f.add(btnZahl[8]);
        f.add(btnZahl[9]);
        f.add(mulBtn);

        cBtn.setBounds(120, 130, 100, 60);
        cBtn.setBackground(Color.RED);
        cBtn.setFont(cBtn.getFont().deriveFont(20.0f));
        cBtn.setForeground(Color.WHITE);
        delBtn.setBounds(230, 130, 100, 60);
        delBtn.setBackground(Color.RED);
        delBtn.setFont(delBtn.getFont().deriveFont(20.0f));
        delBtn.setForeground(Color.WHITE);
        divBtn.setBounds(340, 130, 100, 60); //NEUE GRößE
        divBtn.setBackground(Color.ORANGE);
        divBtn.setFont(divBtn.getFont().deriveFont(35.0f));
        f.add(cBtn);
        f.add(delBtn);
        f.add(divBtn);

        wurzelBtn.setBounds(10, 220, 100, 60);
        wurzelBtn.setFont(wurzelBtn.getFont().deriveFont(35.0f));
        sqrBtn.setBounds(120, 220, 100, 60);
        sqrBtn.setFont(sqrBtn.getFont().deriveFont(35.0f));
        divxBtn.setBounds(230, 220, 100, 60);
        divxBtn.setFont(divxBtn.getFont().deriveFont(35.0f));
        minusBtn.setBounds(340, 220, 100, 60);
        minusBtn.setBackground(Color.ORANGE);
        minusBtn.setFont(minusBtn.getFont().deriveFont(35.0f));
        f.add(wurzelBtn);
        f.add(sqrBtn);
        f.add(divxBtn);
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
        divxBtn.addActionListener(this);
        divBtn.addActionListener(this);

		//Create the panel (background) and define the size and color
        panel = new JPanel();
        panel.setBounds(0, 0, 450, 690);
        panel.setBackground(Color.BLACK);
        f.add(panel);

        f.setVisible(true);




    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {

        if (rb1.isSelected() == true) {
			//Set colors, after turning on the calculator
            gleichBtn.setBackground(Color.ORANGE);
            mulBtn.setBackground(Color.ORANGE);
            plusBtn.setBackground(Color.ORANGE);
            minusBtn.setBackground(Color.ORANGE);
            divBtn.setBackground(Color.ORANGE);
            cBtn.setBackground(Color.RED);
            delBtn.setBackground(Color.RED);
            divxBtn.setBackground(null);
            wurzelBtn.setBackground(null);
            sqrBtn.setBackground(null);
            kommaBtn.setBackground(null);
            tf.setBackground(Color.WHITE);

            for (i=0;i<10;i++){
                btnZahl[i].setBackground(null);
            }

            for (int i = 0; i < 10; i++) {
                if (actionEvent.getSource() == btnZahl[i]) {
                    tf.setText(tf.getText().concat(String.valueOf(i)));


                }
            }
            if (actionEvent.getSource() == cBtn) {
                tf.setText("");
                t2.setText("");
            }
            if (actionEvent.getSource() == delBtn) {
                del = tf.getText();
                tf.setText("");
                for (int i = 0; i < del.length() - 1; i++) {
                    tf.setText(tf.getText() + del.charAt(i));
                }

            }
            if (actionEvent.getSource() == kommaBtn) {
                tf.setText(tf.getText().concat("."));
            }
            if (actionEvent.getSource() == plusBtn) {
                zahl1 = Double.parseDouble(tf.getText());
                operator = '+';
                tf.setText("");
            }
            if (actionEvent.getSource() == minusBtn) {
                zahl1 = Double.parseDouble(tf.getText());
                operator = '-';
                tf.setText("");
            }
            if (actionEvent.getSource() == mulBtn) {
                zahl1 = Double.parseDouble(tf.getText());
                operator = '*';
                tf.setText("");
            }

            if (actionEvent.getSource() == divBtn) {
                zahl1 = Double.parseDouble(tf.getText());
                operator = '/';
                tf.setText("");
            }
            if (actionEvent.getSource() == wurzelBtn) {
                zahl1 = Double.parseDouble(tf.getText());
                operator = '\u221A';     //Square-root
                tf.setText("");

            }
            if (actionEvent.getSource() == sqrBtn) {
                zahl1 = Double.parseDouble(tf.getText());
                operator = '\u00B2';     //Power-math
                tf.setText("");
            }
            if (actionEvent.getSource() == divxBtn) {
                zahl1 = Double.parseDouble(tf.getText());
                operator = 'x';
                tf.setText("");
            }
            if (actionEvent.getSource() == gleichBtn) {
                zahl3 = zahl1;
                if (operator == '\u221A') {              //Square-root
                    summe = Math.sqrt(zahl1);
                    tf.setText(String.valueOf(summe));
                    t2.setText("\u221A" + zahl1);
                    zahl1 = summe;
                } else if (operator == '\u00B2') {     //Power-math
                    summe = Math.pow(zahl1, 2);
                    tf.setText(String.valueOf(summe));
                    t2.setText(zahl1 + "\u00B2");
                    zahl1 = summe;
                } else if (operator == 'x') {          //1/x
                    summe = 1 / zahl1;
                    tf.setText(String.valueOf(summe));
                    t2.setText("1/" + zahl1);
                    zahl1 = summe;
                }
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
        if (rb2.isSelected() == true){
			//Calculator is off -> change colors
            gleichBtn.setBackground(Color.ORANGE.darker());
            mulBtn.setBackground(Color.ORANGE.darker());
            plusBtn.setBackground(Color.ORANGE.darker());
            minusBtn.setBackground(Color.ORANGE.darker());
            divBtn.setBackground(Color.ORANGE.darker());
            cBtn.setBackground(Color.RED.darker());
            delBtn.setBackground(Color.RED.darker());
            divxBtn.setBackground(Color.DARK_GRAY);
            wurzelBtn.setBackground(Color.DARK_GRAY);
            sqrBtn.setBackground(Color.DARK_GRAY);
            kommaBtn.setBackground(Color.DARK_GRAY);
            tf.setBackground(Color.DARK_GRAY);

            for (i=0;i<10;i++){
                btnZahl[i].setBackground(Color.DARK_GRAY);
            }
			//Calculator is off
            tf.setText("OFF");
            t2.setText("OFF");
        }
    }
}
