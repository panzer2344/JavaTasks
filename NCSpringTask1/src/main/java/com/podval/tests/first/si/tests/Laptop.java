package com.podval.tests.first.si.tests;


public class Laptop implements IComputer {

    private Hdd hdd;
    private DvdRom dvdRom;
    private Ram ram;

    public Hdd getHdd() {
        System.out.println("using get for laptop's hdd with name " + hdd.getName());
        return hdd;
    }

    public void setHdd(Hdd hdd) {
        System.out.println("using set for laptop's hdd with new name " + hdd.getName());
        this.hdd = hdd;
    }

    public DvdRom getDvdRom() {
        System.out.println("using get for laptop's dvdRom with name " + dvdRom.getName());
        return dvdRom;
    }

    public void setDvdRom(DvdRom dvdRom) {
        System.out.println("using set for laptop's dvdRom with new name " + dvdRom.getName());
        this.dvdRom = dvdRom;
    }

    public Ram getRam() {
        System.out.println("using get for laptop's ram with name " + ram.getName());
        return ram;
    }

    public void setRam(Ram ram) {
        System.out.println("using set for laptop's ram with new name " + ram.getName());
        this.ram = ram;
    }

    public void copyFromDvd() {
        System.out.println("Copy to laptop hdd");
    }
}
