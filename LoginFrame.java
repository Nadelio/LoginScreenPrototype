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

    // create components-------------------------------------------------------------------------------|

    // Main Screen Components
    public JTextField tField = new JTextField("Username");
    public JPasswordField pField = new JPasswordField("Password");
    public JButton registerButton = new JButton("Register");
    public JButton loginButton = new JButton("Login");
    // Register Screen Components
    public JTextField registerTField = new JTextField("Register Username");
    public JPasswordField registerPField = new JPasswordField("Register Password");
    public JButton confirmRegistrationButton = new JButton("Confirm Registration");
    // Error Boxes
    public JLabel emptyFieldError = new JLabel("Please fill in all boxes!");
    public JLabel userExistsError = new JLabel("This username already exists! Please login!");
    public JLabel wrongPasswordError = new JLabel("Password is incorrect!");
    public JLabel userNoExistError = new JLabel("User doesn't exist");
    // Login Screen Components
    public JLabel loginSuccessful = new JLabel("Login Successful!");

    // create components-------------------------------------------------------------------------------|

    public LoginFrame() throws IOException
    {
        // setup loginsObject
        loginsObject.put("Username", "Password");


        // set bounds of components------------------------------------------------------------------------|

        // Main Screen
        tField.setBounds(660, 200, 200,100);
        pField.setBounds(660, 350, 200, 100);
        registerButton.setBounds(360, 550, 300, 100);
        loginButton.setBounds(860, 550, 300, 100);
        // Register Screen
        registerTField.setBounds(660, 200, 200, 100);
        registerPField.setBounds(660, 350, 200, 100);
        confirmRegistrationButton.setBounds(660, 500, 200, 100);
        // Errors
        emptyFieldError.setBounds(660, 500, 200, 50);
        userExistsError.setBounds(660, 650, 200, 50);
        wrongPasswordError.setBounds(660, 500, 200, 50);
        userExistsError.setBounds(660, 500, 200, 50);
        // Login Successful Screen
        loginSuccessful.setBounds(660, 250, 200, 100);


        // set layout of frame to null
        setLayout(null);


        // Main Screen Configuration-----------------------------------------------------------------------|

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


        //Register Screen Configuration--------------------------------------------------------------------|
        
        // configure registerTField settings
        registerTField.setForeground(Color.GRAY);
        registerTField.setBackground(Color.DARK_GRAY);
        registerTField.setFont(new Font("Arial", Font.PLAIN, 25));
        registerTField.setHorizontalAlignment(SwingConstants.CENTER);
        
        // configure registerPField settings
        registerPField.setForeground(Color.GRAY);
        registerPField.setBackground(Color.DARK_GRAY);
        registerPField.setFont(new Font("Arial", Font.PLAIN, 25));
        registerPField.setHorizontalAlignment(SwingConstants.CENTER);
        registerPField.setEchoChar((char) 0);

        // configure confirmRegistrationButton settings
        confirmRegistrationButton.setFont(new Font("Arial", Font.PLAIN, 45));
        confirmRegistrationButton.setBackground(Color.DARK_GRAY);
        confirmRegistrationButton.setForeground(Color.GRAY);
        confirmRegistrationButton.setFocusPainted(false);

        
        // Errors Configuration----------------------------------------------------------------------------|

        // configure emptyFieldError settings
        emptyFieldError.setForeground(Color.GRAY);
        emptyFieldError.setBackground(Color.DARK_GRAY);
        emptyFieldError.setFont(new Font("Arial", Font.PLAIN, 10));
        emptyFieldError.setHorizontalAlignment(SwingConstants.CENTER);

        // configure userExistsError settings
        userExistsError.setForeground(Color.GRAY);
        userExistsError.setBackground(Color.DARK_GRAY);
        userExistsError.setFont(new Font("Arial", Font.PLAIN, 10));
        userExistsError.setHorizontalAlignment(SwingConstants.CENTER);

        // configure wrongPasswordError settings
        wrongPasswordError.setForeground(Color.GRAY);
        wrongPasswordError.setBackground(Color.DARK_GRAY);
        wrongPasswordError.setFont(new Font("Arial", Font.PLAIN, 10));
        wrongPasswordError.setHorizontalAlignment(SwingConstants.CENTER);

        // configure userNoExistError settings
        userNoExistError.setForeground(Color.GRAY);
        userNoExistError.setBackground(Color.DARK_GRAY);
        userNoExistError.setFont(new Font("Arial", Font.PLAIN, 10));
        userNoExistError.setHorizontalAlignment(SwingConstants.CENTER);


        // Login Successful Screen Configuration-----------------------------------------------------------|

        // stuff here


        // configure Frame settings
        setSize(1920, 1080);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.DARK_GRAY);
        setTitle("Login Screen Prototype");
        setLocationRelativeTo(null);
        setVisible(true);


        // add components
        // Main Screen Components
        add(tField);
        add(pField);
        add(registerButton);
        add(loginButton);

        // Register Screen Components
        add(registerTField);
        add(registerPField);
        add(confirmRegistrationButton);

        // Error Components
        add(emptyFieldError);
        add(userExistsError);
        add(wrongPasswordError);
        add(userNoExistError);

        // Login Successful Screen Components
        add(loginSuccessful);


        // setup action listeners for both tField and pField that remove/replace the text when they are focused/unfocused

        // setup an action listener to registerButton
        registerButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                mainScreen(false);
                registerScreen(true);

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
                if(!loginsObject.containsKey(tField.getText().strip().toLowerCase())) //TODO: change to check file, maybe have a readLine JSONObject?
                {
                    userNoExistError.setVisible(true);
                }
                else if(tField.getText().equals("Username") || pField.getPassword().equals("Password"))
                {
                    emptyFieldError.setVisible(true);
                }
                else if(!loginsObject.get(tField.getText().strip().toLowerCase()).equals(pField.getPassword()))
                {
                    wrongPasswordError.setVisible(true);
                }
                else
                {
                    mainScreen(false);
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

    // sets the state of main screen components
    public void mainScreen(boolean state)
    {
        tField.setVisible(state);
        pField.setVisible(state);
        registerButton.setVisible(state);
        loginButton.setVisible(state);
    }

    // sets the state of register screen components
    public void registerScreen(boolean state)
    {
        registerTField.setVisible(state);
        registerPField.setVisible(state);
        confirmRegistrationButton.setVisible(state);
    }

    // set all errors to invisible
    public void noErrors()
    {
        emptyFieldError.setVisible(false);
        userExistsError.setVisible(false);
        wrongPasswordError.setVisible(false);
        userNoExistError.setVisible(false);
    }

    public void onStart()
    {
        mainScreen(true);
        registerScreen(false);
        noErrors();
        loginSuccessful.setVisible(false);
    }
}
