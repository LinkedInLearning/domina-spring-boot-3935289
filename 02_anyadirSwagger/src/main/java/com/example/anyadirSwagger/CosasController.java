package com.example.anyadirSwagger;

import java.net.URI;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/cosas")
public class CosasController {
	private static Map<Long, Cosa> cosas;
	
	static {
		cosas = new HashMap<>();
		cosas.put(1L, new Cosa(1L, "primera"));
		cosas.put(2L, new Cosa(2L, "segunda"));
		cosas.put(3L, new Cosa(3L, "tercera"));
	}

	@GetMapping
	private ResponseEntity<Collection<Cosa>> findAll() {
		return ResponseEntity.ok(cosas.values());
	}
	

	@GetMapping("/{id}")
	private ResponseEntity<Cosa> findById(@PathVariable Long id) {
		if (cosas.containsKey(id)) {
			return ResponseEntity.ok(cosas.get(id));
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PostMapping()
	private ResponseEntity<Void> create(@RequestBody Cosa nuevaCosa, UriComponentsBuilder ucb) {
		cosas.put(nuevaCosa.id(), nuevaCosa);
		URI uriVerdura = ucb.path("cosas/{id}").buildAndExpand(nuevaCosa.id()).toUri();
		return ResponseEntity.created(uriVerdura).build();
	}
}
