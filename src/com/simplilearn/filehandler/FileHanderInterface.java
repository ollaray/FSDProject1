package com.simplilearn.filehandler;

public interface FileHanderInterface {
	
	public void createNewFile();
	public void readFile();
	public boolean deleteFile() throws Exception;
	public void editFile();
	public void renameFile();
	public void displaySortedFileList(String sortOrder);

}
