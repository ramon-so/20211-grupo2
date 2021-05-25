package com.fatec.GReady.servico;

import org.springframework.web.servlet.ModelAndView;

import com.fatec.GReady.model.Cliente;
import com.fatec.GReady.model.matricula;

public interface MatriculaServico {
	public Iterable<matricula> findAll();

	public Cliente findByCpf(String cpf);

	public void deleteById(Long id);

	public Cliente findById(Long id);

	public ModelAndView saveOrUpdate(Cliente cliente);

	public String obtemEndereco(String cep);

}
