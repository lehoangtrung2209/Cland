package dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import model.Category;

@Repository
public class CategoryDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	//get danh sách category
	public List<Category> getItems() {
		String sql = "SELECT * FROM categories";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Category>(Category.class));
	}

	
	//thêm category
	public int addItem(Category cat) {
		String sql = "INSERT INTO categories(name) VALUES(?)";
		return jdbcTemplate.update(sql, new Object[] {cat.getName()});
	}

	//xoa 1 category
	public int delItem(int id) {
		String sql = "DELETE FROM categories WHERE id = ?";
		return jdbcTemplate.update(sql, new Object[] {id});
	}
	
	//get 1 category
	public Category getItem(int id) {
		String sql = "SELECT * FROM categories WHERE id = ?";
		return jdbcTemplate.queryForObject(sql, new Object[] {id},new BeanPropertyRowMapper<Category>(Category.class));
	}
	
	//edit 1 category
	public int editItem(Category category) {
		String sql = "UPDATE categories SET name = ? WHERE id = ?";
		return jdbcTemplate.update(sql, new Object[] {category.getName(), category.getId()});
	}
}
