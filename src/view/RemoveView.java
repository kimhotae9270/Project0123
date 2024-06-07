package view;

import Remove.RemoveSelect;
import user.User;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RemoveView {
    private Frame remmovelistFrame = new Frame("일정 지우기");
    private Panel removelistPanel = new Panel();


    private Button removeButton = new Button("일정 지우기");

    List<Checkbox> checkboxes = new ArrayList<>();
    public void removeView(Runnable runnable){
        removelistPanel.setLayout(new GridLayout(0, 1, 10, 10));
        String filePath = User.getUserFolder() +"\\"+ MainView.getCurrentYear() + "\\" + MainView.getCurrentMonth() + "\\" + MainView.getCurrentDay() + ".txt";



        Panel buttonPanel = new Panel();

        buttonPanel.add(removeButton);

        remmovelistFrame.setLayout(new BorderLayout());
        remmovelistFrame.add(removelistPanel, BorderLayout.CENTER);
        remmovelistFrame.add(buttonPanel, BorderLayout.SOUTH);
        remmovelistFrame.setSize(300, 300);
        remmovelistFrame.setLocationRelativeTo(null);

        try (BufferedReader lst = new BufferedReader(new FileReader(filePath))) {
            String line;
            File file = new File(filePath);
            if(file.length() == 0){
                Label l = new Label("지울 일정이 없습니다!");
                removelistPanel.add(l);
            } else {
                while ((line = lst.readLine()) != null) {

                    String[] parts = line.split(";", 2);

                    String label = parts[1];
                    Checkbox ch = new Checkbox(label);
                    ch.setFont(new Font("Arial", Font.PLAIN, 18)); // 체크박스 텍스트 크기 조정
                    checkboxes.add(ch);
                    removelistPanel.add(ch);
                }
            }
        } catch (IOException e) {
            Label l = new Label("지울 일정이 없습니다!");
            removelistPanel.add(l);
        }
        remmovelistFrame.setVisible(true);
    removeButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            RemoveSelect re = new RemoveSelect();
            re.remove(checkboxes);
            runnable.run();
            remmovelistFrame.dispose();
        }
    });
        remmovelistFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                remmovelistFrame.dispose();
            }
        });
    }

}
