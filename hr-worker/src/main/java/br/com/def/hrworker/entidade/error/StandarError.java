package br.com.def.hrworker.entidade.error;

import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StandarError implements Serializable{
	private static final long serialVersionUID = -5290893849639304076L;
	
	private LocalDateTime timestamp;
	private Integer status;
	private String error;
	private String message;
	private String path;
	

}
