import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import org.json.simple.JSONObject;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;

public class LoginFrame extends JFrame
{
    private JSONObject loginsObject = new JSONObject();

    public LoginFrame() throws IOException
    {
        // setup loginsObject
        loginsObject.put("Username", "Password");


        // create components

        // Main Screen Components
        JTextField tField = new JTextField("Username");
        JPasswordField pField = new JPasswordField("Password");
        JButton registerButton = new JButton("Register");
        JButton loginButton = new JButton("Login");
        // Register Screen Components
        JTextField registerTField = new JTextField("Register Username");
        JPasswordField registerPField = new JPasswordField("Register Password");
        JButton confirmRegistrationButton = new JButton("Confirm Registration");
        // Error Boxes
        JLabel emptyFieldError = new JLabel("Please fill in all boxes!");
        JLabel userExistsError = new JLabel("This username already exists! Please login!");
        JLabel wrongPasswordError = new JLabel("Password is incorrect!");
        JLabel userNoExistError = new JLabel("User doesn't exist");
        // Login Screen Components
        JLabel loginSuccessful = new JLabel("Login Successful!");

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
        registerButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                tField.setVisible(false);
                pField.setVisible(false);
                registerButton.setVisible(false);
                loginButton.setVisible(false);
                registerTField.setVisible(true);
                registerPField.setVisible(true);
                confirmRegistrationButton.setVisible(true);

                // on confirm registration:
                // loginsObject.put(registerTField.getText(), registerPField.getPassword());
                // try{writeToLogins(loginsObject.toJSONString());}catch(IOException e1){}
            }
        });

        //TODO: Setup register screen component listeners

        // setup action listener to loginButton
        loginButton.addActionListener(new ActionListener()
        {
            
            @Override
            public void actionPerformed(ActionEvent e)
            {
                if(!loginsObject.containsKey(tField.getText().strip().toLowerCase()))
                {
                    userNoExistError.setVisible(true);
                    try
                    {
                        Thread.sleep(2000);
                        userNoExistError.setVisible(false);
                    }
                    catch(InterruptedException e1){}
                }
                else if(tField.getText().equals("") || pField.getPassword().equals(""))
                {
                    emptyFieldError.setVisible(true);try
                    {
                        Thread.sleep(2000);
                        emptyFieldError.setVisible(false);
                    }
                    catch(InterruptedException e1){}
                }
                else if(!loginsObject.get(tField.getText().strip().toLowerCase()).equals(pField.getPassword()))
                {
                    wrongPasswordError.setVisible(true);
                    try
                    {
                        Thread.sleep(2000);
                        wrongPasswordError.setVisible(false);
                    }
                    catch(InterruptedException e1){}
                }
                else
                {
                    tField.setVisible(false);
                    pField.setVisible(false);
                    registerButton.setVisible(false);
                    loginButton.setVisible(false);
                    loginSuccessful.setVisible(true);
                }
            }
        });

    }  
    
    // writes login info to logins.json
    public static void writeToLogins(String JSONString) throws IOException
    {
        FileWriter fWrite = new FileWriter("./logins.json");
        fWrite.write(JSONString);
        fWrite.close();
    }
}
