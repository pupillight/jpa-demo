package org.yj.demo.jpa.owner;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.yj.demo.jpa.pet.Pet;

import java.util.List;

@RestController
@RequestMapping(value = "/owner")
@Slf4j
public class OwnerController {

	@Autowired
	OwnerService ownerService;

	@GetMapping
	public List<Owner> getOwners(@RequestParam(required = false, defaultValue = "0") int page) {
		List<Owner> res = ownerService.findAll(page);
		return res;
	}

	@GetMapping("/{id}")
	public Owner getOwnerById(@PathVariable Integer id) {
		log.info("id=" + id);
		Owner res = ownerService.findById(id);
		return res;
	}

	@GetMapping("/lastName")
	public List<Owner> getOwnerByLastName(@RequestParam(name = "lastName") String lastName,
										  @RequestParam(defaultValue = "0", required = false) int page) {
		return ownerService.findByLastName(lastName, page);
	}

	@PostMapping
	public Integer addNewOwner(@RequestBody Owner owner) {
		log.info("owner", owner);
		int res =ownerService.createOwner(owner);
		return res;
	}

	@PutMapping("/edit/{id}")
	public void updateOwner(@PathVariable Integer id, @RequestBody Owner owner) {
		log.info("owner", owner);
		ownerService.updateOwner(owner);
	}

}
