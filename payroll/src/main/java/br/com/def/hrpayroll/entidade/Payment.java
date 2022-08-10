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
public class Payment implements Serializable{

	private static final long serialVersionUID = 8096447511383426277L;

	private String nome;
	private Double dailyincome;
	private Integer days;
	
	public Double getTotal() {
		return days * dailyincome;
	}
	
}
