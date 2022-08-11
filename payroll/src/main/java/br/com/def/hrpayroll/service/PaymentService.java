package br.com.def.hrpayroll.service;

import br.com.def.hrpayroll.entidade.Payment;
import br.com.def.hrpayroll.feignclients.WorkerFeingClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    @Autowired
    private WorkerFeingClient workerFeingClient;

    public Payment getPayment(String workerId, int days) {
        var worker = workerFeingClient.getId(workerId).getBody();
        if (worker == null) {
            return null;
        } else {
            return Payment
                    .builder()
                    .dailyincome(worker.getDailyIncome())
                    .nome(worker.getNome())
                    .days(days)
                    .build();
        }
    }
}
