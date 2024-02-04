package org.yj.demo.jpa.vet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class VetService {

	@Autowired
	VetRepository vetRepository;

	@Transactional
	public List<Vet> findAll(int pageNum) {

		Page<Vet> page = vetRepository.findAll(PageRequest.of(pageNum, 5));
		return page.getContent();
	}
}
