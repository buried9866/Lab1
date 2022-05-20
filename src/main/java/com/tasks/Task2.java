package com.tasks;

import com.Utis.Gruppyi;
import com.Utis.Studentyi;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class Task2 {
    private final Session s;

    public Task2(Session s) {
        this.s = s;
    }

    public void updateGruppyi(int year) {
        Transaction t = s.beginTransaction();
        year = LocalDate.now().minusYears(year).getYear();
        Query query = s.createQuery("from Gruppyi g where extract(year from g.dataFormir) < :year");
        query.setParameter("year", year);
        List<Gruppyi> q = query.list();
        for (Gruppyi g : q) {
            g.setStatus("rasformirovana");
            g.setStatusDate(new Date());
            for (Studentyi s : g.getStudentyis()) {
                s.setStatus("vyipusknik");
                s.setStatusDate(new Date());
            }
            s.update(g);
        }
        t.commit();
    }
}
