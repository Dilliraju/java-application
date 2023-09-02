import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class LoginPage extends JFrame implements ActionListener {
    private JLabel lblUsername;
    private JTextField txtUsername;
    private JLabel lblPassword;
    private JPasswordField txtPassword;
    private JButton btnLogin;
    private JButton btnCancel;
    public LoginPage() {
        // Set the title of the window
        super("Login Page");
        // Set the layout of the window
        setLayout(new GridBagLayout());
        // Create the username label
        lblUsername = new JLabel("Username:");
        // Create the username text field
        txtUsername = new JTextField(20);
        // Create the password label
        lblPassword = new JLabel("Password:");
        // Create the password text field
        txtPassword = new JPasswordField(20);
        // Create the login button
        btnLogin = new JButton("Login");
        // Create the cancel button
        btnCancel = new JButton("Cancel");
        // Add the components to the window
        add(lblUsername, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(10, 10, 10, 10), 0, 0));
        add(txtUsername, new GridBagConstraints(1, 0, 1, 1, 1.0, 0.0,
                GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(10, 10, 10, 10), 0, 0));
        add(lblPassword, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
                GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(10, 10, 10, 10), 0, 0));
        add(txtPassword, new GridBagConstraints(1, 1, 1, 1, 1.0, 0.0,
                GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(10, 10, 10, 10), 0, 0));
        add(btnLogin, new GridBagConstraints(0,
