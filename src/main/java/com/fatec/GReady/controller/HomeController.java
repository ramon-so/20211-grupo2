package com.fatec.GReady.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
	@GetMapping("/")
	public ModelAndView menu() {
		return new ModelAndView("paginaMenu");
	}

	@GetMapping("/login")
	public ModelAndView autenticacao() {
		return new ModelAndView("paginaLogin");
	}

	@GetMapping("/curso/cadastrar")
	public ModelAndView cadastrarLivro() {
		return new ModelAndView("cadastrarCurso");
	}

	@GetMapping("/aluno/cadastrar")
	public ModelAndView cadastrarAluno() {
		return new ModelAndView("cadastrarCliente");
	}
	
	@GetMapping("/error")
	public ModelAndView error() {
		return new ModelAndView("error");
	}
	
}