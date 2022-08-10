package br.com.def.hrpayroll.service;

import br.com.def.hrpayroll.entidade.Payment;
import br.com.def.hrpayroll.entidade.Worker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class PaymentService {

    @Autowired
    private RestTemplate restTamplet;

    @Value("${hr-worker.host}")
    private String workerHost;

    public Payment getPayment(String workerId, int days) {

        Map<String, String> uriVariable = new HashMap<>();

        uriVariable.put("id", workerId);

        var worker = restTamplet.getForObject(workerHost + "/workers/{id}", Worker.class, uriVariable);

        if (worker == null) {
            return null;
        } else {
            return Payment.builder().dailyincome(worker.getDailyIncome()).nome(worker.getNome()).days(days).build();
        }

    }
}
