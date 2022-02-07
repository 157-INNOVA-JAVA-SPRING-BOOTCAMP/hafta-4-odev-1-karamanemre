package com.springmvcjpa.controller;

import com.springmvcjpa.dto.RegisterDto;
import com.springmvcjpa.entity.RegisterEntity;
import com.springmvcjpa.repository.RegisterRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("api/registerRestController")
@AllArgsConstructor
public class RegisterRestController {


    private final RegisterRepository repository;


    @GetMapping("/rest/add")
    public void add(@Valid RegisterEntity registerEntity){
        repository.save(registerEntity);
    }

    @GetMapping("/rest/deleteById")
    public void deleteById(@RequestParam Long id){
        repository.deleteById(id);
    }

    @GetMapping("/rest/update/{id}")
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
        repository.save(registerEntity);
    }


    @GetMapping("/rest/findById/{id}")
    public RegisterEntity findById(@PathVariable(name="id") Long id){
        Optional<RegisterEntity> optional =  repository.findById(id);
        return optional.get();
    }

}
