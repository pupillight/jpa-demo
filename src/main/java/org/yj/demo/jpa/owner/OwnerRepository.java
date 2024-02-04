package org.yj.demo.jpa.owner;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.yj.demo.jpa.owner.Owner;

import java.util.List;

@Repository
public interface OwnerRepository extends JpaRepository<Owner,Integer> {

	public Page<Owner> findAll(Pageable pageable);

	public List<Owner> findByLastNameIgnoreCase(String lastName);

	public Page<Owner> findByLastNameStartsWith(String lastName, Pageable pageable);


}
