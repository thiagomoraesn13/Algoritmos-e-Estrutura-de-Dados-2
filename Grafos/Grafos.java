import java.util.*;
import java.io.*;
import java.io.FileReader;
class VetorLista{
	private int distancia;
	private int cor;
	private int predecessor;

	public VetorLista(){
		this.distancia = 100000; 
		this.cor = 0;
		this.predecessor = -1;
	}
	public void setdistancia(int distancia){
		this.distancia = distancia;
	}
	public int getdistancia(){
		return distancia;
	}
	public void setCor(int cor){
		this.cor = cor;
	}
	public int getCor(){
		return cor;
	}
	public void setpredecessor(int predecessor){
		this.predecessor = predecessor;
	}
	public int getpredecessor(){
		return predecessor;
	}

}
public class Grafos{
	VetorLista[] vetor; 
	public Grafos (int distancia){
		vetor = new VetorLista[distancia];
	}
	public void dijkstra(int origem, int destino, int imprime[], int n, int matriz[][]){
	int i,k,max,total;
	for(i=0;i<6;i++){
		vetor[i]=new VetorLista();
	}
	vetor[origem].setdistancia(0);
	vetor[origem].setCor(1);
	k = origem;
	max = 0;
	do{
		for(i=0;i<n;i++){
			if(matriz[k][i] != 0 && vetor[i].getCor() == 0){
				if(vetor[k].getdistancia() + matriz[k][i] < vetor[i].getdistancia()){
					vetor[i].setpredecessor(k);
					vetor[i].setdistancia(vetor[k].getdistancia() + matriz[k][i]);
				}
			}
		}
		k = 0;
		max = 100000;
		for(i=0;i<n;i++){
			if(vetor[i].getCor() == 0 && vetor[i].getdistancia() < max){
				max = vetor[i].getdistancia();
				k = i;
			}
		}
		vetor[k].setCor(1);
	}while(k!=destino);
	total = 0;
	i = 0;
	k = destino;
	do{
		imprime[i] = k;
		i++;
		k = vetor[k].getpredecessor();
	}while(k>=0);
	System.out.println("O menor caminho é");
	System.out.print(origem + " -> ");
	for(i=n-1;i >=0;i--){
		if(imprime[i]!=origem && imprime[i]!=0){
		System.out.print(imprime[i] +" -> ");
		}
	}
	System.out.println();
	System.out.println("A distância total é:-> "+ vetor[destino].getdistancia());	
}
	
	public static void main (String args[])throws FileNotFoundException{	
		File doc = new File(args[0]);
		Scanner scanner = new Scanner(doc);
		int n = scanner.nextInt();
		int [][] matriz = new int[n][n]; 
		int i,j,k;
		while(scanner.hasNext()){
			i=scanner.nextInt();
			j=scanner.nextInt();
			k=scanner.nextInt();
			matriz[i][j] = k;
		}
		System.out.println("Dirige o Vertice de origem");
		Scanner ler = new Scanner(System.in);
		int ori;
		ori= ler.nextInt();
		System.out.println("Digite o vertice de destino");
		int des = ler.nextInt();
		System.out.println();
		Grafos grafos = new Grafos(n);
		int [] imprime =  new int [n];
		grafos.dijkstra(ori,des,imprime, n, matriz);
	}
}
