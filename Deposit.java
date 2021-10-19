package openproject;
import java.awt.*;  
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;  
import java.sql.*;

public class Deposit extends JFrame implements ActionListener{
    private Container c; 
    private JLabel title;  
    private JLabel mno; 
    private JTextField tmno;
    private JLabel add; 
    private JTextField am;
    private JButton sub; 
    private JLabel label; 
    private JTextArea tout; 
    public Deposit() 
    { 
        setTitle("Deposit"); 
        setBounds(300, 90, 500, 500); 
        setDefaultCloseOperation(DISPOSE_ON_CLOSE); 
        setResizable(false); 
  
        c = getContentPane(); 
        c.setLayout(null); 
  
        title = new JLabel("Deposit amount"); 
        title.setFont(new Font("Arial", Font.PLAIN, 20)); 
        title.setSize(300, 30); 
        title.setLocation(140, 30); 
        c.add(title); 
  
  
        mno = new JLabel("Enter Account no."); 
        mno.setFont(new Font("Arial", Font.PLAIN, 20)); 
        mno.setSize(200, 20); 
        mno.setLocation(50, 100); 
        c.add(mno); 
  
        tmno = new JTextField(); 
        tmno.setSize(150, 20); 
        tmno.setLocation(230, 100); 
        c.add(tmno); 
        
        add = new JLabel("Amount"); 
        add.setFont(new Font("Arial", Font.PLAIN, 20)); 
        add.setSize(200, 20); 
        add.setLocation(50, 150); 
        c.add(add); 
        
        am = new JTextField();  
        am.setSize(150, 20); 
        am.setLocation(130, 150); 
        c.add(am); 
  
        label = new JLabel(""); 
        label.setFont(new Font("Arial", Font.PLAIN, 20)); 
        label.setSize(500, 25); 
        label.setLocation(100, 400); 
        c.add(label); 
  
  
        sub = new JButton("Deposit"); 
        sub.setFont(new Font("Arial", Font.PLAIN, 15)); 
        sub.setSize(100, 20); 
        sub.setLocation(150, 320); 
        sub.addActionListener(this); 
        c.add(sub); 
        
        tout = new JTextArea(); 
        tout.setFont(new Font("Arial", Font.PLAIN, 15)); 
        tout.setSize(200, 100); 
        tout.setLocation(100, 200); 
        tout.setLineWrap(true); 
        tout.setEditable(false); 
        c.add(tout); 

        setVisible(true); 
    } 
    @Override
    public void actionPerformed(ActionEvent e) 
    { 
        if (e.getSource() == sub) { 
                try{  
                   
                 String accn = tmno.getText();
                  int bal = 0 ;
                 
                   Class.forName("org.apache.derby.jdbc.ClientDriver");  
                   java.sql.Connection con=DriverManager.getConnection("jdbc:derby://localhost:1527/Bank","dhruv","dhruv"); 
                   PreparedStatement stmtp=con.prepareStatement("select balance from banktable where accno = ?");  
                   stmtp.setString(1,accn);  
                  ResultSet rs=stmtp.executeQuery();
                  if(rs.next())
                  {  bal = rs.getInt(1); }
                  else throw new SQLException();
                  int dep = Integer.parseInt(am.getText());
                  bal = bal + dep ;
                  PreparedStatement stmtp2=con.prepareStatement("update banktable set balance = ? where accno = ?");
                  stmtp2.setInt(1,bal);  
                  stmtp2.setString(2,accn);  
                  int i=stmtp2.executeUpdate();
                 
                  PreparedStatement stmtp3=con.prepareStatement("select * from banktable where accno = ?");  
                   stmtp3.setString(1,accn);  
                  ResultSet rs2=stmtp3.executeQuery();
                  while(rs2.next())
                  {  tout.setText("Acc. no: "+rs2.getString(1)+"\n"+"Name: "+rs2.getString(2)+"\n"+"Acc Type: "+rs2.getString(3)+"\n"+"Balance: "+rs2.getInt(4)); }
                   label.setText("Account credited"); 
                   con.close();
                   }catch(Exception ex){ 
                      label.setText("Sorry, an exception occured.."); 
                      System.out.println(ex); }
               }
           
        }

    }
    
