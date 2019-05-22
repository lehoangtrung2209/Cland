package dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import model.Block;

@Repository
public class BlockDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	// get danh sách
	public List<Block> getItems() {
		String sql = "SELECT blocks.*, projects.name AS pname FROM blocks INNER JOIN projects ON blocks.pid = projects.id "
				+ "ORDER BY blocks.id DESC";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Block>(Block.class));
	}

	// thêm
	public int addItem(Block block) {
		String sql = "INSERT INTO blocks(pid,blockname) VALUES(?,?)";
		return jdbcTemplate.update(sql, new Object[] { block.getPid(), block.getBlockname() });
	}

	// xoa
	public int delItem(int id) {
		String sql = "DELETE FROM blocks WHERE id = ?";
		return jdbcTemplate.update(sql, new Object[] { id });
	}

	// get 1
	public Block getItem(int id) {
		String sql = "SELECT * FROM blocks WHERE id = ?";
		return jdbcTemplate.queryForObject(sql, new Object[] { id },
				new BeanPropertyRowMapper<Block>(Block.class));
	}

	// edit 1 category
	public int editItem(Block block) {
		String sql = "UPDATE blocks SET pid = ?, blockname = ? WHERE id = ?";
		return jdbcTemplate.update(sql, new Object[] { block.getPid(), block.getBlockname(), block.getId() });
	}
}
