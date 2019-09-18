package com.codeclan.example.WhiskyTracker.repositories.DistilleryRepository;

import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.models.Whisky;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DistilleryRepository extends JpaRepository<Distillery, Long>, DistilleryRepositoryCustom {

List<Distillery> findDistilleryByRegion(String distilleryRegion);

//List<Distillery> findWhiskiesFromDistilleryByWhiskyAge(int age);


    //Get distilleries that have whiskies that are 12 years old

List<Distillery> findDistilleryWithWhiskyOlderThan12Years(int age);

}
