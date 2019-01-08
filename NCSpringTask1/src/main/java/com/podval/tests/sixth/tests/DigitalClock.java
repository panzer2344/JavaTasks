package com.podval.tests.sixth.tests;

import java.util.Date;

public class DigitalClock implements IClock {

    private Integer id;

    public void showTime() {
        System.out.println(new Date());
    }

    public Integer getId() {
        System.out.println("using get for digital clock");
        return id;
    }

    public void setId(Integer id) {
        System.out.println("using set for digital clock");
        this.id = id;
    }
}
