import com.toedter.calendar.JDateChooser;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Statement;
import java.util.*;
public class SignUp_1 extends JFrame implements ActionListener
{
    JTextField tname; JTextField tfname; JTextField temail;
    JTextField tadd; JTextField tcity; JTextField tpin;
    JTextField tstate; JDateChooser dateChooser;
    JRadioButton male; JRadioButton female; JRadioButton married;
    JRadioButton unmarried; JRadioButton others;
    JButton next; long random; Random ran;
    SignUp_1()
    {
        setSize(850,800);
        setLayout(null);
        setVisible(true);
        setLocationRelativeTo(null);
        setTitle("Automated Teller Machine : Page 1. Personal Details ");
        getContentPane().setBackground(Color.WHITE);

        Random ran = new Random();
        long random = Math.abs((ran.nextLong() % 9000L) + 1000L);

        JLabel formno = new JLabel("Application Form No. "+ random);
        formno.setBounds(180,20,600,40);
        formno.setFont(new Font("Rale way",Font.BOLD,38));

        JLabel personaldetails = new JLabel("Page 1: Personal Details");
        personaldetails.setBounds(280,80,300,30);
        personaldetails.setFont(new Font("Rale way",Font.BOLD,25));

        JLabel name = new JLabel("Name :");
        name.setBounds(180,140,100,20);
        name.setFont(new Font("arial",Font.BOLD,20));

        tname = new JTextField();
        tname.setBounds(350,140,400,30);
        tname.setFont(new Font("arial",Font.BOLD,18));

        JLabel fname = new JLabel("Father's Name :");
        fname.setBounds(180,190,150,20);
        fname.setFont(new Font("arial",Font.BOLD,20));

        tfname = new JTextField();
        tfname.setBounds(350,190,400,30);
        tfname.setFont(new Font("arial",Font.BOLD,18));

        JLabel dob = new JLabel("Date Of Birth :");
        dob.setBounds(180,240,150,20);
        dob.setFont(new Font("arial",Font.BOLD,20));

        dateChooser = new JDateChooser();
        dateChooser.setBounds(350,240,400,30);
        dateChooser.setFont(new Font("arial",Font.BOLD,18));

        JLabel gender = new JLabel("Gender :");
        gender.setBounds(180,290,100,20);
        gender.setFont(new Font("arial",Font.BOLD,20));

        male = new JRadioButton("Male");
        male.setBounds(350,290,100,30);
        male.setFont(new Font("arial",Font.BOLD,18));
        male.setBackground(Color.WHITE);
        female = new JRadioButton("Female");
        female.setBounds(500,290,100,30);
        female.setFont(new Font("arial",Font.BOLD,18));
        female.setBackground(Color.WHITE);

        ButtonGroup Gendergroup = new ButtonGroup();
        Gendergroup.add(male);
        Gendergroup.add(female);

        JLabel email = new JLabel("Email Address :");
        email.setBounds(180,340,150,20);
        email.setFont(new Font("arial",Font.BOLD,20));

        temail = new JTextField();
        temail.setBounds(350,340,400,30);
        temail.setFont(new Font("arial",Font.BOLD,18));

        JLabel marital = new JLabel("Marital Status :");
        marital.setBounds(180,390,150,20);
        marital.setFont(new Font("arial",Font.BOLD,20));

        married = new JRadioButton("Married");
        married.setBounds(350,390,100,30);
        married.setFont(new Font("arial",Font.BOLD,18));
        married.setBackground(Color.WHITE);

        unmarried = new JRadioButton("Unmarried");
        unmarried.setBounds(500,390,120,30);
        unmarried.setFont(new Font("arial",Font.BOLD,18));
        unmarried.setBackground(Color.WHITE);

        others = new JRadioButton("Others");
        others.setBounds(650,390,100,30);
        others.setFont(new Font("arial",Font.BOLD,18));
        others.setBackground(Color.WHITE);

        ButtonGroup Marriedgroup = new ButtonGroup();
        Marriedgroup.add(married);
        Marriedgroup.add(unmarried);
        Marriedgroup.add(others);

        JLabel add = new JLabel("Address :");
        add.setBounds(180,440,100,20);
        add.setFont(new Font("arial",Font.BOLD,20));

        tadd = new JTextField();
        tadd.setBounds(350,440,400,30);
        tadd.setFont(new Font("arial",Font.BOLD,18));

        JLabel city = new JLabel("City :");
        city.setBounds(180,490,100,20);
        city.setFont(new Font("arial",Font.BOLD,20));

        tcity = new JTextField();
        tcity.setBounds(350,490,400,30);
        tcity.setFont(new Font("arial",Font.BOLD,18));

        JLabel pincode = new JLabel("Pin Code :");
        pincode.setBounds(180,540,120,20);
        pincode.setFont(new Font("arial",Font.BOLD,20));

        tpin = new JTextField();
        tpin.setBounds(350,540,400,30);
        tpin.setFont(new Font("arial",Font.BOLD,18));

        JLabel state = new JLabel("State :");
        state.setBounds(180,590,100,20);
        state.setFont(new Font("arial",Font.BOLD,20));

        tstate = new JTextField();
        tstate.setBounds(350,590,400,30);
        tstate.setFont(new Font("arial",Font.BOLD,18));

        next = new JButton("Next");
        next.setBounds(660,650,90,40);
        next.setFont(new Font("arial",Font.BOLD,20));
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);

        add(formno); add(personaldetails); add(name); add(fname);
        add(dob); add(gender); add(email); add(marital);
        add(add); add(city); add(pincode); add(state);

        add(tname); add(tfname); add(dateChooser); add(male);
        add(female); add(temail); add(married); add(unmarried);
        add(others); add(tadd); add(tcity); add(tpin);
        add(tstate); add(next);

        next.addActionListener(this);
    }
    public void actionPerformed(ActionEvent e)
    {
        try
        {
            String formno = "" + random; //long
            String name = tname.getText();
            String fname = tfname.getText();
            String dob = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
            String gender = null;
            if (male.isSelected()) {
                gender = "Male";
            } else if (female.isSelected()) {
                gender = "Female";
            }
            String email = temail.getText();
            String marital = null;
            if (married.isSelected()) {
                marital = "Married";
            } else if (unmarried.isSelected()) {
                marital = "Unmarried";
            } else {
                marital = "Others";
            }
            String address = tadd.getText();
            String city = tcity.getText();
            String pin = tpin.getText();
            String state = tstate.getText();

            if (name.equals("")) {
                JOptionPane.showMessageDialog(null, "Please fill the Name field");
            } else if (fname.equals("")) {
                JOptionPane.showMessageDialog(null, "Please fill the Father's name field");
            } else if (dob.equals("")) {
                JOptionPane.showMessageDialog(null, "Please fill the Date Of Birth field");
            } else if (gender.equals("")) {
                JOptionPane.showMessageDialog(null, "Please choose a Gender option");
            } else if (email.equals("")) {
                JOptionPane.showMessageDialog(null, "Please fill the Email address field");
            } else if (marital.equals("")) {
                JOptionPane.showMessageDialog(null, "Please choose a Marital status");
            } else if (address.equals("")) {
                JOptionPane.showMessageDialog(null, "Please fill the Address field");
            } else if (city.equals("")) {
                JOptionPane.showMessageDialog(null, "Please fill the City field");
            } else if (pin.equals("")) {
                JOptionPane.showMessageDialog(null, "Please fill the Pin Code field");
            } else if (state.equals("")) {
                JOptionPane.showMessageDialog(null, "Please fill the State field");
            } else {
                try {
                    Connection conn = ConnectionProvider.getConnnection();
                    String q2 = "insert into signup_1 values ('" + formno + "','" + name + "','" + fname + "','" + dob + "','" + gender + "','" + email + "','" + marital + "','" + address + "','" + city + "','" + pin + "','" + state + "')";
                    Statement stmt = conn.createStatement();
                    stmt.executeUpdate(q2);
                    System.out.println("Your data has been inserted...!");

                    setVisible(false);
                    new SignUp_2(formno).setVisible(true);

                    JOptionPane.showMessageDialog(null, "Your Personal Detail is stored successfully");
                } catch (Exception ex2) {
                    ex2.printStackTrace();
                }
//                if (e.getSource() == next)
//                {
//                    setVisible(false);
//                    new SignUp_2().setVisible(true);
//                }

            }
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }
    public static void main(String[] args)
    {
        new SignUp_1();
    }
}