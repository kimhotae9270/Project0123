package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class AddScheduleView {
    private Frame writeCheckList = new Frame("할일 추가하기");
    private Panel checklistPanel;
    private Button addButton;
    public void scheduleAddView(){
        writeCheckList.setSize(500,150);
        writeCheckList.setLayout(new BorderLayout());
        TextArea textArea = new TextArea("", 5, 20, TextArea.SCROLLBARS_VERTICAL_ONLY);
        writeCheckList.add(textArea,BorderLayout.NORTH);

        addButton = new Button("추가");
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String newItem = textArea.getText().trim();
                if (!newItem.isEmpty()) {
                    checklistPanel.add(new Checkbox(newItem));
                    //추가 기능 구현
                    //writeFile(textArea.getText());

                }
            }
        });
        writeCheckList.add(addButton, BorderLayout.SOUTH);

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
