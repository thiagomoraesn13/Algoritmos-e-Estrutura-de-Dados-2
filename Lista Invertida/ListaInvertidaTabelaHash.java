//THIAGO MORAES
//[AED2-2015/1]
//MATRÍCULA :-> 21452625
class No{
	String dado;
	No prox;

	public No(String dado){
	 	this.dado = dado;
	 	this.prox = null;
	}
	public String getDado(){
		return dado;
	}
	public No getProx(){
		return prox;
	}
	public void setProx(No prox){
		this.prox = prox;
	}
}

class ListaEncadeada{
	No topo;
	int tamanho1;

	public ListaEncadeada(){
		topo = null;
		tamanho1 = 0;
	}
	public void imprimelista(){
		No aux = topo;
		while(aux != null){
			System.out.println(aux.getDado());
			aux = aux.getProx();
		}
	}
	public void insereInicio(String palavra){
		No aux = new No(palavra);
		aux.setProx(topo);
		topo = aux;
		tamanho1++;
	}
}

class PalavraItemNo{
	String palavra;
	ListaEncadeada documentos;
	PalavraItemNo proximo;

	public PalavraItemNo(String palavra, ListaEncadeada documentos){
		this.documentos =documentos;
		this.palavra = palavra;
		this.proximo = null; 
	}
	public String getPalavra(){
		return palavra;
	}
	public PalavraItemNo getProximo(){
		return proximo;
	}
	public void setProximo(PalavraItemNo proximo){
		this.proximo = proximo;
	}
	public void setpalavra(String palavra){
		this.palavra = palavra;
	}
}

public class ListaInvertidaTabelaHash{
	private PalavraItemNo tabela[];
	private int tamanho=0;

	public ListaInvertidaTabelaHash(int maxTam) {
    tabela = new PalavraItemNo[maxTam];
  	}
  	public int getTamanho(){
  		return tamanho;
  	}
  	public void imprime(){
  		int i;
 		PalavraItemNo atual;
    		for (i=0; i<tabela.length; i++){
    			atual = tabela[i];
    			  	while(atual!= null){			
 						System.out.print(atual.getPalavra());
 						System.out.print(" == ");
 						atual.documentos.imprimelista();
 						atual = atual.getProximo();
					}
			}
	}
	private int funcaoHash(String palavra) {
    	int soma = 0;
    		for (int i=0; i<palavra.length(); i++){
      			soma = soma + palavra.charAt(i);
  			}
    		return soma % tabela.length;
  	}
  	public PalavraItemNo busca(String palavra){
  		if (palavra == null) {
  		return null;
  		}
  	PalavraItemNo aux = tabela[funcaoHash(palavra)];
  		while(aux != null){
  			if(aux.getPalavra() == palavra){
  				return aux;
  			}
  			aux = aux.getProximo();
  		}
  		return null;
  	}

	public boolean insere(String palavra, String documento){
  		
  		if(busca(palavra) == null){	
  			int indice = funcaoHash(palavra);
  			ListaEncadeada documentos = new ListaEncadeada();
  			PalavraItemNo novo = tabela[indice];	
  			tabela[indice] = new PalavraItemNo(palavra, documentos);
  			tabela[indice].setProximo(novo);
  			tabela[indice].setpalavra(palavra);
  			tabela[indice].documentos.insereInicio(documento);
  			tamanho++;
  			return true;
  		}	
		else{		
			int i;
  				for (i=0; i<tabela.length; i++){
  					PalavraItemNo aux = tabela[funcaoHash(palavra)];
  					aux = tabela[i];
  						while(aux!=null){
  							if(aux.getPalavra() == palavra){
  							aux.documentos.insereInicio(documento);
  								return true;
  							}
  						aux = aux.getProximo();
  						}
  				}				
			return true;
		}	
	}
	public float cargaUtilizacao(){
		int i;
		float soma=0;
		float soma2=0;
		for(i=0; i<tabela.length;i++){
			PalavraItemNo aux = tabela[i];
				if(aux!=null){
					soma  = soma + 1;
				}
		}
		if(soma == tabela.length){
			return 100;
		}
		else{
			soma2 = 100 / tabela.length;
			soma = soma2 * soma;
		return soma;	
		}
	}
	private int funcaoHash2(String palavra, int tamanho) {	
  		PalavraItemNo tabela2[] = new PalavraItemNo[tamanho];
    	int soma = 0;
    		for (int i=0; i<palavra.length(); i++){
      			soma = soma + palavra.charAt(i);
  			}
    		return soma % tabela2.length;
  	}
	public void rehash(int novoTamanho){
		PalavraItemNo tabela2[] = new PalavraItemNo[novoTamanho];
		int i;
		int indice;
		PalavraItemNo atual;
		PalavraItemNo topo;
		for(i=0;i<tabela.length;i++){		
			atual=tabela[i]; 
				while(atual!=null){
					indice = funcaoHash2(atual.getPalavra(), novoTamanho);
					topo = tabela2[indice];
					tabela2[indice] = new PalavraItemNo(atual.getPalavra(), atual.documentos);
					tabela2[indice].setProximo(topo);
					atual=atual.getProximo();
				}
		}	
		tabela = tabela2;	
	}
public static void main(String args[]){
	ListaInvertidaTabelaHash lista = new ListaInvertidaTabelaHash(6);
	lista.insere("remember", "document1.txt");
    lista.insere("the", "document1.txt");
    lista.insere("the", "document2.txt");
    lista.insere("the", "document3.txt");
    lista.insere("force", "document1.txt");
    lista.insere("force", "document2.txt");
    lista.insere("force", "document3.txt");
    lista.insere("will", "document1.txt");
    lista.insere("be", "document1.txt");
    lista.insere("with", "document1.txt");
    lista.insere("with", "document2.txt");
    lista.insere("with", "document3.txt");
    lista.insere("you", "document1.txt");
    lista.insere("you", "document2.txt");
    lista.insere("always", "document1.txt");
    lista.insere("is", "document2.txt");
    lista.insere("is", "document3.txt");
    lista.insere("strong", "document2.txt");
    lista.insere("strong", "document3.txt");
    lista.insere("this", "document3.txt");
    lista.insere("one", "document3.txt");
    lista.imprime();
    System.out.println(lista.cargaUtilizacao()); 
    System.out.println(lista.busca("one"));
  	System.out.println("\n");
  	lista.rehash(10);
    lista.imprime();
    //System.out.println("\n");
    System.out.println(lista.cargaUtilizacao());
  	
  }
}