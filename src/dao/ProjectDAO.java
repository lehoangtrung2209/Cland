package dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import model.Project;

@Repository
public class ProjectDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	// get danh sách project
	public List<Project> getItems() {
		String sql = "SELECT projects.* , c.name AS cname FROM projects INNER JOIN categories AS c "
				+ "ON projects.id = c.id ORDER BY projects.id DESC";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Project>(Project.class));
	}

	// thêm project
	public int addItem(Project project) {
		String sql = "INSERT INTO projects(name, overview, place, cid) VALUES(?,?,?)";
		return jdbcTemplate.update(sql,
				new Object[] { project.getName(), project.getOverview(), project.getPlace(), project.getCid() });
	}

	// xóa 1 project
	public int delItem(int id) {
		String sql = "DELETE FROM projects WHERE id = ?";
		return jdbcTemplate.update(sql, new Object[] { id });
	}

	// get 1 project
	public Project getItem(int id) {
		String sql = "SELECT projects.* FROM projects WHERE id = ?";
		return jdbcTemplate.queryForObject(sql, new Object[] { id }, new BeanPropertyRowMapper<Project>(Project.class));
	}

	// edit 1 project
	public int editItem(Project project) {
		String sql = "UPDATE projects SET name = ?, overview = ?, place = ?, cid = ? WHERE id = ?";
		return jdbcTemplate.update(sql, new Object[] { project.getName(), project.getOverview(), project.getPlace(),
				project.getCid(), project.getId() });
	}

	public int delItemByCate(int id) {
		String sql = "DELETE FROM projects WHERE id = ?";
		return jdbcTemplate.update(sql, new Object[] { id });
	}

}
