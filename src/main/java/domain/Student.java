package domain;

/**
 * Created by pengfei on 2017/9/20.
 */
public class Student {
    private int id;
    private String name;
    private String male;
    private String comment;
    private double salary;
    private int age;

    public Student() {

    }

    public Student(int age, String name, String male) {
        this.age = age;
        this.name = name;
        this.male = male;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMale() {
        return male;
    }

    public void setMale(String male) {
        this.male = male;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        String s=this.getId()+" "+getName()+" "+getAge()+" "+getMale()+" "+getComment();
        return s;
    }
}
