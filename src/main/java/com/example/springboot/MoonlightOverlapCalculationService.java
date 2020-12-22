package com.example.springboot;

import com.example.springboot.data.MoonlightOverlap;
import com.example.springboot.data.MoonlightTimes;

public interface MoonlightOverlapCalculationService {

    public MoonlightOverlap calculateOverlap(MoonlightTimes moonlightTimes);
}
