package view;

import user.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.*;

public class SignUpView extends JFrame implements PopUpView{
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JPasswordField confirmPasswordField;
    private JButton signupButton;
    private JButton cancelButton;

    public SignUpView() {
        setTitle("회원 가입");
        setSize(300, 200);

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



                    try (BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\schedule_system\\User\\user.txt", true))) {
                        try (BufferedReader reader = new BufferedReader(new FileReader("C:\\schedule_system\\User\\user.txt"))) {
                            String line;
                            boolean user = false;
                            while ((line = reader.readLine()) != null) {

                                String[] userInfo = line.split(";");
                                if (userInfo[0].equals(username) && userInfo[1].equals(password)) {
                                    popUp("이미 사용중인 아이디 입니다");
                                    user = true;
                                    break;
                                }else{
                                    writer.write(username + ";" + password);
                                    writer.newLine();
                                    JOptionPane.showMessageDialog(SignUpView.this, "회원 가입이 성공적으로 완료되었습니다!", "성공", JOptionPane.INFORMATION_MESSAGE);
                                    dispose();
                                    break;
                                }
                            }
                            if(!user){
                                writer.write(username + ";" + password);
                                writer.newLine();
                                JOptionPane.showMessageDialog(SignUpView.this, "회원 가입이 성공적으로 완료되었습니다!", "성공", JOptionPane.INFORMATION_MESSAGE);
                                dispose();
                            }
                        } catch (IOException ex) {
                            popUp("오류가 발생했습니다!");
                        }

                    } catch (IOException ex) {
                        popUp("오류가 발생했습니다!");
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

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });
        add(panel);
        setVisible(true);
    }
    public void popUp(String message) {
        Dialog dialog = new Dialog(this, "로그인", true);
        dialog.setLayout(new FlowLayout());
        dialog.add(new Label(message));
        Button ok = new Button("확인");
        dialog.setLocationRelativeTo(null);
        ok.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dialog.dispose();
            }
        });
        dialog.add(ok);
        dialog.setSize(200, 100);
        dialog.setVisible(true);

    }

}
