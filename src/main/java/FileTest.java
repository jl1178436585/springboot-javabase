import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.CharBuffer;
import java.nio.charset.Charset;

/*
 * @(#)FileTest.java  
 */
/**
 *<p>Title:</p>
 * @author: jl
 * @date: 2018/06/27
 * @version: v1.0
 */
public class FileTest {

	public static void main(String[] args) throws Exception {
	/*	Reader r = new FileReader(new File("D:\\test\\RCS.CSV"));
		BufferedReader bufferedReader = new BufferedReader(r);
		String readLine = "";
		while((readLine = bufferedReader.readLine()) != null) {
			System.out.println(readLine);
		}
		bufferedReader.close();*/
		
		String s = "abc&nbsp;de";//11
		
		char[] charArray = s.toCharArray();
		int i = 0;
		for (char c : charArray) {
			System.out.println(c + ":" + (++i));
		}
		
		main1();
		
	}
	
	public static void main1() throws Exception {
		FileInputStream in = new FileInputStream(new File("D:\\test\\RCS.CSV"));
		Reader reader = new InputStreamReader(in,"UTF-8");
		BufferedReader bufferedReader = new BufferedReader(reader);
		String readLine = "";
		while((readLine = bufferedReader.readLine()) != null) {
			System.out.println(readLine);
		}
		bufferedReader.close();
	}
}
