package com.example.administrator.retrofitex;

/**
 * Created by Administrator on 2016/12/18 0018.
 */
public class Student {

    /**
     * Id : sample string 1
     * Name : sample string 2
     * Age : 3
     */

    private String Id;
    private String Name;
    private int Age;

    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int Age) {
        this.Age = Age;
    }
}
