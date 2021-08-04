package com.app.dao.repositories;

import com.app.entities.WeatherDbEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface WeatherDbEntityRepository extends CrudRepository<WeatherDbEntity, Long> {
}
