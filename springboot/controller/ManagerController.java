package net.javaguides.springboot.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import net.javaguides.springboot.entity.Manager;
import net.javaguides.springboot.exception.ResourceNotFoundException;
import net.javaguides.springboot.repository.ManagerRepository;


@RestController
@RequestMapping("/api/v2/")
public class ManagerController {

	public ManagerController(ManagerRepository managerRepository) {
		this.managerRepository = managerRepository;
	}
	
	private ManagerRepository managerRepository;
	
	// get all managers
	@GetMapping("/managers")
	public List<Manager> getAllManagers(){
		return managerRepository.findAll();
	}
	
	// create manager rest api
	@PostMapping("/managers")
	public Manager createManager(@RequestBody Manager manager) {
		return managerRepository.save(manager);
	}
	
	// get manager by id rest api
	@GetMapping("/manager/{id}")
	public ResponseEntity<Manager> getManagerById(@PathVariable Long id) {
		Manager manager = managerRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Manager is not exist with id :" + id));
		return ResponseEntity.ok(manager);
	}
	
	// update manager rest api
	@PutMapping("/manager/{id}")
	public ResponseEntity<Manager> updateManager(@PathVariable Long id, @RequestBody Manager managerDetails){
		Manager manager = managerRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Manager not exist with id :" + id));
		
		manager.setManagerName(managerDetails.getManagerName());
		
		Manager updatedManager = managerRepository.save(manager);
		return ResponseEntity.ok(updatedManager);
	}
	
	// delete manager rest api
	@DeleteMapping("/manager/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteManager(@PathVariable Long id){
		Manager manager = managerRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Manager not exist with id :" + id));
		
				managerRepository.delete(manager);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
}

