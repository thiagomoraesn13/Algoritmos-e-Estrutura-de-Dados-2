class No{
	private Object dado;
	private No prox;
	private No ant;

	public No(Object dado){
	 	this.dado = dado;
	 	this.prox = null;
	 	this.ant = null;
	}
	public Object getDado(){
		return dado;
	}
	public No getProx(){
		return prox;
	}
	public void setProx(No prox){
		this.prox = prox;
	}
	public No getAnt(){
		return ant;
	}
	public void setAnt(No ant){
		this.ant = ant;
	}
}

public  class ListaEncadeadaCauda {
	private No topo;
	private No cauda;
	int tamanho;

	public ListaEncadeadaCauda(){
		topo = null;
		cauda = null;
		tamanho = 0;
	}
	public int getTamanho(){
		return tamanho;
	}
	public void imprime(){
		No aux = topo;
		while(aux != null){
			System.out.println(aux.getDado());
			aux = aux.getProx();
		}
	}
	public Object getItem(int item){
		if( item >= tamanho){
			return null;
		}
		No aux = topo;
		while(item > 0){
			aux = aux.getProx();
			item--;
		}
		return aux.getDado();
	}
	public void insereInicio(Object dado){
		No aux = new No(dado);
		aux.setProx(topo);
		if(topo != null){
			topo.setAnt(aux);
		}
		else{
			cauda= aux;
		}
		topo = aux;
		tamanho++; 
	}
	public void imprimeInverso(){
		No aux = cauda;
		No aux1= topo;
		while(aux != aux1.getAnt()){
			System.out.println(aux.getDado());
			aux = aux.getAnt();
		}
	}
	public void limpa(){
		topo = null;
		cauda = null;
	}
	public boolean insereIndice(int indice, Object dado){
		if(indice < 0 && indice >= tamanho){
			return false;
		}
			else {
			No novo = new No(dado);
			No aux = topo;
			No anterior = topo;
				while(indice > 0){
					anterior = aux;
					aux = aux.getProx();
					indice--;
				}
			anterior.setProx(novo);
			novo.setProx(aux);
			tamanho++;
			return true;
			}
	}
	public No getTopo(){
		return topo;
	}
	public void concatena(ListaEncadeada lista){
		No aux = topo;
		while(aux.getProx()!= null){
			aux = aux.getProx();
		}
		aux.setProx(lista.getTopo());
	}
	public Object[] vetor(){
		if(topo == null){
			return null;
		}
		Object[] vet = new Object[tamanho];
		No aux = topo;
		int i=0;
		while(aux!=null && i< tamanho){
			vet[i] = aux.getDado();
			i++;
			aux = aux.getProx();
		}
		return vet;
	}
	public static void main (String args[]){
	ListaEncadeadaCauda lista = new ListaEncadeadaCauda();
	Object[] vet;
		lista.insereInicio("An Unearthly Child");
		lista.insereInicio("The Cave of Skulls");
		lista.insereInicio("The Forest of Fear");
		lista.insereInicio("The Firemaker");
		lista.insereInicio("The Dead Planet");
		
		lista.imprime();
		System.out.println("A lista será impressa inversa agora");
		lista.imprimeInverso();
		
		System.out.println("Colocar o nome do episódio:The Edge of Destruction, no indice 1");
	
		lista.insereIndice(1,"The Edge of Destruction");

		lista.imprime();
		
		System.out.println("Passar da lista para o vetor");
		vet = lista.vetor();
		int i;
		for(i=0; i<6; i++){
			System.out.println(vet[i]);
		}
		
	}

}