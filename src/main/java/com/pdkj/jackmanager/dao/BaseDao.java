package com.pdkj.jackmanager.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.util.List;

public class BaseDao {

    @Autowired
    JdbcTemplate jdbcTemplate;


}