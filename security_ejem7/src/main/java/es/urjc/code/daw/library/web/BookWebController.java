package es.urjc.code.daw.library.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import es.urjc.code.daw.library.book.Book;
import es.urjc.code.daw.library.book.BookService;
import es.urjc.code.daw.library.user.UserComponent;

@Controller
public class BookWebController {

	@Autowired
	private BookService service;
	
	@Autowired
	private UserComponent userComponent;

	@ModelAttribute
	public void addAttributes(Model model) {
		
		boolean logged = userComponent.getLoggedUser() != null;
		
		model.addAttribute("logged", logged);
		model.addAttribute("notLogged", !logged);
		
		if(logged){
			model.addAttribute("userName",userComponent.getLoggedUser().getName());
			model.addAttribute("admin", userComponent.getLoggedUser().getRoles().contains("ROLE_ADMIN"));
		}
	}
	
	
	@RequestMapping("/")
	public String showBooks(Model model) {

		model.addAttribute("books", service.findAll());
		
		return "books";
	}
	
	@RequestMapping("/books/{id}")
	public String showBook(Model model, @PathVariable long id) {
		
		Book book = service.findOne(id);

		model.addAttribute("book", book);

		return "book";
	}
	
	@RequestMapping("/removebook/{id}")
	public String removeBook(Model model, @PathVariable long id) {
		
		Book book = service.findOne(id);

		service.delete(id);
		
		model.addAttribute("book", book);

		return "removedbook";
	}
	
	@RequestMapping(value="/newbook", method=RequestMethod.GET)
	public String newBook(Model model) {
		
		return "newBookPage";
	}
	
	@RequestMapping(value="/newbook", method=RequestMethod.POST)
	public String newBookProcess(Book book) {
		
		
		service.save(book);
		
		return "bookCreated";
	}
	
	@RequestMapping(value="/editbook/{id}", method=RequestMethod.GET)
	public String editBook(Model model, @PathVariable long id) {
		
		Book book = service.findOne(id);

		model.addAttribute("book", book);
		
		return "editBookPage";
	}
	
	@RequestMapping(value="/editbook", method=RequestMethod.POST)
	public String editBookProcess(Book book) {
		
		
		service.save(book);
		
		return "bookEdited";
	}


}
