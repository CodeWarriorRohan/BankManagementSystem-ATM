import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Transactions extends JFrame implements ActionListener
{
    JButton Deposit; JButton CW; JButton FC;
    JButton MS; JButton PC; JButton BE;
    JButton Exit; String pinnumber;
    Transactions(String pinnumber)
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

        JLabel l2 = new JLabel("Please select your Transaction");
        l2.setBounds(210,200,500,40);
        l2.setForeground(Color.WHITE);
        l2.setFont(new Font("System",Font.BOLD,16));

        Deposit = new JButton("Deposit");
        Deposit.setBounds(150,320,100,30);

        CW = new JButton("Cash Withdrawal");
        CW.setBounds(350,320,140,30);

        FC = new JButton("Fast Cash");
        FC.setBounds(150,360,100,30);

        MS = new JButton("Mini Statement");
        MS.setBounds(350,360,140,30);

        PC = new JButton("Pin Change");
        PC.setBounds(150,400,100,30);

        BE = new JButton("Balance Enquiry");
        BE.setBounds(350,400,140,30);

        Exit = new JButton("Exit");
        Exit.setBounds(350,440,140,30);

        add(il1);
        il1.add(l2); il1.add(Deposit); il1.add(CW);
        il1.add(FC); il1.add(MS); il1.add(PC);
        il1.add(BE); il1.add(Exit);

        Deposit.addActionListener(this);
        CW.addActionListener(this);
        FC.addActionListener(this);
        MS.addActionListener(this);
        PC.addActionListener(this);
        BE.addActionListener(this);
        Exit.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == Deposit)
        {
            setVisible(false);
            new Deposit(pinnumber).setVisible(true);
        }
        if (e.getSource() == CW)
        {
            setVisible(false);
            new Withdrawal(pinnumber).setVisible(true);
        }
        if (e.getSource() == FC)
        {
            setVisible(false);
            new FastCash(pinnumber).setVisible(true);
        }
        if (e.getSource() == MS)
        {
            new MiniStatement(pinnumber).setVisible(true);
        }
        if (e.getSource() == PC)
        {
            setVisible(false);
            new PinChange(pinnumber).setVisible(true);
        }
        if (e.getSource() == BE)
        {
            setVisible(false);
            new BalanceEnquiry(pinnumber).setVisible(true);
        }
        if (e.getSource() == Exit)
        {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
         new Transactions("");
    }
}