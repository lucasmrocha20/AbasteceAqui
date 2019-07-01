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
public class Cliente implements Serializable {
	private Integer id;
	private String cnpjCliente;
	private String razaoSocial;
	private String fone;
	private Endereco endereco;

	public Cliente() {
		this.endereco = new Endereco();
	}

	public Cliente(Integer id, String cnpjCliente, String razaoSocial, String fone, Endereco endereco) {

		this.id = id;
		this.cnpjCliente = cnpjCliente;
		this.razaoSocial = razaoSocial;
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

	@Column(name = "cnpj", length = 16, nullable = false)
	public String getCnpjCliente() {
		return cnpjCliente;
	}

	public void setCnpjCliente(String cnpjCliente) {
		this.cnpjCliente = cnpjCliente;
	}

	@Column(name = "nome", length = 45, nullable = false)
	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cnpjCliente == null) ? 0 : cnpjCliente.hashCode());
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
		Cliente other = (Cliente) obj;
		if (cnpjCliente == null) {
			if (other.cnpjCliente != null)
				return false;
		} else if (!cnpjCliente.equals(other.cnpjCliente))
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
		return "Cliente [id=" + id + ", cnpjCliente=" + cnpjCliente + ", razaoSocial=" + razaoSocial + ", fone=" + fone
				+ ", endereco=" + endereco + "]";
	}

}
