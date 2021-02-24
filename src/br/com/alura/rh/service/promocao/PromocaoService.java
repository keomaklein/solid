package br.com.alura.rh.service.promocao;

import br.com.alura.rh.ValidacaoException;
import br.com.alura.rh.model.Cargo;
import br.com.alura.rh.model.Funcionario;

public class PromocaoService {
	
	public void promover(Funcionario funcionario, boolean meta) {
		Cargo cargoAtual = funcionario.getDadosPessoais().getCargo();
		if(Cargo.GERENTE == cargoAtual) {
			throw new ValidacaoException("Gerentes não podem ser promovidos!");
		}
		
		if(meta) {
			Cargo novoCargo = cargoAtual.getProximoCargo();
			funcionario.getDadosPessoais().promover(novoCargo);
		}else {
			throw new ValidacaoException("Funcionario nao bteu a meta!");
		}
	}

}
