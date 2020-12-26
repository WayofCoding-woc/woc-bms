package com.woc.bms.controller;

import com.woc.bms.data.model.City;
import com.woc.bms.data.model.Theatre;
import com.woc.bms.service.DataService;
import java.util.List;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Log4j2
@RestController
@RequestMapping("/api")
public class Api {

    @Autowired
    private DataService dataService;

    @GetMapping("/city")
    public List<City> getAllCity(){
        return dataService.getAllCity();
    }

    @Cacheable("cityCode")
    @GetMapping("/city/code/{cityCode}")
    public List<Theatre> getTheatreByCityCode(@PathVariable("cityCode") String cityCode){
        System.out.println("getTheatreByCityCode api for cityCode="+cityCode + " has been triggered");
        List<Theatre> theatres = dataService.getTheatreByCityCode(cityCode);

        log.debug(theatres);
        return theatres;
    }

}
