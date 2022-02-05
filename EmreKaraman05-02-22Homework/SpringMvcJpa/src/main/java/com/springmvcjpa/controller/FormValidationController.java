package com.springmvcjpa.controller;

import com.springmvcjpa.dto.RegisterDto;
import com.springmvcjpa.services.abstracts.IRegisterService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
@Log4j2
public class FormValidationController {

    @Autowired
    private IRegisterService registerService;

    // http://localhost:8080/formurl
    @GetMapping("/formurl")
    public String getForm(Model model) {
        model.addAttribute("key_form", new RegisterDto());
        return "formvalidation";
    }

    // http://localhost:8080/formurl
    @PostMapping("/formurl")
    public String postForm(@Valid @ModelAttribute("key_form") RegisterDto dto, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            log.error("Hata var");
            log.info(dto);
            return "formvalidation";
        }

        log.info(dto);
        registerService.add(dto);
        return "success";
    }

}