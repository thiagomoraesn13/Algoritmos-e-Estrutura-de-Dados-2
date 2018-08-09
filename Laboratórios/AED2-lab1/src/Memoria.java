
public class Memoria {
	String lua;
	String jato;
	
	Memoria (String lua, String jato){
		this.lua= lua;
		this.jato = jato; 
		
	}
	String getDescricao(){
		return lua + "," + jato;
	}
}
