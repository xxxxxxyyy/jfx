package pojo;

public class user {
    String name;
    String password;
    String zhuz;//电话号码

    public String getZhuz() {
        return zhuz;
    }

    public void setZhuz(String zhuz) {
        this.zhuz = zhuz;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public user() {
    }

    public user(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public user(String name, String password, String zhuz) {
        this.name = name;
        this.password = password;
        this.zhuz = zhuz;
    }
}
