package domina.springboot.verduleria.back;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface VerduleriaRepository extends CrudRepository<Verdura, Long>, PagingAndSortingRepository<Verdura, Long> {
	Optional<Verdura> findByIdAndOwner(Long id, String owner);
	
	Page<Verdura> findByOwner(String owner, PageRequest pageRequest);
	
	Page<Verdura> findByOwnerAndPrecioBetween(String owner, Double desde, Double hasta, PageRequest pageRequest);
} 
