package org.yj.demo.jpa.pet;

import lombok.Data;
import org.yj.demo.jpa.owner.Owner;

import java.time.LocalDate;

@Data
public class PetDto {

	private Integer id;

	private String name;

	private LocalDate birthDate;

	private Integer typeId;

	private Integer ownerId;

}
