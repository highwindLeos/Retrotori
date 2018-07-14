package com.leo.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.leo.dao.FollowDao;
import com.leo.dao.MemberDao;
import com.leo.dto.FollowDto;
import com.leo.dto.MemberDto;

public class ProFileViewService implements Service {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) {
		
		String mId = request.getParameter("mId");
		String fId = mId;

		MemberDao mDao = new MemberDao();
		FollowDao fDao = FollowDao.getInstance();
		
		
		MemberDto Mdto =  mDao.getMember(mId);
		
		int followCnt = fDao.getFollowCnt(mId);
		ArrayList<FollowDto> followDtos = fDao.getFollowList(mId);
		
		int followerCnt = fDao.getFollowerCnt(fId);
		ArrayList<FollowDto> followerDtos = fDao.getFollowerList(fId);
		
		request.setAttribute("followCnt", followCnt);
		request.setAttribute("followerCnt", followerCnt);
		
		request.setAttribute("followDtos", followDtos);
		request.setAttribute("followerDtos", followerDtos);

		request.setAttribute("Mdto", Mdto);
	}

}
