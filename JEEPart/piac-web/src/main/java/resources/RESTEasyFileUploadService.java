package resources;
//import java.io.Console;
//
//import java.io.File;
//
//import java.io.FileOutputStream;
//
//import java.io.IOException;
//
//import java.io.InputStream;
//
//import java.io.OutputStream;
//
//import java.util.List;
//
//import java.util.Map;
//
//import javax.ws.rs.Consumes; 
//
//import javax.ws.rs.POST;
//
//import javax.ws.rs.Path;
//
//import javax.ws.rs.core.MultivaluedMap;
//
//import javax.ws.rs.core.Response;
//
//import org.jboss.resteasy.plugins.providers.multipart.InputPart;
//
//import org.jboss.resteasy.plugins.providers.multipart.MultipartFormDataInput;
//
//@Path("/files")
//public class RESTEasyFileUploadService {
//
//	private static final String SERVER_UPLOAD_LOCATION_FOLDER = "/Users/firassahli/imagesUpload";
//
//	@POST
//	@Path("/upload")
//	@Consumes("multipart/form-data")
//	public Response uploadFile(MultipartFormDataInput input) {
//		String fileName = "";
//		Map<String, List<InputPart>> formParts = input.getFormDataMap();
//
//		List<InputPart> inPart = formParts.get("file");
//
//		for (InputPart inputPart : inPart) {
//
//			try {
//
//				// Retrieve headers, read the Content-Disposition header to obtain the original
//				// name of the file
//
//				MultivaluedMap<String, String> headers = inputPart.getHeaders();
//
//				fileName = parseFileName(headers);
//
//				// Handle the body of that part with an InputStream
//
//				InputStream istream = inputPart.getBody(InputStream.class, null);
//
//				fileName = SERVER_UPLOAD_LOCATION_FOLDER + fileName;
//
//				saveFile(istream, fileName);
//
//			} catch (IOException e) {
//
//				e.printStackTrace();
//
//			}
//
//		}
//
//		String output = "File saved to server location : " + fileName;
//
//		return Response.status(200).entity(output).build();
//
//	}
//
//	// Parse Content-Disposition header to get the original file name
//
//	private String parseFileName(MultivaluedMap<String, String> headers) {
//
//		String[] contentDispositionHeader = headers.getFirst("Content-Disposition").split(";");
//
//		for (String name : contentDispositionHeader) {
//
//			if ((name.trim().startsWith("filename"))) {
//
//				String[] tmp = name.split("=");
//
//				String fileName = tmp[1].trim().replaceAll("\"", "");
//
//				return fileName;
//
//			}
//
//		}
//
//		return "randomName";
//
//	}
//
//	// save uploaded file to a defined location on the server
//
//	private void saveFile(InputStream uploadedInputStream,
//
//			String serverLocation) {
//
//		try {
//
//			OutputStream outpuStream = new FileOutputStream(new File(serverLocation));
//
//			int read = 0;
//
//			byte[] bytes = new byte[1024];
//
//			outpuStream = new FileOutputStream(new File(serverLocation));
//			while ((read = uploadedInputStream.read(bytes)) != -1) {
//
//				outpuStream.write(bytes, 0, read);
//
//			}
//
//			outpuStream.flush();
//
//			outpuStream.close();
//
//		} catch (IOException e) {
//
//			e.printStackTrace();
//
//		}
//
//	}
//
//}

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import org.jboss.resteasy.annotations.providers.multipart.MultipartForm;

@Path("/files")
public class RESTEasyFileUploadService {

	private static final String SERVER_UPLOAD_LOCATION_FOLDER = "/Users/firassahli/imagesUpload/";

	@POST
	@Path("/upload")
	@Consumes("multipart/form-data")
	public Response uploadFile(@MultipartForm FileUploadForm form) {

		String fileName = SERVER_UPLOAD_LOCATION_FOLDER + "randomName.png";
		System.out.println("file is : "+form.getFile_input());

//		saveFile(form.getFile_input(), fileName);
//
//		String output = "File saved to server location : " + fileName;
//
//		return Response.status(200).entity(output).build();
		return null;

	}

	// save uploaded file to a defined location on the server
	private void saveFile(InputStream uploadedInputStream, String serverLocation) {

		try {
			OutputStream outpuStream = new FileOutputStream(new File(
					serverLocation));
			int read = 0;
			byte[] bytes = new byte[1024];

			outpuStream = new FileOutputStream(new File(serverLocation));
			while ((read = uploadedInputStream.read(bytes)) != -1) {
				outpuStream.write(bytes, 0, read);
			}
			outpuStream.flush();
			outpuStream.close();
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

}
