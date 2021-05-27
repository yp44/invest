package org.ypiel.invest;

import java.io.PrintStream;
import java.math.BigDecimal;
import java.time.LocalDate;

import lombok.Data;
import lombok.ToString;

@Data
public class BigFlatEntry {

    public final static String FORMAT = "%5s %10s %10s %25s %20s %5s %20s %6s %6s %10s\n";

    private Integer id;
    private LocalDate date;
    private BigDecimal amount;
    private String summary;
    private String linkedentry_name;
    private Integer linkedentry_id;
    private BigDecimal linkedentry_capital;
    private BigDecimal linkedentry_interest;
    private BigDecimal linkedentry_insurance;
    private BigDecimal linkedentry_remaining;

    private BigFlatEntry previous;
    private BigFlatEntry next;

    public boolean isFirst() {
        return this.previous == null;
    }

    public boolean isLast() {
        return this.next == null;
    }

    public BigFlatEntry getFirst() {
        if (this.isFirst()) {
            return this;
        }
        return this.getPrevious();
    }

    public BigFlatEntry getLast() {
        if (this.isLast()) {
            return this;
        }
        return this.getNext();
    }

    public int size() {
        return this.getLast()._size();
    }

    private int _size() {
        if (this.isFirst()) {
            return 1;
        }

        return this.getPrevious()._size() + 1;
    }

    public void display(PrintStream ps){
        ps.printf(FORMAT, this.getId(), this.getDate(), this.getAmount(), this.getSummary(), this.getLinkedentry_name(), this.getLinkedentry_id(), this.getLinkedentry_capital(), this.getLinkedentry_interest(), this.getLinkedentry_insurance(), this.getLinkedentry_remaining());
    }

}