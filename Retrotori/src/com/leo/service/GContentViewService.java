package com.leo.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.leo.dao.GameDao;
import com.leo.dto.GameDto;

public class GContentViewService implements Service {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) {
		
		String gId = request.getParameter("gId");
		
		GameDao gDao = GameDao.getInstance();
		GameDto gDto = gDao.gameContentView(gId);
		
		if (gDto != null) {
			System.out.println("게임정보 가져오기 성공 : service");
			request.setAttribute("gameContent", gDto);
		} else {
			System.out.println("게임정보 가져오기 실패 : service");
		}
		
	}

}
