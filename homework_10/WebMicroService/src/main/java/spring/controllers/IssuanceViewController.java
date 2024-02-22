package spring.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import spring.services.WebService;

@Controller
@RequiredArgsConstructor
@RequestMapping("/ui/issuance")
public class IssuanceViewController {
    private final WebService webService;

    @GetMapping
    public String getIssuanceList(Model model) {
        model.addAttribute("issuanceList", webService.getIssuanceList());
        return "issuance-table";
    }
}
