package com.springmvcjpa.services.abstracts;

import com.springmvcjpa.dto.RegisterDto;
import com.springmvcjpa.entity.RegisterEntity;

import java.util.List;

public interface IRegisterService {

    String add(RegisterDto dto);
    void deleteById(Long id);
    String update(RegisterEntity registerEntity);
    String findById(Long id);
}
