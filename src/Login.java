import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Login extends JFrame implements ActionListener
{
//    Connection conn = ConnectionProvider.getConnnection();
    JButton login; JButton edit; JButton signup;
    JTextField tf1; JPasswordField pf2;
    Login()
    {
        setSize(800,550);
        setLayout(null);
        setVisible(true);
        setLocationRelativeTo(null);
        setTitle("Automated Teller Machine : Login page");
        getContentPane().setBackground(Color.WHITE);

        Container c = getContentPane();
        JLabel il1 = new JLabel();
        il1.setIcon(new ImageIcon("C:\\\\Users\\\\intel\\\\IdeaProjects\\\\BankManagementSystem\\\\src\\\\icons\\\\logo6.jpg"));
        Dimension size = il1.getPreferredSize();
        il1.setBounds(160,30,size.width, size.height);

        JLabel jl1 = new JLabel("Welcome To ATM");
        jl1.setFont(new Font("arial",Font.BOLD,35));
        jl1.setBounds(310,30,300,100);

        JLabel jl2 = new JLabel("Card Number :");
        jl2.setFont(new Font("arial",Font.BOLD,25));
        jl2.setBounds(160,150,200,40);

        JLabel jl3 = new JLabel("Pin Number:");
        jl3.setFont(new Font("arial",Font.BOLD,25));
        jl3.setBounds(160,230,150,40);

        tf1 = new JTextField();
        tf1.setBounds(400,150,300,40);
        tf1.setFont(new Font("arial",Font.BOLD,20));

        pf2 = new JPasswordField();
        pf2.setBounds(400,230,300,40);
        pf2.setFont(new Font("arial",Font.BOLD,20));

        login = new JButton("SIGN IN");
        login.setBounds(250,350,130,40);
        login.setFont(new Font("arial",Font.BOLD,20));
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);

        edit = new JButton("EDIT");
        edit.setBounds(400,350,130,40);
        edit.setFont(new Font("arial",Font.BOLD,20));
        edit.setBackground(Color.BLACK);
        edit.setForeground(Color.WHITE);

        signup = new JButton("SIGN UP");
        signup.setBounds(250,410,280,40);
        signup.setFont(new Font("arial",Font.BOLD,20));
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.WHITE);

        add(il1); add(jl1); add(jl2); add(jl3);
        add(tf1); add(pf2); add(login); add(edit);
        add(signup);

        login.addActionListener(this);
        edit.addActionListener(this);
        signup.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == login)
        {
            try {
                Connection conn = ConnectionProvider.getConnnection();
                String cardnumber = tf1.getText();
                String pinnumber = pf2.getText();
                String q = "select * from login where Card_Number = '"+cardnumber+"' and Pin_Number = '"+pinnumber+"'";

                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(q);
                if (rs.next())
                {
                    setVisible(false);
                    new Transactions(pinnumber).setVisible(true);
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"Incorrect Card Number or Pin");
                }

            }catch (Exception ex)
            {
                ex.printStackTrace();
            }
        }
        if (e.getSource() == edit)
        {
            tf1.setText(null);
            pf2.setText(null);
        }
        if (e.getSource() == signup)
        {
            setVisible(false);
            new SignUp_1().setVisible(true);
        }
    }
    public static void main(String[] args)
    {
        new Login();
    }
}