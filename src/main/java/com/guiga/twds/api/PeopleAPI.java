package com.guiga.twds.api;

import com.guiga.twds.dto.PeopleDTO;
import com.guiga.twds.entity.People;
import com.guiga.twds.service.PeopleService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

/**
 * Created by guilherme on 21/01/17.
 */
@RestController
@RequestMapping(value = "/people")
public class PeopleAPI {

    @Autowired
    private PeopleService peopleService;


    @RequestMapping(value = "/", method = RequestMethod.POST)
    public void save(@ApiParam(value = "People object", required = true)
                         @RequestBody People people) {
        peopleService.save(people);
    }


    @ApiOperation(value = "Update Location", notes = "Update location of a survivor")
    @RequestMapping(value = "/update-location", method = RequestMethod.POST)
    public void updateLocation(@RequestBody PeopleDTO dto) {

    }

    @RequestMapping(value = "/set-infected/{userIdInfected}/{userId}", method = RequestMethod.POST)
    private void setInfected(@PathVariable("userIdInfected") Long userIdInfected, @PathVariable("userId") Long userId) {

    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<People> getPeoples() {

        return peopleService.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public People findOne(@PathVariable("id") Long id){

        return peopleService.findOne(id);
    }

    @RequestMapping(value = "is-infected/{id}", method = RequestMethod.GET)
    public Boolean isInfected(@PathVariable("id") Long userId) {

        return peopleService.isInfected(userId);
    }



}
