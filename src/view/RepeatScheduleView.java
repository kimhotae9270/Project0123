package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class RepeatScheduleView {
    private Frame repeatScheduleFrame;
    private CheckboxGroup checkboxGroup;
    private TextField textField;

    public void repeatScheduleView() {
        repeatScheduleFrame = new Frame("반복 일정 추가");
        repeatScheduleFrame.setSize(300, 110);
        repeatScheduleFrame.setLayout(new BorderLayout());

        Panel weekPanel = new Panel(new GridLayout(1, 7));
        checkboxGroup = new CheckboxGroup();

        String[] daysOfWeek = {"월", "화", "수", "목", "금", "토", "일"};
        for (String day : daysOfWeek) {
            Checkbox checkbox = new Checkbox(day, checkboxGroup, false);
            weekPanel.add(checkbox);
        }

        repeatScheduleFrame.add(weekPanel, BorderLayout.NORTH);

        Panel inputPanel = new Panel(new BorderLayout());
        Label inputLabel = new Label("일정 : ");
        inputPanel.add(inputLabel, BorderLayout.WEST);

        textField = new TextField(20);
        inputPanel.add(textField, BorderLayout.CENTER);



        repeatScheduleFrame.add(inputPanel, BorderLayout.CENTER);

        Button confirmButton = new Button("확인");
        confirmButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Checkbox selectedCheckbox = checkboxGroup.getSelectedCheckbox();
                String selectedDay = selectedCheckbox != null ? selectedCheckbox.getLabel() : "선택 없음";
                String schedule = textField.getText();
                System.out.println("선택된 요일: " + selectedDay);
                System.out.println("일정: " + schedule);
            }
        });
        repeatScheduleFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                repeatScheduleFrame.dispose();
            }
        });
        repeatScheduleFrame.add(confirmButton, BorderLayout.SOUTH);

        repeatScheduleFrame.setVisible(true);
    }


}
