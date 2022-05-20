package com.runner;

import com.Utis.NewHibernateUtil;
import com.tasks.Task1;
import com.tasks.Task2;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.text.ParseException;

public class Main {
    public static void main(String[] args) throws ParseException {
        SessionFactory sf = NewHibernateUtil.getSessionFactory();
        Session s = sf.openSession();
        Task1 task1 = new Task1(s);
        task1.amountStudentyiInGruppyi();
        Task2 task2 = new Task2(s);
        task2.updateGruppyi(8);
        s.close();
        sf.close();
    }

}
