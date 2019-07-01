package br.com.abasteceaqui.model.entidades;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@SuppressWarnings("serial")
@Entity
public class Frentista implements Serializable {
	private Integer id;
	private String cpfFrentista;
	private Integer matricula;
	private String nome;
	private String fone;
	private Endereco endereco;
	private Posto posto;

	public Frentista() {
		this.endereco = new Endereco();
	}

	public Frentista(String cpfFrentista, Integer matricula, String nome, String fone, Endereco endereco,Posto posto) {

		this.cpfFrentista = cpfFrentista;
		this.matricula = matricula;
		this.nome = nome;
		this.fone = fone;
		this.endereco = endereco;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "cpf", length = 11, nullable = false)
	public String getCpfFrentista() {
		return cpfFrentista;
	}

	public void setCpfFrentista(String cpfFrentista) {
		this.cpfFrentista = cpfFrentista;
	}

	@Column(length = 45, nullable = false)
	public Integer getMatricula() {
		return matricula;
	}

	public void setMatricula(Integer matricula) {
		this.matricula = matricula;
	}

	@Column(length = 45, nullable = false)
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Column
	public String getFone() {
		return fone;
	}

	public void setFone(String fone) {
		this.fone = fone;
	}

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	public Posto getPosto() {
		return posto;
	}

	public void setPosto(Posto posto) {
		this.posto = posto;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cpfFrentista == null) ? 0 : cpfFrentista.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Frentista other = (Frentista) obj;
		if (cpfFrentista == null) {
			if (other.cpfFrentista != null)
				return false;
		} else if (!cpfFrentista.equals(other.cpfFrentista))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Frentista [id=" + id + ", cpfFrentista=" + cpfFrentista + ", matricula=" + matricula + ", nome=" + nome
				+ ", fone=" + fone + ", endereco=" + endereco + ", posto=" + posto + "]";
	}

}