package com.pradeep.deserializetester.Controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pradeep.deserializetester.Model.Hacker;
import com.pradeep.deserializetester.Service.HackerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class HackerController {

    @Autowired
    HackerService hackerService;

    @GetMapping("/ping")
    public String ping(){
        return "ENDPOINTS\n /enableDefaultMapper \n/enableDefaultMapperObject \n/jsonTypeIDClass";
    }

    @GetMapping("/enableDefaultMapper")
    public String enableDefaultMapper(@RequestParam String payload) throws IOException {
        hackerService.deserialize_EnableDefaultMapper(payload);
        return "Deserialization Successfully";
    }

    @GetMapping("/enableDefaultMapperObject")
    public String enableDefaultMapper_ObjectClass(@RequestParam String payload) throws IOException {
        hackerService.deserialize_EnableDefaultMapper_ObjectClass(payload);
        return "Deserialization Successfully";
    }

    @GetMapping("/jsonTypeIDClass")
    public String JsonTypeIDClass(@RequestParam String payload) throws IOException {
        hackerService.deserialize_JsonTypeIDClass(payload);
        return "Deserialization Successfully";
    }

}
