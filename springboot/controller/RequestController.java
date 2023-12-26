package net.javaguides.springboot.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import net.javaguides.springboot.entity.Request;
import net.javaguides.springboot.exception.ResourceNotFoundException;
import net.javaguides.springboot.repository.RequestRepository;


@RestController
@RequestMapping("/api/v4/")
public class RequestController {

	public RequestController(RequestRepository requestRepository) {
		this.requestRepository = requestRepository;
	}

	private RequestRepository requestRepository;
	
	// get all requests
	@GetMapping("/requests")
	public List<Request> getAllRequests() {
		return requestRepository.findAll();
	}
	
	// create request rest api
	@PostMapping("/requests")
	public Request createRequest(@RequestBody Request request) {
		return requestRepository.save(request);
	}
	
	// get request by id rest api
	@GetMapping("/requests/{id}")
	public ResponseEntity<Request> getRequestById(@PathVariable Long id) {
		Request request = requestRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Request is not exist with id :" + id));
		return ResponseEntity.ok(request);
	}
	
	// update request rest api
	@PutMapping("/requests/{id}")
	public ResponseEntity<Request> updateRequest(@PathVariable Long id, @RequestBody Request requestDetails){
		Request request = requestRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Request is not exist with id :" + id));
		
		request.setManagerId(requestDetails.getManagerId());
		request.setRequestsId(requestDetails.getRequestId());
		request.setRequestType(requestDetails.getRequestType());
		request.setDescribtion(requestDetails.getDescribtion());
		request.setDate(requestDetails.getDate());
		request.setStatus(requestDetails.getStatus());
		
		Request updatedrequest = requestRepository.save(request);
		return ResponseEntity.ok(updatedrequest);
	}
	
	// delete request rest api
	@DeleteMapping("/requests/{id}")
	public ResponseEntity<Map<String, Boolean>> deleterequest(@PathVariable Long id){
		Request request = requestRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Request not exist with id :" + id));
		
		requestRepository.delete(request);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
}