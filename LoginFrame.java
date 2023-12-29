import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginFrame extends JFrame
{
    public LoginFrame()
    {
        // create components
        JTextField tField = new JTextField("Username");
        JPasswordField pField = new JPasswordField("Password");
        JButton registerButton = new JButton("Register");
        JButton loginButton = new JButton("Login");

        // set bounds of components
        tField.setBounds(660, 200, 200,100);
        pField.setBounds(660, 350, 200, 100);
        registerButton.setBounds(360, 550, 300, 100);
        loginButton.setBounds(860, 550, 300, 100);

        // set layout of frame to null
        setLayout(null);

        // configure tField settings
        tField.setForeground(Color.GRAY);
        tField.setBackground(Color.DARK_GRAY);
        tField.setFont(new Font("Arial", Font.PLAIN, 25));
        tField.setHorizontalAlignment(SwingConstants.CENTER);

        // configure pField settings
        pField.setForeground(Color.GRAY);
        pField.setBackground(Color.DARK_GRAY);
        pField.setFont(new Font("Arial", Font.PLAIN, 25));
        pField.setHorizontalAlignment(SwingConstants.CENTER);
        pField.setEchoChar((char) 0);

        // configure registerButton settings
        registerButton.setFont(new Font("Arial", Font.PLAIN, 45));
        registerButton.setBackground(Color.DARK_GRAY);
        registerButton.setForeground(Color.GRAY);
        registerButton.setFocusPainted(false);

        // configure loginButton settings
        loginButton.setFont(new Font("Arial", Font.PLAIN, 45));
        loginButton.setBackground(Color.DARK_GRAY);
        loginButton.setForeground(Color.GRAY);
        loginButton.setFocusPainted(false);

        // configure Frame settings
        setSize(1920, 1080);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.DARK_GRAY);
        setTitle("Login Screen Prototype");
        setLocationRelativeTo(null);
        setVisible(true);

        // add components
        add(tField);
        add(pField);
        add(registerButton);
        add(loginButton);

        // setup action listeners for both tField and pField that remove/replace the text when they are focused/unfocused

        // setup an action listener to registerButton
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                tField.setVisible(false);
                registerButton.setVisible(false);
                loginButton.setVisible(false);
                //registerTField.setVisible(true);
                //confirmRegistrationButton.setVisible(true);
                //TODO: add the login info into logins.json 
            }
        });

        // setup an action listener to loginButton
        // check if the username in tField is present in logins.json
        // if not, show the error (in a JLabel)
        // if so, show the login successful screen

    }    
}