package com.board.util;

public class StringUtil {
	public String createListItem(String item, String modify){
		String result = "<div class='board-container__row-item--"+modify+"'>"+item+"</div>";
		return result;
	}
}
