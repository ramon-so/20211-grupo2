package com.fatec.GReady.servico;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.fatec.GReady.model.Matricula;
import com.fatec.GReady.model.MatriculaRepository;

@Service
public class MatriculaServicoI implements MatriculaServico{
	Logger logger = LogManager.getLogger(MatriculaServicoI.class);
	@Autowired
	private MatriculaRepository repository;
	
	public Iterable<Matricula> findAll(){
		return repository.findAll();
	}
	public Matricula findByCpf(String cpf) {
		return repository.findByCpf(cpf);
	}
	public void deleteById(Long id) {
		repository.deleteById(id);
		logger.info(">>>>>>>>>> 2. comando exclusão executado para o id =>" + id);
	}
	public Matricula findById(Long id) {
		return repository.findById(id).get();
	}
	public ModelAndView saveOrUpdate(Matricula matricula) {
		ModelAndView modelAndView = new ModelAndView("consultarMatricula");
		return modelAndView;
	}
}
