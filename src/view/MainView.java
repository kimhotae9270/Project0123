package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.time.LocalDate;

public class MainView extends Frame {
    private static int currentYear;
    private static int currentMonth;
    private static int currentDay;
    private Label monthLabel;
    private Panel calendarPanel;

    void mainView() {
        currentYear = LocalDate.now().getYear();
        currentMonth = LocalDate.now().getMonthValue();

        setTitle(currentYear + "년 " + currentMonth + "월");
        setSize(500, 500);
        setLayout(new BorderLayout());

        monthLabel = new Label();
        updateMonthLabel();
        add(monthLabel, BorderLayout.NORTH);

        calendarPanel = new Panel(new GridLayout(0, 7));
        updateCalendarPanel();
        add(calendarPanel, BorderLayout.CENTER);

        Panel buttonPanel = new Panel(new BorderLayout());

        Button prevButton = new Button("이전 달");
        prevButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (currentMonth == 1) {
                    currentMonth = 12;
                    currentYear--;
                } else {
                    currentMonth--;
                }
                setTitle(currentYear + "년 " + currentMonth + "월");
                updateMonthLabel();
                updateCalendarPanel();
            }
        });
        buttonPanel.add(prevButton, BorderLayout.WEST);

        // Create a panel to hold the center buttons with padding
        Panel centerPanel = new Panel(new FlowLayout(FlowLayout.CENTER, 10, 0));

        Button repeatButton = new Button("반복 일정 추가");
        repeatButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // 반복 일정 추가 기능 구현
                RepeatScheduleView rp = new RepeatScheduleView();
                rp.repeatScheduleView();
            }
        });
        centerPanel.add(repeatButton);

        Button deleteButton = new Button("일정 삭제");
        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // 일정 삭제 기능 구현
                RemoveScheduleView rm = new RemoveScheduleView();
                rm.removeScheduleView();
            }
        });
        centerPanel.add(deleteButton);

        buttonPanel.add(centerPanel, BorderLayout.CENTER);

        Button nextButton = new Button("다음 달");
        nextButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (currentMonth == 12) {
                    currentMonth = 1;
                    currentYear++;
                } else {
                    currentMonth++;
                }
                setTitle(currentYear + "년 " + currentMonth + "월");
                updateMonthLabel();
                updateCalendarPanel();
            }
        });
        buttonPanel.add(nextButton, BorderLayout.EAST);

        add(buttonPanel, BorderLayout.SOUTH);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });
    }

    private void updateMonthLabel() {
        monthLabel.setText(currentYear + "년 " + currentMonth + "월");
    }

    private void updateCalendarPanel() {
        calendarPanel.removeAll();
        String[] daysOfWeek = {"일", "월", "화", "수", "목", "금", "토"};
        for (String day : daysOfWeek) {
            Label label = new Label(day, Label.CENTER);
            calendarPanel.add(label);
        }

        LocalDate firstDayOfMonth = LocalDate.of(currentYear, currentMonth, 1);
        int startDayOfWeek = firstDayOfMonth.getDayOfWeek().getValue();

        for (int i = 1; i < startDayOfWeek; i++) {
            Label label = new Label("", Label.CENTER);
            calendarPanel.add(label);
        }

        int daysInMonth = firstDayOfMonth.lengthOfMonth();
        for (int day = 1; day <= daysInMonth; day++) {
            final int finalDay = day;
            Button button = new Button(String.valueOf(finalDay));
            button.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    currentDay = finalDay;
                    // 버튼 클릭 시 다음 화면으로 이동하는 동작 추가
                    ScheduleView schedule = new ScheduleView();
                    schedule.scheduleView();
                    //new LoadList();
                }
            });
            calendarPanel.add(button);
        }

        revalidate();
        repaint();
        setVisible(true);
    }

    public static int getCurrentYear() {
        return currentYear;
    }

    public static int getCurrentMonth() {
        return currentMonth;
    }

    public static int getCurrentDay() {
        return currentDay;
    }


}
