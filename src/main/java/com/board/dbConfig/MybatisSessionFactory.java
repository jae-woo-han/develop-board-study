package com.board.dbConfig;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisSessionFactory {
	private static SqlSessionFactory factory;
	static {
		try {
			String resource = "com/board/dbConfig/mybatis-config.xml";
			InputStream inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
			factory = builder.build(inputStream);
		} catch (IOException e) {
			throw new RuntimeException("초기화 문제발생");
		}
	}

	public static SqlSessionFactory getSql() {
		return factory;
	}
}
