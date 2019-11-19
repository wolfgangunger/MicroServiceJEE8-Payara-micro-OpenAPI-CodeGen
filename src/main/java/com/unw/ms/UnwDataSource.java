package com.unw.ms;

import javax.annotation.sql.DataSourceDefinition;

@DataSourceDefinition(
    name = "java:global/jdbc/CcrDataSource",
    className = "org.postgresql.ds.PGSimpleDataSource",
    url = "jdbc:postgresql://${ENV=DB_HOST}:${ENV=DB_PORT}/${ENV=DB_NAME}",
    user = "${ENV=DB_USER}",
    password = "${ENV=DB_PASS}")
public class UnwDataSource { }
