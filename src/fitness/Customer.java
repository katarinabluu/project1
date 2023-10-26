/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fitness;

public class Customer {

    private String fullName;
    private int id;
    private int phoneNumber;
    private String email;
    private int age;

    public Customer(int id, String fullName, int phoneNumber, String email, int age) {
        this.fullName = fullName;
        this.id = id;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.age = age;
    }

    public Customer() {
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
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
        return "Customer{" +
                "fullName='" + fullName + '\'' +
                ", id=" + id +
                ", phoneNumber=" + phoneNumber +
                ", email='" + email + '\'' +
                ", age=" + age +
                '}';
    }
}
