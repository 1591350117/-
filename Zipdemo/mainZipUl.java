package Zipdemo;
import static Zipdemo.Zipcode.setcenter;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class mainZipUl extends javax.swing.JFrame {
	private ZipFileUl itsZipFileUl;
	private UnZipFileUl itsUnZipFileUl;

	public mainZipUl() {
		initComponents();
		this.setTitle("Java解压小程序");
		setcenter(this);
		this.setResizable(false);
	}
	private void initComponents() {
		jLabel1 = new javax.swing.JLabel();
		jLabel2 = new javax.swing.JLabel();
		UnZipFile = new javax.swing.JButton();
		about = new javax.swing.JButton();
		ZipFile = new javax.swing.JButton();
		jLabel3 = new javax.swing.JLabel();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setBackground(new java.awt.Color(211, 238, 238));

		jLabel1.setText("小程序可以实现压缩和解压文件功能");

		jLabel2.setText("选择你要的功能");

		UnZipFile.setText("解压文件");
		UnZipFile.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				UnZipFileActionPerformed(evt);
			}
		});

		about.setText("关于");
		about.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				aboutActionPerformed(evt);
			}
		});
		ZipFile.setText("压缩文件");
		ZipFile.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				ZipFileActionPerformed(evt);
			}
		});
		jLabel3.setText("欢迎来到Java解压小程序主界面");
		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(layout.createSequentialGroup().addGap(206, 206, 206)
										.addComponent(UnZipFile, javax.swing.GroupLayout.PREFERRED_SIZE, 100,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(56, 56, 56).addComponent(about, javax.swing.GroupLayout.PREFERRED_SIZE,
												100, javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGroup(layout.createSequentialGroup().addGap(138, 138, 138).addComponent(
										jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 198,
										javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGroup(layout.createSequentialGroup().addGap(181, 181, 181).addComponent(
										jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 106,
										javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGroup(layout.createSequentialGroup().addGap(149, 149, 149).addComponent(jLabel3,
										javax.swing.GroupLayout.PREFERRED_SIZE, 177,
										javax.swing.GroupLayout.PREFERRED_SIZE)))
						.addContainerGap(38, Short.MAX_VALUE))
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(layout.createSequentialGroup().addGap(59, 59, 59)
								.addComponent(ZipFile, javax.swing.GroupLayout.PREFERRED_SIZE, 100,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addContainerGap(341, Short.MAX_VALUE))));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addGap(66, 66, 66)
						.addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 36,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 38,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(18, 18, 18)
						.addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 34,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 79, Short.MAX_VALUE)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(about, javax.swing.GroupLayout.PREFERRED_SIZE, 50,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(UnZipFile, javax.swing.GroupLayout.PREFERRED_SIZE, 50,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(69, 69, 69))
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(
						javax.swing.GroupLayout.Alignment.TRAILING,
						layout.createSequentialGroup().addContainerGap(283, Short.MAX_VALUE).addComponent(ZipFile,
								javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(67, 67, 67))));

		pack();
	}
	private void aboutActionPerformed(java.awt.event.ActionEvent evt) {
		JOptionPane.showMessageDialog(null, "java小程序");
	}

	private void ZipFileActionPerformed(java.awt.event.ActionEvent evt) {
		ZipFileUl zfu = new ZipFileUl();
		String name = (this.getTitle() + "-" + ZipFile.getText());
		this.dispose();//释放此window机其组件
		zfu.setVisible(true);
		zfu.setTitle(name);
	}

	private void UnZipFileActionPerformed(java.awt.event.ActionEvent evt) {
		UnZipFileUl uzf = new UnZipFileUl();
		String name = (this.getTitle() + "-" + UnZipFile.getText());
		this.dispose();//释放此window机其组件
		uzf.setVisible(true);
		uzf.setTitle(name);
	}
	public static void main(String args[]) {
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(mainZipUl.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(mainZipUl.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(mainZipUl.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(mainZipUl.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new mainZipUl().setVisible(true);
			}
		});
	}
	private javax.swing.JButton UnZipFile;
	private javax.swing.JButton ZipFile;
	private javax.swing.JButton about;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;

}
