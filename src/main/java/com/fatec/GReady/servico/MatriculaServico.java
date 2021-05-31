package com.fatec.GReady.servico;

import org.springframework.web.servlet.ModelAndView;

import com.fatec.GReady.model.Matricula;

public interface MatriculaServico {
	public Iterable<Matricula>findAll();
	public Matricula findByCpf(String cpf);
	public void deleteById(Long id);
	public Matricula findById(Long id);
	public ModelAndView saveOrUpdate(Matricula matricula);
}
