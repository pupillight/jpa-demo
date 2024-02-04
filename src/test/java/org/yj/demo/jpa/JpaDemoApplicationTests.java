package org.yj.demo.jpa;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.yj.demo.jpa.vet.Vet;
import org.yj.demo.jpa.vet.VetService;

import java.util.List;

@SpringBootTest(classes = JpaDemoApplication.class)
class JpaDemoApplicationTests {

	@Autowired
	VetService vetService;

	@Test
	public void getVets(){
		List<Vet> vets =vetService.findAll(0);
		vets.forEach(System.out::println);
	}

	@Test
	void contextLoads() {
	}

}
