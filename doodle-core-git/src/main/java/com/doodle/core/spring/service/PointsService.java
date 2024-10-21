package com.doodle.core.spring.service;

import com.doodle.core.spring.entity.MyUser;
import com.doodle.core.spring.entity.Points;

public interface PointsService {
	public void awardPoints(int id, int points);
	
	public Points getPoints(int id);
	
	public void savePoints(Points points);
}
