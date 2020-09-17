package org.cuju.study.oop;

/**
 * @Author: Uoolo
 * @Description: TODO
 * @Date: Create in 14:40 2020/9/17
 */
public class People implements Cloneable {
    private String name;
    private Integer age;
    private String gender;

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

    @Override
    public People clone(){
        People people = null;
        try{
            people = (People)super.clone();
        }catch(CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return people;
    }
}
