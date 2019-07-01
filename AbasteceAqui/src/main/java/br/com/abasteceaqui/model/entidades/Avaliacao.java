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
public class Avaliacao implements Serializable {
	private Integer id;
	private String comentario;
	private String avaliacao;
	private String data;
	private Frentista frentista;
	private Usuario usuario;

	public Avaliacao() {

	}

	public Avaliacao(Integer id, String comentario, String avaliacao, String data, Frentista frentista,
			Usuario usuario) {
		this.id = id;
		this.comentario = comentario;
		this.avaliacao = avaliacao;
		this.data = data;
		this.frentista = frentista;
		this.usuario = usuario;
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
	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	@Column
	public String getAvaliacao() {
		return avaliacao;
	}

	public void setAvaliacao(String avaliacao) {
		this.avaliacao = avaliacao;
	}

	@Column
	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;

	}

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	public Frentista getFrentista() {
		return frentista;
	}

	public void setFrentista(Frentista frentista) {
		this.frentista = frentista;
	}

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
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
		Avaliacao other = (Avaliacao) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Avaliacao [id=" + id + ", comentario=" + comentario + ", avaliacao=" + avaliacao + ", data=" + data
				+ ", frentista=" + frentista + ", usuario=" + usuario + "]";
	}

}
