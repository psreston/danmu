package score;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import count.readxml;
public class score {

	/**
	 * @param args
	 * @throws IOException 
	 */
	private static ArrayList<String[]> zuhe_kind = new ArrayList<String[]>();
	private static ArrayList<String[]> zh = new ArrayList<String[]>();
	private static ArrayList<ArrayList<String[]>> result = new ArrayList<ArrayList<String[]>>();
	private static f_score max = new f_score();
	public static int cnt_score(ArrayList<String[]> a , String b[]){
		int rs = 0;
		
		for(String name : b){
			for(String t[] : a){
				if(name.split("_")[1].equals(t[0])){
					rs += Integer.valueOf(t[2]);
					break;
				}
			}
		}
		return rs;
	}
	
	public static double tfidf_score(ArrayList<String[]> a , String b[]){
		double rs = 0;
		
		for(String name : b){
			for(String t[] : a){
				if(t[0].equals(name)){
					rs += Double.valueOf(t[1]);
					break;
				}
			}
		}
		return rs;	
	}
	
	public static double DF_score(String b[] , String name) throws IOException{
		double rs = 1;
		File filelist[] = new File[b.length];
 		for(int i = 0 ;i<b.length;i++){
			filelist[i] = new File("seg_new_new//"+name+"//"+b[i]);
		}
 		
 		ArrayList<word> bow = tfidf.tf(filelist);
 		ArrayList<String[]> top5 = readxml.read("tf_n//"+name+".xml_n_tf.txt", " ");
 		for(int i = 0;i<5;i++){
 			for(int j = i+1;j<5;j++){
 				int index_i = -1;
 				int index_j = -1;
 				
 				for(int k = 0;k<bow.size();k++){
 					if(index_j!=-1&&index_i!=-1) break;
 					if(bow.get(k).w.equals(top5.get(i)[0])){
 						index_i = k;
 					}
 					if(bow.get(k).w.equals(top5.get(j)[0])){
 						index_j = k;
 					}
 				}
 				int n_i = 0;
 				int n_j = 0;
 				if(index_i!=-1){
 					n_i = bow.get(index_i).n;
 				}
 				if(index_j!=-1){
 					n_j = bow.get(index_j).n;
 				}
 				
 				double bz = ((n_i+0.1)/Integer.valueOf(top5.get(i)[1]))/((n_j+0.1)/Integer.valueOf(top5.get(j)[1]));
 				if(bz>1) bz = 1/bz;
 				int sum = (Integer.valueOf(top5.get(i)[1])+Integer.valueOf(top5.get(j)[1]));
// 				System.out.println(sum+" "+bz);
 				rs *= sum*bz;
 			}
 		}
 		
 		return Double.valueOf(String.valueOf(rs).split("E")[1]);
	}
	
	public static double dis_score(ArrayList<String> dis_s , ArrayList<String[]> seg , String b[]){
		double rs = 0;
		
		for(String name : b){
			int index = 0;
			for(int i = 0 ;i<seg.size();i++){
				if(name.split("_")[1].equals(seg.get(i)[0])){
					index = i;
					break;
				}
			}
			rs += Double.valueOf(dis_s.get(index));
		}
		return rs;
	}
	
	public static void final_score(ArrayList<String[]> cnt ,ArrayList<String[]> score_tfidf,
			ArrayList<String[]> seg , ArrayList<String> dis_s,String name) throws IOException{
		double k1 = 1;
		double k2 = 0.05;
		double k3 = 1;
		double k4 = 1;

//		ArrayList<f_score> rs = new ArrayList<f_score>();
		for(int i = 0;i<result.size();i++){
			int n =0;
			for(int j = 0;j<result.get(i).size();j++){
				n += result.get(i).get(j).length;
			}
			String c[] = new String[n];
			int index = 0;
			for(int j = 0;j<result.get(i).size();j++){
				for(String a : result.get(i).get(j)){
					c[index] = a;
					index++;
				}
			}
			double cs = cnt_score(cnt , c);
			double ts = tfidf_score(score_tfidf , c);
			double ds = DF_score(c , name);
			double dis = dis_score(dis_s , seg , c);
			double score = k1*cs+k2*ts+k3*ds+k4*dis;
//			System.out.println(k1*cs+" "+k2*ts+" "+k3*ds);
			f_score fs = new f_score(score , c , cs , ts , ds , dis);
			if(fs.score>max.score){
				max = fs;
//				System.out.println(fs.print());
				System.out.println(max.print());
			}
//			rs.add(fs);
			
		}
//		return rs;
	}
	
	public static void plzh_name(ArrayList<ArrayList<String[]>> a ,int b){
		for(int i =0;i<a.get(b).size();i++){
			zh.add(a.get(b).get(i));
			if(b+1==a.size()){
				ArrayList<String[]> tt = new ArrayList<String[]>();
				for(int j = 0 ;j<zh.size();j++){
					tt.add(zh.get(j));
				}
				result.add(tt);
			}
			else{
				plzh_name(a , b+1);
			}
			zh.remove(zh.size()-1);
		}
	}
	
	public static void zuhe(ArrayList<String> a ,int start ,int n,String[] rs){
		for(int i = start;i<a.size();i++){
			rs[n-1] = a.get(i);
			if(n-1 == 0){
				String c[]=new String[rs.length];
				for(int j = 0 ;j<rs.length;j++)
					c[j] = rs[j];
				zuhe_kind.add(c);
			}
			else{
				zuhe(a,i+1,n-1,rs);
			}
		}
	}
	
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String name = "ziluolan";
		ArrayList<String[]> score_tfidf = readxml.read("tfidf//"+name+"_tfidf.txt", " ");
		ArrayList<String[]> cnt = readxml.read("con_H//"+name+".xml_con_H" , " ");
		ArrayList<ArrayList<String>> seg_time = DF.doc_cnt("seg_new_new//"+name);
		ArrayList<String> dis_s = readxml.read("dis_0.05//"+name+"_dist1.txt");
		ArrayList<String[]> seg = readxml.read("seg//"+name+".xml_con5_candidates", " ");
		File file = new File(name+"_new.txt");
		System.out.println("0");
		BufferedReader br=new BufferedReader(new FileReader(file));
        String temp=null;
        temp=br.readLine();
        while(temp!=null){
        	String name_cnt[] = temp.split(" ");
        	ArrayList<ArrayList<String[]>> kind_all = new ArrayList<ArrayList<String[]>>();
        	for(String a : name_cnt){
        		if(!a.split(":")[1].equals("0")){
        			String c[] = new String[Integer.valueOf(a.split(":")[1])];
        			zuhe(seg_time.get(Integer.valueOf(a.split(":")[0])) , 0 , Integer.valueOf(a.split(":")[1]) , c);
        			ArrayList<String[]> tt = new ArrayList<String[]>();
        			for(int i = 0 ;i<zuhe_kind.size();i++){
        				tt.add(zuhe_kind.get(i));
        			}
        			kind_all.add(tt);
        			zuhe_kind.clear();
        			System.out.println(temp);
        		}
        	}
        	plzh_name(kind_all , 0);
//        	ArrayList<f_score> rs = new ArrayList<f_score>();
        	final_score(cnt , score_tfidf , seg , dis_s , name);
//        	for(f_score fs : rs)
//        		System.out.println(fs.print());
        	temp = br.readLine();
        }
        System.out.println(name+":");
        System.out.println(max.print());
	}

}
