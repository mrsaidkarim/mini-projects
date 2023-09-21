import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class TicTacToe implements ActionListener
{
    Random random = new Random();
    JFrame frame = new JFrame();
    JPanel titlePanel = new JPanel();
    JPanel buttonPanel = new JPanel();
    JLabel textfield = new JLabel();
    JButton[] buttons = new JButton[9];
    boolean turn1;
    Font myFont = new Font("Chilanka", Font.BOLD, 65);
    int[][] winCmb= {{0, 1, 2}, {3, 4, 5}, {6, 7, 8},
                            {0, 3, 6}, {1, 4, 7}, {2, 5, 8},
                            {0, 4, 8}, {2, 4, 6}};

    TicTacToe(){
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600,600);
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);

        textfield.setText("Tic Tac Toe");
        textfield.setFont(new Font("Chilanka", Font.BOLD, 65));
        textfield.setBackground(new Color(25, 25, 25));
        textfield.setForeground(new Color(25, 255, 0));
        textfield.setHorizontalAlignment(JLabel.CENTER);
        textfield.setOpaque(true);

        titlePanel.setLayout(new BorderLayout());
        titlePanel.setBounds(0,0,800,100);
        titlePanel.add(textfield);

        buttonPanel.setLayout(new GridLayout(3,3));
        buttonPanel.setBackground(new Color(150, 150, 150));
        for(int i = 0; i < 9; i++)
        {
            buttons[i] = new JButton();
            buttonPanel.add(buttons[i]);
            buttons[i].setFont(new Font("Chilanka", Font.BOLD, 120));
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);
        }
        frame.add(titlePanel, BorderLayout.NORTH);
        frame.add(buttonPanel);
        firstTurn();
    }
    public void firstTurn()
    {
        try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
        if (random.nextInt(2)==0)
        {
            turn1 = true;
            textfield.setText("X turn");
        }
        else
        {
            turn1 = false;
            textfield.setText("O turn");
        }
    }
    public void check(){
        for (int[] cmb : winCmb){
            String A, B, C;
            A = buttons[cmb[0]].getText();
            B = buttons[cmb[1]].getText();
            C = buttons[cmb[2]].getText();
            if (!A.isEmpty() && A.equals(B) && A.equals(C))
            {
                buttons[cmb[0]].setBackground(Color.green);
                buttons[cmb[1]].setBackground(Color.green);
                buttons[cmb[2]].setBackground(Color.green);
                textfield.setText(A + " wins");
                for(int i = 0; i < 9; i++)
                    buttons[i].setEnabled(false);
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        for(int i = 0; i < 9; i++)
        {
            if (buttons[i] == e.getSource() && buttons[i].getText()=="")
            {
                if (turn1)
                {
                    buttons[i].setForeground(Color.blue);
                    buttons[i].setText("X");
                    turn1 = false;
                    textfield.setText("O turn");
                }
                else
                {
                    buttons[i].setForeground(Color.red);
                    buttons[i].setText("O");
                    turn1 = true;
                    textfield.setText("X turn");
                }
            }
        }
        check();
    }
}