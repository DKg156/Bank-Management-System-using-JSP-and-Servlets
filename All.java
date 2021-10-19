package openproject;
import java.awt.*;  
import javax.swing.*;  
import java.sql.*;
import javax.swing.table.DefaultTableModel;
public class All extends JFrame {
    DefaultTableModel model = new DefaultTableModel();
    Container cnt = this.getContentPane();
    JTable jtbl = new JTable(model);
    public All() {
        cnt.setLayout(new FlowLayout(FlowLayout.LEFT));
        model.addColumn("Acc no");
        model.addColumn("Name");
        model.addColumn("Acc Type");
        model.addColumn("Balance");
        setTitle("Show all accounts");
        setBounds(300, 90, 500, 500);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");  
            java.sql.Connection con=DriverManager.getConnection("jdbc:derby://localhost:1527/Bank","dhruv","dhruv"); 
            Statement stmt = con.createStatement( );
            ResultSet rs=stmt.executeQuery("select * from banktable");
            while(rs.next()){
                model.addRow(new Object[]{rs.getString(1), rs.getString(2),rs.getString(3),rs.getInt(4)});
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        JScrollPane pg = new JScrollPane(jtbl);
        cnt.add(pg);
        this.pack();
    }
}
      
    
