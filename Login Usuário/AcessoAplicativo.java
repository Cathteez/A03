import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AcessoAplicativo extends JFrame implements ActionListener {
    private JTextField userField;
    private JPasswordField passwordField;
    private JButton confirmButton, cancelButton;

    public AcessoAplicativo() {
        super("Acesso ao Aplicativo");
        setLayout(new GridLayout(3, 2));

        add(new JLabel("Usuário:"));
        userField = new JTextField(15);
        add(userField);

        add(new JLabel("Senha:"));
        passwordField = new JPasswordField(15);
        add(passwordField);

        confirmButton = new JButton("Confirmar");
        confirmButton.addActionListener(this);
        add(confirmButton);

        cancelButton = new JButton("Cancelar");
        cancelButton.addActionListener(this);
        add(cancelButton);

        setSize(400, 250);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == confirmButton) {
            String username = userField.getText();
            String password = new String(passwordField.getPassword());

            if (autenticarUsuario(username, password)) {
                JOptionPane.showMessageDialog(this, "acesso confirmado");
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "usuario ou senha invalido");
            }
        } else if (e.getSource() == cancelButton) {
            dispose();
        }
    }

    private boolean autenticarUsuario(String username, String password) {
        String usuarioCorreto = "denys.silva";
        String senhaCorreta = "Teste@2024";

        return username.equals(usuarioCorreto) && password.equals(senhaCorreta);
    }

    public static void main(String[] args) {
        new AcessoAplicativo();
    }
}