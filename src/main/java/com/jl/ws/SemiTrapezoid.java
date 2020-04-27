package com.jl.ws;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;import org.junit.validator.ValidateWith;

public class SemiTrapezoid {

	/**
	 * 读取txt文件
	 * 
	 */
	public static List<List<Double>> readTxtFile(String filePath) throws Exception {
		
		File file = new File(filePath);
		if(!file.exists()){
			throw new Exception("文件不存在");
		}
		filePath = "D:\\test.txt";
		file = new File(filePath);
		InputStreamReader reader = new InputStreamReader(new FileInputStream(file));
		BufferedReader bufferedReader = new BufferedReader(reader);
		String lineTxt = null;
		int total = 0;
		List<List<Double>> result = new ArrayList<List<Double>>();
		while((lineTxt=bufferedReader.readLine())!=null){
			String[] row = lineTxt.split(",");
			Double[] drow = new Double[row.length];
			for(int i=0;i<row.length;i++){
				String s = row[i].trim();
				int length = s.length();
				for(int index = 0; index < length; index++){
					
					char charAt = s.charAt(index);
//					System.out.println((int)charAt);
				} 
//				System.out.println("0.0".equals(s));
				Double dvalue = Double.valueOf(s);
				drow[i] = dvalue;
				System.out.println(dvalue);
			}
			List<Double> newlist = Arrays.asList(drow);
			result.add(total, newlist);
			total++;
		}
		reader.close();
		return result;
	}
	
	/**
	 * 输出新的txt文件
	 */
	public static void writeToText(String filePath,String content) throws IOException {
		File file = new File(filePath);
		if (file.exists()) {  
            System.out.print("文件存在");  
        } else {  
            System.out.print("文件不存在");  
            file.createNewFile();
        }
	    
	    RandomAccessFile rf = new RandomAccessFile(file, "rw");
	    rf.seek(rf.length());
	    rf.writeBytes(content);
	    rf.close();
	    
//		BufferedWriter output = new BufferedWriter(new FileWriter(file));
//		output.write(content);
//		output.close();
	}
	
	public static Double[][] memberShip(List<Double> range,List<Double> value) throws Exception {
		int valueSize = value.size();
		int rangeSize = range.size();
		Double[][] result = new Double[valueSize][rangeSize];
		for(int i=0;i<valueSize;i++){
			if(value.get(i)>range.get(rangeSize-1)){
				result[i][0] =  (double) 0;
				result[i][1] =  (double) 0;
				result[i][2] = (double) 0;
				result[i][3] = (double) 0;
				result[i][4] = (double) 1;
			}else if(value.get(i)<=range.get(1)){
				result[i][0] = (double) 1;
				result[i][1] = (double) 1;
				result[i][2] = (double) 0;
				result[i][3] = (double) 0;
				result[i][4] = (double) 0;
			}else if(value.get(i)>range.get(1)&&value.get(i)<=range.get(2)){
				result[i][0] = (double) (range.get(2)-value.get(i))/(range.get(2)-range.get(1));
				result[i][1] = (double) (value.get(i)-range.get(1))/(range.get(2)-range.get(1));
				result[i][2] = (double) 0;
				result[i][3] = (double) 0;
				result[i][4] = (double) 0;
			}else if(value.get(i)>range.get(2)&&value.get(i)<=range.get(3)){
				result[i][0] = (double) 0;
				result[i][1] = (double) (range.get(3)-value.get(i))/(range.get(3)-range.get(2));
				result[i][2] = (double) (value.get(i)-range.get(2))/(range.get(3)-range.get(2));
				result[i][3] = (double) 0;
				result[i][4] = (double) 0;
			}else if(value.get(i)>range.get(3)&&value.get(i)<=range.get(4)){
				result[i][0] = (double) 0;
				result[i][1] = (double) 0;
				result[i][2] = (double) (range.get(4)-value.get(i))/(range.get(4)-range.get(3));
				result[i][3] = (double) (value.get(i)-range.get(3))/(range.get(4)-range.get(3));
				result[i][4] = (double) 0;
			}else if(value.get(i)>range.get(4)&&value.get(i)<=range.get(5)){
				result[i][0] = (double) 0;
				result[i][1] = (double) 0;
				result[i][2] = (double) 0;
				result[i][3] = (double) (range.get(5)-value.get(i))/(range.get(5)-range.get(4));
				result[i][4] = (double) (value.get(i)-range.get(4))/(range.get(5)-range.get(4));
			}
		}
		return result;
	}
	
	public static void main(String[] args) throws Exception {
		
//		String value = "0.0";
//		Double dv = Double.parseDouble(value);
//		System.out.println(dv);
		
		String filePath = "D:\\data.txt";
		List<List<Double>> list = readTxtFile(filePath);
		int size = list.size();
//		if(size%2==1){
//			throw new Exception("奇数数据异常");
//		}
		String outfilePath = "C:\\Users\\Think\\Desktop\\饮用水数据结果.txt";
		String content = "";
		for(int i=0;i<size;i=i+2){
			Double[][] result = memberShip(list.get(i),list.get(i+1));
			for(int j=0;j<list.get(i+1).size();j++){
				for(int k=0;k<list.get(i).size();k++){
					content = content+result[j][k]+" ";
				}
				content = content+"\r\n";
			}
			content = content+"\r\n";
		}
		writeToText(outfilePath,content);
	}
}
