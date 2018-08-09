
public class Processador {
	String nome;
	String velocidade;
	
	Processador(String nome, String velocidade){
		this.nome= nome;
		this.velocidade = velocidade; 
		
	}
	String getDescricao(){
		return nome + "," + velocidade;
	}
}
