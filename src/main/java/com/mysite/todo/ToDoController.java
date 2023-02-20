package com.mysite.todo;

import java.util.List;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@RequiredArgsConstructor
@Controller
public class ToDoController {
    private final ToDoRepository toDoRepository;
    @RequestMapping("/todo")
    public String list(Model model){
        List<ToDoEntity> toDoEntityList=this.toDoRepository.findAll();
        model.addAttribute("toDoEntityList",toDoEntityList);
        return "todoList";
    }

    @RequestMapping("/")
    public String root(){
        return "redirect:/todo";
    }
}
