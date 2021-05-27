package org.ypiel.invest.storage;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import org.ypiel.invest.BigFlatEntry;
import org.ypiel.invest.Entry;

public class EntryORB {

    public void addBatch(PreparedStatement ps, Entry e) throws SQLException {
        ps.clearParameters();
        ps.setDate(1, Date.valueOf(e.getDate()));
        ps.setBigDecimal(2, e.getAmount(true));
        ps.setString(3, e.getSummary());
        ps.addBatch();
    }

    public BigFlatEntry createEntity(ResultSet res) throws SQLException {
        BigFlatEntry bfe = new BigFlatEntry();
        bfe.setId(res.getInt("id"));
        bfe.setDate(res.getDate("date").toLocalDate());
        bfe.setAmount(res.getBigDecimal("amount"));
        bfe.setSummary(res.getString("summary"));
        bfe.setLinkedentry_name(res.getString("linkedentry_name"));
        bfe.setLinkedentry_id(res.getInt("linkedentry_id"));
        bfe.setLinkedentry_capital(res.getBigDecimal("linkedentry_capital"));
        bfe.setLinkedentry_interest(res.getBigDecimal("linkedentry_interest"));
        bfe.setLinkedentry_insurance(res.getBigDecimal("linkedentry_insurance"));
        bfe.setLinkedentry_remaining(res.getBigDecimal("linkedentry_remaining"));

        return bfe;
    }
}