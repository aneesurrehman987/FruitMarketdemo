package Java;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {
    JTextField textField;
    JPasswordField jPasswordField;
    JButton  b1,b2;

    Login() {

        JLabel namelable= new JLabel("User name ");
        namelable.setBounds(40,20,100,30);
        namelable.setFont(new Font(" Tahoma",Font.BOLD,16));
        namelable.setForeground(Color.WHITE);
        add(namelable);

        JLabel pasword= new JLabel("Pasword ");
        pasword.setBounds(40,70,100,30);
        pasword.setFont(new Font(" Tahoma",Font.BOLD,16));
        pasword.setForeground(Color.WHITE);
        add(pasword);
        textField=new JTextField();
        textField.setBounds(150,20,150,30);
        textField.setFont(new Font("Tahoma ",Font.BOLD,15));
        textField.setBackground(new Color(255,179,0));
        add(textField);

// Adding the password
        jPasswordField =new JPasswordField();
        jPasswordField.setBounds(150,70,150,30);
        jPasswordField.setFont(new Font("Tahoma ",Font.BOLD,15));
        jPasswordField.setBackground(new Color(255,179,0));
        add(jPasswordField);

// Adding the Icon in this
        ImageIcon imageIcon = new ImageIcon( ClassLoader.getSystemResource("icon/login.png"));
        Image i1 =imageIcon.getImage().getScaledInstance(500,500,Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(i1);
        JLabel label=new JLabel(imageIcon1);
        label.setBounds(330,-40,400,300);
        add(label);
//button adding in this
        b1 = new JButton(" Login ");
        b1.setBounds(40,140,130,30);
        b1.setFont(new Font("serif",Font.BOLD,15));
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        add(b1);//passing b1
// Adding second button
        b2 = new JButton(" Cancel ");
        b2.setBounds(180,140,130,30);
        b2.setFont(new Font("serif",Font.BOLD,15));
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.addActionListener(this);
        add(b2);//passing b2




        getContentPane().setBackground(new Color(109,164,170));
        setSize(750,300);
        setLocation(400,270);
        setLayout(null);
        setVisible(true);


    }

    public static void main (String[]args){
        Login login = new Login();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
// This process fo log in
        if (e.getSource()== b1){
            try {
                conn c = new conn();
                String user = textField.getText();
                String pass;
                pass = jPasswordField.getText();


                String q = "SELECT * FROM login WHERE ID='" + user + "' AND PW='" + pass + "'";

                ResultSet resultSet = c.statement.executeQuery(q);

                if (resultSet.next()){
                    new Reception();
                    setVisible(false);
                }else{
                    JOptionPane.showMessageDialog(null,"Invalid");
                }

            }catch (Exception E){
                E.printStackTrace();

            }
        }else {
            System.exit(10);

        }

    }


    private class conn {
        public PreparedStatement statement;
    }

    private class Reception {
    }
}