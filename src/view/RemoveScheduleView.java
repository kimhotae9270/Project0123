package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class RemoveScheduleView implements PopUpView{
    private Frame deleteWeekFrame;
    private CheckboxGroup checkboxGroup;

    public void removeScheduleView() {
        deleteWeekFrame = new Frame("주차 삭제 선택");
        deleteWeekFrame.setSize(300, 150);
        deleteWeekFrame.setLayout(new BorderLayout());

        Label label = new Label("삭제할 주차를 선택해 주세요", Label.CENTER);
        deleteWeekFrame.add(label, BorderLayout.NORTH);

        Panel radioPanel = new Panel(new FlowLayout());

        checkboxGroup = new CheckboxGroup();

        Checkbox week1Checkbox = new Checkbox("1주차", checkboxGroup, false);
        radioPanel.add(week1Checkbox);

        Checkbox week2Checkbox = new Checkbox("2주차", checkboxGroup, false);
        radioPanel.add(week2Checkbox);

        Checkbox week3Checkbox = new Checkbox("3주차", checkboxGroup, false);
        radioPanel.add(week3Checkbox);

        Checkbox week4Checkbox = new Checkbox("4주차", checkboxGroup, false);
        radioPanel.add(week4Checkbox);

        Checkbox thisMonthCheckbox = new Checkbox("이번달 삭제", checkboxGroup, false);
        radioPanel.add(thisMonthCheckbox);

        Checkbox allCheckbox = new Checkbox("전체 삭제", checkboxGroup, false);
        radioPanel.add(allCheckbox);

        deleteWeekFrame.add(radioPanel, BorderLayout.CENTER);

        Button confirmButton = new Button("확인");
        confirmButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Checkbox selectedCheckbox = checkboxGroup.getSelectedCheckbox();
                if (selectedCheckbox != null) {
                    String selectedWeek = selectedCheckbox.getLabel();
                    //여기에 삭제 구현
                } else {
                    //선택해 주세요 팝업 구현
                    popUp("주차를 선택해주세요.");

                }
            }
        });
        deleteWeekFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                deleteWeekFrame.dispose();
            }
        });
        deleteWeekFrame.add(confirmButton, BorderLayout.SOUTH);

        deleteWeekFrame.setVisible(true);
    }

    public void popUp(String text){
        System.out.println("구현");
    }

}
