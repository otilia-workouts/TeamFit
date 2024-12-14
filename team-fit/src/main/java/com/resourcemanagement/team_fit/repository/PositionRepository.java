package com.resourcemanagement.team_fit.repository;


import com.resourcemanagement.team_fit.model.Skill;
import com.resourcemanagement.team_fit.model.basic.Position;
import org.springframework.data.repository.CrudRepository;

public interface PositionRepository extends CrudRepository<Position, Long> {

}
