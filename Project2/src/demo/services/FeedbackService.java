package demo.services;

import java.util.*;

import demo.entities.*;

public interface FeedbackService {

	public List<Feedbacks> findAll();
	public void deleteFeedback(int id);
	public void addFeedback(Feedbacks feedbacks);
	public void editFeedback(Feedbacks feedbacks,int id);
	//public Feedbacks findById (int productId, int orderId);
}
