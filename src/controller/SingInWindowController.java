package controller;

import javax.swing.JPasswordField;
import javax.swing.JTextField;
import model.UsersXMLfile;

/**
 * @author LeonardoSotillo
 * @author FernandoRainier
 * version 1.0.0
 */
public class SingInWindowController {
    
    public static JTextField userName;
    public static JPasswordField password;
    public static String CBprofile;
    public static String toLowerCaseUserName;
   
    /**
     * Method to create the user
     * @param userName
     * @param Password
     */
    public static void initOutlets (JTextField userName, JPasswordField password)
    {
        SingInWindowController.userName = userName;
        SingInWindowController.password = password;
        
        toLowerCaseUserName = SingInWindowController.userName.getText().toLowerCase();
    }
    
    /**
     * Method to confirm that the entered data by the user is accurate and be able to login
     * @return The user
     */
    public static boolean checkLogin(String userNameLogin, String passwordLogin)
    {
        toLowerCaseUserName = userNameLogin.toLowerCase();
        // Se busca al usuario dentro el Users.xml, de encontrarlo retorna el tipo de usuario, de existir este
        return(UsersXMLfile.readUsersFromXML(toLowerCaseUserName, passwordLogin));
    }
    
    /**
     * Method to find the type of user
     * @return The type of user
     */
    public static String checkProfile(String userNameLogin, String passwordLogin)
    {
        toLowerCaseUserName = userNameLogin.toLowerCase();
        
        // Se busca al usuario dentro el Users.xml, y retorna el tipo de usuario
        return(UsersXMLfile.findProfileOfUserInXML(toLowerCaseUserName,passwordLogin));
    }
    
    public static void clearOutlets(JTextField userName, JPasswordField password)
    {
        SingInWindowController.userName.setText(null);
        SingInWindowController.password.setText(null);
    }
    
}
