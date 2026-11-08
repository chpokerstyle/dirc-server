package com.example.dirc.repo;

import com.example.dirc.model.Person;
import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.SqlQuery;

import java.util.List;

@RegisterBeanMapper(Person.class)
public interface PersonRepo extends Repo {

    @SqlQuery("select * from person")
    List<Person> getAll();

    @SqlQuery("""
            select *
            from person
            where nick_name = :nickName""")
    List<Person> getByNickName(@BindBean String nickName);

    @SqlQuery("""
            select *
            from person
            where depa = :depa""")
    Person getByDepa(@BindBean String depa);
}
