package add;

import user.User;
import view.MainView;

abstract class Add {
    private String userPath;
    Add(){

        userPath = User.getUserFolder()+"\\"+MainView.getCurrentYear()+"\\"+MainView.getCurrentMonth();
    }
    public String getUserPath(){
        return userPath;
    }
    abstract void addSchedule();
}


