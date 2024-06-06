package view;

import add.AddDay;
import com.sun.tools.javac.Main;
import user.User;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;

public class AddScheduleView {
    private Frame writeCheckList = new Frame("할일 추가하기");
    private Panel checklistPanel;
    private Button addButton;
    private Button shareButton;

    public void scheduleAddView(Runnable runnable) {
        writeCheckList.setSize(500, 200);
        writeCheckList.setLayout(new BorderLayout());
        TextArea textArea = new TextArea("", 5, 20, TextArea.SCROLLBARS_VERTICAL_ONLY);
        writeCheckList.add(textArea, BorderLayout.NORTH);

        // Create panel for buttons
        Panel buttonPanel = new Panel();
        buttonPanel.setLayout(new FlowLayout());

        addButton = new Button("추가");
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String newItem = textArea.getText();
                AddDay add = new AddDay();
                add.addDay(newItem);
                writeCheckList.dispose();
                runnable.run();
            }
        });
        buttonPanel.add(addButton);

        shareButton = new Button("일정 공유");
        shareButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                ShareScheduleView share = new ShareScheduleView();
                share.shareScheduleView();
            }
        });
        buttonPanel.add(shareButton);

        writeCheckList.add(buttonPanel, BorderLayout.SOUTH);

        // 체크리스트를 담을 패널 생성
        checklistPanel = new Panel();
        checklistPanel.setLayout(new GridLayout(0, 1)); // 세로로 배치
        writeCheckList.add(checklistPanel, BorderLayout.CENTER);

        // 창 닫기 이벤트 처리
        writeCheckList.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                writeCheckList.dispose();
            }
        });

        writeCheckList.setVisible(true);
    }
}
