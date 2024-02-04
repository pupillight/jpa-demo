package org.yj.demo.jpa.visit;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VisitRepository extends JpaRepository<Visit, Integer> {

	@Query(value = "select * from visits where pet_id = :petId", nativeQuery = true)
	//@Query(value = "SELECT visit FROM Visit visit WHERE visit.pet.id = :petId")
	public List<Visit> findByPetId(@Param("petId") Integer petId);



}
