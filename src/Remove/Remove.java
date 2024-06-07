package Remove;

import user.User;
import view.MainView;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public abstract class Remove {
    private String filePath;
    Remove(){
        this.filePath = User.getUserFolder()+"\\"+ MainView.getCurrentYear()+"\\"+MainView.getCurrentDay()+".txt";

    }
    abstract void remove(List<Checkbox> cb);
}
