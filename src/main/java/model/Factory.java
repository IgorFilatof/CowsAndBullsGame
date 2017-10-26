package model;



import java.io.Serializable;
import java.util.ArrayList;

public class Factory implements Serializable {
    private ArrayList<User> userArrayList;


    public Factory() {
        userArrayList=new ArrayList<User>();
    }

    public ArrayList<User> getUserArrayList() {
        return userArrayList;
    }

    public void setUserArrayList(ArrayList<User> userArrayList) {
        this.userArrayList = userArrayList;
    }
}
