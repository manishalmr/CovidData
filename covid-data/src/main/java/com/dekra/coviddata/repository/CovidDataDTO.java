package com.dekra.coviddata.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dekra.coviddata.entity.CovidData;
@Repository
public interface CovidDataDTO extends CrudRepository<CovidData, Integer>{

}
