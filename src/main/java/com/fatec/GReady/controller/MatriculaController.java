package com.fatec.GReady.controller;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.fatec.GReady.model.Matricula;
import com.fatec.GReady.servico.MatriculaServico;

@Controller
@RequestMapping(path = "/sig")
public class MatriculaController {
	Logger logger = LogManager.getLogger(MatriculaController.class);
	
	@Autowired
	MatriculaServico servico;
	
	@GetMapping("/matriculas")
	public ModelAndView retornaConsultaDeTodasMatriculas(Matricula matricula) {
		ModelAndView modelAndView = new ModelAndView("consultarMatricula");
		modelAndView.addObject("matricula", servico.findAll());
		return modelAndView;
	}
	
	@GetMapping("/matricula")
	public ModelAndView retornaFormDeMatricula(Matricula matricula) {
		ModelAndView mv = new ModelAndView("matricularAluno");
		mv.addObject("matricula", matricula);
		return mv;
	}
	
	@GetMapping("/matriculas/{cpf}")
	public ModelAndView retornaFormParaEditarMatricula(@PathVariable("cpf") String cpf) {
		ModelAndView modelAndView = new ModelAndView("atualizarMatricula");
		modelAndView.addObject("matricula", servico.findByCpf(cpf));
		return modelAndView;
	}
	
	@GetMapping("/matricula/{id}")
	public ModelAndView excluirNoFormDeConsultaMatricula(@PathVariable("id") Long id) {
		servico.deleteById(id);
		logger.info(">>>>>> 1. servico de exclusao chamado para o id => " + id);
		ModelAndView modelAndView = new ModelAndView("consultarMatricula");
		modelAndView.addObject("matriculas", servico.findAll());
		return modelAndView;
	}
	
	@PostMapping("/matriculas")
	public ModelAndView save(@Valid Matricula matricula, BindingResult result) {
		ModelAndView modelAndView = new ModelAndView("consultarMatricula");
		if (result.hasErrors()) {
			modelAndView.setViewName("matricularAluno");
		}else {
			modelAndView = servico.saveOrUpdate(matricula);
		}
		return modelAndView;
	}
	
	@PostMapping("/matriculas/{id}")
	public ModelAndView atualizaCliente(@PathVariable("id") Long id, @Valid Matricula matricula, BindingResult result) {
		ModelAndView modelAndView = new ModelAndView("consultarMatricula");
		if (result.hasErrors()) {
			matricula.setId(id);
			return new ModelAndView("atualizarCliente");
		}
		
		Matricula umaMatricula = servico.findById(id);
		umaMatricula.setCpf(matricula.getCpf());
		umaMatricula.setNome(matricula.getNome());
		umaMatricula.setDataNascimento(matricula.getDataNascimento());
		umaMatricula.setEndereco(matricula.getEndereco());
		umaMatricula.setEmail(matricula.getEmail());
		umaMatricula.setTelefone(matricula.getTelefone());
		
		modelAndView = servico.saveOrUpdate(umaMatricula);
		
		return modelAndView;
	}

}
