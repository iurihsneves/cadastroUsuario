package br.com.iurihsneves.userapi.controller;

import org.springframework.web.bind.annotation.GetMapping;

public class KeepAlive {
    
    @GetMapping("/keepAlive")
    public String getTime() {
        return "User-Api is alive! - " + java.util.Calendar.getInstance().getTime();
    }

}
