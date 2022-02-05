package com.springmvcjpa.controller;

import com.springmvcjpa.dto.RegisterDto;
import com.springmvcjpa.entity.RegisterEntity;
import com.springmvcjpa.services.abstracts.IRegisterService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@Log4j2
public class RegisterController {

    @Autowired
    private IRegisterService registerService;

    @GetMapping("/add")
    @ResponseBody
    public void add(@Valid RegisterDto dto){
        registerService.add(dto);
    }

    @GetMapping("/deleteById")
    @ResponseBody
    public void deleteById(@RequestParam Long id){
        registerService.deleteById(id);
    }

    @GetMapping("/update/{id}")
    @ResponseBody
    public void update(@Valid @PathVariable(name="id") Long id,
                       @RequestParam(name="name") String name,
                       @RequestParam(name="surname") String surname,
                       @RequestParam(name="email") String email,
                       @RequestParam(name="password") String password

    ){
        RegisterEntity registerEntity = new RegisterEntity();
        registerEntity.setId(id);
        registerEntity.setEmail(email);
        registerEntity.setName(name);
        registerEntity.setPassword(password);
        registerEntity.setSurname(surname);
        registerService.update(registerEntity);
    }


    @GetMapping("/findById/{id}")
    @ResponseBody
    public String findById(@PathVariable(name="id") Long id){
        return registerService.findById(id);
    }
}
