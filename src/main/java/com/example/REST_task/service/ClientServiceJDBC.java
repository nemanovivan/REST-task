package com.example.REST_task.service;

import com.example.REST_task.model.Count;
import com.example.REST_task.model.Receipt;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import javax.sql.DataSource;
import java.util.List;



public class ClientServiceJDBC extends JdbcDaoSupport implements ClientService {

    private final Count count = new Count();

    public ClientServiceJDBC(DataSource dataSource) {
        super();
        setDataSource(dataSource);
    }

    @Override
    public void create(Receipt receipt) {
        String sql = "INSERT INTO RECEIPTS (CATEGORY, NAME, NUMBER, STORE, DATESTRING, TIME, PRICE) VALUES (?, ?, ?, ?, ?, ?, ?)";
        getJdbcTemplate().update(sql, receipt.getCategory(), receipt.getName(), receipt.getNumber(), receipt.getStore(), receipt.getDateString(), receipt.getTime(), receipt.getPrice());
   }

    @Override
    public void getSumForThisDay() {
        String sql = "SELECT sum(PRICE) FROM RECEIPTS WHERE dateString=strftime('%Y-%m-%d', 'now')" ;
        count.setOutput("For today: " + getJdbcTemplate().queryForObject(sql, Integer.class));
    }

    @Override
    public void getSumForThisWeek() {
        String sql = "SELECT sum(PRICE) FROM RECEIPTS WHERE dateString>=strftime('%Y-%m-%d', 'now', 'weekday 1') and " +
                "dateString<=strftime('%Y-%m-%d', 'now', 'weekday 0')";
        count.setOutput("For this week: " + getJdbcTemplate().queryForObject(sql, Integer.class));
    }

    @Override
    public void getSumForThisMonth() {
        String sql = "SELECT sum(PRICE) FROM RECEIPTS WHERE dateString >= strftime('%Y-%m-%d', 'now', 'start of month') and dateString <= strftime('%Y-%m-%d', 'now', 'start of month', '+1 month')";
        count.setOutput("For this month: " + getJdbcTemplate().queryForObject(sql, Integer.class));
    }

    @Override
    public void get3MostCostlyCat() {
        String sql = "SELECT category FROM RECEIPTS GROUP BY CATEGORY ORDER BY PRICE DESC";
        List<String> output = getJdbcTemplate().queryForList(sql, String.class);
        int i = output.size();
        if(i > 3) { i = 3; }
        switch (i) {
            case 3:
                count.setThirdCategory(output.get(2));
                i -= 1;
            case 2:
                count.setSecondCategory(output.get(1));
                i -= 1;
            case 1:
                count.setFirstCategory(output.get(0));
                break;
            default: break;
        }
    }

    @Override
    public List<Receipt> getReceipts() {
        String sql = "SELECT * FROM RECEIPTS";
        return  getJdbcTemplate().query(sql, new BeanPropertyRowMapper(Receipt.class));
    }

    public void delete() {
        String sql = " DELETE FROM RECEIPTS";
        getJdbcTemplate().execute(sql);
        count.setFirstCategory(null);
        count.setSecondCategory(null);
        count.setThirdCategory(null);
        count.setOutput(null);
    }

    @Override
    public Count getCount () { return this.count; }
}



