package dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import model.User;

@Repository
public class UserDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	//get danh sách user
	public List<User> getItems() {
		String sql = "SELECT users.*, roles.name FROM users INNER JOIN roles ON users.role_id = roles.role_id ORDER BY id DESC";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<User>(User.class));
	}

	
	//thêm user
	public int addItem(User user) {
		String sql = "INSERT INTO users(username, password, fullname, phone, email, address, role_id) VALUES(?,?,?,?,?,?,?)";
		return jdbcTemplate.update(sql, new Object[] {user.getUsername(), user.getPassword(), user.getFullname(), user.getPhone(), user.getEmail(), user.getAddress(), user.getRole_id()});
	}

	//xóa 1 user
	public int delItem(int id) {
		String sql = "DELETE FROM users WHERE id = ?";
		return jdbcTemplate.update(sql, new Object[] {id});
	}	
	//get 1 user
	public User getItem(int id) {
		String sql = "SELECT users.*, roles.name FROM users INNER JOIN roles ON users.role_id = roles.role_id WHERE id = ?";
		return jdbcTemplate.queryForObject(sql, new Object[] {id},new BeanPropertyRowMapper<User>(User.class));
	}
	
	public User getItem(String username) {
		String sql = "SELECT users.*, roles.name FROM users INNER JOIN roles ON users.role_id = roles.role_id WHERE username = ?";
		return jdbcTemplate.queryForObject(sql, new Object[] {username},new BeanPropertyRowMapper<User>(User.class));
	}
	
	//edit 1 user
	public int editItem(User user) {
		String sql = "UPDATE users SET password = ?, fullname = ?, phone = ?, email = ?, address = ?, role_id = ? WHERE id = ?";
		return jdbcTemplate.update(sql, new Object[] {user.getPassword(), user.getFullname(), user.getPhone(), user.getEmail(), user.getAddress(), user.getRole_id(), user.getId()});
	}
	
	//get user từ username
	public User getUser(String username) {
		String sql = "SELECT users.*, roles.name FROM users INNER JOIN roles ON users.role_id = roles.role_id WHERE username = ?";
		try {
		return jdbcTemplate.queryForObject(sql, new Object[] {username},new BeanPropertyRowMapper<User>(User.class));
		} catch (Exception e) {
			return null;
		}
	}

}
