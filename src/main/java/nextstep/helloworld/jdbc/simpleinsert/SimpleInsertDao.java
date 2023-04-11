package nextstep.helloworld.jdbc.simpleinsert;

import java.util.Map;
import nextstep.helloworld.jdbc.Customer;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
public class SimpleInsertDao {
    private SimpleJdbcInsert insertActor;

    public SimpleInsertDao(DataSource dataSource) {
        this.insertActor = new SimpleJdbcInsert(dataSource)
                .withTableName("customers")
                .usingGeneratedKeyColumns("id");
    }

    /**
     * Map +
     * insertActor.executeAndReturnKey
     * id를 포함한 Customer 객체를 반환하세요
     */
    public Customer insertWithMap(Customer customer) {
        Number newId = insertActor.executeAndReturnKey(Map.of(
                "first_name", customer.getFirstName(),
                "last_name", customer.getLastName()
        ));
        customer.setId(newId.longValue());
        return customer;
    }

    /**
     * SqlParameterSource +
     * insertActor.executeAndReturnKey
     * id를 포함한 Customer 객체를 반환하세요
     */
    public Customer insertWithBeanPropertySqlParameterSource(Customer customer) {
        SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(customer);

        Number newId = insertActor.executeAndReturnKey(parameterSource);
        customer.setId(newId.longValue());
        return customer;
    }
}
