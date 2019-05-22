package dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import model.Role;

@Repository
public class RoleDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	// get danh sách user
	public List<Role> getItems() {
		String sql = "SELECT * FROM roles ORDER BY role_id";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Role>(Role.class));
	}
}
