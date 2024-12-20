import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;

public class remove extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField removeId;
	JLabel removelbl;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					remove frame = new remove();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public remove() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 950, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel Student = new JLabel("Student Detail");
		Student.setBounds(373, 10, 182, 48);
		Student.setHorizontalAlignment(SwingConstants.CENTER);
		Student.setFont(new Font("Tahoma", Font.BOLD, 20));
		contentPane.add(Student);

		removeId = new JTextField();
		removeId.setFont(new Font("Tahoma", Font.PLAIN, 20));
		removeId.setColumns(10);
		removeId.setBounds(421, 69, 143, 50);
		contentPane.add(removeId);

		JLabel lblNewLabel_1 = new JLabel("ID:");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(340, 69, 82, 50);
		contentPane.add(lblNewLabel_1);

		JButton btnRemove = new JButton("Remove");
		btnRemove.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnRemove.setBounds(387, 147, 159, 42);
		contentPane.add(btnRemove);
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int id = Integer.parseInt(removeId.getText());
					String msg = StudentManagementSystem.removeEmployee(id);
					removelbl.setText(msg);
				} catch (Exception ex) {
					removelbl.setText("ID cannot be null.");
				}
			}
		});

		removelbl = new JLabel("");
		removelbl.setFont(new Font("Tahoma", Font.ITALIC, 25));
		removelbl.setBounds(96, 223, 721, 56);
		contentPane.add(removelbl);

		JButton backButton = new JButton("back");
		backButton.setFont(new Font("Tahoma", Font.ITALIC, 18));
		backButton.setBounds(797, 0, 137, 45);
		contentPane.add(backButton);
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				home r = new home();
				r.setVisible(true);
			}
		});
	}

}
