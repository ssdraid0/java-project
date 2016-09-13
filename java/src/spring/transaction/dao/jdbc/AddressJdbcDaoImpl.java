package spring.transaction.dao.jdbc;

import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import spring.transaction.dao.IAddressDao;
import spring.transaction.model.AddressModel;

public class AddressJdbcDaoImpl extends NamedParameterJdbcDaoSupport implements IAddressDao
{

    private final String INSERT_SQL = "insert into address(province, city, street, user_id)"
            + "values(:province, :city, :street, :userId)";
    private final String COUNT_ALL_SQL = "select count(*) from address";

    @Override
    public void save(AddressModel address)
    {
        KeyHolder generatedKeyHolder = new GeneratedKeyHolder();
        SqlParameterSource paramSource = new BeanPropertySqlParameterSource(address);
        getNamedParameterJdbcTemplate().update(INSERT_SQL, paramSource, generatedKeyHolder);
        address.setId(generatedKeyHolder.getKey().intValue());
    }

    @Override
    public int countAll()
    {
        return getJdbcTemplate().queryForObject(COUNT_ALL_SQL, Integer.class);
    }

}
