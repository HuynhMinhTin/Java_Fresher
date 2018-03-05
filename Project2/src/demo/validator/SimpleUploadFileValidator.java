/*package demo.validator;
import org.springframework.validation.*;

import demo.entities2.*;

public class SimpleUploadFileValidator implements Validator{
	private int limit_size=10240000;
	private String limit_type_size="jpg|jpeg|png|gif";
	@Override
	public boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub
		return SimpleUploadFile.class.equals(arg0);
	}
	@Override
	public void validate(Object arg0, Errors arg1) {
		// TODO Auto-generated method stub
		SimpleUploadFile file=(SimpleUploadFile) arg0;
		if (file.getFile().getSize()==0) {
			arg1.rejectValue("file", "required.fileupload");
		}
		else if(file.getFile().getSize()>limit_size){
			arg1.rejectValue("file", "error.filesize");
		}
		else if(!checkFileType(file.getFile().getOriginalFilename())){
			arg1.rejectValue("file", "error.filesize");
		}
	}
	private boolean checkFileType(String fileName){
		if (fileName.length()>0) {
			String[] parts=fileName.split("\\.");
			if (parts.length>0) {
				String extension =parts[parts.length-1];
				return this.limit_type_size.contains(extension);
				
			}
		}
		return false;
		
	}
	
}*/

