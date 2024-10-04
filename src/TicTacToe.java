

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TicTacToe implements ActionListener {
    private JFrame frame;
    private JPanel panel;
    private JButton[] buttons = new JButton[9];
    private boolean xTurn = true;
    public TicTacToe() {
        JFrame frame = new JFrame("Tic Tac Toe");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 3));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));


        for (int i = 0; i < 9; i++) {
            buttons[i] = new JButton();
            buttons[i].setFont(new Font("Arial", Font.PLAIN, 40));
            buttons[i].addActionListener(this);
            panel.add(buttons[i]);
        }

        frame.add(panel, BorderLayout.CENTER);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();
        if (xTurn) {
            button.setText("X");
            xTurn = false;
        } else {
            button.setText("O");
            xTurn = true;
        }
        button.setEnabled(false);
        checkForWinner();
    }

    public void checkForWinner(){
        //check rows
        for (int i = 0; i < 9; i+=3) {
            if (buttons[i].getText().equals(buttons[i+1].getText()) && buttons[i].getText().equals(buttons[i+2].getText()) && !buttons[i].isEnabled()){
                JOptionPane.showMessageDialog(null, "The winner is " + buttons[i].getText(), "Message", JOptionPane.INFORMATION_MESSAGE);
                resetGame();
            }
        }
        //check columns
        for (int i = 0; i < 3; i++) {
            if (buttons[i].getText().equals(buttons[i+3].getText()) && buttons[i].getText().equals(buttons[i+6].getText()) && !buttons[i].isEnabled()){
                JOptionPane.showMessageDialog(null, "The winner is " + buttons[i].getText(), "Message", JOptionPane.INFORMATION_MESSAGE);
                resetGame();
            }
        }

        //check diagonals
        if(buttons[0].getText().equals(buttons[4].getText()) && buttons[0].getText().equals(buttons[8].getText()) && !buttons[0].isEnabled()){
            JOptionPane.showMessageDialog(null, "The winner is " + buttons[0].getText(), "Message", JOptionPane.INFORMATION_MESSAGE);
            resetGame();
        }
        if(buttons[2].getText().equals(buttons[4].getText()) && buttons[2].getText().equals(buttons[6].getText()) && !buttons[2].isEnabled()){
            JOptionPane.showMessageDialog(null, "The winner is " + buttons[0].getText(), "Message", JOptionPane.INFORMATION_MESSAGE);
            resetGame();
        }

    }

    public void resetGame() {
        for (int i = 0; i < 9; i++) {
            buttons[i].setText("");
            buttons[i].setEnabled(true);
        }
        xTurn = true;
    }


}


