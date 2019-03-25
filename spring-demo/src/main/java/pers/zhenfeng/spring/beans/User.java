package pers.zhenfeng.spring.beans;

/**
 * @author Grow-Worm
 * @date 2019/02/27
 */
public class User {

    public User() {
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    private String username;

    private String password;

    private Integer trans;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getTrans() {
        return trans;
    }

    public void setTrans(Integer trans) {
        this.trans = trans;
    }
}
