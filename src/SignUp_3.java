import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Statement;
import java.util.Random;

public class SignUp_3  extends JFrame implements ActionListener
{
    JRadioButton  jb1,jb2,jb3,jb4;
    JCheckBox c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11;
    JButton submit; JButton cancel;
    long random; String formno;
    SignUp_3(String formno)
    {
        this.formno = formno;
        setSize(850,800);
        setLayout(null);
        setVisible(true);
        setLocationRelativeTo(null);
        setTitle("Automated Teller Machine : Page 3. Account Details ");
        getContentPane().setBackground(Color.WHITE);

        JLabel accountdetails = new JLabel("Page 3: Account Details");
        accountdetails.setBounds(280,20,350,30);
        accountdetails.setFont(new Font("Rale way",Font.BOLD,25));

        JLabel type = new JLabel("Account Type :");
        type.setBounds(130,140,150,30);
        type.setFont(new Font("arial",Font.BOLD,20));

        jb1 = new JRadioButton("Saving Account");
        jb1.setBounds(350,140,200,30);
        jb1.setFont(new Font("arial",Font.BOLD,18));
        jb1.setBackground(Color.WHITE);

        jb2 = new JRadioButton("Current Account");
        jb2.setBounds(550,140,200,30);
        jb2.setFont(new Font("arial",Font.BOLD,18));
        jb2.setBackground(Color.WHITE);

        jb3 = new JRadioButton("Recurring Account");
        jb3.setBounds(350,170,200,30);
        jb3.setFont(new Font("arial",Font.BOLD,18));
        jb3.setBackground(Color.WHITE);

        jb4 = new JRadioButton("Fixed Deposit Account");
        jb4.setBounds(550,170,250,30);
        jb4.setFont(new Font("arial",Font.BOLD,18));
        jb4.setBackground(Color.WHITE);

        ButtonGroup accountgroup = new ButtonGroup();
        accountgroup.add(jb1);
        accountgroup.add(jb2);
        accountgroup.add(jb3);
        accountgroup.add(jb4);

        JLabel card = new JLabel("Card Number :");
        card.setBounds(130,240,150,30);
        card.setFont(new Font("arial",Font.BOLD,20));

        JLabel carddetails = new JLabel("Your 16 digits Card number");
        carddetails.setBounds(130,260,200,20);
        carddetails.setFont(new Font("arial",Font.BOLD,12));

        JLabel number = new JLabel("XXXX-XXXX-XXXX-9930");
        number.setBounds(350,240,300,30);
        number.setFont(new Font("arial",Font.BOLD,20));

//        Random ran = new Random();
//        long random = Math.abs((ran.nextLong() % 9859645239210000L) + 1000L);

        JLabel pin = new JLabel("Pin Number :");
        pin.setBounds(130,290,150,30);
        pin.setFont(new Font("arial",Font.BOLD,20));

        JLabel pindetails = new JLabel("Your 4 digits password");
        pindetails.setBounds(130,310,200,20);
        pindetails.setFont(new Font("arial",Font.BOLD,12));

        JLabel pinnum = new JLabel("XXXX");
        pinnum.setBounds(350,290,300,30);
        pinnum.setFont(new Font("arial",Font.BOLD,20));

        JLabel services = new JLabel("Services Required");
        services.setBounds(130,360,300,30);
        services.setFont(new Font("arial",Font.BOLD,20));

        c1 = new JCheckBox("ATM Card");
        c1.setBounds(130,400,150,20);
        c1.setFont(new Font("arial",Font.BOLD,18));
        c1.setBackground(Color.WHITE);

        c2 = new JCheckBox("Debit Card");
        c2.setBounds(130,440,150,20);
        c2.setFont(new Font("arial",Font.BOLD,18));
        c2.setBackground(Color.WHITE);

        c3 = new JCheckBox("Credit Card");
        c3.setBounds(130,480,150,20);
        c3.setFont(new Font("arial",Font.BOLD,18));
        c3.setBackground(Color.WHITE);

        c4 = new JCheckBox("Cheque Payments");
        c4.setBounds(130,520,200,20);
        c4.setFont(new Font("arial",Font.BOLD,18));
        c4.setBackground(Color.WHITE);

        c5 = new JCheckBox("Consultancy");
        c5.setBounds(130,550,150,20);
        c5.setFont(new Font("arial",Font.BOLD,18));
        c5.setBackground(Color.WHITE);

        c6 = new JCheckBox("Pass Book");
        c6.setBounds(350,400,150,20);
        c6.setFont(new Font("arial",Font.BOLD,18));
        c6.setBackground(Color.WHITE);

        c7 = new JCheckBox("Check Book");
        c7.setBounds(350,440,150,20);
        c7.setFont(new Font("arial",Font.BOLD,18));
        c7.setBackground(Color.WHITE);

        c8 = new JCheckBox("Internet Banking");
        c8.setBounds(350,480,200,20);
        c8.setFont(new Font("arial",Font.BOLD,18));
        c8.setBackground(Color.WHITE);

        c9 = new JCheckBox("Mobile Banking");
        c9.setBounds(350,520,200,20);
        c9.setFont(new Font("arial",Font.BOLD,18));
        c9.setBackground(Color.WHITE);

        c10 = new JCheckBox("E-Statements");
        c10.setBounds(350,550,200,20);
        c10.setFont(new Font("arial",Font.BOLD,18));
        c10.setBackground(Color.WHITE);

        c11 = new JCheckBox("I hereby declared that the above entered details are correct to the best of my knowledge");
        c11.setBounds(130,610,800,20);
        c11.setFont(new Font("arial",Font.BOLD,14));
        c11.setBackground(Color.WHITE);

        submit = new JButton("Submit");
        submit.setBounds(450,650,100,40);
        submit.setFont(new Font("arial",Font.BOLD,20));
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);

        cancel = new JButton("Cancel");
        cancel.setBounds(300,650,100,40);
        cancel.setFont(new Font("arial",Font.BOLD,20));
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);


        add(accountdetails);
        add(type); add(card); add(number); add(pin); add(pinnum);
        add(carddetails); add(pindetails); add(services);
        add(jb1); add(jb2); add(jb3); add(jb4);
        add(c1); add(c2); add(c3); add(c4); add(c5);
        add(c6); add(c7); add(c8); add(c9); add(c10); add(c11);
        add(submit); add(cancel);

        submit.addActionListener(this);
        cancel.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submit)
        {
            String AccType = "";
            if (jb1.isSelected())
            {
                AccType = "Saving Account";
            } else if (jb2.isSelected())
            {
                AccType = "Current Account";
            } else if (jb3.isSelected())
            {
                AccType = "Recurring Account";
            } else if (jb4.isSelected())
            {
                AccType = "Fixed Deposit Account";
            }

            Random random = new Random();
//            long random = Math.abs((ran.nextLong() % 9859645239210000L) + 1000L);
            String cardnumber = "" + Math.abs((random.nextLong() % 90000000L) + 5040936000000000L);

            String pinnum = ""+Math.abs((random.nextLong() % 9000L) + 1000L);

            if (AccType.equals(""))
            {
                JOptionPane.showMessageDialog(null,"Account Type is required");
            }

            String Facilities = "";
            {
                if (c1.isSelected())
                {
                    Facilities = Facilities + "ATM Card";
                }
                else if (c2.isSelected())
                {
                    Facilities = Facilities + "Debit Card";
                } else if (c3.isSelected())
                {
                    Facilities = Facilities + "Credit Card";

                }else if (c4.isSelected())
                {
                    Facilities = Facilities + "Cheque Payments";

                }else if (c5.isSelected())
                {
                    Facilities = Facilities + "Consultancy";

                }else if (c6.isSelected())
                {
                    Facilities = Facilities + "Pass Book";

                }else if (c7.isSelected())
                {
                    Facilities = Facilities + "Check Book";

                }else if (c8.isSelected())
                {
                    Facilities = Facilities + "Internet Banking";

                }else if (c9.isSelected())
                {
                    Facilities = Facilities + "Mobile Banking";

                }else if (c10.isSelected())
                {
                    Facilities = Facilities + "E-Statements";

                }

                try {
                    Connection conn = ConnectionProvider.getConnnection();
                    String q1 = "insert into signup_3 values('"+formno+"','"+AccType+"','"+cardnumber+"','"+pinnum+"','"+Facilities+"')";
                    String q2 = "insert into login values('"+formno+"','"+cardnumber+"','"+pinnum+"')";
                    Statement stmt = conn.createStatement();
                    stmt.executeUpdate(q1);
                    stmt.executeUpdate(q2);
                    System.out.println("Your data has been inserted...!");

                    JOptionPane.showMessageDialog(null, "Your Account has created $$"+"\n Card Number : "+cardnumber+ "\n Pin Code : "+pinnum+ "\n Thank you!!");

                    setVisible(false);
                    new Deposit(pinnum).setVisible(true);
                }
                catch (Exception ex)
                {
                    ex.printStackTrace();
                }
            }
        }
        if (e.getSource() == cancel)
        {
            setVisible(false);
            new Login().setVisible(true);
        }
    }

    public static void main(String[] args) {
         new SignUp_3("");
    }
}