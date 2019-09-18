package com.codeclan.example.WhiskyTracker;

import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.models.Whisky;
import com.codeclan.example.WhiskyTracker.repositories.DistilleryRepository.DistilleryRepository;
import com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository.WhiskyRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WhiskyTrackerApplicationTests {

	@Autowired
	WhiskyRepository whiskyRepository;

	@Autowired
	DistilleryRepository distilleryRepository;

	@Test
	public void contextLoads() {
	}

	@Test
	public void findWhiskyByYear() {
		List<Whisky> found = whiskyRepository.findWhiskyByYear(1991);
		assertEquals("The Rosebank 12 - Flora and Fona", found.get(0).getName());
	}

	@Test
	public void findDistilleryByRegion() {
		List<Distillery> found = distilleryRepository.findDistilleryByRegion("Highland");
		assertEquals("Highland", found.get(0).getRegion());
	}

	@Test
	public void findWhiskyByAge() {
		List<Whisky> found = whiskyRepository.findWhiskyByAge(12);
		assertEquals(12, found.get(0).getAge());
	}

	@Test
	public void findWhiskiesFromDistilleryByWhiskyAge() {
		List<Whisky> found = whiskyRepository.findWhiskiesFromDistilleryByWhiskyAge( 1L, 12);
		assertEquals("The Glendronach Original", found.get(0).getName());
	}

	@Test
	public void findWhiskiesFromAParticularRegion(){
		List<Whisky> found = whiskyRepository.findWhiskiesFromAParticularRegion("Highland");
		assertEquals("The Glendronach Revival", found.get(0).getName());
	}

	@Test
	public void findDistilleryWithWhiskyOlderThan12Years(){
		List<Distillery> found = distilleryRepository.findDistilleryWithWhiskyOlderThan12Years( 15);
		assertEquals("Glendronach", found.get(0).getName());
	}

}
