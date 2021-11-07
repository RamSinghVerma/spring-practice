package example.mvnrest.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/files")
public class FileController {
	
	@Autowired
	ServletContext servletContext;
	
	@Autowired
	ResourceLoader resourceLoader;
	
	@GetMapping("")
	public ResponseEntity<Object> demoMethod() {	
		return ResponseEntity.ok("url for file download");
	}
	/*
	 * file download from main resources folder using resource loader
	 * it requires jackson ResourceHttpMessageConverter configuration
	 */
	@GetMapping("/download/static/{fileName:.+}")
	public ResponseEntity<Object> downloadFile1(@PathVariable String fileName) {
		HttpHeaders headers = new HttpHeaders();
		Resource resource = resourceLoader.getResource("classpath:docs/"+fileName);
		ContentDisposition contentDisposition = ContentDisposition.builder("attachment")
				.filename(fileName)
				.build();
		headers.setContentDisposition(contentDisposition);
		return ResponseEntity
				.ok()
				.contentType(MediaType.APPLICATION_PDF)
				.headers(headers)
				.body(resource);
	}
	/*
	 * file download from webapp resources folder using output stream
	 * it requires jackson ByteArrayHttpMessageConverter configuration
	 */
	@GetMapping("/download2/{fileName:.+}")
	public ResponseEntity<Object> downloadFile2(@PathVariable String fileName) {
		HttpHeaders headers = new HttpHeaders();
		String root = servletContext.getRealPath("/resources/pdf");
		Path path = Paths.get(root, fileName);
		File file = path.toFile();
		if(file.exists()) {
			byte[] fileBytes;
			try {
				ContentDisposition contentDisposition = ContentDisposition.builder("attachment")
						.filename(fileName)
						.build();
				headers.setContentDisposition(contentDisposition);
				fileBytes = Files.readAllBytes(path);
				return ResponseEntity
						.ok()
						.contentType(MediaType.APPLICATION_PDF)
						.headers(headers)
						.body(fileBytes);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return ResponseEntity.noContent().build();
	}
	/*
	 * file download from webapp resources folder using output stream
	 * it does not require jackson ByteArrayHttpMessageConverter configuration
	 */
	@GetMapping("/download3/{fileName:.+}")
	public void downloadFile3(@PathVariable String fileName, HttpServletResponse response) throws IOException {
		String root = servletContext.getRealPath("/resources/pdf");
		Path path = Paths.get(root, fileName);
		response.setHeader("Content-Disposition", "attachment; filename="+fileName);
		response.setContentType(MediaType.APPLICATION_PDF_VALUE);
		response.getOutputStream().write(Files.readAllBytes(path));
	}

}
