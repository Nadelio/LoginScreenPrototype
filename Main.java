public class Main
{
    private static LoginFrame loginFrame;
    public static void main(String [] args)
    {
        //TODO: if logins.json doesn't exist, make it, if it does, do nothing

        // initialize JFrame and login stuff
        loginFrame = new LoginFrame();
    }

    public static LoginFrame getLoginFrame(){return loginFrame;}
}
