package com.revature.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.dao.PostDao;
import com.revature.entity.PostEntity;
import com.revature.entity.UserEntity;

@Service
public class PostService {
	@Autowired
	private PostDao postDao;
	
	public PostService()
	{
		
	}
	public PostService(PostDao postDao) {
		this.postDao = postDao;
	}

	public List<PostEntity> getAll() {
		return this.postDao.findAll();
	}

	public PostEntity upsert(PostEntity post) {
		return this.postDao.save(post);
	}
	
	//Service method to call seefirst functionality
	public PostEntity[] seeFirst(int authorId)
	{
		PostEntity[] filteredPosts= this.postDao.seeFirst(authorId);
		return filteredPosts;
	}
}
