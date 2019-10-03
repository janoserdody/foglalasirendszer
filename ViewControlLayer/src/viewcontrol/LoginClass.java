package viewcontrol;

import javax.swing.*;
import java.awt.*;

public class LoginClass extends JFrame {
    JPanel panel;
    JLabel titleLabel;
    JLabel nameLabel;
    JTextField nameTextField;
    JLabel passwLabel;
    JTextField passwTextField;
    JButton registrationButton;
    FlowLayout flo;

    public  LoginClass(){
        super("Sign in");
        this.setSize(400,550);
        Dimension tLabelSize=new Dimension(250,60);
        Dimension tFieldSize=new Dimension(200,20);
        Dimension lSize=new Dimension(150,20);
        Font tileFont=new Font("Segue UI", Font.BOLD,20);

        panel=(JPanel) this.getContentPane();
        flo=new FlowLayout();
        panel.setLayout(flo);

        titleLabel=new JLabel("Sign in or registration");
        titleLabel.setPreferredSize(tLabelSize);
        titleLabel.setFont(tileFont);
        //titleLabel.setBounds(100,50,250,40);
        nameLabel=new JLabel("Name:");
        nameLabel.setPreferredSize(lSize);
        nameTextField=new JTextField("Name");
        nameTextField.setPreferredSize(tFieldSize);
        passwLabel=new JLabel("Password:");
        passwLabel.setPreferredSize(lSize);
        passwTextField=new JTextField("Password");
        passwTextField.setPreferredSize(tFieldSize);
        registrationButton=new JButton("Registration");
        panel.add(titleLabel);
        panel.add(nameLabel);
        panel.add(nameTextField);
        panel.add(passwLabel);
        panel.add(passwTextField);
        panel.add(registrationButton);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        super.setVisible(true);
    }

}
