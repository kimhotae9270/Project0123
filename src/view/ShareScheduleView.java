package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ShareScheduleView {
    private Frame writeCheckList = new Frame("할일 추가하기");
    private TextField nameField;
    private TextField scheduleField;
    private Button confirmButton;

    public void shareScheduleView() {
        writeCheckList.setSize(300, 150);
        writeCheckList.setLayout(new GridLayout(3, 1, 10, 10));

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
                    // 공유기능 구현
                    // saveSchedule(name, schedule);
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


}
