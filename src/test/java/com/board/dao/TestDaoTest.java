package com.board.dao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.board.domain.PostInfo;

class TestDaoTest {
	TestDao dao = new TestDao();
	
	@Test
	void test() {
		PostInfo post = dao.testSel();
		
		assertEquals("sample", post.getTitle());
	}

}
