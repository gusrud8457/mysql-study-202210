package exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.study.springboot202210junil.web.dto.CmResqDto;

@RestControllerAdvice
public class CustomTestException {
	
	public ResponseEntity<?> testException(CustomTestException e) {
		return ResponseEntity.badRequest().body(new CmResqDto<>(e.getMessage(), e.geterrorMap));
	}

	

}
