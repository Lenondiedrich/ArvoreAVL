package br.unisinos;

public class No {
	public int item;
	public No esquerda;
	public No direita;
	public No pai;
	public int balanceamento;
	public int altura;
	
	public No() {}
	
	public No(int valor){
		this.item = valor;
		this.esquerda = this.direita = this.pai = null;
	}

	public int getItem() {
		return item;
	}

	public void setItem(int item) {
		this.item = item;
	}

	public No getEsquerda() {
		return esquerda;
	}

	public void setEsquerda(No esquerda) {
		this.esquerda = esquerda;
	}

	public No getDireita() {
		return direita;
	}

	public void setDireita(No direita) {
		this.direita = direita;
	}

	public No getPai() {
		return pai;
	}

	public void setPai(No pai) {
		this.pai = pai;
	}
	
	public void setBalanceamento(int balanceamento) {
		this.balanceamento = balanceamento;
	}
	
	public int getBalanceamento() {
		return this.esquerda.altura - this.direita.altura;
	}
}

