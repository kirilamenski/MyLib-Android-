package com.ansgar.mylib.fbreader;

import java.util.List;


public interface Description {

	public List<String> getCover();

	public String getTitle();

	public String getAuthor();

	public String getSeries();

	public String getNumOfSer();

	public String getGenre();

	public String getLang();
	
	public List<String> getAnnotation();

}
