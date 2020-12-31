package com.digi.unitouch.scholarOne.Meta;

import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

@XStreamAlias("author_list")
public class AuthorList {
	
	@XStreamAlias("author")
	@XStreamImplicit
	private List<Author> author;

	
	public List<Author> getAuthor() {
		return author;
	}


	public void setAuthor(List<Author> author) {
		this.author = author;
	}


	@Override
	public String toString() {
		return "AuthorList [author=" + author + "]";
	}

	
}
