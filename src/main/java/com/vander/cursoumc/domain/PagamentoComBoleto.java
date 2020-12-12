package com.vander.cursoumc.domain;

import java.time.LocalDateTime;

import javax.persistence.Entity;

import com.vander.cursoumc.domain.enums.EstadoPagamento;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class PagamentoComBoleto extends Pagamento {
	private static final long serialVersionUID = 1L;
	
	private LocalDateTime dataVencimento;
	private LocalDateTime dataPagamento;
	
	public PagamentoComBoleto() {
	}

	public PagamentoComBoleto(Integer id, EstadoPagamento estado, Pedido pedido, 
			LocalDateTime dataVencimento, LocalDateTime dataPagamento) {
		super(id, estado, pedido);
		this.dataVencimento = dataVencimento;
		this.dataPagamento = dataPagamento;
	}

}
