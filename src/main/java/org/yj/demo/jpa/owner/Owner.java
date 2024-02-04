package org.yj.demo.jpa.owner;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;
import org.yj.demo.jpa.pet.Pet;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "owners")
@Data
@ToString
public class Owner {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "first_name", length = 50)
	private String firstName;
	@Column(name = "last_name", length = 50)
	private String lastName;
	@Column(name = "address", length = 100)
	private String address;
	@Column(name = "city", length = 50)
	private String city;
	@Column(name = "telephone", length = 50)
	private String telephone;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	//@OneToMany
	@JoinColumn(name = "owner_id")
	@OrderBy(value = "name")
	private Set<Pet> pets;

	public void addPet(Pet pet){
		if(pets ==null){
			pets = new HashSet<>();
		}
		pets.add(pet);
	}

}
