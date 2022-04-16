package com.board.dao;

import org.apache.ibatis.session.SqlSessionFactory;

import com.board.dbConfig.MybatisSessionFactory;

public interface MybatisDao {
	final SqlSessionFactory factory=MybatisSessionFactory.getSql();
}
