package com.springmvcjpa.services.concrete;

import com.springmvcjpa.dto.RegisterDto;
import com.springmvcjpa.entity.RegisterEntity;
import com.springmvcjpa.repository.RegisterRepository;
import com.springmvcjpa.services.abstracts.IRegisterService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RegisterManager implements IRegisterService {

    @Autowired
    private RegisterRepository repository;

    @Override
    public String add(RegisterDto dto) {
        System.out.println("dto");
        RegisterEntity registerEntity = new RegisterEntity();
        registerEntity.setId(0L);
        registerEntity.setName(dto.getName());
        registerEntity.setSurname(dto.getSurname());
        registerEntity.setEmail(dto.getEmail());
        registerEntity.setPassword(dto.getPassword());
        repository.save(registerEntity);
        return "Kaydedildi";
    }

    @Override
    public void deleteById(Long id) {
        if (repository.existsById(id)){
            repository.deleteById(id);
        }
    }

    @Override
    public String update(RegisterEntity registerEntity) {
        if (repository.existsById(registerEntity.getId())){
            repository.save(registerEntity);
            return "Güncellendi";
        }
        return "Id bulunamadı başarısız";
    }

    @Override
    public String findById(Long id) {
        Optional<RegisterEntity> optional = repository.findById(id);
        if (optional.isPresent()) {
            return "Data: "+optional.get();
        }
        return "bulunamadı";
    }
}
