import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

@Service
public class MyService {

   private final JdbcTemplate jdbcTemplate;

   @Autowired
   public MyService(DataSource dataSource) {
      this.jdbcTemplate = new JdbcTemplate(dataSource);
   }

   public List<MyObject> executeQuery() {
      String sql = "SELECT * FROM my_table";
      return jdbcTemplate.query(sql, new MyObjectRowMapper());
   }

   private static class MyObjectRowMapper implements RowMapper<MyObject> {
      @Override
      public MyObject mapRow(ResultSet rs, int rowNum) throws SQLException {
         MyObject obj = new MyObject();
         obj.setId(rs.getLong("id"));
         obj.setName(rs.getString("name"));
         return obj;
      }
   }

}
