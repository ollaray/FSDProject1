package com.simplilearn.filehandler;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;

public class FileHandler implements FileHanderInterface {
	private String fileName;
	private String fileContent;
	
	public FileHandler() {
		
	}
	public FileHandler(String fileName, String fileContent) {
		this.fileName = fileName;
		this.fileContent = fileContent;
		
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName)  {
		this.fileName = fileName;
	}
	public String getFileContent() {
		return fileContent;
	}
	public void setFileContent(String fileContent) {
		this.fileContent = fileContent;
	}
	@Override
	public  void createNewFile() {
		
		FileOutputStream stream = null;
        String path = this.fileName;
        String fileContent = this.fileContent;
        try {
	        stream = new FileOutputStream(path,true);
	        String str = fileContent;
	        byte[] bcontent = str.getBytes();
	        //System.out.println("File has been created and data written in file");
	        stream.write(bcontent);
        }catch(IOException e) {
        	e.printStackTrace();
        }finally{
            if(stream != null){
                try{
                    stream.close();
                }catch(IOException e){
                    e.printStackTrace();
                }
            }
        }
            
      
	}
	
	public void readFile() {
		
	}
	public boolean deleteFile() throws IOException{
		File file = new File(this.fileName);
		if(file.delete()) {
			return true;
		}else {
			return false;
		}
		
	}
	
	public void editFile() {
		
	}
	public void renameFile() {
		
	}
	public void displaySortedFileList(String sortOrder) {
		File folder = new File(this.fileName);
		String[] fileList = folder.list();
		if(fileList == null) {
			System.out.println("There are currently no files in the application\'s direction");
		}else {
			if(sortOrder.equals("asc") || sortOrder.equalsIgnoreCase("asc")) {
				Arrays.sort(fileList);
				System.out.println(Arrays.toString(fileList));
			}
			if(sortOrder.equals("desc") || sortOrder.equalsIgnoreCase("desc")) {
				try {
					Arrays.sort(fileList, Collections.reverseOrder());
					System.out.println(Arrays.toString(fileList));
				}catch(ClassCastException e) {
					e.printStackTrace();
				}
			}
		}
		
	}

}
