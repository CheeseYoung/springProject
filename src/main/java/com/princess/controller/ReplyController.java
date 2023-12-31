package com.princess.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.princess.domain.Board;
import com.princess.domain.Member;
import com.princess.domain.Reply;
import com.princess.service.ReplyService;

@RestController
@RequestMapping("/reply")
public class ReplyController {
	
	@Autowired
    private ReplyService replyService;
	
	@PostMapping("/insertReply")
    public String saveReply(@RequestBody Map<String, Object> payload,
                            Model model) {
		
		String replyContent = (String) payload.get("replyContent");
		String memberId = (String) payload.get("memberId");
	    Long boardId = Long.valueOf((String) payload.get("boardId"));
	    
	    System.out.println("boardId : "+boardId);
		System.out.println("replyContent : "+replyContent);
		System.out.println("memberId : "+memberId);
		
		Member member = new Member();
		member.setId(memberId);
		
		Board board = new Board();
        board.setPostNum(boardId);
      
        Reply reply = new Reply();
        reply.setUserId(member);
        reply.setReplyContent(replyContent);
        reply.setPostNum(board);

        replyService.saveReply(reply);
        
        List<Reply> replies = replyService.findByBoard(board);
        model.addAttribute("replies", replies);

        return "board/getBoard";
    }
	
	@PostMapping("/insertReReply")
	public String saveReReply(@RequestBody Map<String, Object> payload, Model model) {
		System.out.println("insertReReply");
		String replyContent = (String) payload.get("reReplyContent");
		String memberId = (String) payload.get("memberId");
	    Long boardId = Long.valueOf((String) payload.get("boardId"));
	    Long replyNum = Long.valueOf((String) payload.get("reReplyNum"));
	    
	    System.out.println("boardId : "+boardId);
		System.out.println("replyContent : "+replyContent);
		System.out.println("memberId : "+memberId);
		System.out.println("memberId : "+replyNum);
		
	    Member member = new Member();
		member.setId(memberId);
		
		Board board = new Board();
        board.setPostNum(boardId);
      
        Reply reply = new Reply();
        reply.setReplyNum(replyNum);
        reply.setUserId(member);
        reply.setReplyContent(replyContent);
        reply.setPostNum(board);
        reply.setReference(reply);
	    
        replyService.saveReReply(reply);
        
        List<Reply> replies = replyService.findByBoard(board);
        model.addAttribute("replies", replies);
        
		return "board/getBoard";
	}

	@PostMapping("/delete")
    public String deleteReply(@RequestBody Map<String, Object> payload, Model model) {
		Long replyNum = Long.valueOf((String) payload.get("replyNum"));
		System.out.println("boradID : "+replyNum);
        replyService.deleteReply(replyNum);
        return "redirect:/board/getBoard"; 
    }
}
