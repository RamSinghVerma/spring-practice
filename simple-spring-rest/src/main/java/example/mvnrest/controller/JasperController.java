package example.mvnrest.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;

@RestController
public class JasperController {

	@GetMapping("/file/jasper")
	public ResponseEntity<byte[]> demoMethod() {
		Map<String, Object> map = new HashMap<>();
		try {
			JasperReport jasperReport = JasperCompileManager.compileReport(ResourceUtils.getFile("classpath:reports/simple.jrxml").getAbsolutePath());
			JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, map, new JREmptyDataSource());
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_PDF);
			headers.setContentDispositionFormData("filename", "simple.pdf");
			return new ResponseEntity<byte[]>(JasperExportManager.exportReportToPdf(jasperPrint), 
					headers, HttpStatus.OK);
		}catch (Exception e) {
			return new ResponseEntity<byte[]>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	
	}
	
}
