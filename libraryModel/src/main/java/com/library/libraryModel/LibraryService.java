package com.library.libraryModel;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class LibraryService {
	
	static List<Library> library=new ArrayList<>();
	
	static int lid=0;
	
	static {
		library.add(new Library(++lid ,"Dr.Apj Abdul Kalam" ,"Paratwada","2735629332","Wifi,gardern,Water,Parking"));
		library.add(new Library(++lid ,"DBA Library" ,"Akola","2566629332","Wifi,Water,Parking"));
		library.add(new Library(++lid ,"Bhagat Singh" ,"Up","2735600332","Water,Parking"));
		library.add(new Library(++lid ,"SGB Libray" ,"Paratwada","2735629032","Wifi,gardern,Water,Parking"));
		library.add(new Library(++lid ,"V.Sawrkar" ,"Amravati","2735699332","Wifi,gardern,Water,Parking,Computers"));
		
	}

	public List<Library> findAll() {
		
		return library;
	}

	public void addLibrary(Library li) {
		library.add(li);
		
	}

	public Library findLibrary(String lname) {
		for(Library literateLibrary:library) {
			if(literateLibrary.getName().equals(lname)) {
				return literateLibrary;
			}
		}
		return null;
	}

	public void deleteLibrary(int lid2) {
		for(Library literateLibrary:library) {
			if(literateLibrary.getLId()==lid2) {
				library.remove(lid2) ;
			}
		}
	}
	

	

}
