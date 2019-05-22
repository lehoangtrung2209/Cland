package dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import model.CategoryNews;

@Repository
public class CategoryNewsDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	//get danh sách category
	public List<CategoryNews> getItems() {
		String sql = "SELECT * FROM categorynews";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<CategoryNews>(CategoryNews.class));
	}

	
	//thêm category
	public int addItem(CategoryNews cat) {
		String sql = "INSERT INTO categorynews(name) VALUES(?)";
		return jdbcTemplate.update(sql, new Object[] {cat.getName()});
	}

	//xoa 1 category
	public int delItem(int id) {
		String sql = "DELETE FROM categorynews WHERE id = ?";
		return jdbcTemplate.update(sql, new Object[] {id});
	}
	
	//get 1 category
	public CategoryNews getItem(int id) {
		String sql = "SELECT * FROM categorynews WHERE id = ?";
		return jdbcTemplate.queryForObject(sql, new Object[] {id},new BeanPropertyRowMapper<CategoryNews>(CategoryNews.class));
	}
	
	//edit 1 category
	public int editItem(CategoryNews category) {
		String sql = "UPDATE categorynews SET name = ? WHERE id = ?";
		return jdbcTemplate.update(sql, new Object[] {category.getName(), category.getId()});
	}
}
