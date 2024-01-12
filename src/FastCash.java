import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
//import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;

// In the Date class compiler is confused in that it import Date from java.sql.Date or import from java.util.Date;
// There we should use import java.util.Date;
public class FastCash extends JFrame implements ActionListener
{
    JButton hun; JButton fivehun; JButton oneth; JButton twoth;
    JButton fiveth; JButton tenth; JButton back;
    String pinnumber;
    FastCash(String pinnumber)
    {
        this.pinnumber = pinnumber;
        setSize(850,800);
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
        il1.setBounds(0,0,size.width, size.height);

        JLabel l2 = new JLabel("Selects Withdrawal Amount");
        l2.setBounds(210,200,500,40);
        l2.setForeground(Color.WHITE);
        l2.setFont(new Font("System",Font.BOLD,16));

        hun = new JButton("Rs.100");
        hun.setBounds(150,320,100,30);

        fivehun = new JButton("Rs.500");
        fivehun.setBounds(385,320,100,30);

        oneth = new JButton("Rs.1000");
        oneth.setBounds(150,360,100,30);

        twoth = new JButton("Rs.2000");
        twoth.setBounds(385,360,100,30);

        fiveth = new JButton("Rs.5000");
        fiveth.setBounds(150,400,100,30);

        tenth = new JButton("Rs.10000");
        tenth.setBounds(385,400,100,30);

        back = new JButton("Back");
        back.setBounds(385,440,100,30);

        add(il1);
        il1.add(l2); il1.add(hun); il1.add(fivehun);
        il1.add(oneth); il1.add(twoth); il1.add(fiveth);
        il1.add(tenth); il1.add(back);

        hun.addActionListener(this);
        fivehun.addActionListener(this);
        oneth.addActionListener(this);
        twoth.addActionListener(this);
        fiveth.addActionListener(this);
        tenth.addActionListener(this);
        back.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == back)
        {
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }
        else
        {
            // Here we get direct buttons values, but e.getSource gives us object then we need to typecast that into JButton
            // And we don't need Rs ,we need only rupees then we are using substring beginIndex 3.
            String amt2 = (String) ((JButton) e.getSource()).getText().substring(3);
            Connection conn = ConnectionProvider.getConnnection();
            try
            {
//                Connection conn = ConnectionProvider.getConnnection();
                String q = "select * from transaction where Pin_Number = '"+pinnumber+"'";

                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(q);

                int balance = 0;
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
                if (e.getSource() != back && balance < Integer.parseInt(amt2)){
                    JOptionPane.showMessageDialog(null,"Insufficient Balance");
                    return;
                }

                try
                {
                    Date date = new Date();

                    String q2 = "insert into transaction values('" + pinnumber + "','" + date + "', 'Credit' ,'" + amt2 + "')";
                    Statement stmt1 = conn.createStatement();
                    stmt1.executeUpdate(q2);
                    JOptionPane.showMessageDialog(null, "Rs. " + amt2 + " Credited successfully.");

                    setVisible(false);
                    new Transactions(pinnumber).setVisible(true);
                }
                catch (Exception ex1)
                {
                    ex1.printStackTrace();
                }
            }
            catch (Exception ex)
            {
                ex.printStackTrace();
            }
        }
    }
    public static void main(String[] args)
    {
        new FastCash("");
    }
}