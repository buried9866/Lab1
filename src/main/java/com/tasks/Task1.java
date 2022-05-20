package com.tasks;

import com.Utis.Gruppyi;
import com.Utis.Studentyi;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Date;
import java.util.List;

public class Task1 {
    private final Session s;

    public Task1(Session s) {
        this.s = s;
    }

    public void selectStudentyi() {
        Transaction t = s.beginTransaction();
        List<Studentyi> q = s.createQuery("from Studentyi s").list();
        for (Studentyi u : q) {
            System.out.print(u.getFamiliya() + " " + u.getImya() + " " + u.getOtchestvo() + " - " + u.getGruppyi().getNazvanie() + ";\n");
            u.setStatusDate(new Date());
            s.saveOrUpdate(u);
        }
        t.commit();
    }

    public void amountStudentyiInGruppyi() {
        Transaction t = s.beginTransaction();
        List<Gruppyi> gr = s.createQuery("from Gruppyi g").list();
        gr.forEach(a -> System.out.println(a.getNazvanie() + " - " + a.getStudentyis().size()));
        t.commit();
    }
}
