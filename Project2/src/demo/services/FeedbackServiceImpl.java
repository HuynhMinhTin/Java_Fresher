package demo.services;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import demo.dao.*;
import demo.entities.*;

@Service("feedbackService")
@Transactional
public class FeedbackServiceImpl implements FeedbackService {

	@Autowired
	private FeedbackDAO feedbackDAO;
	
	@Override
	public List<Feedbacks> findAll() {
		return  feedbackDAO.findAll();
	}

	@Override
	public void deleteFeedback(int id) {
		// TODO Auto-generated method stub
	
		 feedbackDAO.deleteFeedbacks(id);
		
	}
	@Override
	public void editFeedback(Feedbacks feedbacks,int id) {
	
		 feedbackDAO.updateFeedbacks(feedbacks, id);
		
	}

	

	@Override
	public void addFeedback(Feedbacks feedbacks) {
		
		feedbackDAO.addFeedbacks(feedbacks);
	}

	
	

	

	
}
