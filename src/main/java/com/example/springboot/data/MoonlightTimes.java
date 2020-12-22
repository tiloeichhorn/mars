package com.example.springboot.data;

public class MoonlightTimes {

    private TimeInterval deimos;
    private TimeInterval phobos;

    public MoonlightTimes(TimeInterval deimos, TimeInterval phobos) {
        this.deimos = deimos;
        this.phobos = phobos;
    }

    public TimeInterval getDeimos() {
        return deimos;
    }

    public TimeInterval getPhobos() {
        return phobos;
    }

    @Override
    public String toString() {
        return "D" + deimos + ", P" + phobos;
    }
}
