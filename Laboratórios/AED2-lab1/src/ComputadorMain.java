
public class ComputadorMain {

	public static void main(String[] args) {
		Processador pro = new Processador("Processador", "dual");
		Memoria mem = new Memoria("Memoria","ram");
		Disco dis = new Disco("Disco", "rigido");
		Computador sony = new Computador (pro, mem, dis);
		System.out.println(sony.getDescricao());
	}
	
	

}
