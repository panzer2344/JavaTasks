package com.podval.tests.first.ci.configs;

import com.podval.tests.first.ci.tests.DvdRom;
import com.podval.tests.first.ci.tests.Hdd;
import com.podval.tests.first.ci.tests.Ram;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.podval.tests.first.ci.main")
public class Config {

    @Bean
    public Hdd hdd(){
        return new Hdd("hdd1");
    }

    @Bean
    public DvdRom dvdRom(){
        return new DvdRom("dvdRom1");
    }

    @Bean
    public Ram ram(){
        return new Ram("ram1");
    }

    /*@Bean
    public Laptop laptop() {
        return new Laptop(hdd(), dvdRom(), ram());
    }

    @Bean
    public PC pc() {
        return new PC(hdd(), dvdRom(), ram());
    }*/
}
