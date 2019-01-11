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
		jt.append("ѹ����...\n");
		ZipOutputStream zout = new ZipOutputStream(zipFile, StandardCharsets.UTF_8);
		BufferedOutputStream bo = new BufferedOutputStream(zout);
		zip(zout, srcfile, srcfile.getName(), bo, jt);
		bo.close();
		zout.close(); // ������ر�
		jt.append("ѹ�����\n");
	}
	public void zip(ZipOutputStream zout, File f, String src, BufferedOutputStream bo, JTextArea jt) throws Exception {
		if (f.isDirectory()) {
			File[] fl = f.listFiles();
			if (fl.length == 0) {
				zout.putNextEntry(new ZipEntry(src + File.separator)); // ����zipѹ�������base
				jt.append("����ѹ����" + src + File.separator + "\n");
			}
			for (int i = 0; i < fl.length; i++) {
				zip(zout, fl[i], src + File.separator + fl[i].getName(), bo, jt); // �ݹ�������ļ���
			}
		} else {
			zout.putNextEntry(new ZipEntry(src)); // ����zipѹ�������base
			jt.append("����ѹ����" + src + "\n");
			FileInputStream in = new FileInputStream(f);
			BufferedInputStream bi = new BufferedInputStream(in);
			int b;
			while ((b = bi.read()) != -1) {
				bo.write(b); // ���ֽ���д�뵱ǰzipĿ¼
				bo.flush();
			}
			bi.close();
			in.close(); // �������ر�
		}
	}
	public void unzip(String ZipFile, String dest_dir, JTextArea jt) {
		File file = new File(ZipFile);//��ǰѹ���ļ�
		ZipInputStream zin;//����ZipInputStream����
		try {
			ZipFile zipFile = new ZipFile(file);//����ѹ���ļ�����
			zin = new ZipInputStream(new FileInputStream(file));//ʵ��������ָ��Ҫ��ѹ���ļ�
			ZipEntry entry;
			while (((entry = zin.getNextEntry()) != null) && !entry.isDirectory()) {//���entry��Ϊ�գ�������ͬһ��Ŀ¼��
				File tmp = new File(dest_dir + File.separator + entry.getName());//��ѹ�����ļ�·��
				if (!tmp.exists()) {//����ļ�������
					tmp.getParentFile().mkdirs();//�����ļ������ļ���·��
					OutputStream os = new FileOutputStream(tmp);//���ļ�Ŀ¼�е��ļ����������
					//����������ȡѹ���ļ����е��ļ�
					InputStream in = zipFile.getInputStream(entry);
					int count = 0;
					while ((count = in.read()) != -1) {//�������������Զ�ȡ����ֵ
						os.write(count);//�����д��
					}
					os.close();
					in.close();
				}
				zin.closeEntry();
				jt.append(entry.getName() + "��ѹ�ɹ�\n");
			}
			zin.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
