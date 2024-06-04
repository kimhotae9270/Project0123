package view;

import user.User;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedWriter;
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
                    System.out.println("이름: " + name);
                    System.out.println("일정: " + schedule);

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

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(User.getUserFolder() + "\\"+MainView.getCurrentYear()+"\\"+MainView.getCurrentMonth()+"\\"+MainView.getCurrentDay()+".txt", true))) {
            try(BufferedWriter writer1 = new BufferedWriter(new FileWriter("C:\\schedule_system\\User\\"+name+"\\"+MainView.getCurrentYear()+"\\"+MainView.getCurrentMonth()+"\\"+MainView.getCurrentDay()+".txt"))){
                writer.write(schedule);
                writer.newLine();
                writer1.write(schedule);
                writer1.newLine();
                popUp("이벤트가 성공적으로 공유되었습니다!");
            }catch  (IOException ex){
                popUp("해당 유저가 존재하지 않습니다");
            }


        } catch (IOException ex) {
            popUp("이벤트 공유 중 오류가 발생했습니다!");
        }
    }

    public void popUp(String message) {
        Dialog dialog = new Dialog(writeCheckList, "일정 공유", true);
        dialog.setLayout(new FlowLayout());
        dialog.add(new Label(message));
        Button ok = new Button("확인");
        ok.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dialog.dispose();
            }
        });
    }

}
