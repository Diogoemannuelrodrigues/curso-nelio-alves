package br.com.def.hrworker.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.def.hrworker.entidade.Worker;
import br.com.def.hrworker.service.WorkerService;

@RestController
@RequestMapping("/workers")
public class WorkerController {

	@Autowired
	private WorkerService workService;

	@PostMapping
	public ResponseEntity<Worker> save(@RequestBody Worker work) {

		var worker = workService.save(work);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(worker.getId()).toUri();

		return ResponseEntity.created(uri).build();
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Worker> getId(@PathVariable String id) {
		var work = workService.findByIdWorker(id);

		if (work != null) {
			return ResponseEntity.ok(work);
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(work);
	}

	@GetMapping
	public ResponseEntity<List<Worker>> getAll() {
		List<Worker> workers = workService.findAll();

		if (!workers.isEmpty()) {
			return ResponseEntity.ok(workers);
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(workers);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Worker> deleteId(@PathVariable String id) {
		workService.delete(id);

		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

}
