package view;

import user.User;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ShareScheduleView implements PopUpView{
    private Frame writeCheckList = new Frame("할일 추가하기");
    private TextField nameField;
    private TextField scheduleField;
    private Button confirmButton;

    public void shareScheduleView() {
        writeCheckList.setSize(300, 150);
        writeCheckList.setLayout(new GridLayout(3, 1, 10, 10));
        writeCheckList.setLocationRelativeTo(null);
        // Panel for name label and text field
        Panel namePanel = new Panel();
        namePanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        Label nameLabel = new Label("이름:");
        nameField = new TextField(20);
        namePanel.add(nameLabel);
        namePanel.add(nameField);
        writeCheckList.add(namePanel);

        // Panel for schedule label and text field
        Panel schedulePanel = new Panel();
        schedulePanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        Label scheduleLabel = new Label("일정:");
        scheduleField = new TextField(20);
        schedulePanel.add(scheduleLabel);
        schedulePanel.add(scheduleField);
        writeCheckList.add(schedulePanel);

        // Confirm button with center alignment
        Panel buttonPanel = new Panel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        confirmButton = new Button("확인");
        confirmButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String schedule = scheduleField.getText();
                if (!name.isEmpty() && !schedule.isEmpty()) {


                    saveSchedule(name, schedule);
                }
            }
        });
        buttonPanel.add(confirmButton);
        writeCheckList.add(buttonPanel);

        // 창 닫기 이벤트 처리
        writeCheckList.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                writeCheckList.dispose();
            }
        });

        writeCheckList.setVisible(true);
    }
    private void saveSchedule(String name, String schedule) {
        String myPath = User.getUserFolder() + "\\"+MainView.getCurrentYear()+"\\"+MainView.getCurrentMonth();
        File userPath = new File(myPath);
        String friendPath = "C:\\schedule_system\\User\\"+name;
        File friend = new File(friendPath);
        if (!userPath.exists()){
            userPath.mkdirs();
        }
        if(!friend.exists()){
            popUp("존재하지 않는 유저 입니다");
        }else{
            friend = new File(friendPath+"\\"+MainView.getCurrentYear()+"\\"+MainView.getCurrentMonth());
            if(!friend.exists()){
                friend.mkdirs();
            }

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(User.getUserFolder() + "\\"+MainView.getCurrentYear()+"\\"+MainView.getCurrentMonth()+"\\"+MainView.getCurrentDay()+".txt", true))) {
                try(BufferedWriter writer1 = new BufferedWriter(new FileWriter("C:\\schedule_system\\User\\"+name+"\\"+MainView.getCurrentYear()+"\\"+MainView.getCurrentMonth()+"\\"+MainView.getCurrentDay()+".txt",true))){
                    writer.write("0;"+schedule+"\n");

                    writer1.write("0;"+schedule+"\n");

                    popUp("이벤트가 성공적으로 공유되었습니다!");
                    writeCheckList.dispose();
                }catch (IOException ex){
                    popUp("이벤트 공유 중 오류가 발생했습니다!");
                }


            }catch (IOException ex) {
                popUp("이벤트 공유 중 오류가 발생했습니다!");
            }
        }

    }

    public void popUp(String message) {
        Dialog dialog = new Dialog(writeCheckList, "일정 공유", true);
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
        dialog.setSize(250, 100);
        dialog.setVisible(true);
    }

}
