package org.yj.demo.jpa.pet;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.yj.demo.jpa.owner.Owner;
import org.yj.demo.jpa.owner.OwnerService;
import org.yj.demo.jpa.visit.Visit;
import org.yj.demo.jpa.visit.VisitService;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/owner/{ownerId}")
@Slf4j
public class PetController {

	@Autowired
	PetService petService;

	@Autowired
	OwnerService ownerService;

	@Autowired
	VisitService visitService;


	@GetMapping("/pet/{petId}/visit")
	public Set<Visit> getPetVisits(@PathVariable Integer ownerId, @PathVariable Integer petId) {
		Owner owner = ownerService.findById(ownerId);
		for (Pet pet : owner.getPets()) {
			if (pet.getId() == petId) {
				return pet.getVisits();
			}
		}
		return null;
	}

	@PostMapping("/pet/{petId}/visit")
	public void addVisit(@PathVariable Integer ownerId,@PathVariable Integer petId, @RequestBody Visit visit) {
		System.out.println(petId);
		System.out.println(visit);
		ownerService.addPetVisit(ownerId,petId,visit);
		//visitService.addVisit(petId, visit);
	}

	@PostMapping("/pet")
	public void addPet(@PathVariable Integer ownerId, @RequestBody Pet pet) {
		log.info(pet.toString());
		ownerService.addPet(ownerId, pet);
	}

	@GetMapping("/pet/{petId}")
	public Pet getPet(@PathVariable Integer ownerId, @PathVariable Integer petId) {
		Owner owner = ownerService.findById(ownerId);
		for (Pet pet : owner.getPets()) {
			if (pet.getId() == petId) {
				return pet;
			}
		}
		return null;
	}

	@PutMapping("/pet/{petId}")
	public void updatePet(@PathVariable Integer ownerId, @PathVariable Integer petId, @RequestBody Pet pet) {
		ownerService.updatePet(ownerId, pet);

	}

	@DeleteMapping("/pet/{petId}")
	public void deletePet(@PathVariable Integer ownerId, @PathVariable Integer petId) {
		ownerService.deletePet(ownerId, petId);

	}
}
