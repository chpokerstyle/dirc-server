package com.example.dirc.repo;

import com.example.dirc.model.MessageDto;
import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.statement.SqlQuery;

import java.util.List;

@RegisterBeanMapper(MessageDto.class)
public interface MessagesRepo {

    @SqlQuery("""
            select *
            from messages
            where :my in (consumer, producer)
               and :user in (consumer, producer)
            """)
    List<MessageDto> getMessagesWithUser(@Bind String user,
                                              @Bind String my);

    @SqlQuery("""
            insert into message
            """)
    void save(MessageDto message);
}
