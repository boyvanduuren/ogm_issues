package com.github.boyvanduuren.recursivenode;

import org.neo4j.ogm.session.Session;
import org.neo4j.ogm.session.SessionFactory;

import com.github.boyvanduuren.recursivenode.domain.Entity;
import org.neo4j.ogm.session.transaction.Transaction;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;

public class App
{
    public static void main( String[] args ) {
        SessionFactory sessionFactory = new SessionFactory("com.github.boyvanduuren.recursivenode.domain");
        Session session = sessionFactory.openSession("http://localhost:7474");

        session.purgeDatabase();

        Transaction tx = session.beginTransaction();

        Entity parent = new Entity("parent");
        Entity child01 = new Entity("child01").setRel(parent);

        session.save(child01);

        tx.commit();
        tx.close();

        tx = session.beginTransaction();

        Entity child02 = new Entity("child02").setRel(parent);

        session.save(child02);

        tx.commit();
        tx.close();
    }
}
