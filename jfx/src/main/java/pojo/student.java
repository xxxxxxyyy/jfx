package pojo;

public class student {
    private String stuno;
    private String name;
    private String room;

    private String sex;
    private String bed;
    private int age;



    public String getStuno() {
        return stuno;
    }

    public void setStuno(String stuno) {
        this.stuno = stuno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getBed() {
        return bed;
    }

    public void setBed(String bed) {
        this.bed = bed;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }


    public student() {
    }

    public student(String stuno, String name, String sex, String room, int age) {
        this.stuno = stuno;
        this.name = name;
        this.room = room;

        this.sex = sex;
        this.age = age;
    }

    public student(String stuno, String name, String sex,String room, int age, String bed) {
        this.stuno = stuno;
        this.name = name;
        this.room = room;
        this.sex = sex;
        this.bed = bed;
        this.age = age;
    }

    public student(String stuno) {
        this.stuno = stuno;
    }

    @Override
    public String toString() {
        return "student{" +
                "stuno='" + stuno + '\'' +
                ", name='" + name + '\'' +
                ", room='" + room + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                '}';
    }
}
