package org.yj.demo.jpa.pet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class PetService {
	@Autowired
	PetRepository petRepository;

	public void createPet(Pet pet) {
		petRepository.save(pet);
	}


	public Pet findById(Integer id) {
		return petRepository.findById(id).orElse(null);
	}

	public void updatePet(Pet pet) {
		petRepository.save(pet);
	}

	public void deletePet(Integer id) {
		petRepository.deleteById(id);
	}

	public List<Pet> getPetsByOwner(Integer ownerId) {
		List<Pet> res = petRepository.findByOwnerId(ownerId);
		return res;
	}
}
