import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class login implements ActionListener{
    private JFrame frame;
    private JButton loginButton;
    private JPanel panel;
    private JLabel userLabel, passwordLabel;
    private JTextField userText;
    private JPasswordField passwordText;

    public login(){
        frame = new JFrame("Minha vida, meus momentos");
        frame.setSize(320, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        panel = new JPanel();
        panel.setLayout(null);
        frame.add(panel);

        userLabel = new JLabel("Usuario:");
        userLabel.setBounds(10, 20, 50, 25);
        panel.add(userLabel);

        userText = new JTextField(20);
        userText.setBounds(100, 20, 165, 25);
        panel.add(userText);

        passwordLabel = new JLabel("Senha:");
        passwordLabel.setBounds(10, 80, 50, 25);
        panel.add(passwordLabel);
        
        passwordText = new JPasswordField();
        passwordText.setBounds(100, 80, 165, 25);
        panel.add(passwordText);

        loginButton = new JButton("Login");
        loginButton.setBounds(120, 125, 75, 25);
        loginButton.addActionListener(this);
        panel.add(loginButton);

        frame.setVisible(true);
        frame.setResizable(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (userText.getText().equals("FranciscoBueno") && String.valueOf(passwordText.getPassword()).equals("campusiv")){
            JOptionPane.showMessageDialog(frame, "Login feito com sucesso", "Login", 1);
            frame.dispose();
            new GUI();
        } else {
            JOptionPane.showMessageDialog(frame, "Dados inválidos", "login", 0);
        }
    }
}