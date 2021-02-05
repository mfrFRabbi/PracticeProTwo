package com.mfr;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class CardLayOutExample extends JFrame implements ActionListener {
    JButton nextButton;
    JButton prvButton;

    JPanel panel;
    CardLayout cardLayout;
    Container c;
    public CardLayOutExample() {
        String[] image = {"pic1.jpg","pic2.png","logo.png","iconX.png","iconfinder.png","unnamed.png"};
        panel = new JPanel();
        JPanel botomPanel = new JPanel();
        botomPanel.setLayout(new GridLayout());
        nextButton = new JButton("Next");
        prvButton = new JButton("prv");
        nextButton.setFocusable(false);
        prvButton.setFocusable(false);


        cardLayout = new CardLayout(5,5);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(700,700);
   //     this.setLayout(new BorderLayout());

        botomPanel.setBackground(Color.pink);
        botomPanel.setPreferredSize(new Dimension(700,50));


        panel.setSize(700,550);
        panel.setBackground(Color.cyan);
        nextButton.setBounds(50,400,50,50);
        panel.setLayout(cardLayout);

   //     label.setPreferredSize(new Dimension(500,500));
        for(String i: image){
            ImageIcon icon = new ImageIcon(i);
            JLabel label = new JLabel();
            label.setIcon(icon);
            panel.add(label);

        }

        nextButton.addActionListener(this);
        prvButton.addActionListener(this);

/*        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(10,10,10,10);
        constraints.gridx = 0;
        constraints.gridx = 1;
        */
        botomPanel.add(prvButton);

        botomPanel.add(nextButton);

        this.add(panel);
        this.add(botomPanel,BorderLayout.SOUTH);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
            if(e.getSource() == nextButton){
                cardLayout.next(panel);
            } else if(e.getSource() == prvButton){
            cardLayout.previous(panel);
           }

    }
}
