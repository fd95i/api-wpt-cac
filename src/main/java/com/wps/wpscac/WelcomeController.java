package com.wps.wpscac;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class WelcomeController {
    @GetMapping
    public Map<String, String> get() {
        HashMap<String, String> hm = new HashMap<>();
        hm.put("Status", "200");
        hm.put("Desctiption", "Operational");
        return hm;
    }
}
