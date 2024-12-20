import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.SwingConstants;
import javax.swing.LayoutStyle.ComponentPlacement;

public class read extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel lbl;
	private JTextField idInput;
	Integer id;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					read frame = new read();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public read() {
		// setExtendedState(JFrame.MAXIMIZED_BOTH);
		setFont(new Font("Dialog", Font.PLAIN, 17));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 950, 800);
		lbl = new JPanel();
		lbl.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(lbl);

		JLabel Student = new JLabel("Student Detail");
		Student.setHorizontalAlignment(SwingConstants.CENTER);
		Student.setFont(new Font("Tahoma", Font.BOLD, 20));

		JLabel lblNewLabel_1 = new JLabel("ID:");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));

		JLabel resultLbl = new JLabel("");
		resultLbl.setHorizontalAlignment(SwingConstants.CENTER);
		resultLbl.setFont(new Font("Tahoma", Font.ITALIC, 25));

		JButton btnFetch = new JButton("Fetch");
		btnFetch.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnFetch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					id = Integer.parseInt(idInput.getText());
					List<String> studentDetails = StudentManagementSystem.readEmployee(id);
					for (String detail : studentDetails) {
						resultLbl.setText(detail);
					}
				} catch (Exception ex) {
					resultLbl.setText("ID cannot be null.");
				}
			}
		});

		idInput = new JTextField();
		idInput.setFont(new Font("Tahoma", Font.PLAIN, 20));
		idInput.setColumns(10);

		JButton backButton = new JButton("back");
		backButton.setFont(new Font("Tahoma", Font.ITALIC, 18));
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				home r = new home();
				r.setVisible(true);
			}
		});
		GroupLayout gl_lbl = new GroupLayout(lbl);
		gl_lbl.setHorizontalGroup(gl_lbl.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_lbl.createSequentialGroup().addGap(303)
						.addGroup(gl_lbl.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_lbl.createSequentialGroup().addGap(20)
										.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(idInput, GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE))
								.addComponent(Student, GroupLayout.DEFAULT_SIZE, 318, Short.MAX_VALUE))
						.addGap(178)
						.addComponent(backButton, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_lbl.createSequentialGroup().addGap(114)
						.addComponent(resultLbl, GroupLayout.PREFERRED_SIZE, 697, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(125, Short.MAX_VALUE))
				.addGroup(gl_lbl.createSequentialGroup().addGap(361)
						.addComponent(btnFetch, GroupLayout.DEFAULT_SIZE, 243, Short.MAX_VALUE).addGap(332)));
		gl_lbl.setVerticalGroup(gl_lbl.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_lbl.createSequentialGroup().addGroup(gl_lbl.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_lbl.createSequentialGroup().addGap(32)
								.addComponent(Student, GroupLayout.DEFAULT_SIZE, 54, Short.MAX_VALUE).addGap(61)
								.addGroup(gl_lbl.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
										.addComponent(idInput, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE))
								.addGap(52).addComponent(btnFetch, GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE)
								.addGap(18))
						.addGroup(gl_lbl.createSequentialGroup()
								.addComponent(backButton, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)))
						.addComponent(resultLbl, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
						.addGap(447)));
		lbl.setLayout(gl_lbl);

	}
}
