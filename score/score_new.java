package score;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import count.readxml;


public class score_new {

	/**
	 * @param args
	 */
	private static ArrayList<String[]> zuhe_kind = new ArrayList<String[]>();
	private static ArrayList<String[]> zh = new ArrayList<String[]>();
	
	private static f_score max = new f_score();
	
	public static String final_score(ArrayList<String[]> cnt ,ArrayList<String[]> score_tfidf,
			ArrayList<String[]> seg , ArrayList<String> dis_s,String name) throws IOException{
		double k1 = 1;
		double k2 = 0.05;
		double k3 = 1;
		double k4 = 1;

		// ArrayList<f_score> rs = new ArrayList<f_score>();
		int index = 0;
		for (int j = 0; j < zuhe_kind.size(); j++) {
			String c[] = new String[zuhe_kind.get(j).length];
			for (String a : zuhe_kind.get(j)) {
				c[index] = a;
				index++;
			}
			double cs = score.cnt_score(cnt, c);
			double ts = score.tfidf_score(score_tfidf, c);
			double ds = score.DF_score(c, name);
			double dis = score.dis_score(dis_s, seg, c);
			double score = k1 * cs + k2 * ts + k3 * ds + k4 * dis;
			// System.out.println(k1*cs+" "+k2*ts+" "+k3*ds);
			f_score fs = new f_score(score, c, cs, ts, ds, dis);
			if (fs.score > max.score) {
				max = fs;
				// System.out.println(fs.print());
				System.out.println(max.print());
			}
			// rs.add(fs);
		}
		return max.print();
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String name = "ziluolan";
		ArrayList<String[]> score_tfidf = readxml.read("tfidf//" + name
				+ "_tfidf.txt", " ");
		ArrayList<String[]> cnt = readxml.read("con_H//" + name + ".xml_con_H",
				" ");
		ArrayList<ArrayList<String>> seg_time = DF.doc_cnt("seg_new_new//"
				+ name);
		ArrayList<String> dis_s = readxml.read("dis_0.05//" + name
				+ "_dist1.txt");
		ArrayList<String[]> seg = readxml.read("seg//" + name
				+ ".xml_con5_candidates", " ");
		File file = new File(name + "_new.txt");
		BufferedReader br = new BufferedReader(new FileReader(file));
		String temp = null;
		StringBuffer sb = new StringBuffer();
		String max_segs[][] = new String[21][cnt.size() + 1];
		String[] max_final = {"0" , ""};
		temp = br.readLine();
		while (temp != null) {
			String name_cnt[] = temp.split(" ");
			String[] max_now = { "0", "" };
			for (String a : name_cnt) {
				if (!a.split(":")[1].equals("0")) {
					String c[] = new String[Integer.valueOf(a.split(":")[1])];
					int sec = Integer.valueOf(a.split(":")[0]);
					int count = Integer.valueOf(a.split(":")[1]);
					score.zuhe(seg_time.get(sec),
							0, count, c);
					if (max_segs[sec][count] == null) {
						max_segs[sec][count] = final_score(cnt,
								score_tfidf, seg, dis_s, name);
					}
					String max_con[] = max_segs[sec][count].split(" ");
					max_now[0] = String.valueOf(Double.valueOf(max_now[0])+Double.valueOf(max_con[0]));
					max_now[1] += " "+max_con[1];

					zuhe_kind.clear();
				}
			}
			if(Double.valueOf(max_now[0]) > Double.valueOf(max_final[0])){
				max_final[0] = max_now[0];
				max_final[1] = max_now[1];
				System.out.println(max_final[0]+max_final[1]);
			}
			// score.plzh_name(kind_all , 0);
			// ArrayList<f_score> rs = new ArrayList<f_score>();

			// for(f_score fs : rs)
			// System.out.println(fs.print());
			temp = br.readLine();
		}
		
		System.out.println(max_final[0]+max_final[1]);
	}

}
