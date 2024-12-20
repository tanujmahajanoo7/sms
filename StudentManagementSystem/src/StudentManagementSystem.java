import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentManagementSystem {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

	}

	public static List<String> readEmployee(Integer id) {
		List<String> studentDetails = new ArrayList<>();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sms", "root", "Tanuj@123");
			String sql = "SELECT * FROM student WHERE id = ?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();

			while (rs.next()) {
				String studentData = "id: " + rs.getInt(1) + " | " + " name: " + rs.getString(2) + " | " + " class: "
						+ rs.getString(3) + " | " + " marks: " + rs.getInt(4) + " | " + " gender: " + rs.getString(5);
				studentDetails.add(studentData);
			}
			if (studentDetails.isEmpty()) {
				studentDetails.add("ID is not present in the database.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (ps != null)
					ps.close();
				if (con != null)
					con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return studentDetails;
	}

	public static List<String> addEmployee(int id, String name, String classs, int marks, String gender) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<String> addedEmployeeDetails = new ArrayList<>();

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sms", "root", "Tanuj@123");
			String insertSql = "INSERT INTO student VALUES(?, ?, ?, ?, ?)";
			pstmt = con.prepareStatement(insertSql);
			pstmt.setInt(1, id);
			pstmt.setString(2, name);
			pstmt.setString(3, classs);
			pstmt.setInt(4, marks);
			pstmt.setString(5, gender);
			int rowsAffected = pstmt.executeUpdate();
			if (rowsAffected > 0) {
				String fetchSql = "SELECT * FROM student WHERE id = ?";
				pstmt = con.prepareStatement(fetchSql);
				pstmt.setInt(1, id);
				rs = pstmt.executeQuery();
				while (rs.next()) {
					String studentData = "id: " + rs.getInt(1) + " | " + " name: " + rs.getString(2) + " | "
							+ " class: " + rs.getString(3) + " | " + " marks: " + rs.getInt(4) + " | " + " gender: "
							+ rs.getString(5);
					addedEmployeeDetails.add(studentData);
//		            addedEmployeeDetails.add("Student with ID " + id + " added successfully.");
				}
			} else {
				addedEmployeeDetails.add("Failed to add student with ID " + id + ".");
			}
		} catch (Exception e) {
			addedEmployeeDetails.add("Failed to add student with ID " + id + ".");
//			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (Exception e) {
				addedEmployeeDetails.add("Failed to add student with ID " + id + ".");
//				e.printStackTrace();
			}
		}
		return addedEmployeeDetails;
	}

	public static String removeEmployee(int id) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sms", "root", "Tanuj@123");
			String sql = "DELETE FROM student WHERE id = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
			int rowsAffected = pstmt.executeUpdate();
			if (rowsAffected > 0) {
				return "Student with ID " + id + " removed successfully.";
			} else {
				return "No student found with ID " + id + ".";
			}
		} catch (Exception e) {
			return "Ops you forgot to fill id to be romoved.";
//			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (Exception e) {
				return "An error occurred while trying to remove the student.";
//				e.printStackTrace();
			}
		}
	}

	public static List<String> updateEmployee(int id, String name, String classs, int marks, String gender) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<String> updatedStudentDetails = new ArrayList<>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sms", "root", "Tanuj@123");
			String updateSql = "UPDATE student SET name = ?, class = ?, marks = ?, gender = ? WHERE id = ?";
			pstmt = con.prepareStatement(updateSql);
			pstmt.setString(1, name);
			pstmt.setString(2, classs);
			pstmt.setInt(3, marks);
			pstmt.setString(4, gender);
			pstmt.setInt(5, id);
			int rowsAffected = pstmt.executeUpdate();

			if (rowsAffected > 0) {
				String fetchSql = "SELECT * FROM student WHERE id = ?";
				pstmt = con.prepareStatement(fetchSql);
				pstmt.setInt(1, id);
				rs = pstmt.executeQuery();
				while (rs.next()) {
					String studentData = "id: " + rs.getInt(1) + " | " + " name: " + rs.getString(2) + " | "
							+ " class: " + rs.getString(3) + " | " + " marks: " + rs.getInt(4) + " | " + " gender: "
							+ rs.getString(5);
					updatedStudentDetails.add(studentData);
//					updatedStudentDetails.add("Student with ID " + id + " updated successfully.");
				}
			} else {
				updatedStudentDetails.add("No student found with ID " + id + ".");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return updatedStudentDetails;
	}
}
