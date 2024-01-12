import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;

public class BalanceEnquiry extends JFrame implements ActionListener
{
    JButton back;
    String pinnumber;
    BalanceEnquiry(String pinnumber)
    {
        this.pinnumber = pinnumber;
        setSize(850, 800);
        setLayout(null);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.WHITE);
        setUndecorated(true); // to remove upper bars of frame
        setVisible(true);

        Container c = getContentPane();
        JLabel il1 = new JLabel();
        il1.setIcon(new ImageIcon("C:\\Users\\intel\\Desktop\\ATM\\atm.jpg"));
        Dimension size = il1.getPreferredSize();
        il1.setBounds(0,0,size.width, size.height);

        back = new JButton("Back");
        back.setBounds(385,440,100,30);

//        String amount = (String) ((JButton) e.getSource()).getText().substring(3);
        Connection conn = ConnectionProvider.getConnnection();
        int balance = 0;
        try
        {
            String q = "select * from transaction where Pin_Number = '"+pinnumber+"'";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(q);

            // (rs.next()) --> It loop all raw one by one
            while (rs.next())
            {
                if (rs.getString("Transaction_Type").equals("Deposit"))
                {
                    balance += Integer.parseInt(rs.getString("Amount"));
                }
                else
                {
                    balance -= Integer.parseInt(rs.getString("Amount"));
                }
            }
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }

        JLabel bal = new JLabel("Your Current Account Balance is Rs. "+balance);
        bal.setForeground(Color.WHITE);
        bal.setBounds(150,300,350,40);
        bal.setFont(new Font("System", Font.BOLD, 16));

        add(il1);
        il1.add(back);
        il1.add(bal);

        back.addActionListener(this);
    }
    public void actionPerformed(ActionEvent e)
    {
        setVisible(false);
        new Transactions(pinnumber).setVisible(true);
    }

    public static void main(String[] args) {
        new BalanceEnquiry("");
    }
}