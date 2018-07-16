package com.leo.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.leo.service.AdminLoginService;
import com.leo.service.BContentViewService;
import com.leo.service.BDeleteService;
import com.leo.service.BGetContentService;
import com.leo.service.BLikeService;
import com.leo.service.BListService;
import com.leo.service.BModifyService;
import com.leo.service.BReplyService;
import com.leo.service.BReplyViewService;
import com.leo.service.BWriteService;
import com.leo.service.GContentViewService;
import com.leo.service.GListViewService;
import com.leo.service.GVoteService;
import com.leo.service.GWriteService;
import com.leo.service.MFollowService;
import com.leo.service.MJoinService;
import com.leo.service.MLoginOutService;
import com.leo.service.MLoginService;
import com.leo.service.MUnFollowService;
import com.leo.service.MainNewListService;
import com.leo.service.NDeleteService;
import com.leo.service.NGetContent;
import com.leo.service.NListService;
import com.leo.service.NModifyService;
import com.leo.service.NWriteService;
import com.leo.service.ProFileViewService;
import com.leo.service.Service;


@WebServlet("*.do")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Controller() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionDo(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		actionDo(request, response);
	}


	private void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String uri = request.getRequestURI(); // URI
		String conPath = request.getContextPath(); 
		String comDo = uri.substring(conPath.length());
		
		Service service = null;
		String viewPage = null;
		
		if (comDo.equals("/mainView.do")) {
			
			service = new MainNewListService();
			service.excute(request, response);
			viewPage = "main/main.jsp";
			
		} else if (comDo.equals("/loginForm.do")) {
			
			viewPage = "member/loginForm.jsp";
			
		} else if (comDo.equals("/adminLoginForm.do")) {
			
			viewPage = "admin/adminLoginForm.jsp";
			
		} else if(comDo.equals("/adminLogin.do")) { 
			
			service = new AdminLoginService();
			service.excute(request, response);
			viewPage = "mainView.do";
			
		} else if (comDo.equals("/login.do")) {
			
			service = new MLoginService();
			service.excute(request, response);
			viewPage = "loginForm.do";
			
		} else if (comDo.equals("/logout.do")) {
			
			service = new MLoginOutService();
			service.excute(request, response);
			viewPage = "mainView.do";
			
		} else if (comDo.equals("/joinForm.do")) {
			
			viewPage = "member/joinForm.jsp";
			
		} else if (comDo.equals("/join.do")) {
			
			service = new MJoinService();
			service.excute(request, response);
			viewPage = "loginForm.do";
			
		} else if (comDo.equals("/profileView.do")) {
			
			service = new ProFileViewService();
			service.excute(request, response);
			viewPage = "member/proFileView.jsp";
			
		} else if (comDo.equals("/Follow.do")) {
			
			service = new MFollowService();
			service.excute(request, response);
			viewPage = "/profileView.do";
		
		} else if (comDo.equals("/UnFollow.do")) {
			
			service = new MUnFollowService();
			service.excute(request, response);
			viewPage = "/profileView.do";
			
		} else if (comDo.equals("/notice.do")) {
		
			service = new NListService();
			service.excute(request, response);
			viewPage = "notice/noticeView.jsp";
			
		} else if (comDo.equals("/noticeWriteForm.do")) { 
			
			viewPage = "notice/noticeWriteForm.jsp";
			
		} else if (comDo.equals("/noticeWrite.do")) {
			
			service = new NWriteService();
			service.excute(request, response);
			viewPage = "notice.do";
			
		} else if (comDo.equals("/noticeModifyForm.do")) {
			
			service = new NGetContent();
			service.excute(request, response);
			viewPage = "notice/noticeModifyForm.jsp";
			
		} else if (comDo.equals("/noticeModify.do")) {
			
			service = new NModifyService();
			service.excute(request, response);
			viewPage = "notice.do";
			
		} else if (comDo.equals("/noticeDelete.do")) {
			
			service = new NDeleteService();
			service.excute(request, response);
			viewPage = "notice.do";
			
		} else if (comDo.equals("/boardListView.do")) {
			
			service = new BListService();
			service.excute(request, response);
			viewPage = "board/boardListView.jsp";
			
		} else if(comDo.equals("/boardContentView.do")) {
			
			service = new BContentViewService();
			service.excute(request, response);
			viewPage = "board/contentView.jsp";
			
		} else if (comDo.equals("/boardWriteForm.do")) { 
			
			viewPage = "board/boardWriteForm.jsp";
			
		} else if (comDo.equals("/boardWrite.do")) { 
			
			service = new BWriteService();
			service.excute(request, response);
			viewPage = "boardListView.do";
			
		} else if (comDo.equals("/boardModifyForm.do")) { 
			
			service = new BGetContentService();
			service.excute(request, response);
			viewPage = "board/boardModifyForm.jsp";
			
		} else if (comDo.equals("/boardModify.do")) {
			
			service = new BModifyService();
			service.excute(request, response);
			viewPage = "boardListView.do";
			
		} else if (comDo.equals("/boardDelete.do")) {
			
			service = new BDeleteService();
			service.excute(request, response);
			viewPage = "boardListView.do";
			
		} else if (comDo.equals("/boardReplyForm.do")) {
			
			service = new BReplyViewService();
			service.excute(request, response);
			viewPage = "board/boardReplyForm.jsp";
			
		} else if (comDo.equals("/boardReply.do")) {
			
			service = new BReplyService();
			service.excute(request, response);
			viewPage = "boardListView.do";
			
		} else if (comDo.equals("/BoardLikeService.do")) {
			
			service = new BLikeService();
			service.excute(request, response);
			viewPage = "boardContentView.do";
			
		} else if (comDo.equals("/gameListView.do")) {
			
			service = new GListViewService();
			service.excute(request, response);
			viewPage = "game/gameListView.jsp";
			
		} else if (comDo.equals("/gameContentView.do")) {
			
			service = new GContentViewService();
			service.excute(request, response);
			viewPage = "game/gameContentView.jsp";
			
		} else if (comDo.equals("/gameVote.do")) {
			
			service = new GVoteService();
			service.excute(request, response);
			viewPage = "gameContentView.do";

		}  else if (comDo.equals("/gameVote.do")) {
			
			service = new GVoteService();
			service.excute(request, response);
			viewPage = "gameContentView.do";

		} else if (comDo.equals("/gameWriteForm.do")) {
			
			viewPage = "game/gaWriteForm.jsp";
			
		}  else if (comDo.equals("/gameWrite.do")) {
			
			service = new GWriteService();
			service.excute(request, response);
			viewPage = "/gameListView.do";
			
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
		
	}

}
