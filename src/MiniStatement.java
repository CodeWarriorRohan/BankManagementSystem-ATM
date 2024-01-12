import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class MiniStatement extends JFrame
{
    String pinnumber;
    MiniStatement(String pinnumber)
    {
        this.pinnumber = pinnumber;
        setSize(400,600);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
//        setUndecorated(true); // to remove upper bars of frame
        setVisible(true);

        JLabel bank = new JLabel("Rohan Private Finance Ltd. Company");
        bank.setBounds(50,10,400,40);
        bank.setFont(new Font("arial",Font.BOLD,18));

        JLabel card = new JLabel();
        card.setBounds(25,100,300,40);
        card.setFont(new Font("arial",Font.BOLD,14));

        JLabel ms = new JLabel("Mini Statement");
        ms.setBounds(25,150,500,40);
        ms.setFont(new Font("arial",Font.BOLD,14));

        JLabel balance = new JLabel();
        balance.setBounds(25,350,100,40);
        balance.setFont(new Font("arial",Font.BOLD,14));

        JLabel mini = new JLabel();
        mini.setBounds(25,200,400,200);
        mini.setFont(new Font("arial",Font.BOLD,14));

        try {
            Connection conn = ConnectionProvider.getConnnection();
            Statement stmt = conn.createStatement();
            String q = "select * from login where Pin_Number = '"+pinnumber+"'";
//            String q = "select * from login where Pin_Number = '8439'";
            ResultSet rs = stmt.executeQuery(q);

            while (rs.next())
            {
                card.setText("Card Number : "+rs.getString("Card_Number").substring(0,4)+"XXXXXXXX" +rs.getString("Card_Number").substring(12));
            }

        }catch (Exception e)
        {
            e.printStackTrace();
        }

        try {
            Connection conn = ConnectionProvider.getConnnection();
            Statement stmt = conn.createStatement();
            String q = "select * from transaction where Pin_Number = '"+pinnumber+"'";
//            String q = "select * from login where Pin_Number = '8439'";
            ResultSet rs = stmt.executeQuery(q);

            int bal = 0;
            while (rs.next())
            {
                // Here we use html tag for gap between details
                mini.setText(mini.getText() + "<html>" +rs.getString("Date") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+ rs.getString("Transaction_Type")+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+ rs.getString("Amount") +"<br><br><html>");

                if (rs.getString("Transaction_Type").equals("Deposit"))
                {
                    bal += Integer.parseInt(rs.getString("Amount"));
                }
                else
                {
                    bal -= Integer.parseInt(rs.getString("Amount"));
                }
            }
            balance.setText("Your Account Balance is Rs. "+bal);

        }catch (Exception e)
        {
            e.printStackTrace();
        }

        add(bank);
        add(card);
        add(ms);
        add(mini);
    }
    public static void main(String[] args) {

        new MiniStatement("");
    }
}