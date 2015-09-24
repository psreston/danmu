package score;

public class f_score {
	public String name[];
	public double score;
	public double ts;
	public double ds;
	public double cs;
	public double dis;
	
	public f_score(double score , String name[] , double cs , double ts , double ds,double dis){
		this.score = score;
		this.name = name;
		this.cs = cs;
		this.ds = ds;
		this.ts = ts;
		this.dis = dis;
	}
	public f_score(){
		this.score = 0;
	}
	
	public String print(){
		String a ="";
		for(int i = 0;i<this.name.length-1;i++){
			a += this.name[i]+",";
		}
		a += this.name[this.name.length-1]+" ";
		return this.score+" "+a+this.cs+" "+this.ts+" "+this.ds+" "+this.dis;
	}
	
}
