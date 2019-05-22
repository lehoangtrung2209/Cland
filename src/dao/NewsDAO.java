package dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import constant.Defines;
import model.News;

@Repository
public class NewsDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	// get danh sách news
	public List<News> getItems(int offset) {
		String sql = "SELECT news.*, c.name AS cname FROM news INNER JOIN categorynews AS c ON news.cid = c.id ORDER BY news.id DESC LIMIT ?, ?";
		return jdbcTemplate.query(sql, new Object[] { offset, Defines.ROW_COUNT_ADMIN },
				new BeanPropertyRowMapper<News>(News.class));
	}
	
	public List<News> getItemsPublic(int offset) {
		String sql = "SELECT news.*, c.name AS cname FROM news INNER JOIN categorynews AS c ON news.cid = c.id ORDER BY news.id DESC LIMIT ?, ?";
		return jdbcTemplate.query(sql, new Object[] { offset, Defines.ROW_COUNT_PUBLIC },
				new BeanPropertyRowMapper<News>(News.class));
	}

	public int countItems() {
		String sql = "SELECT count(*) AS countItems FROM news INNER JOIN categorynews AS c ON news.cid = c.id";
		return jdbcTemplate.queryForObject(sql, Integer.class);
	}
	
	//search count
	public int countItemsSearch(String key) {
		String k = "%"+key +"%";
		String sql = "SELECT count(*) AS countItems FROM news INNER JOIN categorynews AS c ON news.cid = c.id WHERE news.name LIKE ? OR news.description LIKE ?";
		return jdbcTemplate.queryForObject(sql, new Object[] {k,k},Integer.class);
	}
	
	//search list
	public List<News> getItemsSearch(String key,int offset) {
		String k = "%"+key +"%";
		String sql = "SELECT news.*, c.cname FROM news INNER JOIN categorynews AS c ON news.cid = c.id "
				+ "WHERE news.name LIKE ? OR description LIKE ? ORDER BY news.id DESC LIMIT ?, ?";
		return jdbcTemplate.query(sql, new Object[] { k,k, offset, Defines.ROW_COUNT_PUBLIC },
				new BeanPropertyRowMapper<News>(News.class));
	}
	
	public News getItem(int id) {
		String sql = "SELECT news.* FROM news WHERE id = ?";
		try {
			return jdbcTemplate.queryForObject(sql, new Object[] { id }, new BeanPropertyRowMapper<News>(News.class));
		} catch (Exception e) {
			return null;
		}
	}

	public int delItemByCate(int id) {
		String sql = "DELETE FROM news WHERE cid = ?";
		return jdbcTemplate.update(sql, new Object[] { id });
	}

	public int editItem(News news) {
		String sql = "UPDATE news SET name = ?, description = ?, cid = ?, picture = ? WHERE id = ?";
		return jdbcTemplate.update(sql, new Object[] { news.getName(), news.getDescription(), news.getCid(),
				news.getPicture(), news.getId() });
	}

	public int addItem(News news) {
		String sql = "INSERT INTO news(name,description,cid,picture) VALUES (?,?,?,?)";
		return jdbcTemplate.update(sql, new Object[] { news.getName(), news.getDescription(), news.getCid(),
				news.getPicture() });
	}

	public int delItem(int id) {
		String sql = "DELETE FROM news WHERE id = ?";
		return jdbcTemplate.update(sql, new Object[] { id });
	}

	// public
	// get danh sách xem nhiều
//	public List<News> getItemsView() {
//		String sql = "SELECT l.*, c.cname FROM lands AS l INNER JOIN categories AS c ON l.cid = c.cid ORDER BY l.count_views DESC LIMIT 5";
//		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<News>(News.class));
//	}
//
//	public List<News> getItemsByIdCat(int id, int offset) {
//		String sql = "SELECT l.*, c.cname FROM lands AS l INNER JOIN categories AS c ON l.cid = c.cid WHERE c.cid = ? ORDER BY l.lid DESC LIMIT ?, ?";
//		return jdbcTemplate.query(sql, new Object[] { id,offset, Defines.ROW_COUNT_PUBLIC }, new BeanPropertyRowMapper<News>(News.class));
//	}
//	
//	public int countItemsByIdCat(int id) {
//		String sql = "SELECT count(*) AS countItemsByIdCat FROM lands AS l INNER JOIN categories AS c ON l.cid = c.cid WHERE c.cid = ? ";
//		return jdbcTemplate.queryForObject(sql, new Object[] { id }, Integer.class);
//	}
//
//	public List<News> getItemOthers(News news) {
//		String sql = "SELECT l.*, c.cname FROM lands AS l INNER JOIN categories AS c ON l.cid = c.cid WHERE l.cid = ? && l.lid != ? ORDER BY l.lid DESC LIMIT 3";
//		return jdbcTemplate.query(sql, new Object[] { news.getCid(), news.getLid() }, new BeanPropertyRowMapper<News>(News.class));
//	}
}