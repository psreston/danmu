package score;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import count.readxml;
public class tfidf {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static ArrayList<word> tf(File f) throws IOException{
		ArrayList<word> bow = new ArrayList<word>();
		ArrayList<String[]> word = readxml.read(f.getPath()," ");
		ArrayList<String> stoplist = readxml.read("停用词.txt");
		bow.add(new word("sum_num" , word.size() , 1));
		for (String[] a : word) {
			for (int j = 0; j < a.length; j++) {
				boolean flag_stop = false;
				if (a[j].equals("")) continue;
				for(String b :stoplist){
					if(b.equals(a[j])){
						flag_stop = true;
						break;
					}
				}
				if(flag_stop) continue;
				boolean flag = false;
				for (int i = 1; i < bow.size(); i++) {

					if (a[j].equals(bow.get(i).w)) {
						flag = true;
						bow.get(i).n++;
						break;
					}
				}
				if (!flag) {
					word temp = new word(a[j]);
					bow.add(temp);
				}
			}

		}
		
		return bow;
	}
	
	public static ArrayList<word> tf(File []filelist) throws IOException{
		ArrayList<word> bow = new ArrayList<word>();
		bow.add(new word("sum_all" , 0 , filelist.length));
		for(File f : filelist){
			ArrayList<word> word = tf(f);
			bow.get(0).n += word.size();
			for(word a : word){
				boolean flag = false;
				for(int i = 1 ;i<bow.size();i++){
					if(a.w.equals(bow.get(i).w)){
						flag = true;
						bow.get(i).n += a.n;
						bow.get(i).doc_n++;
						break;
					}
				}
				if(!flag){
					word temp = new word(a.w , a.n , 1);
					bow.add(temp);
				}
			}
		}
		return bow;
	}
	
	public static ArrayList<doc> tfidf_score(String name) throws IOException{
		ArrayList<doc> score = new ArrayList<doc>();
		File filelist[] = new File(name).listFiles();
		ArrayList<word> all_num = tf(filelist);
		double AL = all_num.get(0).n/Double.valueOf(all_num.get(0).doc_n);
		double k1 = 2;
		double k2 = 0.75;
		
		for(File f : filelist){
			ArrayList<word> num = tf(f);
			double s = 0;
			for(int i = 1;i<num.size();i++){
				int index = 0;
				for(int j =1 ;j<all_num.size();j++){
					if(num.get(i).w.equals(all_num.get(j).w))
						index = j;
				}
				s += (k1+1)*num.get(i).n/(k1*((1-k2)+k2*(num.get(0).n/AL))+num.get(i).n)*Math.log(all_num.get(0).n/all_num.get(index).doc_n);
			}
			doc temp = new doc(f.getName() , s);
			score.add(temp);
		}
		return score;
		
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		File dirlist[] = new File("seg_new").listFiles();
		
		for(File dir : dirlist){
			ArrayList<doc> list = tfidf_score(dir.getPath());
			
			FileOutputStream out = new FileOutputStream(new File(dir.getName()+"_tfidf.txt") , false);
			StringBuffer sb = new StringBuffer();
			for(doc d : list){
				sb.append(d.print()+"\n");
			}
			out.write(sb.toString().getBytes("utf-8"));
			out.close();
		}
		
	}

}
