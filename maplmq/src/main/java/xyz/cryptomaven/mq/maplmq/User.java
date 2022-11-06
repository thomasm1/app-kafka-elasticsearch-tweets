package xyz.cryptomaven.mq.maplmq;


import java.io.Serializable;

public class User implements Serializable{

    private static final long serialVersionUID = 1L;

    private int id;
    private String userName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

}
