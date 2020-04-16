package br.unisinos;

public class Arvore {

	public No raiz;

	public Arvore() {
		raiz = null;
	}

	public void inserir(int valor) {
		No novo = new No();
		novo.item = valor;
		novo.direita = null;
		novo.esquerda = null;

		if (raiz == null) {
			raiz = novo;
		} else {
			No procurado = buscar(valor);
			if (procurado == null) {
				No atual = raiz;
				No anterior;

				int i = 0;
				while (i == 0) {
					anterior = atual;

					// VAI PARA ESQUERDA
					if (valor < atual.item) {
						atual = atual.esquerda;
						if (atual == null) {
							anterior.esquerda = novo;
							i += 1;
						}
					}
					// VAI PARA DIREITA
					else {
						atual = atual.direita;
						if (atual == null) {
							anterior.direita = novo;
							i += 1;
						}
					}

				}
			} else {
				System.out.println("Esse valor jÃ¡ consta na arvore");
			}
		}
		// METODO PARA IMPRIMIR
		// METODO PARA BALANCEAR
	}

	public No buscarPrint(int valor) {
		if (raiz == null) {
			System.out.println("A raiz Ã© nula");
			return null;
		}
		No atual = raiz;

		if (atual.item == valor) {
			System.out.println("O elemento consta");
			return atual;
		} else {

			while (valor != atual.item) {

				System.out.print(atual.item + " - ");

				if (valor < atual.item) {
					atual = atual.esquerda;
					if (atual == null) {
						System.out.println("O elemento nÃ£o consta");
						return null;
					}
				} else {
					atual = atual.direita;
					if (atual == null) {
						System.out.println("O elemento nÃ£o consta");
						return null;
					}
				}

			}
		}
		System.out.println("O elemento consta na arvore");
		return atual;

	}

	public No buscar(int valor) {
		if (raiz == null) {
			return null;
		}
		No atual = raiz;

		if (atual.item == valor) {
			return atual;
		} else {

			while (valor != atual.item) {
				if (valor < atual.item) {
					atual = atual.esquerda;
					if (atual == null) {
						return null;
					}
				} else {
					atual = atual.direita;
					if (atual == null) {
						return null;
					}
				}

			}
		}
		return atual;

	}

	public void imprimirOrdem(No atual) {
		if (atual != null) {
			imprimirOrdem(atual.esquerda);
			System.out.print(atual.item + " ");
			imprimirOrdem(atual.direita);
		}
	}

	public void imprimirPreOrdem(No atual) {
		if (atual != null) {
			System.out.print(atual.item + " ");
			imprimirPreOrdem(atual.esquerda);
			imprimirPreOrdem(atual.direita);
		}
	}

	public void imprimirPosOrdem(No atual) {
		if (atual != null) {
			imprimirPosOrdem(atual.esquerda);
			imprimirPosOrdem(atual.direita);
			System.out.print(atual.item + " ");
		}
	}

	public void imprimir() {
		System.out.println("Impressão em Ordem: ");
		imprimirOrdem(raiz);
		System.out.println("\nImpressão em Pré-Ordem: ");
		imprimirPreOrdem(raiz);
		System.out.println("\nImpressão em Pós-Ordem: ");
		imprimirPosOrdem(raiz);
	}

//---------------------------------- FUNCOES AUXILIARES --------------------------------------------------//	
	public void calculaAltura(No n) {
		n.altura = 1 + Math.max(getAltura(n.esquerda), getAltura(n.direita));
	}

	public int getAltura(No n) {
		if (n == null) {
			return -1;
		} else {
			return n.altura;
		}
	}
	
	public int getBalanceamento(No no) {
		  if (no == null) {
		    return 0;
		  }
		  return getAltura(no.getEsquerda()) - getAltura(no.getDireita());
		}


	// ROTACAO SIMPLES DIREITA
	public No rotacaoDireita(No no) {
		No novoPai = no.esquerda;
		No novaEsquerda = novoPai.direita;

		// Faz a Rotacao
		novoPai.direita = no;
		no.esquerda = novaEsquerda;

		// Atualiza alturas
		calculaAltura(no);
		calculaAltura(novoPai);

		// Retorna a nova raiz
		return novoPai;
	}

	// ROTACAO SIMPLES ESQUERDA
	public No rotacaoEsquerda(No no) {
		No novoPai = no.direita;
		No novaDireita = novoPai.esquerda;

		novoPai.esquerda = no;
		no.direita = novaDireita;

		calculaAltura(no);
		calculaAltura(novoPai);

		return novoPai;
	}

	// ROTACAO DUPLA ESQUERDA
	public No duplaRotacaoEsquerdaDireita(No inicial) {
		inicial.setEsquerda(rotacaoEsquerda(inicial.getEsquerda()));
		return rotacaoDireita(inicial);
	}

	// ROTACAO DUPLA DIREITA
	public No duplaRotacaoDireitaEsquerda(No inicial) {
		inicial.setDireita(rotacaoDireita(inicial.getDireita()));
		return rotacaoEsquerda(inicial);
	}
	
	public No verificarBalanceamento(int valor, No node) {
		  int balance = getBalanceamento(node);
		 
		  if (balance > 1 && valor < node.getEsquerda().getItem()) {
		    return rotacaoDireita(node);
		  }
		 
		  if (balance < -1 && valor > node.getDireita().getItem()) {
		    return rotacaoEsquerda(node);
		  }
		 
		  if (balance > 1 && valor > node.getEsquerda().getItem()) {
		    node.setEsquerda(rotacaoEsquerda(node.getEsquerda()));
		    return rotacaoDireita(node);
		  }
		 
		  if (balance < -1 && valor < node.getDireita().getItem()) {
		    node.setDireita(rotacaoDireita(node.getDireita()));
		    return rotacaoEsquerda(node);
		  }
		 
		  return node;
		}
}
