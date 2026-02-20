package org.example.persistence;

import com.zaxxer.hikari.HikariDataSource;
import jakarta.persistence.SharedCacheMode;
import jakarta.persistence.ValidationMode;
import jakarta.persistence.spi.ClassTransformer;
import jakarta.persistence.spi.PersistenceUnitInfo;
import jakarta.persistence.spi.PersistenceUnitTransactionType;

import javax.sql.DataSource;
import java.net.URL;
import java.util.List;
import java.util.Properties;

public class CustomPersistenceUnitInfo implements PersistenceUnitInfo {

    @Override
    public String getPersistenceUnitName() {
        return "dev";
    }

    @Override
    public String getPersistenceProviderClassName() {
        return "org.hibernate.jpa.HibernatePersistenceProvider";
    }

    @Override
    public PersistenceUnitTransactionType getTransactionType() {
        return PersistenceUnitTransactionType.RESOURCE_LOCAL;
    }

    @Override
    public DataSource getJtaDataSource() {
        return null;
    }

    @Override
    public DataSource getNonJtaDataSource() {
        HikariDataSource hdc = new HikariDataSource();
        hdc.setJdbcUrl("jdbc:mysql://localhost:3306/HJPA_DB?createDatabaseIfNotExist=true");
        hdc.setUsername("root");
        hdc.setPassword("7761890349");

        hdc.setDriverClassName("com.mysql.cj.jdbc.Driver");

        return hdc;
    }

    @Override
    public List<String> getManagedClassNames() {
        return List.of("org.example.Person");
    }

    @Override
    public Properties getProperties() {
        Properties props = new Properties();

        props.put("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
        props.put("hibernate.hbm2ddl.auto", "update");
        props.put("hibernate.show_sql", "true");
        props.put("hibernate.format_sql", "true");

        return props;
    }

    @Override public List<String> getMappingFileNames() { return List.of(); }
    @Override public List<URL> getJarFileUrls() { return List.of(); }
    @Override public URL getPersistenceUnitRootUrl() { return null; }
    @Override public boolean excludeUnlistedClasses() { return false; }
    @Override public SharedCacheMode getSharedCacheMode() { return SharedCacheMode.UNSPECIFIED; }
    @Override public ValidationMode getValidationMode() { return ValidationMode.NONE; }
    @Override public String getPersistenceXMLSchemaVersion() { return "2.2"; }
    @Override public ClassLoader getClassLoader() { return Thread.currentThread().getContextClassLoader(); }
    @Override public void addTransformer(ClassTransformer classTransformer) {}
    @Override public ClassLoader getNewTempClassLoader() { return Thread.currentThread().getContextClassLoader(); }
}