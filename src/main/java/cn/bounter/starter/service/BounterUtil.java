package cn.bounter.starter.service;

import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

public class BounterUtil {

    @Autowired
    private BounterService bounterService;

    private static BounterUtil bounterUtil ;

    @PostConstruct
    public void init() {
        bounterUtil = this;
        bounterUtil.bounterService= this.bounterService;
    }

    public static void print() {
        bounterUtil.bounterService.printName();
    }

}
