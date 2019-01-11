package Zipdemo;
import static Zipdemo.Zipcode.setcenter;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
public class UnZipFileUl extends javax.swing.JFrame {
	public Zipcode itsZipcode;
	public UnZipFileUl() {
		initComponents();
		setcenter(this);
		this.setResizable(false);
		text2.setEditable(false);
		UnZipText.setEditable(false);
	}
	private void initComponents() {
		jLabel1 = new javax.swing.JLabel();
		UnZipText = new javax.swing.JTextField();
		selectZipFile = new javax.swing.JButton();
		returnMBu = new javax.swing.JButton();
		UnzipBu = new javax.swing.JButton();
		exitBu2 = new javax.swing.JButton();
		jScrollPane1 = new javax.swing.JScrollPane();
		text2 = new javax.swing.JTextArea();
		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		jLabel1.setText("                  请选择要解压的压缩文件");
		selectZipFile.setText("打开压缩文件");
		selectZipFile.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				selectZipFileActionPerformed(evt);
			}
		});
		returnMBu.setText("返回主菜单");
		returnMBu.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				returnMBuActionPerformed(evt);
			}
		});
		UnzipBu.setText("解压");
		UnzipBu.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				UnzipBuActionPerformed(evt);
			}
		});
		exitBu2.setText("退出程序");
		exitBu2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				exitBu2ActionPerformed(evt);
			}
		});
		text2.setColumns(20);
		text2.setRows(5);
		jScrollPane1.setViewportView(text2);
		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(layout.createSequentialGroup().addGap(45, 45, 45)
										.addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 414,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(0, 0, Short.MAX_VALUE))
								.addGroup(layout.createSequentialGroup().addGap(25, 25, 25)
										.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
												.addGroup(layout.createSequentialGroup()
														.addComponent(UnzipBu, javax.swing.GroupLayout.PREFERRED_SIZE,
																139, javax.swing.GroupLayout.PREFERRED_SIZE)
														.addGap(18, 18, 18)
														.addComponent(returnMBu, javax.swing.GroupLayout.PREFERRED_SIZE,
																139, javax.swing.GroupLayout.PREFERRED_SIZE)
														.addPreferredGap(
																javax.swing.LayoutStyle.ComponentPlacement.RELATED,
																javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
														.addComponent(exitBu2, javax.swing.GroupLayout.PREFERRED_SIZE,
																139, javax.swing.GroupLayout.PREFERRED_SIZE))
												.addGroup(layout.createSequentialGroup()
														.addComponent(UnZipText, javax.swing.GroupLayout.PREFERRED_SIZE,
																321, javax.swing.GroupLayout.PREFERRED_SIZE)
														.addGap(32, 32, 32).addComponent(selectZipFile,
																javax.swing.GroupLayout.DEFAULT_SIZE, 112,
																Short.MAX_VALUE)))))
						.addContainerGap()));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addGap(25, 25, 25)
						.addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
								.addComponent(UnZipText)
								.addComponent(selectZipFile, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE))
						.addGap(18, 18, 18)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(returnMBu, javax.swing.GroupLayout.PREFERRED_SIZE, 48,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(exitBu2, javax.swing.GroupLayout.PREFERRED_SIZE, 48,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(UnzipBu, javax.swing.GroupLayout.PREFERRED_SIZE, 48,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(18, 18, 18)
						.addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)
						.addContainerGap()));
		pack();
	}
	private void exitBu2ActionPerformed(java.awt.event.ActionEvent evt) {
		System.exit(0);
	}
	private void returnMBuActionPerformed(java.awt.event.ActionEvent evt) {
		mainZipUl mu = new mainZipUl();
		this.dispose();//释放此window机其组件
		mu.setVisible(true);
	}
	private void selectZipFileActionPerformed(java.awt.event.ActionEvent evt) {
		if (selectZipFile.getText().equals("打开压缩文件"))
		{
			JFileChooser jfc = new JFileChooser();
			jfc.setFileSelectionMode(JFileChooser.FILES_ONLY);
			jfc.showDialog(new JLabel(), "确定");
			File file = jfc.getSelectedFile();
			UnZipText.setText(file.getAbsolutePath());
			Src_zip = file.getAbsolutePath();
			selectZipFile.setText("解压到");
		}
		if (selectZipFile.getText().equals("解压到")) {
			JFileChooser jfc = new JFileChooser();
			jfc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			jfc.showDialog(new JLabel(), "确定");
			File file = jfc.getSelectedFile();
			selectZipFile.setText(file.getAbsolutePath());
			Dest_dir = file.getAbsolutePath();
			selectZipFile.setText("打开压缩文件");
		}
	}
	private void UnzipBuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UnzipBuActionPerformed
		Zipcode user = new Zipcode();
		String src_file, dest_dir;
		src_file = this.Src_zip;
		dest_dir = this.Dest_dir;
		if (src_file.equals("")) {
			JOptionPane.showMessageDialog(this, "未输入或选择解压文件，请检查后重试");
			return;
		}
		try {
			user.unzip(src_file, dest_dir, text2);
			String message = "解压成功，文件存放在：" + dest_dir + "目录下";
			JOptionPane.showMessageDialog(this, message);
		} catch (Exception ex) {
			Logger.getLogger(UnZipFileUl.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
	private String Src_zip = "";
	private String Dest_dir = "";
	private javax.swing.JTextField UnZipText;
	private javax.swing.JButton UnzipBu;
	private javax.swing.JButton exitBu2;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JButton returnMBu;
	private javax.swing.JButton selectZipFile;
	private javax.swing.JTextArea text2;
	public Zipcode getItsZipcode() {
		return this.itsZipcode;
	}
}
