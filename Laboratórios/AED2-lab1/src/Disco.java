
public class Disco {
	String marte;
	String terra;
	
	
	Disco(String marte, String terra){
		this.marte= marte;
		this.terra = terra; 
		
	}
	String getDescricao(){
		return marte + "," + terra;
	}
}
