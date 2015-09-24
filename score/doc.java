package score;

public class doc {
	String name;
	double score;
	
	public doc(String name , double s){
		this.name = name;
		this.score = s;
	}
	
	public String print(){
		return this.name+" "+this.score;
	}
}
