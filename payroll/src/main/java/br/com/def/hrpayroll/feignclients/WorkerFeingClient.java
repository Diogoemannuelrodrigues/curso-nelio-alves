package br.com.def.hrpayroll.feignclients;

import br.com.def.hrpayroll.entidade.Worker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(name = "hr-worker", url = "http://localhost:8080", path = "/workers")
public interface WorkerFeingClient {

    @GetMapping(value = "/{id}")
    ResponseEntity<Worker> getId(@PathVariable String id);
}
