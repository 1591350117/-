package Zipdemo;
import static Zipdemo.Zipcode.setcenter;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
public class ZipFileUl extends javax.swing.JFrame {
	public Zipcode itsZipcode;
	public ZipFileUl() {
		initComponents();
		setcenter(this);
		this.setResizable(false);
		text1.setEditable(false);
		Dir_name.setEditable(false);
	}

	private void initComponents() {
		jLabel1 = new javax.swing.JLabel();
		Dir_name = new javax.swing.JTextField();
		selectDir = new javax.swing.JButton();
		jScrollPane1 = new javax.swing.JScrollPane();
		text1 = new javax.swing.JTextArea();
		exitBu = new javax.swing.JButton();
		returnMU = new javax.swing.JButton();
		Zipbu = new javax.swing.JButton();
		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		jLabel1.setText("请选择要压缩的文件夹或文件");
		selectDir.setText("选择要压缩的文件夹");
		selectDir.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				selectDirActionPerformed(evt);
			}
		});
		text1.setColumns(20);
		text1.setRows(5);
		jScrollPane1.setViewportView(text1);
		exitBu.setText("退出程序");
		exitBu.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				exitBuActionPerformed(evt);
			}
		});
		returnMU.setText("返回主菜单");
		returnMU.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				returnMUActionPerformed(evt);
			}
		});
		Zipbu.setText("压缩文件");
		Zipbu.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				ZipbuActionPerformed(evt);
			}
		});
		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
				.createSequentialGroup().addGap(40, 40, 40)
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
						.createSequentialGroup()
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(layout.createSequentialGroup().addGap(0, 6, Short.MAX_VALUE)
										.addComponent(Zipbu, javax.swing.GroupLayout.PREFERRED_SIZE, 99,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(76, 76, 76).addComponent(returnMU).addGap(56, 56, 56)
										.addComponent(exitBu, javax.swing.GroupLayout.PREFERRED_SIZE, 93,
												javax.swing.GroupLayout.PREFERRED_SIZE))
								.addComponent(jScrollPane1))
						.addGap(43, 43, 43))
						.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
								layout.createSequentialGroup().addGap(0, 0, Short.MAX_VALUE)
										.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addComponent(Dir_name, javax.swing.GroupLayout.PREFERRED_SIZE, 276,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(jLabel1))
										.addGap(18, 18, 18).addComponent(selectDir).addGap(21, 21, 21)))));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
				.createSequentialGroup().addGap(20, 20, 20)
				.addComponent(
						jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
				.addGap(18, 18, 18)
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
						.addComponent(Dir_name, javax.swing.GroupLayout.PREFERRED_SIZE, 32,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addComponent(selectDir, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE))
				.addGap(18, 18, 18)
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
						.addComponent(Zipbu, javax.swing.GroupLayout.PREFERRED_SIZE, 44,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addComponent(returnMU, javax.swing.GroupLayout.PREFERRED_SIZE, 44,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addComponent(exitBu, javax.swing.GroupLayout.PREFERRED_SIZE, 44,
								javax.swing.GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
				.addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 210,
						javax.swing.GroupLayout.PREFERRED_SIZE)
				.addContainerGap()));
		pack();
	}

	private void exitBuActionPerformed(java.awt.event.ActionEvent evt) {
		System.exit(0);
	}

	private void returnMUActionPerformed(java.awt.event.ActionEvent evt) {
		mainZipUl mu = new mainZipUl();
		this.dispose();//释放当前窗口及其组件占用的资源
		mu.setVisible(true);
	}
	private void selectDirActionPerformed(java.awt.event.ActionEvent evt) {
		if (selectDir.getText().equals("选择要压缩的文件夹")) {
			JFileChooser jfc = new JFileChooser();
			jfc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			jfc.showDialog(new JLabel(), "选此文件夹");
			File file = jfc.getSelectedFile();
			Dir_name.setText(file.getAbsolutePath());
			Ssrc = file.getAbsolutePath();
			selectDir.setText("保存到");
		}
		if (selectDir.getText().equals("保存到")) {
			JFileChooser jfc = new JFileChooser();
			jfc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			jfc.showDialog(new JLabel(), "保存到");
			File file = jfc.getSelectedFile();
			Dir_name.setText(file.getAbsolutePath());
			Dsrc = file.getAbsolutePath();
			selectDir.setText("选择要压缩的文件夹");
		}
	}
	private void ZipbuActionPerformed(java.awt.event.ActionEvent evt) {
		Zipcode user = new Zipcode();
		String src = this.Ssrc;
		String dest = this.Dsrc;
		File srcf = new File(src);
		File destf = new File(dest);
		if (!srcf.exists()) {
			JOptionPane.showMessageDialog(this, "文件或文件夹不存在，请检查后重试");
			return;
		}
		if (!destf.exists()) {
			destf.mkdirs();
		}
		try {
			String message = "压缩成功，文件存放在：" + dest + "目录下";
			JOptionPane.showMessageDialog(this, message);
			user.zip(src, dest, text1);
		} catch (Exception ex) {
			Logger.getLogger(ZipFileUl.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
	private String Ssrc;//文件选择器获取的要压缩的文件路径
	private String Dsrc;//文件选择器获取的目标地址
	private javax.swing.JTextField Dir_name;
	private javax.swing.JButton Zipbu;
	private javax.swing.JButton exitBu;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JButton returnMU;
	private javax.swing.JButton selectDir;
	private javax.swing.JTextArea text1;
	public Zipcode getItsZipcode() {
		return this.itsZipcode;
	}
}
