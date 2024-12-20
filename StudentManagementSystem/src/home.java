import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public class home extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					home frame = new home();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public home() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 950, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);

		JButton btnDisplayRecord = new JButton("Display Record");
		btnDisplayRecord.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				read r = new read();
				r.setVisible(true);
			}
		});
		btnDisplayRecord.setFont(new Font("Tahoma", Font.PLAIN, 17));

		JButton btnDeleteRecord = new JButton("Delete Record");
		btnDeleteRecord.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnDeleteRecord.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				remove r = new remove();
				r.setVisible(true);
			}
		});

		JButton btnInsertRecord = new JButton("Insert Record");
		btnInsertRecord.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnInsertRecord.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				add r = new add();
				r.setVisible(true);
			}
		});

		JButton btnUpdateRecord = new JButton("Update Record");
		btnUpdateRecord.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnUpdateRecord.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				update r = new update();
				r.setVisible(true);
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup().addGap(280)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
										.addComponent(btnDisplayRecord, GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
										.addGap(35)
										.addComponent(btnInsertRecord, GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE))
								.addGroup(gl_contentPane.createSequentialGroup()
										.addComponent(btnDeleteRecord, GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
										.addGap(35)
										.addComponent(btnUpdateRecord, GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE)))
						.addGap(304)));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup().addGap(251)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(btnDisplayRecord, GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
								.addComponent(btnInsertRecord, GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE))
						.addGap(35)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(btnDeleteRecord, GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
								.addComponent(btnUpdateRecord, GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE))
						.addGap(373)));
		contentPane.setLayout(gl_contentPane);
	}
}
