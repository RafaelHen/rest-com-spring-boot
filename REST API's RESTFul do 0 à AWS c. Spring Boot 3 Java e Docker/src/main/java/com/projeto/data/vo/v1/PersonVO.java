package com.projeto.data.vo.v1;

import java.io.Serializable;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"id", "primeiro_nome", "segundo_nome", "endereco", "genero"})
public class PersonVO implements Serializable{

	private static final long serialVersionUID = 1L;

	private Long id;
	
	@JsonProperty("primeiro_nome")
	private String nome;
	
	@JsonProperty("segundo_nome")
	private String sobrenome;
	
	private String endereco;
	
//	@JsonIgnore
	private String genero;
	
	public PersonVO() {}

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

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	@Override
	public int hashCode() {
		return Objects.hash(endereco, genero, id, nome, sobrenome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PersonVO other = (PersonVO) obj;
		return Objects.equals(endereco, other.endereco) && Objects.equals(genero, other.genero)
				&& Objects.equals(id, other.id) && Objects.equals(nome, other.nome)
				&& Objects.equals(sobrenome, other.sobrenome);
	}

	
}
