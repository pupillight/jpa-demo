package org.yj.demo.jpa.visit;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Entity
@Table(name = "visits")
@Data
public class Visit {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	/*@ManyToOne
	@JoinColumn(name = "pet_id")
	private Pet pet;*/

	/*@Column(name = "pet_id")
	private Integer petId;*/

	@Column(name = "visit_date")
	@Temporal(TemporalType.DATE)
	//@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate visitDate;

	@Column(name = "description")
	private String desc;


}
