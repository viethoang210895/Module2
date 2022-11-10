package TestModule2;

import java.io.Serializable;

public class Student implements Serializable {
    String id;
    String name;

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", address='" + address + '\'' +
                ", mediumscore=" + mediumscore +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getMediumscore() {
        return mediumscore;
    }

    public void setMediumscore(Long mediumscore) {
        this.mediumscore = mediumscore;
    }

    public Student(String id, String name, Integer age, String gender, String address, Long mediumscore) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.address = address;
        this.mediumscore = mediumscore;
    }

    Integer age;
    String gender;
    String address;
    Long mediumscore;

    public Student() {
    }


}
