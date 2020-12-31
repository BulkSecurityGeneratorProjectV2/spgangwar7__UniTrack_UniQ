package com.digi.unitouch.scholarOne.Meta;

import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

@XStreamAlias("file_list")
public class FileList {
	
	@XStreamAlias("file")
	@XStreamImplicit
	private List<File> file;

	@Override
	public String toString() {
		return "FileList [file=" + file + "]";
	}

	
	
	
}
