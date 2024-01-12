import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Statement;
public class SignUp_2 extends JFrame implements ActionListener
{
    JTextField tfpn; JTextField tfaadhaar;
    JRadioButton ayes; JRadioButton ano; JRadioButton eyes; JRadioButton eno;
    JButton next; long random;
    String formno;

    JComboBox jc1; JComboBox jc2; JComboBox jc3; JComboBox jc4; JComboBox jc5;
    SignUp_2(String formno)
    {
        this.formno = formno;
        setSize(850,800);
        setLayout(null);
        setVisible(true);
        setLocationRelativeTo(null);
        setTitle("Automated Teller Machine : Page 2. Additional Details ");
        getContentPane().setBackground(Color.WHITE);

        JLabel additionaldetails = new JLabel("Page 2: Additional Details");
        additionaldetails.setBounds(280,20,350,30);
        additionaldetails.setFont(new Font("Rale way",Font.BOLD,25));

        JLabel religion = new JLabel("Religion :");
        religion.setBounds(180,140,100,30);
        religion.setFont(new Font("arial",Font.BOLD,20));

        String rel[] = {"Hindu","Muslim","Sikh","Christian","Others"};
        jc1 = new JComboBox<>(rel);
        jc1.setBounds(350,140,400,30);
        jc1.setFont(new Font("arial",Font.BOLD,18));
        jc1.setBackground(Color.WHITE);

        JLabel  category = new JLabel("Category :");
        category.setBounds(180,190,100,30);
        category.setFont(new Font("arial",Font.BOLD,20));

        String cate[] = {"General","OBC","SC","ST","Minority"};
        jc2 = new JComboBox<>(cate);
        jc2.setBounds(350,190,400,30);
        jc2.setFont(new Font("arial",Font.BOLD,18));
        jc2.setBackground(Color.WHITE);

        JLabel income = new JLabel("Income :");
        income.setBounds(180,240,100,20);
        income.setFont(new Font("arial",Font.BOLD,20));

        String inc[] = {"< 1,50,000","< 2,50,000","< 5,00,000","Upto 10,00,000","None"};
        jc3 = new JComboBox<>(inc);
        jc3.setBounds(350,240,400,30);
        jc3.setFont(new Font("arial",Font.BOLD,18));
        jc3.setBackground(Color.WHITE);

        JLabel eq1 = new JLabel("Educational ");
        JLabel eq2 = new JLabel("Qualification :");
        eq1.setBounds(180,290,150,20);
        eq2.setBounds(180,310,200,30);
        eq1.setFont(new Font("arial",Font.BOLD,20));
        eq2.setFont(new Font("arial",Font.BOLD,20));

        String edu[] = {"High School","Intermediate","Graduation","Post Graduation","Ph.D","None Literate"};
        jc4 = new JComboBox<>(edu);
        jc4.setBounds(350,310,400,30);
        jc4.setFont(new Font("arial",Font.BOLD,18));
        jc4.setBackground(Color.WHITE);

        JLabel occupation = new JLabel("Occupation :");
        occupation.setBounds(180,360,150,30);
        occupation.setFont(new Font("arial",Font.BOLD,20));

        String occu[] = {"Student","Salaried","Self Employed","Business","Retired","Others"};
        jc5 = new JComboBox<>(occu);
        jc5.setBounds(350,360,400,30);
        jc5.setFont(new Font("arial",Font.BOLD,18));
        jc5.setBackground(Color.WHITE);

        JLabel pn = new JLabel("Pan Card No. :");
        pn.setBounds(180,410,150,20);
        pn.setFont(new Font("arial",Font.BOLD,20));

        tfpn = new JTextField();
        tfpn.setBounds(350,410,400,30);
        tfpn.setFont(new Font("arial",Font.BOLD,18));

        JLabel ad = new JLabel("Aadhaar No. :");
        ad.setBounds(180,460,150,20);
        ad.setFont(new Font("arial",Font.BOLD,20));

        tfaadhaar = new JTextField();
        tfaadhaar.setBounds(350,460,400,30);
        tfaadhaar.setFont(new Font("arial",Font.BOLD,18));

        JLabel seniorcity = new JLabel("Senior Citizen :");
        seniorcity.setBounds(180,510,150,20);
        seniorcity.setFont(new Font("arial",Font.BOLD,20));

        ayes = new JRadioButton("Yes");
        ayes.setBounds(350,510,100,30);
        ayes.setFont(new Font("arial",Font.BOLD,18));
        ayes.setBackground(Color.WHITE);
        ano = new JRadioButton("No");
        ano.setBounds(500,510,100,30);
        ano.setFont(new Font("arial",Font.BOLD,18));
        ano.setBackground(Color.WHITE);

        ButtonGroup seniorgroup = new ButtonGroup();
        seniorgroup.add(ayes);
        seniorgroup.add(ano);

        JLabel exixtacc = new JLabel("Existing Acc. :");
        exixtacc.setBounds(180,560,150,20);
        exixtacc.setFont(new Font("arial",Font.BOLD,20));

        eyes = new JRadioButton("Yes");
        eyes.setBounds(350,560,100,30);
        eyes.setFont(new Font("arial",Font.BOLD,18));
        eyes.setBackground(Color.WHITE);
        eno = new JRadioButton("No");
        eno.setBounds(500,560,100,30);
        eno.setFont(new Font("arial",Font.BOLD,18));
        eno.setBackground(Color.WHITE);

        ButtonGroup Accgroup = new ButtonGroup();
        Accgroup.add(eyes);
        Accgroup.add(eno);

        next = new JButton("Next");
        next.setBounds(660,630,90,40);
        next.setFont(new Font("arial",Font.BOLD,20));
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);

        add(additionaldetails); add(religion); add(category); add(income); add(eq1);
        add(eq2); add(occupation); add(pn); add(ad);
        add(seniorcity); add(exixtacc);

        add(jc1); add(jc2); add(jc3); add(jc4); add(jc5);
        add(tfpn); add(tfaadhaar); add(ayes); add(ano);
        add(eyes); add(eno); add(next);

        next.addActionListener(this);
    }
    public void actionPerformed(ActionEvent e)
    {
        try
        {
            String formno = "" + random; //long
            String sreligion = (String) jc1.getSelectedItem();
            String scategory = (String) jc2.getSelectedItem();
            String sincome = (String) jc3.getSelectedItem();
            String seq = (String) jc4.getSelectedItem();

            String soccupation = (String) jc5.getSelectedItem();
            String spn = tfpn.getText();
            String saadhaar = tfaadhaar.getText();
            String sseniorcity = null;
            if (ayes.isSelected()) {
                sseniorcity = "Yes";
            } else if (ano.isSelected()) {
                sseniorcity = "No";
            }
            String nexistingacc = null;
            if (ayes.isSelected()) {
                nexistingacc = "Yes";
            } if(ano.isSelected()) {
                nexistingacc = "No";
            }
            if (jc1.equals("")) {
                JOptionPane.showMessageDialog(null, "Please choose a Religion option");
            } else if (jc2.equals("")) {
                JOptionPane.showMessageDialog(null, "Please choose a Category option");
            } else if (jc3.equals("")) {
                JOptionPane.showMessageDialog(null, "Please choose a Educational Qualification option");
            } else if (jc4.equals("")) {
                JOptionPane.showMessageDialog(null, "Please choose a Income option");
            } else if (jc5.equals("")) {
                JOptionPane.showMessageDialog(null, "Please fill Occupation field");
            } else if (tfpn.equals("")) {
                JOptionPane.showMessageDialog(null, "Please fill Pan No. field");
            } else if (tfaadhaar.equals("")) {
                JOptionPane.showMessageDialog(null, "Please fill the Aadhaar field");
            }
            else {
                try {
                    Connection conn = ConnectionProvider.getConnnection();
                    String q2 = "insert into signup_2 values ('" + formno + "','" + sreligion + "','" + scategory + "','" + sincome + "','" + seq + "','" + soccupation + "','" + spn + "','" + saadhaar + "','" + sseniorcity + "','" + nexistingacc + "')";
                    Statement stmt = conn.createStatement();
                    stmt.executeUpdate(q2);
                    System.out.println("Your data has been inserted...!");

                    setVisible(false);
                    new SignUp_3(formno).setVisible(true);

                    JOptionPane.showMessageDialog(null, "Your Additional Detail is stored successfully");
                } catch (Exception ex2) {
                    ex2.printStackTrace();
                }
//                if (e.getSource() == next)
//                {
//                    setVisible(false);
//                    new SignUp_3().setVisible(true);
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
        new SignUp_2("");
    }
}
