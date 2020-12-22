package com.example.springboot;

import com.example.springboot.data.MoonlightTimes;
import com.example.springboot.data.Time;
import com.example.springboot.data.TimeInterval;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class MonlightOverlapCalulationServiceImplTest {

    @Test
    void calculateOverlap1() {
        MoonlightOverlapCalculationService service = new MonlightOverlapCalulationServiceImpl();
        Assertions.assertThat(service.calculateOverlap(new MoonlightTimes(interval(1391, 2305), interval(2205, 2445))).getOverlapInMinutes()).isEqualTo(100);
        Assertions.assertThat(service.calculateOverlap(new MoonlightTimes(interval(2205, 2445), interval(1391, 2305))).getOverlapInMinutes()).isEqualTo(100);
    }

    @Test
    void calculateOverlap2() {
        MoonlightOverlapCalculationService service = new MonlightOverlapCalulationServiceImpl();
        Assertions.assertThat(service.calculateOverlap(new MoonlightTimes(interval(2453, 712), interval(512, 845))).getOverlapInMinutes()).isEqualTo(200);
        Assertions.assertThat(service.calculateOverlap(new MoonlightTimes(interval(512, 845), interval(2453, 712))).getOverlapInMinutes()).isEqualTo(200);
    }

    @Test
    void calculateOverlap3() {
        MoonlightOverlapCalculationService service = new MonlightOverlapCalulationServiceImpl();
        Assertions.assertThat(service.calculateOverlap(new MoonlightTimes(interval(1400, 2240), interval(1588, 2207))).getOverlapInMinutes()).isEqualTo(619);
        Assertions.assertThat(service.calculateOverlap(new MoonlightTimes(interval(1588, 2207), interval(1400, 2240))).getOverlapInMinutes()).isEqualTo(619);
    }

    @Test
    void calculateOverlap4() {
        MoonlightOverlapCalculationService service = new MonlightOverlapCalulationServiceImpl();
        Assertions.assertThat(service.calculateOverlap(new MoonlightTimes(interval(1400, 2240), interval(1020, 2207))).getOverlapInMinutes()).isEqualTo(807);
        Assertions.assertThat(service.calculateOverlap(new MoonlightTimes(interval(1020, 2207), interval(1400, 2240))).getOverlapInMinutes()).isEqualTo(807);
    }

    @Test
    void calculateOverlap5() {
        MoonlightOverlapCalculationService service = new MonlightOverlapCalulationServiceImpl();
        Assertions.assertThat(service.calculateOverlap(new MoonlightTimes(interval(1000, 900), interval(999, 998))).getOverlapInMinutes()).isEqualTo(2400);
        Assertions.assertThat(service.calculateOverlap(new MoonlightTimes(interval(999, 998), interval(1000, 900))).getOverlapInMinutes()).isEqualTo(2400);
    }

    @Test
    void calculateOverlap6() {
        MoonlightOverlapCalculationService service = new MonlightOverlapCalulationServiceImpl();
        Assertions.assertThat(service.calculateOverlap(new MoonlightTimes(interval(1000, 1100), interval(900, 1000))).getOverlapInMinutes()).isEqualTo(1);
        Assertions.assertThat(service.calculateOverlap(new MoonlightTimes(interval(900, 1000), interval(1000, 1100))).getOverlapInMinutes()).isEqualTo(1);
    }

    private TimeInterval interval(int from, int to) {
        return new TimeInterval(new Time(from / 100, from % 100), new Time(to / 100, to % 100));
    }
}