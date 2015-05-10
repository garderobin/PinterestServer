package com.action.pin;

import java.io.File;  
import java.io.FileInputStream;  
import java.io.FileOutputStream;  
import java.io.InputStream;  
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class FileUploadAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7052578415972155194L;
	private File file; // 文件  
    private String fileName; // 文件名 这里因为还没插入数据库，所以还没有picnum 
    private String filePath; // 文件路径  
    private InputStream inputStream;  
  
    /** 
     * 文件上传 
     *  
     * @return 
     */  
    public String fileUpload() {  
    	System.out.println("!!!!!!!!!!!!!!!!!!!!!!!");
        String path = ServletActionContext.getServletContext().getRealPath("/upload");  
        File ff = new File(path); // 判断文件夹是否存在,如果不存在则创建文件夹  
        System.out.println("PATH: " + path);
        if (!ff.exists()) {  
            ff.mkdir();  
        }  
        try {  
            if (this.file != null) {  
                File f = this.getFile();  
                String fileName = java.util.UUID.randomUUID().toString(); // 采用时间+UUID的方式随即命名  
                String name = fileName  
                        + fileName.substring(fileName.lastIndexOf(".")); // 保存在硬盘中的文件名  
  
                FileInputStream inputStream = new FileInputStream(f);  
                FileOutputStream outputStream = new FileOutputStream(path  
                        + "\\" + name);  
                byte[] buf = new byte[1024];  
                int length = 0;  
                while ((length = inputStream.read(buf)) != -1) {  
                    outputStream.write(buf, 0, length);  
                }  
                inputStream.close();  
                outputStream.flush();  
                // 文件保存的完整路径  
                // 比如：D:\tomcat6\webapps\eserver\\upload\a0be14a1-f99e-4239-b54c-b37c3083134a.png  
                filePath = path + "\\" + name;  
            }  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        return SUCCESS;  
    }  
  
    public File getFile() {  
        return file;  
    }  
  
    public void setFile(File file) {  
        this.file = file;  
    }  
  
    public String getFileFileName() {  
        return fileName;  
    }  
  
    public void setFileFileName(String fileFileName) {  
        this.fileName = fileFileName;  
    }  
  
    public String getFilePath() {  
        return filePath;  
    }  
  
    public void setFilePath(String filePath) {  
        this.filePath = filePath;  
    }  
  
    public InputStream getInputStream() {  
        return inputStream;  
    }  
  
    public void setInputStream(InputStream inputStream) {  
        this.inputStream = inputStream;  
    } 
    
}
