package score;

public class word {
	String w;
	int n;
	int doc_n;
	
	public word(String a){
		this.w = a;
		this.n = 1;
		this.doc_n = 1;
	}
	
	public word(String a , int n , int doc_n){
		this.w = a;
		this.n = n;
		this.doc_n = doc_n;
	}
}
