package com.example.springboot;

import java.util.stream.IntStream;

import com.example.springboot.data.MoonlightOverlap;
import com.example.springboot.data.MoonlightTimes;
import com.example.springboot.data.TimeInterval;
import org.springframework.stereotype.Component;

@Component
public class MonlightOverlapCalulationServiceImpl implements MoonlightOverlapCalculationService {

    public static final int HOURS_OF_MARS_DAY = 25;

    @Override
    public MoonlightOverlap calculateOverlap(MoonlightTimes moonlightTimes) {
        TimeInterval deimos = moonlightTimes.getDeimos();
        TimeInterval phobos = moonlightTimes.getPhobos();

        int xD = deimos.getStart().getHours() * 100 + deimos.getStart().getMinutes();
        int yD = deimos.getEnd().getHours() * 100 + deimos.getEnd().getMinutes();
        int xP = phobos.getStart().getHours() * 100 + phobos.getStart().getMinutes();
        int yP = phobos.getEnd().getHours() * 100 + phobos.getEnd().getMinutes();

        if (yD < xD && yP < xP) {
            yD += 2500;
            yP += 2500;
        }else if(yD < xD) {
            yD += 2500;
            xP += 2500;
            yP += 2500;
        } else if (yP < xP) {
            yP += 2500;
            xD += 2500;
            yD += 2500;
        }

        int x = Math.max(xD, xP);
        int y = Math.min(yD, yP);
        int duration = y - x;
        if (duration < 0) {
            duration = 0;
        } else if (duration == 0) {
            duration = 1;
        }

        return new MoonlightOverlap(duration);
    }

}
