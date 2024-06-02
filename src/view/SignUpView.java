package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class SignUpView extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JPasswordField confirmPasswordField;
    private JButton signupButton;
    private JButton cancelButton;

    public SignUpView() {
        setTitle("회원 가입");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(4, 2));

        panel.add(new JLabel("아이디:"));
        usernameField = new JTextField();
        panel.add(usernameField);

        panel.add(new JLabel("비밀번호:"));
        passwordField = new JPasswordField();
        panel.add(passwordField);

        panel.add(new JLabel("비밀번호 확인:"));
        confirmPasswordField = new JPasswordField();
        panel.add(confirmPasswordField);

        signupButton = new JButton("가입");
        signupButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());
                String confirmPassword = new String(confirmPasswordField.getPassword());

                if (!password.equals(confirmPassword)) {
                    JOptionPane.showMessageDialog(SignUpView.this, "비밀번호가 일치하지 않습니다!", "오류", JOptionPane.ERROR_MESSAGE);
                } else {
                    try (BufferedWriter writer = new BufferedWriter(new FileWriter("users.txt", true))) {
                        writer.write(username + "," + password);
                        writer.newLine();
                        JOptionPane.showMessageDialog(SignUpView.this, "회원 가입이 성공적으로 완료되었습니다!", "성공", JOptionPane.INFORMATION_MESSAGE);
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(SignUpView.this, "회원 가입 중 오류가 발생했습니다!", "오류", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });
        panel.add(signupButton);

        cancelButton = new JButton("취소");
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        panel.add(cancelButton);

        add(panel);
        setVisible(true);
    }

//    public static void main(String[] args) {
//        SwingUtilities.invokeLater(new Runnable() {
//            @Override
//            public void run() {
//                new SignUpView().setVisible(true);
//            }
//        });
//    }
}
