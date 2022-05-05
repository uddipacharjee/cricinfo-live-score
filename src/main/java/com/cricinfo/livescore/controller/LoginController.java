package com.cricinfo.livescore.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
@RequiredArgsConstructor( onConstructor_ = { @Autowired} )
public class LoginController {

    @GetMapping( "/login" )
    public String login(){

        return "login";
    }
}
