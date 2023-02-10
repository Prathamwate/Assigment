package com.library.libraryModel;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class LibraryController {
	
	@Autowired
	private LibraryService ls;
	
	@GetMapping("/findAll")
	public List<Library> findAll(){
		return ls.findAll();
		
	}

	@PostMapping("/addLibrary")
	public void addLibrary(@RequestBody Library li) {
		ls.addLibrary(li);
	}
	
	@GetMapping("/findLibrary/{lname}")
	public Library findAll(@PathVariable String lname){
		return ls.findLibrary(lname);
		
	}
	
	@DeleteMapping("/deleteLibrary/{lid}")
	public void deleteLibrary(@PathVariable int lid) {
		ls.deleteLibrary(lid);
	}
	
}
