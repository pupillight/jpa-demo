package org.yj.demo.jpa.visit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.yj.demo.jpa.pet.Pet;
import org.yj.demo.jpa.pet.PetRepository;

import java.util.List;

@Service
public class VisitService {

	@Autowired
	VisitRepository visitRepository;

	@Autowired
	PetRepository petRepository;

	public List<Visit> findByPetId(Integer petId){
		return visitRepository.findByPetId(petId);
	}


	@Transactional
	public void addVisit(Integer petId,Visit visit){
		Pet pet = petRepository.findById(petId).orElse(null);
		pet.addVisit(visit);
		petRepository.save(pet);
		//visitRepository.save(visit);
	}
}
