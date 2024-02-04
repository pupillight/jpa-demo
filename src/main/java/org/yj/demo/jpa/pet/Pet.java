package org.yj.demo.jpa.pet;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.Data;
import org.yj.demo.jpa.visit.Visit;

import java.time.LocalDate;
import java.util.Set;
import java.util.HashSet;


@Entity
@Table(name = "pets")
@Data
public class Pet {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "name", length = 50)
	private String name;

	@Column(name = "birth_date")
	@Temporal(TemporalType.DATE)
	//@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate birthDate;

	@ManyToOne
	@JoinColumn(name = "type_id")
	private PetType type;


/*	@ManyToOne
	@JoinColumn(name ="owner_id")
	private Owner owner;*/

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "pet_id")
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private Set<Visit> visits;

	public void addVisit(Visit visit){
		if(visits==null){
			visits = new HashSet<Visit>();
		}
		visits.add(visit);
	}

	@Override
	public String toString() {
		return "Pet{" +
			"id=" + id +
			", name='" + name + '\'' +
			", birthDate=" + birthDate +
			", type=" + type +
			", visits=" + visits +
			'}';
	}
}
