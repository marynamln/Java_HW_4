package org.example;

public class Subject {
    private String name;
    private int hours;
    private int credit;

    public Subject(String name, int hours, int credit){
        this.name = name;
        this.hours = hours;
        this.credit = credit;
    }

    public int getHours() {
        return hours;
    }

    public int getCredit() {
        return credit;
    }

    public String getName() {
        return name;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString(){
        return this.name + ", hours: " + this.hours + ", credit: " + this.credit;
    }
}
