package Remove;

import user.User;
import view.MainView;

import java.util.ArrayList;

public abstract class Remove {
    private String filePath;
    Remove(){
        this.filePath = User.getUserFolder()+"\\"+ MainView.getCurrentYear()+"\\"+MainView.getCurrentDay()+".txt";

    }
    abstract void remove(String label);
}
