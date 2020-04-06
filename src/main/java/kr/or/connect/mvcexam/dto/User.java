package kr.or.connect.mvcexam.dto;

public class User { // getter, setter 메서드가 있어야 스프링 컨테이너가 객체의 필드를 사용할 수 있음.
    private String name;
    private String email;
    private int age;
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    @Override
    public String toString() {
        return "User [name=" + name + ", email=" + email + ", age=" + age + "]";
    }   
}