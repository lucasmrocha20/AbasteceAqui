package br.com.abasteceaqui.model.entidades;

import java.io.Serializable;
import java.math.BigDecimal;

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
public class Posto implements Serializable {
	private Integer id;
	private String nomeFantasia;
	private String cnpj;
	private BigDecimal precoAlcool;
	private BigDecimal precoGasolina;
	private String distribuidora;
	private String fone;
	private Endereco endereco;
	private Cliente cliente;

	public Posto() {
		this.endereco = new Endereco();
	}

	public Posto(Integer id, String nomeFantasia, String cnpj, BigDecimal precoAlcool, BigDecimal precoGasolina,
			String distribuidora, String fone, Endereco endereco, Cliente cliente) {

		this.id = id;
		this.nomeFantasia = nomeFantasia;
		this.cnpj = cnpj;
		this.precoAlcool = precoAlcool;
		this.precoGasolina = precoGasolina;
		this.distribuidora = distribuidora;
		this.fone = fone;
		this.endereco = endereco;
		this.cliente = cliente;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(length = 45, nullable = false)
	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	@Column(name = "cnpj", length = 14, nullable = false)
	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	@Column(nullable = false)
	public BigDecimal getPrecoAlcool() {
		return precoAlcool;
	}

	public void setPrecoAlcool(BigDecimal precoAlcool) {
		this.precoAlcool = precoAlcool;
	}

	@Column(nullable = false)
	public BigDecimal getPrecoGasolina() {
		return precoGasolina;
	}

	public void setPrecoGasolina(BigDecimal precoGasolina) {
		this.precoGasolina = precoGasolina;
	}

	@Column(length = 45, nullable = false)
	public String getDistribuidora() {
		return distribuidora;
	}

	public void setDistribuidora(String distribuidora) {
		this.distribuidora = distribuidora;
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
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cnpj == null) ? 0 : cnpj.hashCode());
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
		Posto other = (Posto) obj;
		if (cnpj == null) {
			if (other.cnpj != null)
				return false;
		} else if (!cnpj.equals(other.cnpj))
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
		return "Posto [id=" + id + ", nomeFantasia=" + nomeFantasia + ", cnpj=" + cnpj + ", precoAlcool="
				+ precoAlcool + ", precoGasolina=" + precoGasolina + ", distribuidora=" + distribuidora + ", fone="
				+ fone + ", endereco=" + endereco + ", cliente=" + cliente + "]";
	}

}
