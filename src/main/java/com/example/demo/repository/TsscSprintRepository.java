package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.TsscSprint;
@Repository
public interface TsscSprintRepository extends CrudRepository<TsscSprint, Long> {

}
