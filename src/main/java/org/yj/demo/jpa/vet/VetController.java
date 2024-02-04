package org.yj.demo.jpa.vet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/vet")
public class VetController {

	@Autowired
	VetService vetService;
	@GetMapping
	public List<Vet> getVets(@RequestParam(required = false, defaultValue = "0") int pageNum) {
		List<Vet> vets =vetService.findAll(pageNum);
		vets.forEach(System.out::println);
		return vets;
	}
}
