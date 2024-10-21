package com.doodle.core.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doodle.core.spring.dao.PointsDao;
import com.doodle.core.spring.entity.MyUser;
import com.doodle.core.spring.entity.Points;

import jakarta.transaction.Transactional;

@Service
public class PointsServiceImpl implements PointsService {
	@Autowired
	private PointsDao pointsDao;

	@Override
	@Transactional
	public void awardPoints(int id, int points) {
		pointsDao.awardPoints(id, points);
	}

	@Override
	@Transactional
	public Points getPoints(int id) {
		return pointsDao.getPoints(id);
	}

	@Override
	@Transactional
	public void savePoints(Points points) {
		pointsDao.savePoints(points);
	}

}
