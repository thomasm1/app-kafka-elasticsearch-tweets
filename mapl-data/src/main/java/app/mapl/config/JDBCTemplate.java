package app.mapl.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@EnableTransactionManagement
@Configuration
public class JDBCTemplate {

    private final DataSource dataSource;

    JDBCTemplate(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    @Bean
	JdbcTemplate jdbcTemplate(DataSource dataSource) {
		return new JdbcTemplate(dataSource);
	}

	@Bean
	public NamedParameterJdbcTemplate namedParameterJdbcTemplate(JdbcOperations jdbcOperations) {
		return new NamedParameterJdbcTemplate(jdbcOperations);
	}



}
