package demo.dao;

import java.util.*;

import demo.entities.*;

public interface FeedbackDAO {

	public List<Feedbacks> findAll();
	public void deleteFeedbacks(int id);
	public void updateFeedbacks(Feedbacks feedbacks , int id);
	public void addFeedbacks(Feedbacks feedbacks);
	public Feedbacks findFeedbacks(int id);
	
}
