package openproject;
import java.awt.*;  
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;  
public class HomeScreen extends JFrame implements ActionListener{
    private Container c; 
    private JLabel title; 
    private JButton newb;
    private JButton dep;
    private JButton with;
    private JButton check;
    private JButton del;
    private JButton selectall;
    
 public HomeScreen()
 {      setTitle("Home"); 
        setBounds(300, 90, 500, 500); 
        setDefaultCloseOperation(EXIT_ON_CLOSE); 
        setResizable(false); 
  
        c = getContentPane(); 
        c.setLayout(null); 
        title = new JLabel("Bank Management System"); 
        title.setFont(new Font("Arial", Font.PLAIN, 20)); 
        title.setSize(300, 30); 
        title.setLocation(130, 30); 
        c.add(title); 
        newb = new JButton("Create a new account"); 
        newb.setFont(new Font("Arial", Font.PLAIN, 15)); 
        newb.setSize(200, 30); 
        newb.setLocation(150, 80); 
        newb.addActionListener(this); 
        c.add(newb); 
        setVisible(true);
        dep = new JButton("Deposit"); 
        dep.setFont(new Font("Arial", Font.PLAIN, 15)); 
        dep.setSize(200, 30); 
        dep.setLocation(150, 140); 
        dep.addActionListener(this); 
        c.add(dep); 
        setVisible(true);
        with= new JButton("Withdraw"); 
        with.setFont(new Font("Arial", Font.PLAIN, 15)); 
        with.setSize(200, 30); 
        with.setLocation(150, 200); 
        with.addActionListener(this); 
        c.add(with); 
        setVisible(true);
        check= new JButton("Check acc details"); 
        check.setFont(new Font("Arial", Font.PLAIN, 15)); 
        check.setSize(200, 30); 
        check.setLocation(150, 260); 
        check.addActionListener(this); 
        c.add(check); 
        setVisible(true);
        del= new JButton("Delete account"); 
        del.setFont(new Font("Arial", Font.PLAIN, 15)); 
        del.setSize(200, 30); 
        del.setLocation(150, 320); 
        del.addActionListener(this); 
        c.add(del); 
        setVisible(true);
        selectall= new JButton("Show all accounts"); 
        selectall.setFont(new Font("Arial", Font.PLAIN, 15)); 
        selectall.setSize(200, 30); 
        selectall.setLocation(150, 380); 
        selectall.addActionListener(this); 
        c.add(selectall); 
        setVisible(true);
 }
    @Override
 public void actionPerformed(ActionEvent e) 
    { 
        if (e.getSource() == newb) { 
          NewAccount acc = new NewAccount();
           
        }
        if (e.getSource() == dep) { 
          Deposit d = new Deposit();
           
        }
         if (e.getSource() == with) { 
          Withdraw w = new Withdraw();
           
        }
         if (e.getSource() == check) { 
          Check c = new Check();
           
        }
         if (e.getSource() == del) { 
          DeleteAc d = new DeleteAc();
           
        }
         if (e.getSource() == selectall) { 
          All a = new All();
           
        }
    } 
    
}
