package com.cricinfo.livescore.controller;

import com.cricinfo.livescore.model.request.UserRegistrationRequest;
import com.cricinfo.livescore.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("registration")
public class UserRegistrationController {

    private final UserService userService;

    public UserRegistrationController(UserService userService) {
        super();
        this.userService = userService;
    }

    @GetMapping
    public String showRegistrationForm(Model model) {
        model.addAttribute("user",UserRegistrationRequest.builder().build());
        return "registration";
    }

    @PostMapping
    public String registerUserAccount(@Valid UserRegistrationRequest registrationDto, BindingResult bindingResult, RedirectAttributes redirectAttributes ) {
        if(bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("errorMessage", "Invalid data");
            return "redirect:/registration";
        }
        try{
            userService.save(registrationDto);
        }catch (Exception e){
            redirectAttributes.addFlashAttribute("errorMessage", e.getMessage());
            return "redirect:/registration";
        }
        redirectAttributes.addFlashAttribute("successMessage", "Registration Successful. Please Login.");
        return "redirect:/login";
    }
}
