import java.io.File;
import java.io.IOException;

public class Main
{
    private static LoginFrame loginFrame;
    public static File f = new File("./logins.json");
    public static void main(String [] args) throws IOException
    {
        if(!f.exists())
        {
            f.createNewFile();
        }
        // initialize JFrame and login stuff
        loginFrame = new LoginFrame();
        loginFrame.onStart();
    }

    public static LoginFrame getLoginFrame(){return loginFrame;}
}
