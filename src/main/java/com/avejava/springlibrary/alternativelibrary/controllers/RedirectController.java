package com.avejava.springlibrary.alternativelibrary.controllers;

import com.avejava.springlibrary.alternativelibrary.domain.AuthorEntity;
import com.avejava.springlibrary.alternativelibrary.domain.BookEntity;
import com.avejava.springlibrary.alternativelibrary.repository.AuthorEntityRepo;
import com.avejava.springlibrary.alternativelibrary.repository.BookEntityRepo;
import com.avejava.springlibrary.alternativelibrary.service.AuthorEntityService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Controller
public class RedirectController {
    @GetMapping("/")
    //@RequestMapping(value = "", method = RequestMethod.GET)
    public String baseUrlRedirect(HttpServletRequest request, HttpServletResponse response) {
        // перенаправление на страницу индекс
        return "redirect:" + request.getRequestURL().append("index.xhtml").toString();
    }

}
