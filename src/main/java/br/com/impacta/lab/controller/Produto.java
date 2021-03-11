package br.com.impacta.lab.controller;

public class Produto {

	private int _id;
	private String _descricao;
	private double _valor;

	public int getId() {
		return this._id;
	}

	public void setId(int id) {
		this._id = id;
	}

	public String getDescricao() {
		return this._descricao;
	}

	public void setDescricao(String descricao) {
		this._descricao = descricao;
	}

  public double getValor() {
		return this._valor;
	}

	public void setValor(double valor) {
		this._valor = valor;
	}

}
