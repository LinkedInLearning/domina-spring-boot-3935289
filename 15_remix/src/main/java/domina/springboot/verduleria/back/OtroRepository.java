package domina.springboot.verduleria.back;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface OtroRepository extends CrudRepository<Otro, Long>, PagingAndSortingRepository<Otro, Long> {

}
