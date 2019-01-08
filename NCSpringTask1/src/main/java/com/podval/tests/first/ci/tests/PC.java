package com.podval.tests.first.ci.tests;

public class PC implements IComputer {

    private Hdd hdd;
    private DvdRom dvdRom;
    private Ram ram;

    public PC(Hdd hdd, DvdRom dvdRom, Ram ram){
        this.hdd = hdd;
        this.dvdRom = dvdRom;
        this.ram = ram;
    }

    public void copyFromDvd() {
        System.out.println("Copy to pc hdd");
    }
}
