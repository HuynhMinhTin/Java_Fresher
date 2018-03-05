package demo.helper;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.sun.org.apache.xalan.internal.xsltc.dom.CurrentNodeListFilter;



public class UploadFileHelper {
	
	public static String simpleUpload(MultipartFile file,
			HttpServletRequest request,boolean encrypt_file_name,
			String upload_folder){
		String filename=null;
		try {
			if (!file.isEmpty()) {
				String applicationPath=request.getServletContext().
						getRealPath("");
				ServletContext servletContext = request.getSession().getServletContext();

				//String applicationPath = servletContext.getRealPath("/");
				//System.out.println(applicationPath);
				///String applicationPath="C:"+File.separator+"Users"+File.separator+"Thanh Cong"+
								//File.separator+"workspace"+File.separator+"Project"+File.separator+
								//"WebContent";
				if (encrypt_file_name) {
					String currentFileName=file.getOriginalFilename();
					String extension=currentFileName.substring(
							currentFileName.lastIndexOf("."),
							currentFileName.length());
					Long nameRandom=Calendar.getInstance().getTimeInMillis();
					String newfilename=nameRandom+extension;
					filename=newfilename;
				} else {
					filename=file.getOriginalFilename();	
				}
				byte[] bytes=file.getBytes();
				String rootPath=applicationPath;
				File dir=new File(rootPath+File.separator+upload_folder);
				if(!dir.exists())
					dir.mkdirs();
				File serverFile=new File(dir.getAbsolutePath()+
						File.separator+filename);
				BufferedOutputStream stream=new  BufferedOutputStream(
						new FileOutputStream(serverFile));
				stream.write(bytes);
				stream.close();
				System.out.println(dir.getAbsolutePath()+
						File.separator+filename);
				return filename;
				
			} else {
				filename=null;
			}
		} catch (Exception e) {
			filename=null;
		}
		return filename;
	}
	public static List<String>multipleFileUpload(List<MultipartFile> files,
			HttpServletRequest request,boolean encrypt_file_name,
			String upload_folder){
		List<String> filenames=new ArrayList<String>();
		
		try {
			if (files.size()!=0) {
				BufferedOutputStream stream=null;
				String applicationPath=request.getServletContext().
						getRealPath("");
				for(MultipartFile file:files){
					String filename="";
					if (encrypt_file_name) {
						String currentFileName=file.getOriginalFilename();
						String extension=currentFileName.substring(
								currentFileName.lastIndexOf("."),
								currentFileName.length());
						Long nameRandom=Calendar.getInstance().getTimeInMillis();
						String newfilename=nameRandom+extension;
						filename=newfilename;
					} else {
						filename=file.getOriginalFilename();
					}
					byte[] bytes=file.getBytes();
					String rootPath=applicationPath;
					File dir=new File(rootPath+File.separator+upload_folder);
					if(!dir.exists())
						dir.mkdirs();
					File serverFile=new File(dir.getAbsolutePath()+
							File.separator+filename);
					stream=new  BufferedOutputStream(
							new FileOutputStream(serverFile));
					stream.write(bytes);
					System.out.println(filename);
					filenames.add(filename);
				}
				stream.close();
			} else {
				filenames=null;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			filenames=null;
		}
		return filenames;
	}

}
