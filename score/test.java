package score;

import java.util.ArrayList;

public class test {

	/**
	 * @param args
	 */
	public static ArrayList<ArrayList<String>> rs =new ArrayList<ArrayList<String>>();
	public static ArrayList<String> temp = new ArrayList<String>();
	public static ArrayList<String[]> result1 = new ArrayList<String[]>();
	public static void test(ArrayList<ArrayList<String>> a ,int b){
		for(int i =0;i<a.get(b).size();i++){
			temp.add(a.get(b).get(i));
			if(b+1==a.size()){
				ArrayList<String> tt = new ArrayList<String>();
				for(int j = 0 ;j<temp.size();j++){
					tt.add(temp.get(j));
				}
				rs.add(tt);
//				System.out.println(rs.get(0).get(0));
			}
			else{
				test(a , b+1);
			}
			temp.remove(temp.size()-1);
		}
	}
	
	public static void zuhe(ArrayList<String> a ,int start ,int n,String[] result){
		for(int i = start;i<a.size();i++){
			result[n-1] = a.get(i);
			if(n-1 == 0){
				String c[]=result;
				for(int j = 0 ;j<result.length;j++)
					c[j] = result[j];
				result1.add(c);
			}
			else{
				zuhe(a,i+1,n-1,result);
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> a1 = new ArrayList<String>();
		ArrayList<String> a2 = new ArrayList<String>();
		ArrayList<String> a3 = new ArrayList<String>();
		ArrayList<ArrayList<String>> a = new ArrayList<ArrayList<String>>();
		a1.add("1");
		a1.add("2");
		a1.add("3");
		a2.add("4");
		a2.add("5");
		a3.add("6");
		a3.add("7");
		a3.add("8");
		a3.add("9");
		a.add(a1);
		a.add(a2);
		a.add(a3);
		
		test(a , 0);
		String[] result = new String[3];
		zuhe(a3,0,3,result);
		System.out.println(rs.get(0).get(0));
		for(int i=0;i<rs.size();i++){
			for(int j = 0;j<rs.get(i).size();j++){
				System.out.print(rs.get(i).get(j)+" ");
			}
			System.out.println();
		}
		
		for(int i = 0 ;i<result1.size();i++){
			for(int j = 0 ;j<result1.get(i).length;j++){
				System.out.print(result1.get(i)[j]+" ");
			}
			System.out.println();
		}
	}

}
