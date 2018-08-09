
//THIAGO MORAES - 21452625
class NoArvore{
	private int quantidade;
	private String palavra;
	
	private NoArvore  pai;
	private NoArvore  esquerda;
	private NoArvore  direita;

	public NoArvore(String palavra, NoArvore  pai){
		this.palavra   = palavra;
		this.quantidade = 1;
		this.pai = pai;
		this.esquerda = null;
		this.direita = null;
	}
	

	public int getquantidade(){
		return quantidade;
	}
	public void setquantidade(int quantidade){
		this.quantidade = quantidade;
	}
	public String getpalavra(){
		return palavra;
	}
	public void setpalavra(String palavra){
		this.palavra  = palavra;
	}
	public NoArvore  getPai(){
		return pai;
	}
	public void setPai(NoArvore  pai){
		this.pai = pai;
	}
	public NoArvore  getEsquerda(){
		return esquerda;
	}
	public void setEsquerda(NoArvore  esquerda){
		this.esquerda = esquerda;
	}
	public NoArvore  getDireita(){
		return direita;
	}
	public void setDireita(NoArvore  direita){
		this.direita = direita;
	}
}

public class ArvoreDicionario{
	private NoArvore  raiz;
	private int tamanho;

	public ArvoreDicionario(){
		raiz = null;
		tamanho = 0;
	}
	public int getTamanho(){
		return tamanho;
	}
	public void insere(String palavra){
		if(raiz == null){
			NoArvore  novo = new NoArvore(palavra, null);
			raiz = novo;
			tamanho++;
			return;	
			}
		NoArvore  atual = raiz;
		NoArvore  nopai=null;
		while(atual != null){
			nopai = atual; 
			if(palavra.compareTo(atual.getpalavra())< 0){
				atual = atual.getEsquerda();
			}
			else 
				if(palavra.compareTo(atual.getpalavra())>0){
				atual = atual.getDireita();
			}
				else{
					int quantidadeatual = atual.getquantidade();
					quantidadeatual++;
				atual.setquantidade(quantidadeatual);
				return;
			
			}
		}
		NoArvore  novoNo = new NoArvore (palavra, nopai);
		if(palavra.compareTo(nopai.getpalavra())<0){
			nopai.setEsquerda(novoNo);
		}
		else{
			nopai.setDireita(novoNo);
		}
		tamanho++;  
}
	
	public void caminhaCentral(){
    caminhaCentral(raiz);
  	}
  	public void caminhaCentral(NoArvore subArvore) {
    if (subArvore != null) {
      caminhaCentral(subArvore.getEsquerda());
      System.out.println(subArvore.getpalavra() + " == " + subArvore.getquantidade());
      caminhaCentral(subArvore.getDireita());
    }
  }


public static void main(String args[]){
	ArvoreDicionario teste = new ArvoreDicionario();

	teste.insere("thiago");
	teste.insere("thiago");

	teste.insere("edwin");
	teste.insere("edwin");

	teste.insere("carlos");
	teste.insere("carlos");
	
	teste.insere("brandell");
	teste.insere("brandell");

	teste.insere("joao");
	teste.insere("pedro");

	teste.insere("rodrigo");
	
	System.out.println(teste.getTamanho());

	teste.caminhaCentral();
	//System.out.println('\n');	

}
}


















     