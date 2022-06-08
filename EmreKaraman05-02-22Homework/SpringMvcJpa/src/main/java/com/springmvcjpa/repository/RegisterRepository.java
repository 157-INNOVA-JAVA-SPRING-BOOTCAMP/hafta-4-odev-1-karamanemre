package com.springmvcjpa.repository;

import com.springmvcjpa.entity.RegisterEntity;
import org.springframework.data.repository.CrudRepository;

public interface RegisterRepository extends CrudRepository<RegisterEntity,Long> {

}
