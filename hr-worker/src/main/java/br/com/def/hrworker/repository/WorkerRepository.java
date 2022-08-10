package br.com.def.hrworker.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.def.hrworker.entidade.Worker;

@Repository
public interface WorkerRepository extends MongoRepository <Worker, String> {
	
	Worker findByNome(String nome);
}
