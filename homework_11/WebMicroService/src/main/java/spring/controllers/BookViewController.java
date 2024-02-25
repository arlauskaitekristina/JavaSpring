package spring.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import spring.services.WebService;

@Controller
@RequiredArgsConstructor
@RequestMapping("/ui/book")
public class BookViewController {
    private final WebService webService;

    @GetMapping
    public String getBookList(Model model) {
        model.addAttribute("bookList", webService.getBookList());
        return "book-list";
    }
}
