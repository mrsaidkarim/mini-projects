
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class Calculator implements ActionListener{

    JFrame frame;
    JTextField text;
    JPanel panel;
    JButton[] numbers = new JButton[10];
    JButton addButton, subButton, mulButton, divButton;
    JButton clrButton, delButton, decButton, eqButton;
    JButton[] functions = new JButton[8];
    Font myFont = new Font("Chilanka", Font.BOLD, 30);
    double num1;
    double num2;
    double result;
    char opr;

    Calculator()
    {
        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 550);
        frame.setLayout(null);

        text = new JTextField();
        text.setBounds(50,25,300,50);
        text.setEditable(false);
        text.setFont(myFont);
        text.setBackground(Color.WHITE); 

        for(int i = 0; i < 10; i++)
        {
            numbers[i] = new JButton(String.valueOf(i));
            numbers[i].addActionListener(this);
            numbers[i].setFont(myFont);
            numbers[i].setFocusable(false);
        }

        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        eqButton = new JButton("=");
        decButton = new JButton(".");
        delButton = new JButton("delete");
        clrButton = new JButton("clear");
        functions[0] = addButton;
        functions[1] = subButton;
        functions[2] = mulButton;
        functions[3] = divButton;
        functions[4] = eqButton;
        functions[5] = decButton;
        functions[6] = delButton;
        functions[7] = clrButton;
        for(int i = 0; i < 8; i++)
        {
            functions[i].addActionListener(this);
            functions[i].setFont(myFont);
            functions[i].setFocusable(false);
        }

        panel = new JPanel();
        panel.setBounds(50, 100, 300, 300);
        panel.setLayout(new GridLayout(4,4,10,10));

        panel.add(numbers[1]);
        panel.add(numbers[2]);
        panel.add(numbers[3]);
        panel.add(addButton);
        panel.add(numbers[4]);
        panel.add(numbers[5]);
        panel.add(numbers[6]);
        panel.add(subButton);
        panel.add(numbers[7]);
        panel.add(numbers[8]);
        panel.add(numbers[9]);
        panel.add(mulButton);
        panel.add(decButton);
        panel.add(numbers[0]);
        panel.add(divButton);
        panel.add(eqButton);

        clrButton.setBounds(50,430,145,50);
        delButton.setBounds(205,430,145,50);
        frame.add(panel);
        frame.add(text);
        frame.add(clrButton);
        frame.add(delButton);
        frame.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        
        for(int i = 0; i < 10; i++)
        {
            if(e.getSource() == numbers[i])
            {
                text.setText(text.getText()+numbers[i].getText());
            }
        }
        if (e.getSource() == decButton)
        {
            text.setText(text.getText()+'.');
        }
        if (e.getSource() == addButton)
        {
            num1 = Double.parseDouble(text.getText());
            opr = '+';
            text.setText(null);
        }
        if (e.getSource() == subButton)
        {
            num1 = Double.parseDouble(text.getText());
            opr = '-';
            text.setText(null);
        }
        if (e.getSource() == mulButton)
        {
            num1 = Double.parseDouble(text.getText());
            opr = '*';
            text.setText(null);
        }
        if (e.getSource() == divButton)
        {
            num1 = Double.parseDouble(text.getText());
            opr = '/';
            text.setText(null);
        }
        if (e.getSource() == eqButton)
        {
            num2 = Double.parseDouble(text.getText());
            switch (opr)
            {
                case '+':
                    result = num1 + num2;
                break;
                case '-':
                    result = num1 - num2;
                break;
                case '*':
                    result = num1 * num2;
                break;
                case '/':
                    result = num1 / num2;
                break;
            }
            text.setText(String.valueOf(result));
        }
        if (e.getSource() == clrButton)
            text.setText(null);
        if (e.getSource() == delButton)
        {
            String str = text.getText();
            String s = "";
            for(int i = 0; i < str.length() - 1; i++)
                s += str.charAt(i);
            text.setText(s);
        }
    }

    public static void main(String[] args) {
        new Calculator();
    }
}
