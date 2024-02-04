package org.yj.demo.jpa.vet;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "specialties")
@Data
public class Specialty {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column
	private String name;
}
