package com.podval.tests.sixth.tests;

public class DigitalClockFactory implements IClockFactory {
    public IClock getClock(Integer id) {
        DigitalClock clock = new DigitalClock();
        clock.setId(id);
        return clock;
    }
}
