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
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@CrossOrigin // con esta línea logro que funcione desde Angular
public class RemixController {

	private final OtroRepository otroRepository;
	private final VerduleriaRepository verduleriaRepository;

	private RemixController(OtroRepository otroRepository, VerduleriaRepository verduleriaRepository) {
		this.otroRepository = otroRepository;
		this.verduleriaRepository = verduleriaRepository;
	}

	@GetMapping("otros2/{id}")
	private ResponseEntity<Otro> findOtroById(@PathVariable Long id) {
		Optional<Otro> otroOptional = otroRepository.findById(id);
		if (otroOptional.isPresent()) {
			return ResponseEntity.ok(otroOptional.get());
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PostMapping("otros2")
	private ResponseEntity<Otro> create(@RequestBody Otro nuevaOtro, UriComponentsBuilder ucb) {
		Otro otro = otroRepository.save(nuevaOtro);
		URI uriOtro = ucb.path("otros/{id}").buildAndExpand(otro.getId()).toUri();
		return ResponseEntity.status(HttpStatus.CREATED).location(uriOtro).body(otro);
	}

	@GetMapping("otros2")
	private ResponseEntity<Page<Otro>> findOtroAll(Pageable pageable) {
		Page<Otro> pag = otroRepository.findAll(PageRequest.of(pageable.getPageNumber(),
				pageable.getPageSize(), pageable.getSortOr(Sort.by(Direction.ASC, "precio"))));
		return ResponseEntity.ok(pag);
	}


	@GetMapping("verduras2/{id}")
	private ResponseEntity<Verdura> findById(@PathVariable Long id) {
		Optional<Verdura> verduraOptional = verduleriaRepository.findById(id);
		if (verduraOptional.isPresent()) {
			return ResponseEntity.ok(verduraOptional.get());
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PostMapping("verduras2")
	private ResponseEntity<Verdura> create(@RequestBody Verdura nuevaVerdura, UriComponentsBuilder ucb) {
		Verdura verdura = verduleriaRepository.save(nuevaVerdura);
		URI uriVerdura = ucb.path("verduras/{id}").buildAndExpand(verdura.getId()).toUri();
		return ResponseEntity.status(HttpStatus.CREATED).location(uriVerdura).body(verdura);
	}

	@GetMapping("verduras2")
	private ResponseEntity<Page<Verdura>> findAll(Pageable pageable) {
		Page<Verdura> pag = verduleriaRepository.findAll(PageRequest.of(pageable.getPageNumber(),
				pageable.getPageSize(), pageable.getSortOr(Sort.by(Direction.ASC, "precio"))));
		return ResponseEntity.ok(pag);
	}

}
