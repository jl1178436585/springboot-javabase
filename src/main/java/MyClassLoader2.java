/*
 * @(#)MyClassLoader.java  
 */


import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;

/**
 *<p>
 *	测试参考 默认包下面的MyClassLoader.java
 *</p>
 * @author: jl
 * @date: 2018/06/25
 * @version: v1.0
 */
public class MyClassLoader2 extends ClassLoader{

	private String name;//类加载器的名称
	
	private String path= "d:\\" ;//加载类的路径
	
	private final String fileType = ".class"; //class文件的扩展名
	
	public MyClassLoader2(String name) {
		super(); //让系统类加载器成为该类加载器的父加载器
		this.name = name;
	}
	
	public MyClassLoader2(ClassLoader panrent,String name) {
		super(panrent); //让系统类加载器成为该类加载器的父加载器
		this.name = name;
	}
	
	@Override
	protected Class<?> findClass(String name) throws ClassNotFoundException {
		byte[] data = loadClassData(name);
		
		return this.defineClass(name,data, 0, data.length);
	}
	
	private byte[] loadClassData(String name) {
		InputStream in = null;
		ByteArrayOutputStream out = null;
		byte[] data = null; 
		try {
			this.name = this.name.replace(".", "\\");
			in = new FileInputStream(new File(path + name + fileType));
			
			out = new ByteArrayOutputStream();
			int ch = 0;
			while((ch = in.read())!= -1) {
				out.write(ch);
			}
			
			data = out.toByteArray();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(out != null) {
				try {
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(in != null) {
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		return data;
	}
	
	@Override
	public String toString() {
		return this.name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getFileType() {
		return fileType;
	}
	

	
	public static void main(String[] args) throws Exception {
		
//		test1();
		test2();
	}
	
	/**
	 * 测试前提：
	 * Sample和Dog类只在目录D:\test\serverlib下,MyClassLoader2只在目录D:\test\syslib
	 * @param args
	 * @throws Exception 
	 * @throws InstantiationException 
	 * @throws Exception 
	 */
	public static void test1() throws Exception {
		MyClassLoader2 loader1 = new MyClassLoader2("loader1");
		loader1.setPath("D:\\test\\serverlib\\");
		
		MyClassLoader2 loader2 = new MyClassLoader2(loader1,"loader2");
		loader2.setPath("D:\\test\\clientlib\\");
		
		Class<?> clazz = loader1.loadClass("Sample");
		Object object = clazz.newInstance();
		Sample s = (Sample)object;//这里会报错：Exception in thread "main" java.lang.NoClassDefFoundError: Sample
		/**
		 * 分析：
		 * 因为MyClassLoader是由系统类加载器加载，而Sample是由loader1类加载器加载，因此
		 * MyClassLoader类看不见Sample类，在MyClassLoader类的main方法使用Sample类会导致
		 * NoClassDefFoundError错误
		 * 
		 * 当两个不同命名空间的类相互不可见时，可以采用反射机制来访问对方的实例属性和方法
		 */
		
		System.out.println(s.getV1());
	}
	
	
	public static void test2() throws Exception {
		MyClassLoader2 loader1 = new MyClassLoader2("loader1");
		loader1.setPath("D:\\test\\serverlib\\");
		
		MyClassLoader2 loader2 = new MyClassLoader2(loader1,"loader2");
		loader2.setPath("D:\\test\\clientlib\\");
		
		Class<?> clazz = loader1.loadClass("Sample");
		Object object = clazz.newInstance();
		Field field = clazz.getDeclaredField("v1");
		int value = field.getInt(object);
		System.out.println(value);
		
	}
	
	

}
