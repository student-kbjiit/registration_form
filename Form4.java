import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.awt.*;
public class Form4
{
public static void main(String args[])
{
JFrame f = new JFrame();
//METHOD-1 : Using Color Fields
f.getContentPane().setBackground(Color.CYAN);

JLabel lb = new JLabel("Registration Form");
lb.setFont(new Font("Arial", Font.PLAIN, 32)); //Creating an Arial Font Style with size 30 
lb.setBounds(350,5,300,75);

JLabel lb2 = new JLabel("Name   :");
lb2.setFont(new Font("Arial", Font.PLAIN, 22)); 
lb2.setBounds(130,80,200,50);
JLabel lb3 = new JLabel("mobile no. :");
lb3.setFont(new Font("Arial", Font.PLAIN, 22));
lb3.setBounds(130,130,200,50);
JLabel lb4 = new JLabel("Gender  :");
lb4.setFont(new Font("Arial", Font.PLAIN, 22)); 
lb4.setBounds(130,180,200,50);
JLabel lb5 = new JLabel("DOB     :");
lb5.setFont(new Font("Arial", Font.PLAIN, 22)); 
lb5.setBounds(130,230,200,50);
JLabel lb6 = new JLabel("Address  :");
lb6.setFont(new Font("Arial", Font.PLAIN, 22)); 
lb6.setBounds(130,280,200,50);

JTextField tf = new JTextField();
tf.setFont(new Font("Arial", Font.PLAIN, 22)); 
tf.setBounds(300,80,250,35);
JTextField tf2 = new JTextField();
tf2.setFont(new Font("Arial", Font.PLAIN, 22));
tf2.setBounds(300,130,200,35);
JRadioButton r1 = new JRadioButton("male");
r1.setFont(new Font("Arial", Font.PLAIN, 22));
r1.setBounds(300,180,100,35);
JRadioButton r2 = new JRadioButton("female");
r2.setFont(new Font("Arial", Font.PLAIN, 22));
r2.setBounds(450,180,100,35);

SpinnerModel value1 = new SpinnerNumberModel(1,1,31,1);
JSpinner s1 = new JSpinner(value1);
s1.setBounds(300,230,50,35);

SpinnerModel value2 = new SpinnerNumberModel(1,1,12,1);
JSpinner s2 = new JSpinner(value2);
s2.setBounds(360,230,50,35);

SpinnerModel value3 = new SpinnerNumberModel(2000,2000,2010,1);
JSpinner s3 = new JSpinner(value3);
s3.setBounds(420,230,50,35);

JTextArea a1 = new JTextArea();
a1.setFont(new Font("Arial", Font.PLAIN, 22));
a1.setBounds(300,280,250,200);

JCheckBox cb = new JCheckBox("Accept tearms and conditions");
cb.setFont(new Font("Arial", Font.PLAIN, 22));
cb.setBounds(300,500,350,35);

JButton b1 = new JButton("Register");
b1.setFont(new Font("Arial", Font.PLAIN, 22));
b1.setBounds(300,570,120,35);
b1.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent e){
try{
Class.forName("oracle.jdbc.driver.OracleDriver");
Connection con=DriverManager.getConnection("jdbc:Oracle:thin:@localhost:1521:XE","sysdba","admin@123");
Statement stmt = con.createStatement();
String query="insert into form4 values(?,?,?,?)";
PreparedStatement ps = con.prepareStatement(query);
ps.setString(1,tf.getText());
ps.setInt(2, Integer.parseInt(tf2.getText()));
if(r1.isSelected())
  ps.setString(3,r1.getText());
else
  ps.setString(3,r2.getText());
ps.setString(4,a1.getText());

int i = ps.executeUpdate();
}catch(Exception e1)
{
System.out.println(e1);
}
}
});

JButton b2 = new JButton("Reset");
b2.setFont(new Font("Arial", Font.PLAIN, 22));
b2.setBounds(450,570,120,35);

b2.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent e)
{
tf.setText("");
tf2.setText("");
a1.setText("");
if(r1.isSelected())
 r1.setSelected(false);
else
 r2.setSelected(false);
cb.setSelected(false);
}
});
f.add(b1);f.add(b2);
f.add(lb);
f.add(lb2);
f.add(lb3);f.add(lb4);f.add(lb5);f.add(lb6);
f.add(tf);f.add(tf2);
f.add(r1);f.add(r2);
f.add(s1);f.add(s2);f.add(s3);
f.add(a1);
f.add(cb);
f.setSize(400,400);
f.setLayout(null);
f.setVisible(true);
}
}