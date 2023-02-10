package com.library.libraryModel;


import lombok.AllArgsConstructor;
import lombok.Data;



public @Data @AllArgsConstructor class Library {
	
	//"Dr.Apj Abdul Kalam" ,"Paratwada","2735629332","Wifi,gardern,Water,Parking
	
	private int lId;
	private String name;
	private String address;
	private String number;
	private String facility;

}
