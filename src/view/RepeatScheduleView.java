package view;

import add.AddPeriod;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class RepeatScheduleView {


    public void repeatScheduleView() {
        Frame frame = new Frame("일정 추가하기");

        // 프레임 크기 설정
        frame.setSize(400, 200);

        // 레이아웃 설정 (수직 배치를 위해 GridBagLayout 사용)
        frame.setLayout(new GridBagLayout());
        frame.setLocationRelativeTo(null);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5); // 컴포넌트 간의 간격 설정

        // 시작 일 드롭다운 메뉴 생성
        Choice startDateDropdown = new Choice();
        startDateDropdown.add("Start Date");
        for (int i = 1; i <= 31; i++) {
            startDateDropdown.add("" + i);
        }

        // 끝 일 드롭다운 메뉴 생성
        Choice endDateDropdown = new Choice();
        endDateDropdown.add("End Date");
        for (int i = 1; i <= 31; i++) {
            endDateDropdown.add("" + i);
        }

        // 레이블 생성
        Label startDateLabel = new Label("시작 일: ");
        Label endDateLabel = new Label("끝 일: ");
        Label scheduleLabel = new Label("일정: ");
        TextField scheduleTextField = new TextField(20);
        Button confirmButton = new Button("확인");

        confirmButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String startDate = startDateDropdown.getSelectedItem();
                String endDate = endDateDropdown.getSelectedItem();
                String schedule = scheduleTextField.getText();
                AddPeriod ap = new AddPeriod();
                ap.addSchedule(Integer.parseInt(startDate),Integer.parseInt(endDate),schedule);
            }
        });

        // 프레임에 레이블과 드롭다운 메뉴 및 버튼 추가
        gbc.gridx = 0;
        gbc.gridy = 0;
        frame.add(startDateLabel, gbc);

        gbc.gridx = 1;
        frame.add(startDateDropdown, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        frame.add(endDateLabel, gbc);

        gbc.gridx = 1;
        frame.add(endDateDropdown, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        frame.add(scheduleLabel, gbc);

        gbc.gridx = 1;
        frame.add(scheduleTextField, gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        frame.add(confirmButton, gbc);

        // 윈도우 이벤트 핸들러 설정 (닫기 버튼 클릭 시 프로그램 종료)
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent) {
                frame.dispose();
            }
        });

        frame.setVisible(true);
    }



}
