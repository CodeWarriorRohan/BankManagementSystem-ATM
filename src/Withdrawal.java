import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;

public class Withdrawal extends JFrame implements ActionListener {
    JTextField tf1;
    JButton withdrawal; JButton Back;
    String pinnumber;

    Withdrawal(String pinnumber) {
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

        JLabel l2 = new JLabel("Enter the amount you want to withdraw");
        l2.setBounds(170, 240, 300, 40);
        l2.setForeground(Color.WHITE);
        l2.setFont(new Font("System", Font.BOLD, 16));

        tf1 = new JTextField();
        tf1.setBounds(170, 290, 290, 40);
//        tf1.setForeground(Color.WHITE);
        tf1.setFont(new Font("System", Font.BOLD, 16));

        withdrawal = new JButton("Withdraw");
        withdrawal.setBounds(390, 400, 100, 30);

        Back = new JButton("Back");
        Back.setBounds(390, 440, 100, 30);

        add(il1);
        il1.add(l2); il1.add(tf1);
        il1.add(withdrawal); il1.add(Back);

        withdrawal.addActionListener(this);
        Back.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == Back) {
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }
        else
        {
            String amt3 = tf1.getText();
            Date date = new Date();

//            String amt3 = (String) ((JButton) e.getSource()).getText().substring(3);
//            amt3 = tf1.getText();
//            Connection conn = ConnectionProvider.getConnnection();
            try
            {
                Connection conn = ConnectionProvider.getConnnection();
                String q = "select * from transaction where Pin_Number = '"+pinnumber+"'";

                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(q);

                int balance = 0;

                while (rs.next())
                {
                    if (rs.getString("Transaction_Type").equals("Withdrawal"))
                    {
                        balance -= Integer.parseInt(rs.getString("Amount"));
                    }
                    else
                    {
                        balance += Integer.parseInt(rs.getString("Amount"));
                    }
                }
                if (e.getSource() == withdrawal && balance < Integer.parseInt(amt3)){
                    JOptionPane.showMessageDialog(null,"Insufficient Balance");
                    return;
                }
                if (amt3.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please enter the amount you want to withdrawal");
                }
                try
                {
//                    Connection conn = ConnectionProvider.getConnnection();

                    String q1 = "insert into transaction values('" + pinnumber + "','" + date + "', 'Credit' ,'" + amt3 + "')";
                    Statement stmt1 = conn.createStatement();
                    stmt1.executeUpdate(q1);
                    JOptionPane.showMessageDialog(null, "Rs. " + amt3 + " Credited successfully.");

                    setVisible(false);
                    new Transactions(pinnumber).setVisible(true);
                }
                catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
            catch (Exception e2)
            {
                e2.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new Withdrawal("");
    }
}