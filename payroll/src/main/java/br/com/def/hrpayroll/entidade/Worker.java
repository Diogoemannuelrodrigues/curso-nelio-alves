package br.com.def.hrpayroll.entidade;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Worker implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;
    private String nome;
    private Double dailyIncome;

}
