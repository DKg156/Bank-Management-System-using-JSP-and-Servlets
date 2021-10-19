package openproject;
import java.awt.*;  
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;  
import java.sql.*;

public class Check extends JFrame implements ActionListener{
    private Container c; 
    private JLabel title;  
    private JLabel mno; 
    private JTextField tmno;
    private JButton sub; 
    private JLabel label; 
    private JTextArea tout; 
    public Check() 
    { 
        setTitle("Check details"); 
        setBounds(300, 90, 500, 500); 
        setDefaultCloseOperation(DISPOSE_ON_CLOSE); 
        setResizable(false); 
  
        c = getContentPane(); 
        c.setLayout(null); 
  
        title = new JLabel("Check account details"); 
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
        
        label = new JLabel(""); 
        label.setFont(new Font("Arial", Font.PLAIN, 20)); 
        label.setSize(500, 25); 
        label.setLocation(100, 400); 
        c.add(label); 
  
  
        sub = new JButton("Submit"); 
        sub.setFont(new Font("Arial", Font.PLAIN, 15)); 
        sub.setSize(100, 20); 
        sub.setLocation(150, 320); 
        sub.addActionListener(this); 
        c.add(sub); 
        
        tout = new JTextArea(); 
        tout.setFont(new Font("Arial", Font.PLAIN, 15)); 
        tout.setSize(200, 100); 
        tout.setLocation(100, 170); 
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
                 label.setText("");
                   Class.forName("org.apache.derby.jdbc.ClientDriver");  
                   java.sql.Connection con=DriverManager.getConnection("jdbc:derby://localhost:1527/Bank","dhruv","dhruv"); 
                   PreparedStatement stmtp=con.prepareStatement("select * from banktable where accno = ?");  
                   stmtp.setString(1,accn);  
                   ResultSet rs=stmtp.executeQuery();
                   if(rs.next())
                  {  tout.setText("Acc. no: "+rs.getString(1)+"\n"+"Name: "+rs.getString(2)+"\n"+"Acc Type: "+rs.getString(3)+"\n"+"Balance: "+rs.getInt(4)); }
                  else    { tout.setText(""); 
                       label.setText("Sorry, account doesn't exist..");  }
                   
                   con.close();
                   }catch(Exception ex){ 
                      label.setText("Sorry, an exception occured.."); 
                      System.out.println(ex); }
               }
           
        }

    }