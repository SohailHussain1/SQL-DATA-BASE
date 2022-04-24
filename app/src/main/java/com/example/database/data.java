package com.example.database;

public class data {
    private String id;
    private String name;
    private String surname;
    private String marks;
    private String dec;
    private String email;


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
    public String getSurname() {
        return surname;
    }
    public void setSurname(String name) {
        this.surname = surname;
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMarks() {
        return marks;
    }

    public void setMarks(String number) {
        this.marks = marks;
    }



    public String getDec() {
        return dec;
    }

    public void setDec(String skill) {
        this.dec = dec;
    }

    public data(String id,String name,String Surname,String Marks,String Des,String Mail){
        this.id=id;
        this.name=name;
        this.email=email;
        this.surname=Surname;
        this.marks=Marks;
        this.dec=Des;
    }
}
