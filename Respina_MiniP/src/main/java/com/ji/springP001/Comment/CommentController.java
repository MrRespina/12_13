package com.ji.springP001.Comment;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ji.springP001.Board.BoardController;
import com.ji.springP001.Member.MemberDAO;

@Controller
public class CommentController {
	
	@Autowired
	private MemberDAO mDAO;
	
	@Autowired
	private CommentDAO cDAO;
	
	@Autowired
	private BoardController bCtr;

	@RequestMapping(value = "/cmt.commentUpdate", method = RequestMethod.GET)
	public String commentUpdate(HttpServletRequest req) throws Exception {

		mDAO.loginCheck(req);
		cDAO.getComments(req);
		cDAO.updateComments(req);
		
		return bCtr.home(req);

	}
	
	@RequestMapping(value = "/cmt.insertComment", method = RequestMethod.GET)
	public String insertComment(HttpServletRequest req) throws Exception {
		
		mDAO.loginCheck(req);
		cDAO.getComments(req);
		cDAO.insertComments(req);
		
		return bCtr.home(req);
		
	}
	
	@RequestMapping(value = "/cmt.commentDelete", method = RequestMethod.GET)
	public String deleteComment(HttpServletRequest req) throws Exception {
		
		mDAO.loginCheck(req);
		cDAO.getComments(req);
		cDAO.deleteComments(req);
		
		return bCtr.home(req);
		
	}

}
