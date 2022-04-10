package com.board.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.board.domain.CategoryInfo;

class CategoryDaoTest {
	CategoryDao dao = new CategoryDao();
	
	@Test
	void test() {
		List<CategoryInfo> list = dao.getCategoryAll();
		
		assertEquals("공지",list.get(0).getCategoryName());
	}

}
