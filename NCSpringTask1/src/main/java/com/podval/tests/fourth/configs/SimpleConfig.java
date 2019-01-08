package com.podval.tests.fourth.configs;

import org.springframework.stereotype.Component;

@Component("SimpleConfig")
public class SimpleConfig {

    private String hddName = "SEAGATE ST1000";
    private String ramName = "BESTMEMORY999";
    private String dvdRomName = "SMTMSIOPN777";

    public String getHddName() {
        return hddName;
    }

    public String getRamName() {
        return ramName;
    }

    public String getDvdRomName() {
        return dvdRomName;
    }
}
