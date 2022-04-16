package com.board.util;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class UtilTest {
	
	StringUtil util = new StringUtil();
	
	@Test
	void test() {
		String act = util.createListItem("카테고리", "category");
		
		assertEquals("<div class='board-container__row-item--category'>카테고리</div>", act);
	}

}
