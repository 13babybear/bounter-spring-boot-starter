package cn.bounter.starter.service;

public class BounterService {

    private String name;

    public BounterService(String name) {
        this.name = name;
    }

    public void printName() {
        System.out.println(name);
    }

}
