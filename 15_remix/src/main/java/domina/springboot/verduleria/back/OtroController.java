package domina.springboot.verduleria.back;

import java.net.URI;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@CrossOrigin // con esta línea logro que funcione desde Angular
@RequestMapping("/otros")
public class OtroController {

	private final OtroRepository otroRepository;

	private OtroController(OtroRepository otroRepository) {
		this.otroRepository = otroRepository;
	}

	@GetMapping("/{id}")
	private ResponseEntity<Otro> findById(@PathVariable Long id) {
		Optional<Otro> otroOptional = otroRepository.findById(id);
		if (otroOptional.isPresent()) {
			return ResponseEntity.ok(otroOptional.get());
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PostMapping()
	private ResponseEntity<Otro> create(@RequestBody Otro nuevaOtro, UriComponentsBuilder ucb) {
		Otro otro = otroRepository.save(nuevaOtro);
		URI uriOtro = ucb.path("otros/{id}").buildAndExpand(otro.getId()).toUri();
		return ResponseEntity.status(HttpStatus.CREATED).location(uriOtro).body(otro);
	}

	@GetMapping
	private ResponseEntity<Page<Otro>> findAll(Pageable pageable) {
		Page<Otro> pag = otroRepository.findAll(PageRequest.of(pageable.getPageNumber(),
				pageable.getPageSize(), pageable.getSortOr(Sort.by(Direction.ASC, "precio"))));
		return ResponseEntity.ok(pag);
	}

}
