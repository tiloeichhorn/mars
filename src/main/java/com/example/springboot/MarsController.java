package com.example.springboot;

import com.example.springboot.data.MoonlightOverlap;
import com.example.springboot.data.MoonlightTimes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MarsController {

    Logger LOG = LoggerFactory.getLogger(MarsController.class);

	@Autowired
	private MoonlightOverlapCalculationService moonlightOverlapCalculationService;

    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }

    @PostMapping("/calculate/moonlight-overlap")
    public MoonlightOverlap calculateMoonlightOverlap(@RequestBody MoonlightTimes moonlightTimes) {
        LOG.info("Processing moonlight calculation request for: " + moonlightTimes.toString());
        return moonlightOverlapCalculationService.calculateOverlap(moonlightTimes);
    }

}
