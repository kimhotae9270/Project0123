package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class LoginView extends Frame implements PopUpView{

    void loginView(){
        setTitle("로그인 폼");
        setSize(300, 120);
        setLayout(new GridLayout(2, 2));
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });
        setLocationRelativeTo(null);

        Panel inputPanel = new Panel(new GridLayout(2, 2));
        Label idLabel = new Label("아이디:");
        TextField idField = new TextField();
        Label pwLabel = new Label("비밀번호:");
        TextField pwField = new TextField();
        pwField.setEchoChar('*'); // 비밀번호 입력 시 숨기기

        inputPanel.add(idLabel);
        inputPanel.add(idField);
        inputPanel.add(pwLabel);
        inputPanel.add(pwField);

        add(inputPanel, BorderLayout.CENTER);

        // 버튼 패널 생성
        // 버튼 패널 생성
        Panel buttonPanel = new Panel(new GridLayout(1, 2));

        // 로그인 버튼 패널 생성 및 추가
        Panel loginPanel = new Panel(new FlowLayout(FlowLayout.LEFT));
        Button loginButton = new Button("로그인");
        loginPanel.add(loginButton);
        buttonPanel.add(loginPanel, BorderLayout.WEST);

        // 회원가입 버튼 패널 생성 및 추가
        Panel registerPanel = new Panel(new FlowLayout(FlowLayout.RIGHT));
        Button registerButton = new Button("회원가입");
        registerPanel.add(registerButton);
        buttonPanel.add(registerPanel, BorderLayout.EAST);


        add(buttonPanel, BorderLayout.SOUTH);

        loginButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String username = idField.getText();
                String password = pwField.getText();
                boolean login = false;


                try (BufferedReader reader = new BufferedReader(new FileReader("C:\\schedule_system\\User\\user.txt"))) {
                    String line;
                    while ((line = reader.readLine()) != null) {
                        String[] userInfo = line.split(";");
                        if (userInfo[0].equals(username) && userInfo[1].equals(password)) {
                            login = true;
                            MainView main = new MainView();
                            main.mainView();
                            dispose();
                            break;
                        }
                    }
                    if(!login){
                        popUp("아이디 또는 비밀번호가 틀렸습니다");
                    }


                } catch (IOException ex) {
                    popUp("회원가입이 진행된 유저가 없습니다");
                }


            }


        });
        registerButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                new SignUpView();

            }
        });
        // 화면에 프레임 표시
        setVisible(true);
    }
    public void popUp(String message) {
        Dialog dialog = new Dialog(this, "로그인", true);
        dialog.setLayout(new FlowLayout());
        dialog.add(new Label(message));
        dialog.setLocationRelativeTo(null);
        Button ok = new Button("확인");
        ok.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dialog.dispose();
            }
        });
        dialog.add(ok);
        dialog.setSize(230, 100);
        dialog.setVisible(true);

    }



    public static void main(String[] args) {
        LoginView login = new LoginView();
        login.loginView();
    }
}
