package com.example.dirc.configuration;

import com.example.dirc.repo.MessagesRepo;
import com.example.dirc.repo.PersonRepo;
import com.example.dirc.repo.Repo;
import org.jdbi.v3.core.Jdbi;
import org.jdbi.v3.sqlobject.SqlObjectPlugin;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.TransactionAwareDataSourceProxy;

import javax.sql.DataSource;

@Configuration
public class JdbiConfig {

    @Bean
    public Jdbi jdbi(DataSource dataSource) {
        // Обертывание для синхронизации транзакций Spring и Jdbi
        TransactionAwareDataSourceProxy proxyDataSource = new TransactionAwareDataSourceProxy(dataSource);

        Jdbi jdbi = Jdbi.create(proxyDataSource);

        // Включаем плагин для работы декларативного стиля (SqlObject)
        jdbi.installPlugin(new SqlObjectPlugin());

        return jdbi;
    }

    // Создание DAO как Spring Bean с использованием jdbi.onDemand()
    // onDemand-объекты потокобезопасны и открывают/закрывают соединения автоматически
    @Bean
    public MessagesRepo messagesRepo(Jdbi jdbi) {
        return jdbi.onDemand(MessagesRepo.class);
    }
    @Bean
    public PersonRepo personRepo(Jdbi jdbi) {
        return jdbi.onDemand(PersonRepo.class);
    }
}