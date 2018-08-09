
public class Computador {
	Processador processador;
	Memoria memoria ;
	Disco disco;
	
	Computador(Processador processador,Memoria memoria, Disco disco){
	
		this.processador= processador;
		this.memoria = memoria;
		this.disco = disco; 
	}
	
	String getDescricao(){
		return processador.getDescricao() + "," + memoria.getDescricao()+"," + disco.getDescricao();

}
}

