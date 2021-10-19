package openproject;
import java.awt.*;  
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;  
import java.sql.*;
public class NewAccount extends JFrame implements ActionListener {  
    private Container c; 
    private JLabel title; 
    private JLabel name; 
    private JTextField tname; 
    private JLabel mno; 
    private JTextField tmno; 
    private JLabel type; 
    private JRadioButton savings; 
    private JRadioButton current; 
    private ButtonGroup typegp; 
    private JLabel add; 
     private JTextField open;
    private JButton sub; 
    private JButton reset; 
    private JLabel label; 

    public NewAccount() 
    { 
        setTitle("New Account"); 
        setBounds(300, 90, 500, 500); 
        setDefaultCloseOperation(DISPOSE_ON_CLOSE); 
        setResizable(false); 
  
        c = getContentPane(); 
        c.setLayout(null); 
  
        title = new JLabel("Add new customer account"); 
        title.setFont(new Font("Arial", Font.PLAIN, 20)); 
        title.setSize(300, 30); 
        title.setLocation(140, 30); 
        c.add(title); 
  
        name = new JLabel("Name"); 
        name.setFont(new Font("Arial", Font.PLAIN, 20)); 
        name.setSize(100, 20); 
        name.setLocation(120, 100); 
        c.add(name); 
  
        tname = new JTextField(); 
        tname.setSize(190, 20); 
        tname.setLocation(200, 100); 
        c.add(tname); 
  
        mno = new JLabel("Account no."); 
        mno.setFont(new Font("Arial", Font.PLAIN, 20)); 
        mno.setSize(190, 20); 
        mno.setLocation(100, 150); 
        c.add(mno); 
  
        tmno = new JTextField(); 
        tmno.setSize(150, 20); 
        tmno.setLocation(210, 150); 
        c.add(tmno); 
  
        type = new JLabel("Account type"); 
        type.setFont(new Font("Arial", Font.PLAIN, 20)); 
        type.setSize(140, 20); 
        type.setLocation(100, 200); 
        c.add(type); 
  
        savings = new JRadioButton("Savings"); 
        savings.setFont(new Font("Arial", Font.PLAIN, 15)); 
        savings.setSelected(true); 
        savings.setSize(80, 20); 
        savings.setLocation(220, 200); 
        c.add(savings); 
  
        current = new JRadioButton("Current"); 
        current.setFont(new Font("Arial", Font.PLAIN, 15)); 
        current.setSelected(false); 
        current.setSize(80, 20); 
        current.setLocation(300, 200); 
        c.add(current); 
  
        typegp = new ButtonGroup(); 
        typegp.add(savings); 
        typegp.add(current); 
  
        add = new JLabel("Opening balance"); 
        add.setFont(new Font("Arial", Font.PLAIN, 20)); 
        add.setSize(200, 20); 
        add.setLocation(100, 250); 
        c.add(add); 
        
        open = new JTextField();  
        open.setSize(150, 20); 
        open.setLocation(260, 250); 
        c.add(open); 
       
        label = new JLabel(""); 
        label.setFont(new Font("Arial", Font.PLAIN, 20)); 
        label.setSize(500, 25); 
        label.setLocation(100, 400); 
        c.add(label); 
  
  
        sub = new JButton("Create"); 
        sub.setFont(new Font("Arial", Font.PLAIN, 15)); 
        sub.setSize(100, 20); 
        sub.setLocation(150, 320); 
        sub.addActionListener(this); 
        c.add(sub); 
  
        reset = new JButton("Reset"); 
        reset.setFont(new Font("Arial", Font.PLAIN, 15)); 
        reset.setSize(100, 20); 
        reset.setLocation(270, 320); 
        reset.addActionListener(this); 
        c.add(reset); 
  
  
        setVisible(true); 
    } 
  
    // method actionPerformed() 
    // to get the action performed 
    // by the user and act accordingly 
    @Override
    public void actionPerformed(ActionEvent e) 
    { 
        if (e.getSource() == sub) { 
               if((tname.getText().isEmpty())||(tmno.getText().isEmpty())||(open.getText().isEmpty()))
               { label.setText("Please fill all the details...");  }
               else {
                   
                   
                   
                   String accno = tmno.getText();
                   String name = tname.getText();
                   String data ;
                   int bal = Integer.parseInt(open.getText());
                   if (savings.isSelected()) 
                   { data = "Savings";}
                   else data = "Current";
                  try{   Class.forName("org.apache.derby.jdbc.ClientDriver");  
                   java.sql.Connection con=DriverManager.getConnection("jdbc:derby://localhost:1527/Bank","dhruv","dhruv"); 
                   PreparedStatement stmtp=con.prepareStatement("insert into banktable values(?,?,?,?)");  
                   stmtp.setString(1,accno);  
                   stmtp.setString(2,name);  
                   stmtp.setString(3,data);  
                   stmtp.setInt(4,bal);
                   int i=stmtp.executeUpdate();
                   label.setText("Account successfully created.."); 
                   sub.setEnabled(false);
                   con.close();
                   }catch(Exception ex){ 
                      label.setText("Sorry, an exception occured.."); 
                      System.out.println(ex); }  
               }
           
        }
  
        if (e.getSource() == reset) { 
            String def = ""; 
            tname.setText(def);  
            tmno.setText(def); 
            open.setText(def);
            label.setText(def); 
            sub.setEnabled(true);
        } 
    } 
}

