package org.yj.demo.jpa.pet;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.yj.demo.jpa.pet.Pet;

import java.util.List;

@Repository
public interface PetRepository extends JpaRepository<Pet, Integer> {

	//@Query("SELECT pet FROM Pet pet WHERE pet.owner.id = :id" )
	@Query(value = "select * from pets where owner_id = :id", nativeQuery = true)
	List<Pet> findByOwnerId(@Param("id") Integer ownerId);

}
