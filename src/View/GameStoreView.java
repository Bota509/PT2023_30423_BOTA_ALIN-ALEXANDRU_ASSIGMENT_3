package View;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;


public class GameStoreView extends JFrame {
    private JPanel contentPane;
    private JButton clientButton;
    private JButton productButton;
    private JButton productOrderButton;

    public GameStoreView() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1350, 763);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(128, 128, 0));

        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));



        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel gameStoreLabel = new JLabel("Game Store");
        gameStoreLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 36));
        gameStoreLabel.setBounds(477, 10, 220, 77);
        contentPane.add(gameStoreLabel);

        clientButton = new JButton("Clients");
        clientButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 26));
        clientButton.setBounds(477, 167, 220, 92);
        contentPane.add(clientButton);

        productButton = new JButton("Products");
        productButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 26));
        productButton.setBounds(477, 334, 220, 92);
        contentPane.add(productButton);

        productOrderButton = new JButton("Product Orders");
        productOrderButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 26));
        productOrderButton.setBounds(460, 495, 260, 92);
        contentPane.add(productOrderButton);
        this.setVisible(true);
    }

    public void openClientViewActionListener(ActionListener actionListener)
    {
        this.clientButton.addActionListener(actionListener);
    }
    public void openProductViewActionListener(ActionListener actionListener)
    {
        this.productButton.addActionListener(actionListener);
    }
    public void openProductOrderViewActionListener(ActionListener actionListener)
    {
        this.productOrderButton.addActionListener(actionListener);
    }

}
