package app.mapl.service;

import app.mapl.models.Category;
import app.mapl.models.PostEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Set;

@Service
public class PostServiceJDBC {

    private final JdbcTemplate jdbcTemplate;

    private final RowMapper<PostEntity> postRowMapper = (rs, rowNum) -> new PostEntity(rs.getLong("ID"), rs.getString("DID"), rs.getString("DATE_"), rs.getString("AUTHOR"), rs.getString("CAT3"), rs.getString("TITLE"), rs.getString("POST"), rs.getString("BLOGCITE"), rs.getString("USERNAME"),rs.getObject("CATEGORY", Category.class), rs.getObject("post", Set.class));

    public PostServiceJDBC(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public PostEntity bycat3(String cat3) {
        return this.jdbcTemplate.queryForObject("SELECT * FROM post_entity WHERE cat3 = ?", postRowMapper, cat3);
    }

    public PostEntity byid(Long id) {
        return this.jdbcTemplate.queryForObject("SELECT * FROM post_entity WHERE id = ?", postRowMapper, id);
    }

    public Collection<PostEntity> all() {
//		return this.jdbcTemplate.query("SELECT * FROM users", (rs, rowNum) -> new User(rs.getInt("userid"), rs.getString("email"), rs.getString("password"), rs.getS
        return this.jdbcTemplate.query("SELECT * FROM post_entity", postRowMapper);

    }

    public PostEntity byusername(String username) {
        return this.jdbcTemplate.queryForObject("SELECT * FROM post_entity WHERE username = ?", postRowMapper, username);
    }

}
