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
public class Venda implements Serializable {
	private Integer id;
	private Integer litragem;
	private Integer desconto;
	private String data;
	private BigDecimal valor;
	private Posto posto;
	private Usuario usuario;
	private Frentista frentista;

	public Venda() {
		
	}

	public Venda(Integer id, Integer litragem, Integer desconto, String data, BigDecimal valor, Posto posto,
			Usuario usuario, Frentista frentista) {

		this.id = id;
		this.litragem = litragem;
		this.desconto = desconto;
		this.data = data;
		this.valor = valor;
		this.posto = posto;
		this.usuario = usuario;
		this.frentista = frentista;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column
	public Integer getLitragem() {
		return litragem;
	}

	public void setLitragem(Integer litragem) {
		this.litragem = litragem;
	}

	@Column
	public Integer getDesconto() {
		return litragem;
	}

	public void setDesconto(Integer desconto) {
		this.desconto = desconto;
	}

	@Column
	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;

	}

	@Column(nullable = false)
	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	public Posto getPosto() {
		return posto;
	}

	public void setPosto(Posto posto) {
		this.posto = posto;
	}

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	public Frentista getFrentista() {
		return frentista;
	}

	public void setFrentista(Frentista frentista) {
		this.frentista = frentista;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
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
		Venda other = (Venda) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Venda [id=" + id + ", litragem=" + litragem + ", desconto=" + desconto + ", data=" + data + ", valor="
				+ valor + ", posto=" + posto + ", usuario=" + usuario + ", frentista=" + frentista + "]";
	}

}
