package com.viniciusmdc.ExemploPatternSingleton.Controller;

import com.viniciusmdc.ExemploPatternSingleton.Service.Impl.ThreadServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/thread")
public class ThreadController {

    @Autowired
    public ThreadServiceImpl threadService;

    @GetMapping("/start/{id}")
    public ResponseEntity<String> startThread(@PathVariable String id){
        threadService.start(id);
        return new ResponseEntity<>("Thread iniciada com sucesso", HttpStatus.OK);
    }

    @GetMapping("/stop/{id}")
    public ResponseEntity<String> stopThread(@PathVariable String id){
        threadService.stop(id);
        return new ResponseEntity<>("Thread interrompida com sucesso", HttpStatus.OK);
    }
}
