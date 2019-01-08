package com.podval.tests.first.ci.tests;


public class Laptop implements IComputer {

    private Hdd hdd;
    private DvdRom dvdRom;
    private Ram ram;

    public Laptop(Hdd hdd, DvdRom dvdRom, Ram ram){
        this.hdd = hdd;
        this.dvdRom = dvdRom;
        this.ram = ram;
    }

    public void copyFromDvd() {
        System.out.println("Copy to laptop hdd");
    }
}
