package com.example.dirc.repo;

import com.example.dirc.model.Message;
import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.statement.SqlQuery;

import java.util.List;
import java.util.UUID;

@RegisterBeanMapper(Message.class)
public interface MessagesRepo extends Repo {

    @SqlQuery("""
            select *
            from messages
            where :my in (consumer, producer)
               and :user in (consumer, producer)
            """)
    List<Message> getMessagesWithUser(@Bind String user,
                                      @Bind String my);

    @SqlQuery("""
            insert into messages (produser, consumer, create_date, payload)
            VALUES (:producer, :consumer, now(), :payload)
            """)
    @GetGeneratedKeys("id")
    UUID save(@BindBean Message message);
}
