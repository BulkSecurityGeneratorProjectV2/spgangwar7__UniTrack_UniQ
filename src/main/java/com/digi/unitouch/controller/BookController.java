package com.digi.unitouch.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.digi.unitouch.model.Books;
import com.digi.unitouch.service.BookService;
import com.digi.unitouch.util.LoggerClass;
import com.digi.unitouch.vo.JournalVo;

@Controller
public class BookController extends LoggerClass {
	
	@Autowired
	BookService bookService;

	@GetMapping("books")
	public ModelAndView books() {
		return new ModelAndView("books");
	}

	@GetMapping("/booklList")
	public ModelAndView journalList(ModelMap model) {
		List<Books> book = bookService.getallList();
		model.put("booklist", book);
		return new ModelAndView("bookList");

	}

	@PostMapping("createbook")
	public String createUser(@Valid @ModelAttribute("books") JournalVo journalVo, BindingResult result,
			ModelMap model) {
		LOGGER.debug("adfa ::" + journalVo.toString());
		Books book = new Books();
		book.setBookName(journalVo.getJournalTitle());
		book.setPrintIssb(journalVo.getPrintIssn());
		book.setBookAcronym(journalVo.getJournalAcronym());
		book.setDoiPrefix(journalVo.getDoiPrefix());
		book.setStatus(journalVo.getoAStatus());
//		book.setDoiPrefix(journalVo.getIssnDoi());
		book.setStatus("Active");
		bookService.saveBooks(book);
		return "redirect:booksList";

	}
	
	
}
