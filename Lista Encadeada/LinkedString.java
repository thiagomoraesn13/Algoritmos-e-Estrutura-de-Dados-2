//THIAGO MORAES ROCHA
//MATRICULA - 21452625
// AED2 - 2015/1
class Nochar{
	private char dado;
	private Nochar prox;
	private Nochar ant;

	public Nochar(char dado){
	 	this.dado = dado;
	 	this.prox = null;
	 	this.ant = null;
	}
	public char getDado(){
		return dado;
	}
	public Nochar getProx(){
		return prox;
	}
	public void setProx(Nochar prox){
		this.prox = prox;
	}
	public Nochar getAnt(){
		return ant;
	}
	public void setAnt(Nochar ant){
		this.ant = ant;
	}
	public void setdado(char dado){
		this.dado=dado;
	}
}

public class LinkedString {
	private Nochar topo;
	private Nochar cauda;
	int tam;

public LinkedString(){
		topo = null;
		tam = 0;
	}

// eu sei que poderia usar a funcao insere, mas pensei que todos acabariam fazendo isso
// entao resolvir fazer no "braço"
// todos os construtores	
public LinkedString(String conteudo){
		topo =null;
		tam = 0;
		int i;
		for(i=0; i<conteudo.length(); i++){
			Nochar aux = new Nochar(conteudo.charAt(i));
			if(topo == null){
			aux.setProx(topo);
			topo = aux;
			}
			else{
				Nochar inicio = topo;
				while(inicio.getProx()!=null){
					inicio = inicio.getProx();
				}  
				inicio.setProx(aux);
				aux.setAnt(inicio);
				aux.setProx(null);
				tam++;
			}
		}
	}

public LinkedString(char[] conteudo){
		topo = null;
		tam=0;
		int i;
		for(i=0; i < conteudo.length; i++){		
			Nochar aux= new Nochar(conteudo[i]);
			if(topo == null){
			aux.setProx(topo);
			topo = aux;
			}
			else{
				Nochar inicio = topo;
				while(inicio.getProx()!=null){
					inicio = inicio.getProx();
				}  
				inicio.setProx(aux);
				aux.setAnt(inicio);
				aux.setProx(null);
				tam++;
			}
		}
	}

public LinkedString(LinkedString conteudo){
	Nochar listavelha = conteudo.getTopo();
	topo = null;
	tam =0;
	while(listavelha!=null){
		Nochar listanova = new Nochar(listavelha.getDado());
		if(topo == null){
			listanova.setProx(topo);
			topo = listanova;
			listavelha=listavelha.getProx();
		}
		else{
			Nochar novo = topo;
			while(novo.getProx()!=null){
				novo = novo.getProx();
			}
			novo.setProx(listanova);
			listanova.setAnt(novo);
			listanova.setProx(null);
			tam++;
			listavelha=listavelha.getProx();
		}

	}
}
//funcoes insere, imprime, só para testar//
// não foram pedidas para implementar//

public void inserefim(char dado){
	Nochar aux = new Nochar(dado);
			if(topo == null){
			aux.setProx(topo);
			topo = aux;
			}
			else{
				Nochar inicio = topo;
				while(inicio.getProx()!=null){
					inicio = inicio.getProx();
				}  
				inicio.setProx(aux);
				aux.setAnt(inicio);
				aux.setProx(null);
				tam++;
			}
		}

public void imprime(){
		Nochar aux = topo;
			while(aux != null){
			System.out.println(aux.getDado());
			aux = aux.getProx();
		}
	}

public char charAt(int indice){
		if (indice < 0 || indice >= tam){
			System.out.println("erro");
			System.exit(1);
		}
			Nochar aux = topo;
			while(indice > 0){
				aux = aux.getProx();
				indice--;
			}
		return aux.getDado();		
	}

public Nochar getTopo(){
		return topo;
}

public int compareTo(LinkedString srt){
	int tamanho1=0;
	int tamanho2=0; 
	
	Nochar inicio1 = topo;
	Nochar inicio2 = srt.getTopo();
	while(inicio1!=null && inicio2 !=null){
		if (inicio1.getDado() != inicio2.getDado()){
			return (int)inicio1.getDado() - (int)inicio2.getDado();
		}
		else{
			inicio1 = inicio1.getProx();
			inicio2 = inicio2.getProx();
		}	
	}
	Nochar aux = topo;
	Nochar lista3 = srt.getTopo();
	while(aux!=null){
		aux= aux.getProx();
		tamanho1++;
	}
	while(lista3!=null){
		lista3 = lista3.getProx();
		tamanho2++;
	}
	if(tamanho1 < tamanho2){
		return tamanho1 - tamanho2; 
	}
	if (tamanho2 < tamanho1){
		return tamanho2 - tamanho1;
	}
	return 0;
}

public LinkedString concat(LinkedString lista){
		Nochar aux = this.topo;
		while(aux.getProx()!= null){
			aux = aux.getProx();
		}
		aux.setProx(lista.getTopo());
		return this; 
}

public boolean equals(LinkedString lista){
	Nochar aux = topo;
	Nochar lista2 = lista.getTopo();
	while(aux != null && lista2 !=null){
		if(aux.getDado() != lista2.getDado()){
			return false;
		}
		else{
			aux = aux.getProx();
			lista2 = lista2.getProx();
		}

	}
	return true; 
}

public int indexOf(int ch){
 	int cont = 0;
 	Nochar aux = topo;
 	while(aux!=null){ 		
 		if(aux.getDado() == ch){
			 	return cont;					
 		}
 		else{
 			cont++;
 			aux= aux.getProx();
 		}
 
	}
	return -1;
 }		

public boolean isEmpty(){
	Nochar aux = topo;
	if(aux == null){
		return true;
	}
	else{
		return false;
	}
}

public int length(){
  	int cont=0;
  	Nochar aux= topo;
  	while(aux!=null){
  		cont++;
  		aux = aux.getProx();
  	}
  	return cont;

 }

public LinkedString replace(char oldchar, char newchar){	
 	Nochar aux = topo;
	while(aux!=null){
 		if(aux.getDado() == oldchar){
 			aux.setdado(newchar);
 			aux = aux.getProx();
 		}
 		else{
 			aux = aux.getProx();
 		}
 	}
	return this;
}
public String toString(){
	Nochar aux = topo;
	String concatenanada = "";
	while(aux!=null){
		concatenanada = concatenanada + aux.getDado();
		aux = aux.getProx();
	}
	return concatenanada;
}

public static void main(String args[]){
	LinkedString lista1 = new LinkedString();
	LinkedString lista2 = new LinkedString();
	char[] nome = {'t', 'm', 'r'};
	LinkedString lista3 = new LinkedString(nome);
	//lista3.imprime();
	String sociedade = "Legolas";
	LinkedString lista4 = new LinkedString(sociedade);
	//lista4.imprime();
	lista1.inserefim('a');
	lista1.inserefim('b');
	lista1.inserefim('c');
	LinkedString lista5 = new LinkedString(lista1);	
	lista2.inserefim('a');
	lista2.inserefim('b');
	lista2.inserefim('a');
	//lista5.imprime();
	lista1.imprime();
	//lista2.imprime();
	//lista3.imprime();
	//lista4.imprime();
	//lista5.imprime();
	//System.out.println(lista1.charAt(-1));
	//System.out.println(lista1.compareTo(lista2));	
	//System.out.println(lista1.concat(lista2));	
	//System.out.println(lista1.indexOf(99));
	//System.out.println(lista1.isEmpty());
	//System.out.println(lista1.length());
	//System.out.println(lista1.replace('a', 'd'));
	//System.out.println(lista1.toString());
	}	
}






















