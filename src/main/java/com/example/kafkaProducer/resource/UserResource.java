package com.example.kafkaProducer.resource;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.kafkaProducer.resource.model.User;

@RestController
@RequestMapping("/kafka")
public class UserResource {


	
	public static final String KAFKA_EXAMPLE = "TestTopic";
	
//	@Autowired
//	KafkaTemplate<String, String> kafkaTemplate;
//	
//	@GetMapping("/publish/{message}")
//	public String publish(@PathVariable("message") String message) {
//		
//		kafkaTemplate.send(KAFKA_EXAMPLE, message );
//		
//		return "Published Successfully";
//	}
//	
	@Autowired
	KafkaTemplate<String, List<User>> kafkaTemplate1;
	
	@PostMapping("/publish")
	public ResponseEntity<String> publishContent(@RequestBody(required = false) List<User> users){
		
		
		System.out.println("Successfully got here");
		
		List<User> list = new ArrayList<>();
		list.add(new User("Name",20));
		
		kafkaTemplate1.send(KAFKA_EXAMPLE, users );
		
		return new ResponseEntity<String>(HttpStatus.OK);
	}
	
}
