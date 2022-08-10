package br.com.def.hrworker.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.def.hrworker.entidade.Worker;
import br.com.def.hrworker.repository.WorkerRepository;
import br.com.def.hrworker.service.exception.ObjectNotFoundException;

@Service
public class WorkerService {

	@Autowired
	private WorkerRepository wrepo;

	public Worker findByIdWorker(String id) {
		var worker = wrepo.findById(id);
		return worker.orElseThrow(() -> new ObjectNotFoundException("Nao encontrado"));
	}

	public Worker delete(String id) {
		var workDell = wrepo.findById(id);
		if (workDell.isPresent()) {
			wrepo.delete(workDell.get());
		}
		return null;
	}

	public List<Worker> findAll() {
		return wrepo.findAll();
	}

	public Worker save(Worker work) {

		if (work == null) {
			return null;
		}

		return wrepo.save(work);
	}

}
