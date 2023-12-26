package net.javaguides.springboot.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import net.javaguides.springboot.entity.News;
import net.javaguides.springboot.exception.ResourceNotFoundException;
import net.javaguides.springboot.repository.NewsRepository;

@RestController
@RequestMapping("/api/v3/")
public class NewsController {

	public NewsController(NewsRepository newsRepository) {
		this.newsRepository = newsRepository;
	}

	private NewsRepository newsRepository;
	
	// get all News
	@GetMapping("/news")
	public List<News> getAllNewss() {
		return newsRepository.findAll();
	}
	
	// create News rest api
	@PostMapping("/news")
	public News createNews(@RequestBody News news) {
		return newsRepository.save(news);
	}
	
	// get news by id rest api
	@GetMapping("/news/{id}")
	public ResponseEntity<News> getnewsById(@PathVariable Long id) {
		News news = newsRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("News not exist with id :" + id));
		return ResponseEntity.ok(news);
	}
	
	// update news rest api
	@PutMapping("/news/{id}")
	public ResponseEntity<News> updateNews(@PathVariable Long id, @RequestBody News newsDetails){
		News news = newsRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("news not exist with id :" + id));
		
		news.setTitle(newsDetails.getTitle());
		news.setContent(newsDetails.getContent());
		news.setPublicationDate(newsDetails.getPublicationDate());
		news.setAuthor(newsDetails.getAuthor());
		
		News updatednews = newsRepository.save(news);
		return ResponseEntity.ok(updatednews);
	}
	
	// delete news rest api
	@DeleteMapping("/news/{id}")
	public ResponseEntity<Map<String, Boolean>> deletenews(@PathVariable Long id){
		News news = newsRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("news not exist with id :" + id));
		
		newsRepository.delete(news);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
}
