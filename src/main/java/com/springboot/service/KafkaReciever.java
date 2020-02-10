package com.springboot.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.springboot.model.Student;

@Service
public class KafkaReciever {

	private static final Logger LOGGER = LoggerFactory.getLogger(KafkaReciever.class);

	@KafkaListener(topics = "${kafka.topic.name}", group = "${kafka.consumer.group.id}")
	public void recieveData(Student student) {
		LOGGER.info("Data recieved by consumer===>");
		LOGGER.info("Consumer Data - " + student.toString() + " recieved");
		LOGGER.info("Consumer Id - " + student.getStudentId() + " recieved");
		LOGGER.info("Consumer FirstName - " + student.getFirstName() + " recieved");
		LOGGER.info("Consumer LastName " + student.getLastName() + " recieved");
		LOGGER.info("Consumer Age - " + student.getAge() + " recieved");
	}
}
