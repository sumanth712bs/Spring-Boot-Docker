package io.badadal.sumanth.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author sbadadal
 */

@RestController
@RequestMapping("/docker")
public class MainController {

    @GetMapping("/test")
    public String demoMethod(){

        return "Spring Boot with Docker learning !!";
    }
}
