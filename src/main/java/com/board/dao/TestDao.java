package com.board.dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.board.domain.PostInfo;

public class TestDao {
	private static SqlSessionFactory factory;
	static {
		try {
			String resource = "com/board/dbConfig/mybatis-config.xml";
			InputStream inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
			factory = builder.build(inputStream);
		}catch(IOException e) {
			throw new RuntimeException("초기화 문제발생");
		}
	}
	public static SqlSessionFactory getSql() {
		return factory;
	}
	
	
	public PostInfo testSel(){
		SqlSession session = factory.openSession(true);
		return session.selectOne("aa.selectPost", 1);
	}
}
