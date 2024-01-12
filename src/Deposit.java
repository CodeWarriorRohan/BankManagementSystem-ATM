import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Statement;
import java.util.Date;

public class Deposit extends JFrame implements ActionListener {
    JTextField tf1;
    JButton deposit; JButton Back;
    String pinnumber;
    Deposit(String pinnumber) {
        this.pinnumber = pinnumber;
        setSize(850, 800);
        setLayout(null);
        setLocationRelativeTo(null);
//        setTitle("Automated Teller Machine : Transactions ");
        getContentPane().setBackground(Color.WHITE);
        setUndecorated(true); // to remove upper bars of frame
        setVisible(true);

        Container c = getContentPane();
        JLabel il1 = new JLabel();
        il1.setIcon(new ImageIcon("C:\\Users\\intel\\Desktop\\ATM\\atm.jpg"));
        Dimension size = il1.getPreferredSize();
        il1.setBounds(0, 0, size.width, size.height);

        JLabel l2 = new JLabel("Enter the amount you want to deposit");
        l2.setBounds(170, 240, 300, 40);
        l2.setForeground(Color.WHITE);
        l2.setFont(new Font("System", Font.BOLD, 16));

        tf1 = new JTextField();
        tf1.setBounds(170, 290, 290, 40);
//        tf1.setForeground(Color.WHITE);
        tf1.setFont(new Font("System", Font.BOLD, 16));

        deposit = new JButton("Deposit");
        deposit.setBounds(390, 400, 100, 30);

        Back = new JButton("Back");
        Back.setBounds(390, 440, 100, 30);


        add(il1);
        il1.add(l2); il1.add(tf1);
        il1.add(deposit); il1.add(Back);

        deposit.addActionListener(this);
        Back.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == deposit) {
            String amt1 = tf1.getText();
            Date date = new Date();

            if (amt1.equals("")) {
                JOptionPane.showMessageDialog(null, "Please enter the amount you want to deposit");
            }
            else {
                try {
                    Connection conn = ConnectionProvider.getConnnection();

                    String q = "insert into transaction values('" + pinnumber + "','" + date + "', 'Deposit' ,'" + amt1 + "')";
                    Statement stmt = conn.createStatement();
                    stmt.executeUpdate(q);
                    JOptionPane.showMessageDialog(null, "Rs. " + amt1 + " Deposited successfully.");

                    setVisible(false);
                    new Transactions(pinnumber).setVisible(true);
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        } else if (e.getSource() == Back) {
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }
    }

    public static void main(String[] args) {
        new Deposit("");
    }
}