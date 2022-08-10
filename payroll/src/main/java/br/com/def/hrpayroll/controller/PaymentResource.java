package br.com.def.hrpayroll.controller;

import br.com.def.hrpayroll.entidade.Payment;
import br.com.def.hrpayroll.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payments")
public class PaymentResource {

	@Autowired
	private PaymentService paymentService;

	@GetMapping(value = "/{workerId}/days/{days}")
	public ResponseEntity<Payment> getPagamentos(@PathVariable String workerId, @PathVariable int days ) {
		
		var payment = paymentService.getPayment(workerId, days);
		
		return ResponseEntity.ok(payment);
	}
}
