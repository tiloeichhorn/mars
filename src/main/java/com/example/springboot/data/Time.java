package com.example.springboot.data;

import java.util.Objects;

public class Time implements Comparable<Time> {

    private int hours;
    private int minutes;

    public Time(int hours, int minutes) {
        this.hours = hours;
        this.minutes = minutes;
    }

    public Time(Time origin) {
        this.hours = origin.hours;
        this.minutes = origin.minutes;
    }

    public int getHours() {
        return hours;
    }

    public int getMinutes() {
        return minutes;
    }

    @Override
    public int compareTo(Time t2) {
        return this.hours == t2.hours ? this.minutes - t2.minutes : this.hours - t2.hours;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Time time = (Time) o;
        return hours == time.hours &&
                minutes == time.minutes;
    }

    @Override
    public int hashCode() {
        return Objects.hash(hours, minutes);
    }

    @Override
    public String toString() {
        return String.format("%02d", hours) + ":" + String.format("%02d", minutes);
    }
}
