package java9r.controller.com;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java9r.entities.com.Product;
import java9r.service.com.ProductService;

@RestController
@RequestMapping("product")
public class ProductController {
	@Autowired
	ProductService productService;  
	
	// -------------------Retrieve All  Products--------------------------------------------------------

	@RequestMapping(value = "/all/", method = RequestMethod.GET)
	public ResponseEntity<List<Product>> listAllProducts() {
		List<Product> product = productService.findAll();
		if (product.isEmpty()) {
			return new ResponseEntity<List<Product>>(HttpStatus.NO_CONTENT); 
		}
		return new ResponseEntity<List<Product>>(product, HttpStatus.OK);
	}

	 

}
