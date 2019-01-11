package Zipdemo;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;
import Zipdemo.ZipFileUl;
import Zipdemo.UnZipFileUl;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.*;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
public class Zipcode {
	public static void setcenter(JFrame f) {
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension d = tk.getScreenSize();
		int screenWidth = (int) (d.getWidth());
		int screenHeight = (int) d.getHeight();
		int frameWidth = f.getWidth();
		int frameHeight = f.getWidth();
		f.setBounds((screenWidth - frameWidth) / 2, (screenHeight - frameHeight) / 2, frameWidth, frameHeight);
	}
	public void zip(String src_name, String dest_name, JTextArea jt) throws Exception {
		File srcfile = new File(src_name);
		String zfname = dest_name + File.separator + srcfile.getName() + ".zip";
		FileOutputStream zipFile = new FileOutputStream(zfname);
		jt.append("压缩中...\n");
		ZipOutputStream zout = new ZipOutputStream(zipFile, StandardCharsets.UTF_8);
		BufferedOutputStream bo = new BufferedOutputStream(zout);
		zip(zout, srcfile, srcfile.getName(), bo, jt);
		bo.close();
		zout.close(); // 输出流关闭
		jt.append("压缩完成\n");
	}
	public void zip(ZipOutputStream zout, File f, String src, BufferedOutputStream bo, JTextArea jt) throws Exception {
		if (f.isDirectory()) {
			File[] fl = f.listFiles();
			if (fl.length == 0) {
				zout.putNextEntry(new ZipEntry(src + File.separator)); // 创建zip压缩进入点base
				jt.append("正在压缩：" + src + File.separator + "\n");
			}
			for (int i = 0; i < fl.length; i++) {
				zip(zout, fl[i], src + File.separator + fl[i].getName(), bo, jt); // 递归遍历子文件夹
			}
		} else {
			zout.putNextEntry(new ZipEntry(src)); // 创建zip压缩进入点base
			jt.append("正在压缩：" + src + "\n");
			FileInputStream in = new FileInputStream(f);
			BufferedInputStream bi = new BufferedInputStream(in);
			int b;
			while ((b = bi.read()) != -1) {
				bo.write(b); // 将字节流写入当前zip目录
				bo.flush();
			}
			bi.close();
			in.close(); // 输入流关闭
		}
	}
	public void unzip(String ZipFile, String dest_dir, JTextArea jt) {
		File file = new File(ZipFile);//当前压缩文件
		ZipInputStream zin;//创建ZipInputStream对象
		try {
			ZipFile zipFile = new ZipFile(file);//创建压缩文件对象
			zin = new ZipInputStream(new FileInputStream(file));//实例化对象，指明要解压的文件
			ZipEntry entry;
			while (((entry = zin.getNextEntry()) != null) && !entry.isDirectory()) {//如果entry不为空，并不在同一个目录下
				File tmp = new File(dest_dir + File.separator + entry.getName());//解压出的文件路径
				if (!tmp.exists()) {//如果文件不存在
					tmp.getParentFile().mkdirs();//创建文件父类文件夹路径
					OutputStream os = new FileOutputStream(tmp);//将文件目录中的文件放入输出流
					//用输入流读取压缩文件中中的文件
					InputStream in = zipFile.getInputStream(entry);
					int count = 0;
					while ((count = in.read()) != -1) {//如有输入流可以读取到数值
						os.write(count);//输出流写入
					}
					os.close();
					in.close();
				}
				zin.closeEntry();
				jt.append(entry.getName() + "解压成功\n");
			}
			zin.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
