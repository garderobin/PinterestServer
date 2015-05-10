package com.action.pin;

import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import org.apache.struts2.ServletActionContext;
import org.springframework.transaction.annotation.Transactional;

import com.opensymphony.xwork2.ActionSupport;
import com.service.PinService;

public class FileAction extends ActionSupport{

	private static final long serialVersionUID = 1799354892803595092L;
	private File file; 
	private String filePath;
	private String fileFileName;
	private int picnum;
	private PinService pinService;

	@Transactional
	public String fileUpload() {
		//String path = ServletActionContext.getServletContext().getRealPath("/");
		String path = "/Users/jasmineliu/Development/Data/pinterest/";	
//		String uploadPath = "userphotos/";
//		path = path + uploadPath;
		File ff = new File(path); 
		if (!ff.exists()) {
			ff.mkdir();
		}
		try {
			if (this.file != null) {
				File f = this.getFile();
				String fileName = java.util.UUID.randomUUID().toString(); 
				String fileType = fileFileName.substring(fileFileName.lastIndexOf("."));
				String name = fileName + fileType;		
				BufferedImage image = ImageIO.read(f);				
				filePath = path + name;
				System.out.println(">>>>>>>>>>>>>>>>>>>>>>>> fileType = " + fileType  +  "<<<<<<<<<<<<<<<<<<<<<<<<<<<");
				System.out.println(">>>>>>>>>>>>>>>>>>>>>>>> store path = " + filePath  +  "<<<<<<<<<<<<<<<<<<<<<<<<<<<");
				ImageIO.write(image, fileType.substring(1), new File(filePath));
				String uploadPath = "userphotos/";
				filePath = uploadPath + name;
				System.out.println(">>>>>>>>>>>>>>>>>>>>>>>> visit path = " + filePath  +  "<<<<<<<<<<<<<<<<<<<<<<<<<<<");
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		picnum = pinService.addPicture(filePath, "Uploaded by user");
		
		return SUCCESS;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public String getFileFileName() {
		return fileFileName;
	}

	public void setFileFileName(String fileFileName) {
		this.fileFileName = fileFileName;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public void setPinService(PinService pinService) {
		this.pinService = pinService;
	}

	public int getPicnum() {
		return picnum;
	}

	public void setPicnum(int picnum) {
		this.picnum = picnum;
	}
	

}
