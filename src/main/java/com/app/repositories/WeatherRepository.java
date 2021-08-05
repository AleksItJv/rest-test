package com.app.repositories;

import com.app.entities.WeatherDbEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface WeatherRepository extends CrudRepository<WeatherDbEntity, Long> {
}
