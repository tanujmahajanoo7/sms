import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;

public class update extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel lbl;
	private JTextField idInput;
	private JTextField updateName;
	private JTextField updateClass;
	private JTextField updateMarks;
	private JTextField updateGender;
	JLabel updatedlbl;
	Integer id;
	String name;
	String nclass;
	Integer marks;
	String gender;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					update frame = new update();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public update() {
		// setExtendedState(JFrame.MAXIMIZED_BOTH);
		setFont(new Font("Dialog", Font.PLAIN, 17));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 950, 800);
		JPanel lbl = new JPanel();
		lbl.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(lbl);

		JLabel Student = new JLabel("Student Detail");
		Student.setHorizontalAlignment(SwingConstants.CENTER);
		Student.setFont(new Font("Tahoma", Font.BOLD, 20));

		JLabel lblNewLabel_1 = new JLabel("ID:");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));

		JLabel resultLbl = new JLabel("");
		resultLbl.setFont(new Font("Tahoma", Font.ITALIC, 25));

		JTextField idInput = new JTextField();
		idInput.setFont(new Font("Tahoma", Font.PLAIN, 20));
		idInput.setColumns(10);

		JButton btnFetch = new JButton("Fetch");
		btnFetch.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnFetch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				id = Integer.parseInt(idInput.getText());
				List<String> studentDetails = StudentManagementSystem.readEmployee(id);
				for (String detail : studentDetails) {
					resultLbl.setText(detail);
				}
			}
		});

		JLabel lblNewLabel_1_1 = new JLabel("Name:");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));

		JLabel lblNewLabel_1_1_1 = new JLabel("Class");
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));

		updateName = new JTextField();
		updateName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		updateName.setColumns(10);

		updateClass = new JTextField();
		updateClass.setFont(new Font("Tahoma", Font.PLAIN, 20));
		updateClass.setColumns(10);

		updateMarks = new JTextField();
		updateMarks.setFont(new Font("Tahoma", Font.PLAIN, 20));
		updateMarks.setColumns(10);

		updateGender = new JTextField();
		updateGender.setFont(new Font("Tahoma", Font.PLAIN, 20));
		updateGender.setColumns(10);

		JLabel lblNewLabel_1_1_2 = new JLabel("Marks:");
		lblNewLabel_1_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 20));

		JLabel lblNewLabel_1_1_3 = new JLabel("Gender:");
		lblNewLabel_1_1_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_3.setFont(new Font("Tahoma", Font.PLAIN, 20));

		JButton btnUpdate = new JButton("Update");
		btnUpdate.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (!idInput.getText().trim().isEmpty()) {
						id = Integer.parseInt(idInput.getText());
					}
				} catch (NumberFormatException ex) {
					updatedlbl.setText("Enter valid number for ID");
					return;
				}
				name = updateName.getText().trim();
				if (name.isEmpty() || !name.matches("[a-zA-Z]+")) {
					updatedlbl.setText("Enter valid name");
					return;
				}
				nclass = updateClass.getText().trim();
				if (nclass.isEmpty() || !nclass.matches("[A-Za-z]")) {
					updatedlbl.setText("Enter valid class (one letter)");
					return;
				}
//		        marks=null;
				try {
					marks = Integer.parseInt(updateMarks.getText());
				} catch (NumberFormatException ex) {
					updatedlbl.setText("Enter valid number for marks");
					return;
				}
				gender = updateGender.getText().trim();
				if (gender.isEmpty() || !gender.matches("[a-zA-Z]+")) {
					updatedlbl.setText("Enter valid gender");
					return;
				}
				List<String> studentDetails = StudentManagementSystem.updateEmployee(id, name, nclass, marks, gender);
				for (String detail : studentDetails) {
					updatedlbl.setText(detail);
				}
			}
		});

		updatedlbl = new JLabel("");
		updatedlbl.setFont(new Font("Tahoma", Font.ITALIC, 25));

		JButton backButton = new JButton("back");
		backButton.setFont(new Font("Tahoma", Font.ITALIC, 18));
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				home r = new home();
				r.setVisible(true);
			}
		});
		GroupLayout gl_lbl = new GroupLayout(lbl);
		gl_lbl.setHorizontalGroup(gl_lbl.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_lbl.createSequentialGroup().addGap(337)
						.addGroup(gl_lbl.createParallelGroup(Alignment.LEADING)
								.addComponent(Student, GroupLayout.PREFERRED_SIZE, 235, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_lbl.createSequentialGroup().addGap(30)
										.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(idInput, GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
										.addPreferredGap(ComponentPlacement.RELATED)))
						.addGap(215)
						.addComponent(backButton, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_lbl.createSequentialGroup().addGap(384)
						.addComponent(btnFetch, GroupLayout.PREFERRED_SIZE, 159, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(405, Short.MAX_VALUE))
				.addGroup(gl_lbl.createSequentialGroup().addGroup(gl_lbl.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_lbl.createSequentialGroup().addGap(113).addComponent(resultLbl,
								GroupLayout.PREFERRED_SIZE, 721, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_lbl.createSequentialGroup().addGap(170).addGroup(gl_lbl
								.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_lbl.createSequentialGroup()
										.addComponent(lblNewLabel_1_1_2, GroupLayout.PREFERRED_SIZE, 82,
												GroupLayout.PREFERRED_SIZE)
										.addGap(18)
										.addComponent(updateMarks, GroupLayout.PREFERRED_SIZE, 143,
												GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED, 86, Short.MAX_VALUE)
										.addComponent(lblNewLabel_1_1_3, GroupLayout.PREFERRED_SIZE, 82,
												GroupLayout.PREFERRED_SIZE)
										.addGap(18).addComponent(updateGender, GroupLayout.PREFERRED_SIZE, 143,
												GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_lbl.createSequentialGroup()
										.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 82,
												GroupLayout.PREFERRED_SIZE)
										.addGap(18)
										.addComponent(updateName, GroupLayout.PREFERRED_SIZE, 143,
												GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)
										.addComponent(lblNewLabel_1_1_1, GroupLayout.PREFERRED_SIZE, 82,
												GroupLayout.PREFERRED_SIZE)
										.addGap(28).addComponent(updateClass, GroupLayout.PREFERRED_SIZE, 143,
												GroupLayout.PREFERRED_SIZE)))
								.addGap(92)))
						.addContainerGap(114, Short.MAX_VALUE))
				.addGroup(gl_lbl.createSequentialGroup().addGap(388)
						.addComponent(btnUpdate, GroupLayout.PREFERRED_SIZE, 159, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(401, Short.MAX_VALUE))
				.addGroup(gl_lbl.createSequentialGroup().addGap(101)
						.addComponent(updatedlbl, GroupLayout.PREFERRED_SIZE, 721, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(126, Short.MAX_VALUE)));
		gl_lbl.setVerticalGroup(gl_lbl.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_lbl.createSequentialGroup().addGroup(gl_lbl.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_lbl.createSequentialGroup().addGap(20).addComponent(Student))
						.addComponent(backButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addGap(30)
						.addGroup(gl_lbl.createParallelGroup(Alignment.LEADING)
								.addComponent(idInput, GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
								.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE))
						.addGap(18).addComponent(btnFetch, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
						.addGap(18).addComponent(resultLbl, GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE).addGap(70)
						.addGroup(gl_lbl.createParallelGroup(Alignment.BASELINE)
								.addComponent(updateClass, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_1_1_1, GroupLayout.PREFERRED_SIZE, 50,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(updateName, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 50,
										GroupLayout.PREFERRED_SIZE))
						.addGap(36)
						.addGroup(gl_lbl.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_1_1_2, GroupLayout.PREFERRED_SIZE, 50,
										GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_lbl.createSequentialGroup().addGap(1).addGroup(gl_lbl
										.createParallelGroup(Alignment.LEADING)
										.addComponent(lblNewLabel_1_1_3, GroupLayout.PREFERRED_SIZE, 50,
												GroupLayout.PREFERRED_SIZE)
										.addGroup(gl_lbl.createSequentialGroup().addGap(1).addComponent(updateGender,
												GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE))
										.addComponent(updateMarks, GroupLayout.PREFERRED_SIZE, 50,
												GroupLayout.PREFERRED_SIZE))))
						.addGap(38).addComponent(btnUpdate, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
						.addGap(46).addComponent(updatedlbl, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
						.addGap(1176)));
		lbl.setLayout(gl_lbl);

	}
}
