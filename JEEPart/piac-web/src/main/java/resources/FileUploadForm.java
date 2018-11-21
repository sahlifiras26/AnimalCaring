package resources;
//
//import javax.ws.rs.FormParam;
//import org.jboss.resteasy.annotations.providers.multipart.PartType;
//
//public class FileUploadForm {
//
//	public FileUploadForm() {
//	}
//	
//	private byte[] data;
//
//	public byte[] getData() {
//		return data;
//	}
//
//	@FormParam("uploadedFile")
//	@PartType("application/octet-stream")
//	public void setData(byte[] data) {
//		this.data = data;
//	}
//	
//}

import java.io.InputStream;

import javax.ws.rs.FormParam;

import org.jboss.resteasy.annotations.providers.multipart.PartType;

public class FileUploadForm {
	

	@FormParam("file")
	@PartType("image/png")
	private InputStream file_input;

	public InputStream getFile_input() {
		return file_input;
	}

	public void setFile_input(InputStream file_input) {
		this.file_input = file_input;
	}
	
}
