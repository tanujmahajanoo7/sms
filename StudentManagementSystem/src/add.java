import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.LayoutStyle.ComponentPlacement;

public class add extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField addId;
	private JTextField addName;
	private JTextField addClass;
	private JTextField addMarks;
	private JTextField addGender;
	JLabel addlbl;
	Integer id;
	String name;
	String gender;
	String nclass;
	Integer marks;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					add frame = new add();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public add() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 950, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);

		JLabel Student = new JLabel("Student Detail");
		Student.setHorizontalAlignment(SwingConstants.CENTER);
		Student.setFont(new Font("Tahoma", Font.BOLD, 20));

		addId = new JTextField();
		addId.setFont(new Font("Tahoma", Font.PLAIN, 20));
		addId.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("ID:");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));

		JLabel lblNewLabel_1_1 = new JLabel("Name:");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));

		addName = new JTextField();
		addName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		addName.setColumns(10);

		JLabel lblNewLabel_1_1_1 = new JLabel("Class");
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));

		addClass = new JTextField();
		addClass.setFont(new Font("Tahoma", Font.PLAIN, 20));
		addClass.setColumns(10);

		JLabel lblNewLabel_1_1_2 = new JLabel("Marks:");
		lblNewLabel_1_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 20));

		addMarks = new JTextField();
		addMarks.setFont(new Font("Tahoma", Font.PLAIN, 20));
		addMarks.setColumns(10);

		JLabel lblNewLabel_1_1_3 = new JLabel("Gender:");
		lblNewLabel_1_1_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_3.setFont(new Font("Tahoma", Font.PLAIN, 20));

		addGender = new JTextField();
		addGender.setFont(new Font("Tahoma", Font.PLAIN, 20));
		addGender.setColumns(10);

		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					try {
						id = Integer.parseInt(addId.getText());
					} catch (NumberFormatException e1) {
						addlbl.setText("Enter valid number");
						return;
					}
					name = addName.getText().trim();
					if (name.isEmpty() || !name.matches("[a-zA-Z]+")) {
						addlbl.setText("Enter valid name");
						return;
					}
					nclass = addClass.getText().trim();
					if (nclass.isEmpty() || !nclass.matches("[A-Za-z]")) {
						addlbl.setText("Enter valid class (one letter)");
						return;
					}
					try {
						marks = Integer.parseInt(addMarks.getText());
					} catch (NumberFormatException e1) {
						addlbl.setText("Enter valid marks");
						return;
					}
					gender = addGender.getText().trim();
					if (gender.isEmpty() || !gender.matches("[a-zA-Z]+")) {
						addlbl.setText("Enter valid gender");
						return;
					}
					List<String> studentDetails = StudentManagementSystem.addEmployee(id, name, nclass, marks, gender);
					for (String detail : studentDetails) {
						addlbl.setText(detail);
					}
				} catch (Exception ex) {
					addlbl.setText("Don't worry it is paper less work don't hesitate to fill all fields");
				}
			}
		});
		btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 20));

		addlbl = new JLabel("");
		addlbl.setFont(new Font("Tahoma", Font.ITALIC, 25));

		JButton backButton = new JButton("back");
		backButton.setFont(new Font("Tahoma", Font.ITALIC, 18));
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				home r = new home();
				r.setVisible(true);
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING).addGroup(gl_contentPane
				.createSequentialGroup().addGap(323)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
								.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)
								.addGap(4)
								.addComponent(addId, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE)
								.addContainerGap())
						.addGroup(gl_contentPane.createSequentialGroup()
								.addComponent(Student, GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE).addGap(366))))
				.addGroup(gl_contentPane.createSequentialGroup().addContainerGap(184, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
										.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 82,
												GroupLayout.PREFERRED_SIZE)
										.addGap(18).addComponent(addName, GroupLayout.PREFERRED_SIZE, 143,
												GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
										.addComponent(lblNewLabel_1_1_2, GroupLayout.PREFERRED_SIZE, 82,
												GroupLayout.PREFERRED_SIZE)
										.addGap(18).addComponent(addMarks, GroupLayout.PREFERRED_SIZE, 143,
												GroupLayout.PREFERRED_SIZE)))
						.addGap(76)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
										.addComponent(lblNewLabel_1_1_1, GroupLayout.PREFERRED_SIZE, 82,
												GroupLayout.PREFERRED_SIZE)
										.addGap(28).addComponent(addClass, GroupLayout.PREFERRED_SIZE, 143,
												GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
										.addComponent(lblNewLabel_1_1_3, GroupLayout.PREFERRED_SIZE, 82,
												GroupLayout.PREFERRED_SIZE)
										.addGap(28).addComponent(addGender, GroupLayout.PREFERRED_SIZE, 143,
												GroupLayout.PREFERRED_SIZE)))
						.addGap(168))
				.addGroup(gl_contentPane.createSequentialGroup().addContainerGap(403, Short.MAX_VALUE)
						.addComponent(btnAdd, GroupLayout.PREFERRED_SIZE, 159, GroupLayout.PREFERRED_SIZE).addGap(362))
				.addGroup(gl_contentPane.createSequentialGroup().addContainerGap(108, Short.MAX_VALUE)
						.addComponent(addlbl, GroupLayout.PREFERRED_SIZE, 721, GroupLayout.PREFERRED_SIZE).addGap(95))
				.addGroup(gl_contentPane.createSequentialGroup().addContainerGap(787, Short.MAX_VALUE)
						.addComponent(backButton, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE)));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
				.createSequentialGroup()
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
						.createSequentialGroup().addGap(6)
						.addComponent(Student, GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE).addGap(18)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
								.addComponent(addId, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE))
						.addGap(39)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 50,
										GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane.createSequentialGroup().addGap(1).addComponent(addName,
										GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE))
								.addComponent(lblNewLabel_1_1_1, GroupLayout.PREFERRED_SIZE, 50,
										GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane.createSequentialGroup().addGap(1).addComponent(addClass,
										GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)))
						.addGap(36)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_1_1_2, GroupLayout.PREFERRED_SIZE, 50,
										GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane.createSequentialGroup().addGap(1).addComponent(addMarks,
										GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup().addGap(2)
										.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
												.addComponent(addGender, GroupLayout.PREFERRED_SIZE, 50,
														GroupLayout.PREFERRED_SIZE)
												.addComponent(lblNewLabel_1_1_3, GroupLayout.PREFERRED_SIZE, 50,
														GroupLayout.PREFERRED_SIZE))))
						.addGap(34).addComponent(btnAdd, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
						.addGap(35))
						.addGroup(gl_contentPane.createSequentialGroup()
								.addComponent(backButton, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)))
				.addComponent(addlbl, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE).addGap(283)));
		contentPane.setLayout(gl_contentPane);
	}
}
