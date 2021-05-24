package com.yrllanio.controleveiculos.dto;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PastOrPresent;

import com.yrllanio.controleveiculos.entities.Usuario;

public class UsuarioDTO {

	private Long id;
	
	@NotBlank(message = "Campo obrigatório")
	private String nome;
	
	@Email(message = "Favor entrar com um email válido")
	private String email;
	
	@NotBlank(message = "Campo obrigatório")
	private String cpf;
	
	@PastOrPresent(message = "A data não é válida")
	private Instant dataNascimento;

	private List<VeiculoDTO> veiculos = new ArrayList<>();

	public UsuarioDTO() {
	}

	public UsuarioDTO(Long id, String nome, String email, String cpf, Instant dataNascimento, List<VeiculoDTO> veiculos) {
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
		this.veiculos = veiculos;
	}

	public UsuarioDTO(Usuario usuario) {
		id = usuario.getId();
		nome = usuario.getNome();
		email = usuario.getEmail();
		cpf = usuario.getCpf();
		dataNascimento = usuario.getDataNascimento();
		veiculos = usuario.getVeiculos().stream().map(x -> new VeiculoDTO(x)).collect(Collectors.toList());
	}

	public List<VeiculoDTO> getVeiculos() {
		return veiculos;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Instant getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Instant dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

}
