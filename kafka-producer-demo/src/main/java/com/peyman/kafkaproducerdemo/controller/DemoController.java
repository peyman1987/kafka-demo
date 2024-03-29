package com.peyman.kafkaproducerdemo.controller;

import com.peyman.kafkaproducerdemo.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
public class DemoController {

    @Autowired
    KafkaTemplate<String, Book> kafkaTemplate;

    private static final String TOPIC = "NewTopic";

    @PostMapping("/publish")
    public String publishMessage(@RequestBody Book book)
    {
        kafkaTemplate.send(TOPIC, book);
        return "Published Successfully!";
    }
//    @GetMapping("/publish/{message}")
//    public String publishMessage(@PathVariable("message") final String message){
//        kafkaTemplate.send(TOPIC, message);
//        return "Published successfully!";
//    }
}
