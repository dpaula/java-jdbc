/**
 * 
 */
package com.dpaula.jdbc.model;

/**
 * @author ferna
 *
 */
public class Produto {

	private Integer id;
	private String nome;
	private String desc;

	/**
	 * @param nome
	 * @param desc
	 */
	public Produto(String nome, String desc) {
		this.nome = nome;
		this.desc = desc;
	}

	public Produto() {
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 * @return
	 */
	public Produto setId(Integer id) {
		this.id = id;
		return this;
	}

	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome
	 *            the nome to set
	 * @return
	 */
	public Produto setNome(String nome) {
		this.nome = nome;
		return this;
	}

	/**
	 * @return the desc
	 */
	public String getDesc() {
		return desc;
	}

	/**
	 * @param desc
	 *            the desc to set
	 * @return
	 */
	public Produto setDesc(String desc) {
		this.desc = desc;
		return this;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Produto [id=" + id + ", nome=" + nome + ", desc=" + desc + "]";
	}

}
