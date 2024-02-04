package org.yj.demo.jpa.owner;


import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.yj.demo.jpa.owner.Owner;
import org.yj.demo.jpa.owner.OwnerRepository;
import org.yj.demo.jpa.pet.Pet;
import org.yj.demo.jpa.pet.PetRepository;
import org.yj.demo.jpa.visit.Visit;

import java.awt.desktop.ScreenSleepEvent;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class OwnerService {

	@Autowired
	OwnerRepository ownerRepository;

	@Autowired
	PetRepository petRepository;

	public List<Owner> findAll(int pageNum) {
		Pageable pageable = PageRequest.of(pageNum, 5, Sort.by("id").ascending());
		Page<Owner> res = ownerRepository.findAll(pageable);
		return res.getContent();
	}

	public Owner findById(Integer id) {
		Optional<Owner> op = ownerRepository.findById(id);
		return op.orElse(null);
	}

	public List<Owner> findByLastName(String lastName, Integer pageNum) {
		Pageable pageable = PageRequest.of(pageNum, 5, Sort.by("id").ascending());
		List<Owner> res = ownerRepository.findByLastNameStartsWith(lastName, pageable).getContent();
		return res;
	}

	public Integer createOwner(Owner owner) {
		Owner res = ownerRepository.save(owner);
		System.out.println(owner);
		System.out.println(owner);
		System.out.println(owner == res);
		return owner.getId();
	}

	public void updateOwner(Owner owner) {
		Optional<Owner> optional = ownerRepository.findById(owner.getId());
		Owner persistedOwner = optional.get();
		BeanUtils.copyProperties(owner, persistedOwner, "pets");
		Owner o = ownerRepository.save(persistedOwner);
		System.out.println(o);
	}


	public void addPet(Integer ownerId, Pet pet) {
		Optional<Owner> optional = ownerRepository.findById(ownerId);
		Owner owner = null;
		if (optional.isPresent()) {
			owner = optional.get();
			//petRepository.save(pet);
			owner.addPet(pet);
			ownerRepository.save(owner);
		}
	}

	public void updatePet(Integer ownerId, Pet pet) {
		Optional<Owner> optional = ownerRepository.findById(ownerId);
		if (optional.isPresent()) {
			Owner owner = optional.get();
			owner.getPets().stream().forEach(item -> {
				if(item.getId() ==pet.getId()){
					BeanUtils.copyProperties(pet,item);
				}
			});
			System.out.println(owner);
			Owner res =ownerRepository.save(owner);
			System.out.println(res);
		}
	}

	public void deletePet(Integer ownerId, Integer petId){
/*		Owner owner = ownerRepository.findById(ownerId).get();
		Set<Pet> pets = owner.getPets().stream().filter(item -> item.getId() != petId).collect(Collectors.toSet());
		owner.setPets(pets);

		ownerRepository.save(owner);*/
		petRepository.deleteById(petId);
	}

	public void addPetVisit(Integer ownerId, Integer petId, Visit visit){

		Owner owner =ownerRepository.findById(ownerId).get();
		for(Pet pet:owner.getPets()){
			if(pet.getId()== petId){
				pet.addVisit(visit);
			}
		}

		ownerRepository.save(owner);
	}
}
