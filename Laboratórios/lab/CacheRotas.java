//THIAGO MORAES 
//MATRICULA : 21452625

class CacheItem {
	private String destino;
	private int interface2;

	public CacheItem(String destino, int interface2){
		this.destino = destino;
		this.interface2 = interface2;
	}
	public String getDestino(){
		return destino;
	}
	public void setDestino(String destino){
		this.destino = destino;
	}
	public int getInterface(){
		return interface2;
	}
	public void setInterface(int interface2){
		this.interface2 = interface2;
	}
}

public class CacheRotas {
	private CacheItem tabela[]; 
	private int tamanho;
	
	public CacheRotas (int maxTam){
		tabela = new CacheItem[maxTam];
	}
	public int getTamanho(){
		return tamanho;
	}
	public void imprime(){
		int i;
		for(i=0; i<tabela.length; i++){
			if(tabela[i] != null && tabela[i].getDestino() != null)
			System.out.println(tabela[i].getDestino() + "=" + tabela[i].getInterface());
		}
	}
	private int funcaoHash(String destino){
		int soma =0;
		int i;
		for(i=0; i<tabela.length; i++){
			soma = soma + destino.charAt(i);
		}
		return soma % tabela.length;
	}

	public CacheItem busca(String destino) {
    if (destino == null) return null;
    int inicio = funcaoHash(destino);
    int i = 0;
    while(tabela[(inicio + i) % tabela.length] != null && tabela[(inicio + i) % tabela.length].getDestino() != destino && i < tabela.length){
 	i++;
 	}

	CacheItem retorno = tabela[(inicio + i) % tabela.length];

    if(retorno != null && retorno.getDestino() == destino){
      return retorno;
  	}
    else {
      return null;
  }

}


public boolean insere(String destino, int interface2) {
    if (tamanho == tabela.length || busca(destino) != null) return false;
    int inicio = funcaoHash(destino);
    int i = 0;
    while (
        tabela[(inicio + i) % tabela.length] != null &&
        tabela[(inicio + i) % tabela.length].getDestino() != null){
        i++;
	}
	 tabela[(inicio + i) % tabela.length] = new CacheItem(destino, interface2);
    tamanho++;
    return true;
  }


    public boolean remove(String destino) {
    CacheItem item = (CacheItem) busca(destino);
    
    if (item == null) {
    	return false;
    }
    item.setDestino(null);
    item.setInterface(0);
    tamanho­­--;
    return true;
  }

public static void main(String args[]){
	CacheRotas tabela = new CacheRotas(10);

	tabela.insere("192.168.200.5", 3);
	tabela.insere("192.168.200.4", 4);
	tabela.insere("192.168.200.3", 3);
	tabela.insere("192.168.200.8", 9);
	tabela.insere("192.168.012.8", 9);


	tabela.imprime();

}

}














