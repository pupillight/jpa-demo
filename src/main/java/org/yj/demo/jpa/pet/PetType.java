package org.yj.demo.jpa.pet;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "types")
@Data
public class PetType {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "name", length = 50)
	private String name;
}
