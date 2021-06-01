package com.fatec.GReady.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;

import com.sun.istack.NotNull;

@Entity
public class Matricula {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@NotNull
	@Size(min = 11, message = "CPF deve ter 11 caracteres")
	@Column(unique = true)
	private String cpf;
	
	@NotNull
	private String nome;
	
	@NotNull
	private String email;
	
	@NotNull
	private String dataNascimento;
	
	@NotNull
	private String endereco;
	
	@NotNull
	private String telefone;
	
	public Matricula() {
	}

	public Matricula(@Size(min = 11, message = "CPF deve ter 11 caracteres") String cpf, String nome, String email,
			String dataNascimento, String endereco, String telefone) {
		this.cpf = cpf;
		this.nome = nome;
		this.email = email;
		this.dataNascimento = dataNascimento;
		this.endereco = endereco;
		this.telefone = telefone;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	@Override
	public String toString() {
		return "Matricula [id=" + id + ", cpf=" + cpf + ", nome=" + nome + ", email=" + email + ", dataNascimento="
				+ dataNascimento + ", endereco=" + endereco + ", telefone=" + telefone + "]";
	}
	
	
}
