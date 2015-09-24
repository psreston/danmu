package score;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

public class DF {

	public static void combine_increase(ArrayList<document> doc, int start,
			ArrayList<Integer> result, int count, int NUM) throws UnsupportedEncodingException, IOException {
		int i = 0;
		for (i = start; i < doc.size() + 1 - count; i++) {
			result.set(count - 1, i);
			if (count - 1 == 0) {
				int j;
				int sum = 0;
				for (j = NUM - 1; j >= 0; j--){
					sum += doc.get(result.get(j)).time;
				}
				if(sum<=240&&sum>=220){
					FileOutputStream out = new FileOutputStream(new File("ziluolan.txt") , true);
					StringBuffer sb = new StringBuffer();
					for (j = NUM - 1; j >= 0; j--){
						sb.append(doc.get(result.get(j)).name + " ");
//						System.out.print(doc.get(result.get(j)).name + " ");
					}
					sb.append("\n");
					out.write(sb.toString().getBytes("utf-8"));
					out.close();
				}
			} else{
				int sum = 0;
				for(int j = result.size()-1;j>=0;j--){
					sum += doc.get(result.get(j)).time;
				}
				if(sum>240){}
				combine_increase(doc, i + 1, result, count - 1, NUM);
			}
		}
	}
	
	public static ArrayList<ArrayList<String>> doc_cnt(String name){
		File filelist[] = new File(name).listFiles();
		ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
		
		for(int i =0;i<21;i++){
			ArrayList<String> a = new ArrayList<String>();
			result.add(a);
		}
		
		for(File f : filelist){
			int time = Integer.valueOf(f.getName().split("_")[2])-Integer.valueOf(f.getName().split("_")[1]);
			result.get(time).add(f.getName());
		}
		return result;
	}
	
	public static void main(String args[]) throws UnsupportedEncodingException, IOException{
		ArrayList<ArrayList<String>> list = doc_cnt("seg_new//ziluolan");
		FileOutputStream out = new FileOutputStream(new File("ziluolan.txt") , false);
		for(int i = 0;i<21;i++)
			System.out.println(list.get(i).size());
		for(int a3=0;a3<=list.get(3).size();a3++){
			System.out.println(a3);
			int t = a3*21;
			int n = a3;
			if(t>236&&t<=240&&n<=30){
				StringBuffer sb = new StringBuffer();
				sb.append("3:"+a3+"\n");
				out.write(sb.toString().getBytes("utf-8"));
				break;
			}
			if(t>240||n>30) break;
			for(int a4=0;a4<=list.get(4).size();a4++){
				t = a3*4+a4*5;
				n = a3+a4;
				if(t>235&&t<=240&&n<=30){
					if((240-t>=4 && list.get(3).size() - a3 >0)){}
					else{
						StringBuffer sb = new StringBuffer();
						sb.append("3:"+a3+" "+"4:"+a4+" "+"\n");
						out.write(sb.toString().getBytes("utf-8"));
					}
					break;
				}
				if(t>240||n>30) break;
				for(int a5=0;a5<=list.get(5).size();a5++){
					t = a3*4+a4*5+a5*6;
					n = a3+a4+a5;
					if(t>234&&t<=240&&n<=30){
						if((240-t>=4 && list.get(3).size() - a3 >0) || (240-t>=5 && list.get(4).size() - a4 >0)
								){}
						else{
							StringBuffer sb = new StringBuffer();
							sb.append("3:" + a3 + " " + "4:" + a4 + " " + "5:"
									+ a5 + " " + "\n");
							out.write(sb.toString().getBytes("utf-8"));
						}
						break;
					}
					if(t>240||n>30) break;
					for(int a6=0;a6<=list.get(6).size();a6++){
						t = a3*4+a4*5+a5*6+a6*7;
						n = a3+a4+a5+a6;
						if(t>233&&t<=240&&n<=30){
							if((240-t>=4 && list.get(3).size() - a3 >0) || (240-t>=5 && list.get(4).size() - a4 >0)
									|| (240-t>=6 && list.get(5).size() - a5 >0)){}
							else{
								StringBuffer sb = new StringBuffer();
								sb.append("3:" + a3 + " " + "4:" + a4 + " "
										+ "5:" + a5 + " " + "6:" + a6 + "\n");
								out.write(sb.toString().getBytes("utf-8"));
							}
							break;
						}
						if(t>240||n>30) break;
						for(int a7=0;a7<=list.get(7).size();a7++){
							t = a3*4+a4*5+a5*6+a6*7+a7*8;
							n = a3+a4+a5+a6+a7;
							if(t>232&&t<=240&&n<=30){
								if((240-t>=4 && list.get(3).size() - a3 >0) || (240-t>=5 && list.get(4).size() - a4 >0)
										|| (240-t>=6 && list.get(5).size() - a5 >0) || (240-t>=7 && list.get(6).size() - a6 >0)){}
								else{
									StringBuffer sb = new StringBuffer();
									sb.append("3:" + a3 + " " + "4:" + a4 + " "
											+ "5:" + a5 + " " + "6:" + a6 + " "
											+ "7:" + a7 + "\n");
									out.write(sb.toString().getBytes("utf-8"));
								}
								break;
							}
							if(t>240||n>30) break;
							for(int a8=0;a8<=list.get(8).size();a8++){
								t = a3*4+a4*5+a5*6+a6*7+a7*8+a8*9;
								n = a3+a4+a5+a6+a7+a8;
								if(t>231&&t<=240&&n<=30){
									if((240-t>=4 && list.get(3).size() - a3 >0) || (240-t>=5 && list.get(4).size() - a4 >0)
											|| (240-t>=6 && list.get(5).size() - a5 >0) || (240-t>=7 && list.get(6).size() - a6 >0)
											|| (240-t>=8 && list.get(7).size() - a7 >0)){}
									else{
									StringBuffer sb = new StringBuffer();
									sb.append("3:"+a3+" "+"4:"+a4+" "+"5:"+a5+" "+"6:"+a6+" "+"7:"+a7+" "+"8:"+a8+"\n");
									out.write(sb.toString().getBytes("utf-8"));
									}
									break;
								}
								if(t>240||n>30) break;
								for(int a9=0;a9<=list.get(9).size();a9++){
									t = a3*4+a4*5+a5*6+a6*7+a7*8+a8*9+a9*10;
									n = a3+a4+a5+a6+a7+a8+a9;
									if(t>230&&t<=240&&n<=30){
										if((240-t>=4 && list.get(3).size() - a3 >0) || (240-t>=5 && list.get(4).size() - a4 >0)
												|| (240-t>=6 && list.get(5).size() - a5 >0) || (240-t>=7 && list.get(6).size() - a6 >0)
												|| (240-t>=8 && list.get(7).size() - a7 >0) || (240-t>=9 && list.get(8).size() - a8 >0)){}
										else{
										StringBuffer sb = new StringBuffer();
										sb.append("3:"+a3+" "+"4:"+a4+" "+"5:"+a5+" "+"6:"+a6+" "+"7:"+a7+" "+"8:"+a8
												+" "+"9:"+a9+"\n");
										out.write(sb.toString().getBytes("utf-8"));
										}
										break;
									}
									if(t>240||n>30) break;
									for(int a10=0;a10<=list.get(10).size();a10++){
										t = a3*4+a4*5+a5*6+a6*7+a7*8+a8*9+a9*10+a10*11;
										n = a3+a4+a5+a6+a7+a8+a9+a10;
										if(t>229&&t<=240&&n<=30){
											if((240-t>=4 && list.get(3).size() - a3 >0) || (240-t>=5 && list.get(4).size() - a4 >0)
													|| (240-t>=6 && list.get(5).size() - a5 >0) || (240-t>=7 && list.get(6).size() - a6 >0)
													|| (240-t>=8 && list.get(7).size() - a7 >0) || (240-t>=9 && list.get(8).size() - a8 >0)
													|| (240-t>=10 && list.get(9).size() - a9 >0)){}
											else{
											StringBuffer sb = new StringBuffer();
											sb.append("3:"+a3+" "+"4:"+a4+" "+"5:"+a5+" "+"6:"+a6+" "+"7:"+a7+" "+"8:"+a8
													+" "+"9:"+a9+" "+"10:"+a10+"\n");
											out.write(sb.toString().getBytes("utf-8"));
											}
											break;
										}
										if(t>240||n>30) break;
										for(int a11=0;a11<=list.get(11).size();a11++){
											t = a3*4+a4*5+a5*6+a6*7+a7*8+a8*9+a9*10+a10*11+a11*12;
											n = a3+a4+a5+a6+a7+a8+a9+a10+a11;
											if(t>228&&t<=240&&n<=30){
												if((240-t>=4 && list.get(3).size() - a3 >0) || (240-t>=5 && list.get(4).size() - a4 >0)
														|| (240-t>=6 && list.get(5).size() - a5 >0) || (240-t>=7 && list.get(6).size() - a6 >0)
														|| (240-t>=8 && list.get(7).size() - a7 >0) || (240-t>=9 && list.get(8).size() - a8 >0)
														|| (240-t>=10 && list.get(9).size() - a9 >0)|| (240-t>=11 && list.get(10).size() - a10 >0)){}
												else{
												StringBuffer sb = new StringBuffer();
												sb.append("3:"+a3+" "+"4:"+a4+" "+"5:"+a5+" "+"6:"+a6+" "+"7:"+a7+" "+"8:"+a8
														+" "+"9:"+a9+" "+"10:"+a10+" "+"11:"+a11+"\n");
												out.write(sb.toString().getBytes("utf-8"));
												}
												break;
											}
											if(t>240||n>30) break;
											for(int a12=0;a12<=list.get(12).size();a12++){
												t = a3*4+a4*5+a5*6+a6*7+a7*8+a8*9+a9*10+a10*11+a11*12+a12*13;
												n = a3+a4+a5+a6+a7+a8+a9+a10+a11+a12;
												if(t>227&&t<=240&&n<=30){
													if((240-t>=4 && list.get(3).size() - a3 >0) || (240-t>=5 && list.get(4).size() - a4 >0)
															|| (240-t>=6 && list.get(5).size() - a5 >0) || (240-t>=7 && list.get(6).size() - a6 >0)
															|| (240-t>=8 && list.get(7).size() - a7 >0) || (240-t>=9 && list.get(8).size() - a8 >0)
															|| (240-t>=10 && list.get(9).size() - a9 >0)|| (240-t>=11 && list.get(10).size() - a10 >0)
															|| (240-t>=12 && list.get(11).size() - a11 >0)){}
													else{
													StringBuffer sb = new StringBuffer();
													sb.append("3:"+a3+" "+"4:"+a4+" "+"5:"+a5+" "+"6:"+a6+" "+"7:"+a7+" "+"8:"+a8
															+" "+"9:"+a9+" "+"10:"+a10+" "+"11:"+a11+" "+"12:"+a12+"\n");
													out.write(sb.toString().getBytes("utf-8"));
													}
													break;
												}
												if(t>240||n>30) break;
												for(int a13=0;a13<=list.get(13).size();a13++){
													t = a3*4+a4*5+a5*6+a6*7+a7*8+a8*9+a9*10+a10*11+a11*12+a12*13+a13*14;
													n = a3+a4+a5+a6+a7+a8+a9+a10+a11+a12+a13;
													if(t>226&&t<=240&&n<=30){
														if((240-t>=4 && list.get(3).size() - a3 >0) || (240-t>=5 && list.get(4).size() - a4 >0)
																|| (240-t>=6 && list.get(5).size() - a5 >0) || (240-t>=7 && list.get(6).size() - a6 >0)
																|| (240-t>=8 && list.get(7).size() - a7 >0) || (240-t>=9 && list.get(8).size() - a8 >0)
																|| (240-t>=10 && list.get(9).size() - a9 >0)|| (240-t>=11 && list.get(10).size() - a10 >0)
																|| (240-t>=12 && list.get(11).size() - a11 >0) || (240-t>=13 && list.get(12).size() - a12 >0)){}
														else{
														StringBuffer sb = new StringBuffer();
														sb.append("3:"+a3+" "+"4:"+a4+" "+"5:"+a5+" "+"6:"+a6+" "+"7:"+a7+" "+"8:"+a8
																+" "+"9:"+a9+" "+"10:"+a10+" "+"11:"+a11+" "+"12:"+a12+" "+"13:"+a13+"\n");
														out.write(sb.toString().getBytes("utf-8"));
														}
														break;
													}
													if(t>240||n>30) break;
													for(int a14=0;a14<=list.get(14).size();a14++){
														t = a3*4+a4*5+a5*6+a6*7+a7*8+a8*9+a9*10+a10*11+a11*12+a12*13+a13*14+a14*15;
														n = a3+a4+a5+a6+a7+a8+a9+a10+a11+a12+a13+a14;
														if(t>225&&t<=240&&n<=30){
															if((240-t>=4 && list.get(3).size() - a3 >0) || (240-t>=5 && list.get(4).size() - a4 >0)
																	|| (240-t>=6 && list.get(5).size() - a5 >0) || (240-t>=7 && list.get(6).size() - a6 >0)
																	|| (240-t>=8 && list.get(7).size() - a7 >0) || (240-t>=9 && list.get(8).size() - a8 >0)
																	|| (240-t>=10 && list.get(9).size() - a9 >0)|| (240-t>=11 && list.get(10).size() - a10 >0)
																	|| (240-t>=12 && list.get(11).size() - a11 >0) || (240-t>=13 && list.get(12).size() - a12 >0)
																	|| (240-t>=14 && list.get(13).size() - a13 >0)){}
															else{
															StringBuffer sb = new StringBuffer();
															sb.append("3:"+a3+" "+"4:"+a4+" "+"5:"+a5+" "+"6:"+a6+" "+"7:"+a7+" "+"8:"+a8
																	+" "+"9:"+a9+" "+"10:"+a10+" "+"11:"+a11+" "+"12:"+a12+" "+"13:"+a13+" "+"14:"+a14+"\n");
															out.write(sb.toString().getBytes("utf-8"));
															}
															break;
														}
														if(t>240||n>30) break;
														for(int a15=0;a15<=list.get(15).size();a15++){
															t = a3*4+a4*5+a5*6+a6*7+a7*8+a8*9+a9*10+a10*11+a11*12+a12*13+a13*14+a14*15+a15*16;
															n = a3+a4+a5+a6+a7+a8+a9+a10+a11+a12+a13+a14+a15;
															if(t>224&&t<=240&&n<=30){
																if((240-t>=4 && list.get(3).size() - a3 >0) || (240-t>=5 && list.get(4).size() - a4 >0)
																		|| (240-t>=6 && list.get(5).size() - a5 >0) || (240-t>=7 && list.get(6).size() - a6 >0)
																		|| (240-t>=8 && list.get(7).size() - a7 >0) || (240-t>=9 && list.get(8).size() - a8 >0)
																		|| (240-t>=10 && list.get(9).size() - a9 >0)|| (240-t>=11 && list.get(10).size() - a10 >0)
																		|| (240-t>=12 && list.get(11).size() - a11 >0) || (240-t>=13 && list.get(12).size() - a12 >0)
																		|| (240-t>=14 && list.get(13).size() - a13 >0) || (240-t>=14 && list.get(13).size() - a13 >0)
																		|| (240-t>=15 && list.get(14).size() - a14 >0)){}
																else{
																StringBuffer sb = new StringBuffer();
																sb.append("3:"+a3+" "+"4:"+a4+" "+"5:"+a5+" "+"6:"+a6+" "+"7:"+a7+" "+"8:"+a8
																		+" "+"9:"+a9+" "+"10:"+a10+" "+"11:"+a11+" "+"12:"+a12+" "+"13:"+a13+" "+"14:"+a14
																		+" "+"15:"+a15+"\n");
																out.write(sb.toString().getBytes("utf-8"));
																}
																break;
															}
															if(t>240||n>30) break;
															for(int a16=0;a16<=list.get(16).size();a16++){
																t = a3*4+a4*5+a5*6+a6*7+a7*8+a8*9+a9*10+a10*11+a11*12+a12*13+a13*14+a14*15+a15*16+a16*17;
																n = a3+a4+a5+a6+a7+a8+a9+a10+a11+a12+a13+a14+a15+a16;
																if(t>223&&t<=240&&n<=30){
																	if((240-t>=4 && list.get(3).size() - a3 >0) || (240-t>=5 && list.get(4).size() - a4 >0)
																			|| (240-t>=6 && list.get(5).size() - a5 >0) || (240-t>=7 && list.get(6).size() - a6 >0)
																			|| (240-t>=8 && list.get(7).size() - a7 >0) || (240-t>=9 && list.get(8).size() - a8 >0)
																			|| (240-t>=10 && list.get(9).size() - a9 >0)|| (240-t>=11 && list.get(10).size() - a10 >0)
																			|| (240-t>=12 && list.get(11).size() - a11 >0) || (240-t>=13 && list.get(12).size() - a12 >0)
																			|| (240-t>=14 && list.get(13).size() - a13 >0) || (240-t>=14 && list.get(13).size() - a13 >0)
																			|| (240-t>=15 && list.get(14).size() - a14 >0) || (240-t>=16 && list.get(15).size() - a15 >0)){}
																	else{
																	StringBuffer sb = new StringBuffer();
																	sb.append("3:"+a3+" "+"4:"+a4+" "+"5:"+a5+" "+"6:"+a6+" "+"7:"+a7+" "+"8:"+a8
																			+" "+"9:"+a9+" "+"10:"+a10+" "+"11:"+a11+" "+"12:"+a12+" "+"13:"+a13+" "+"14:"+a14
																			+" "+"15:"+a15+" "+"16:"+a16+"\n");
																	out.write(sb.toString().getBytes("utf-8"));
																	}
																	break;
																}
																if(t>240||n>30) break;
																for(int a17=0;a17<=list.get(17).size();a17++){
																	t = a3*4+a4*5+a5*6+a6*7+a7*8+a8*9+a9*10+a10*11+a11*12+a12*13+a13*14+a14*15+a15*16+a16*17+a17*18;
																	n = a3+a4+a5+a6+a7+a8+a9+a10+a11+a12+a13+a14+a15+a16+a17;
																	if(t>222&&t<=240&&n<=30){
																		if((240-t>=4 && list.get(3).size() - a3 >0) || (240-t>=5 && list.get(4).size() - a4 >0)
																				|| (240-t>=6 && list.get(5).size() - a5 >0) || (240-t>=7 && list.get(6).size() - a6 >0)
																				|| (240-t>=8 && list.get(7).size() - a7 >0) || (240-t>=9 && list.get(8).size() - a8 >0)
																				|| (240-t>=10 && list.get(9).size() - a9 >0)|| (240-t>=11 && list.get(10).size() - a10 >0)
																				|| (240-t>=12 && list.get(11).size() - a11 >0) || (240-t>=13 && list.get(12).size() - a12 >0)
																				|| (240-t>=14 && list.get(13).size() - a13 >0) || (240-t>=14 && list.get(13).size() - a13 >0)
																				|| (240-t>=15 && list.get(14).size() - a14 >0) || (240-t>=16 && list.get(15).size() - a15 >0)
																				|| (240-t>=17 && list.get(16).size() - a16 >0)){}
																		else{
																		StringBuffer sb = new StringBuffer();
																		sb.append("3:"+a3+" "+"4:"+a4+" "+"5:"+a5+" "+"6:"+a6+" "+"7:"+a7+" "+"8:"+a8
																				+" "+"9:"+a9+" "+"10:"+a10+" "+"11:"+a11+" "+"12:"+a12+" "+"13:"+a13+" "+"14:"+a14
																				+" "+"15:"+a15+" "+"16:"+a16+" "+"17:"+a17+"\n");
																		out.write(sb.toString().getBytes("utf-8"));
																		}
																		break;
																	}
																	if(t>240||n>30) break;
																	for(int a18=0;a18<=list.get(18).size();a18++){
																		t = a3*4+a4*5+a5*6+a6*7+a7*8+a8*9+a9*10+a10*11+a11*12+a12*13+a13*14+a14*15+a15*16+a16*17+a17*18+a18*19;
																		n = a3+a4+a5+a6+a7+a8+a9+a10+a11+a12+a13+a14+a15+a16+a17+a18;
																		if(t>221&&t<=240&&n<=30){
																			if((240-t>=4 && list.get(3).size() - a3 >0) || (240-t>=5 && list.get(4).size() - a4 >0)
																					|| (240-t>=6 && list.get(5).size() - a5 >0) || (240-t>=7 && list.get(6).size() - a6 >0)
																					|| (240-t>=8 && list.get(7).size() - a7 >0) || (240-t>=9 && list.get(8).size() - a8 >0)
																					|| (240-t>=10 && list.get(9).size() - a9 >0)|| (240-t>=11 && list.get(10).size() - a10 >0)
																					|| (240-t>=12 && list.get(11).size() - a11 >0) || (240-t>=13 && list.get(12).size() - a12 >0)
																					|| (240-t>=14 && list.get(13).size() - a13 >0) || (240-t>=14 && list.get(13).size() - a13 >0)
																					|| (240-t>=15 && list.get(14).size() - a14 >0) || (240-t>=16 && list.get(15).size() - a15 >0)
																					|| (240-t>=17 && list.get(16).size() - a16 >0) || (240-t>=18 && list.get(17).size() - a17 >0)){}
																			else{
																			StringBuffer sb = new StringBuffer();
																			sb.append("3:"+a3+" "+"4:"+a4+" "+"5:"+a5+" "+"6:"+a6+" "+"7:"+a7+" "+"8:"+a8
																					+" "+"9:"+a9+" "+"10:"+a10+" "+"11:"+a11+" "+"12:"+a12+" "+"13:"+a13+" "+"14:"+a14
																					+" "+"15:"+a15+" "+"16:"+a16+" "+"17:"+a17+" "+"18:"+a18+"\n");
																			out.write(sb.toString().getBytes("utf-8"));
																			}
																			break;
																		}
																		if(t>240||n>30) break;
																		for(int a19=0;a19<=list.get(19).size();a19++){
																			t = a3*4+a4*5+a5*6+a6*7+a7*8+a8*9+a9*10+a10*11+a11*12+a12*13+a13*14+a14*15+a15*16+a16*17+a17*18+a18*19+a19*20;
																			n = a3+a4+a5+a6+a7+a8+a9+a10+a11+a12+a13+a14+a15+a16+a17+a18+a19;
																			if(t>220&&t<=240&&n<=30){
																				if((240-t>=4 && list.get(3).size() - a3 >0) || (240-t>=5 && list.get(4).size() - a4 >0)
																						|| (240-t>=6 && list.get(5).size() - a5 >0) || (240-t>=7 && list.get(6).size() - a6 >0)
																						|| (240-t>=8 && list.get(7).size() - a7 >0) || (240-t>=9 && list.get(8).size() - a8 >0)
																						|| (240-t>=10 && list.get(9).size() - a9 >0)|| (240-t>=11 && list.get(10).size() - a10 >0)
																						|| (240-t>=12 && list.get(11).size() - a11 >0) || (240-t>=13 && list.get(12).size() - a12 >0)
																						|| (240-t>=14 && list.get(13).size() - a13 >0) || (240-t>=14 && list.get(13).size() - a13 >0)
																						|| (240-t>=15 && list.get(14).size() - a14 >0) || (240-t>=16 && list.get(15).size() - a15 >0)
																						|| (240-t>=17 && list.get(16).size() - a16 >0) || (240-t>=18 && list.get(17).size() - a17 >0)
																						|| (240-t>=19 && list.get(18).size() - a18 >0)){}
																				else{
																				StringBuffer sb = new StringBuffer();
																				sb.append("3:"+a3+" "+"4:"+a4+" "+"5:"+a5+" "+"6:"+a6+" "+"7:"+a7+" "+"8:"+a8
																						+" "+"9:"+a9+" "+"10:"+a10+" "+"11:"+a11+" "+"12:"+a12+" "+"13:"+a13+" "+"14:"+a14
																						+" "+"15:"+a15+" "+"16:"+a16+" "+"17:"+a17+" "+"18:"+a18+" "+"19:"+a19+"\n");
																				out.write(sb.toString().getBytes("utf-8"));
																				}
																				break;
																			}
																			if(t>240||n>30) break;
																			for(int a20=0;a20<=list.get(20).size();a20++){
																				t = a3*4+a4*5+a5*6+a6*7+a7*8+a8*9+a9*10+a10*11+a11*12+a12*13+a13*14+a14*15+a15*16+a16*17+a17*18+a18*19+a19*20+a20*21;
																				n = a3+a4+a5+a6+a7+a8+a9+a10+a11+a12+a13+a14+a15+a16+a17+a18+a19+a20;
																				if(t>219&&t<=240&&n<=30){
																					if((240-t>=4 && list.get(3).size() - a3 >0) || (240-t>=5 && list.get(4).size() - a4 >0)
																							|| (240-t>=6 && list.get(5).size() - a5 >0) || (240-t>=7 && list.get(6).size() - a6 >0)
																							|| (240-t>=8 && list.get(7).size() - a7 >0) || (240-t>=9 && list.get(8).size() - a8 >0)
																							|| (240-t>=10 && list.get(9).size() - a9 >0)|| (240-t>=11 && list.get(10).size() - a10 >0)
																							|| (240-t>=12 && list.get(11).size() - a11 >0) || (240-t>=13 && list.get(12).size() - a12 >0)
																							|| (240-t>=14 && list.get(13).size() - a13 >0) || (240-t>=14 && list.get(13).size() - a13 >0)
																							|| (240-t>=15 && list.get(14).size() - a14 >0) || (240-t>=16 && list.get(15).size() - a15 >0)
																							|| (240-t>=17 && list.get(16).size() - a16 >0) || (240-t>=18 && list.get(17).size() - a17 >0)
																							|| (240-t>=19 && list.get(18).size() - a18 >0) || (240-t>=20 && list.get(19).size() - a19 >0)){}
																					else{
																					StringBuffer sb = new StringBuffer();
																					sb.append("3:"+a3+" "+"4:"+a4+" "+"5:"+a5+" "+"6:"+a6+" "+"7:"+a7+" "+"8:"+a8
																							+" "+"9:"+a9+" "+"10:"+a10+" "+"11:"+a11+" "+"12:"+a12+" "+"13:"+a13+" "+"14:"+a14
																							+" "+"15:"+a15+" "+"16:"+a16+" "+"17:"+a17+" "+"18:"+a18+" "+"19:"+a19+" "+"20:"+a20+"\n");
																					out.write(sb.toString().getBytes("utf-8"));
																					}
																					break;
																				}
																				if(t>240||n>30) break;
																			}
																		}
																	}
																}
															}
														}
													}
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
	}

}
