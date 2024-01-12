import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Statement;

public class PinChange extends JFrame implements ActionListener
{
    JPasswordField pf1,pf2;
    JButton change; JButton back;
    String pinnumber;
    PinChange(String pinnumber)
    {
        this.pinnumber = pinnumber;
        setSize(850,800);
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

        JLabel l2 = new JLabel("Change your pin");
        l2.setBounds(250, 240, 300, 40);
        l2.setForeground(Color.WHITE);
        l2.setFont(new Font("System", Font.BOLD, 16));

        JLabel l3 = new JLabel("New pin:");
        l3.setBounds(150, 290, 200, 40);
        l3.setForeground(Color.WHITE);
        l3.setFont(new Font("System", Font.BOLD, 16));

        pf1= new JPasswordField();
        pf1.setBounds(290, 290, 200, 40);
        pf1.setFont(new Font("System", Font.BOLD, 20));

        JLabel l4 = new JLabel("Re-Enter pin:");
        l4.setBounds(150, 340, 300, 40);
        l4.setForeground(Color.WHITE);
        l4.setFont(new Font("System", Font.BOLD, 16));

        pf2= new JPasswordField();
        pf2.setBounds(290, 340, 200, 40);
        pf2.setFont(new Font("System", Font.BOLD, 20));

        change = new JButton("Change");
        change.setBounds(385,400,100,30);

        back = new JButton("Back");
        back.setBounds(385,440,100,30);

        add(il1);
        il1.add(l2); il1.add(l3); il1.add(l4);
        il1.add(pf1); il1.add(pf2); il1.add(change);
        il1.add(back);
        change.addActionListener(this);
        back.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == change)
        {
            try
            {
                String npin = pf1.getText();
                String rpin = pf2.getText();

                if (!npin.equals(rpin))
                {
                    JOptionPane.showMessageDialog(null,"Re-Entered pin doesn't match");
                    return;
                }
                if (npin.equals(""))
                {
                    JOptionPane.showMessageDialog(null,"Please enter new pin");
                    return;
                }
                if (rpin.equals(""))
                {
                    JOptionPane.showMessageDialog(null,"Please re-enter pin");
                    return;
                }

                Connection conn = ConnectionProvider.getConnnection();

                String q1 = "update login set Pin_Number = '"+rpin+"' where Pin_Number = '"+pinnumber+"'";
                String q2 = "update signup_3 set Pin_Number = '"+rpin+"' where Pin_Number = '"+pinnumber+"'";
                String q3 = "update transaction set Pin_Number = '"+rpin+"' where Pin_Number = '"+pinnumber+"'";

                Statement stmt1 = conn.createStatement();
                Statement stmt2 = conn.createStatement();
                Statement stmt3 = conn.createStatement();

                stmt1.executeUpdate(q1);
                stmt2.executeUpdate(q2);
                stmt3.executeUpdate(q3);

                JOptionPane.showMessageDialog(null,"Pin Changed Successfully");

                setVisible(false);
                new Transactions(npin).setVisible(true);
            }
            catch (Exception ex)
            {
                ex.printStackTrace();
            }
        }
        else
        {
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }
    }
    public static void main(String[] args) {
        new PinChange("");
    }
}