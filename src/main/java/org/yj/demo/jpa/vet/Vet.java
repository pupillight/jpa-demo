package org.yj.demo.jpa.vet;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "vets")
@Data
public class Vet {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "first_name")
	private String firstName;
	@Column(name = "last_name")
	private String lastName;


	@ManyToMany
	@JoinTable(name = "vet_specialties",
		joinColumns = {@JoinColumn(name = "vet_id")},
		inverseJoinColumns = {@JoinColumn(name = "specialty_id")})
	private List<Specialty> specialties;
}
