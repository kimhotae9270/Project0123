package view;

import user.CheckInfo;
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
                if(!password.equals(confirmPassword)) {
                    popUp("비밀번호가 서로 다릅니다");
                }else{
                    CheckInfo ck = new CheckInfo();
                    ck.checkInfo(username);
                    if(ck.getIsIDtrue()){
                        popUp("이미 사용중인 아이디 입니다");
                    }else{
                        String folderPath = "C:\\schedule_system\\User";
                        File folder = new File(folderPath);
                        if(!folder.exists()){
                            folder.mkdirs();
                        }
                        try(FileWriter fw = new FileWriter(folderPath+"\\user.txt",true)){
                            File u = new File(folderPath+"\\"+username);
                            u.mkdirs();
                            fw.write(username+";"+password+"\n");
                            popUp("회원가입에 성공했습니다");
                            dispose();
                        }catch (IOException err){
                            System.out.println(err);
                        }
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
