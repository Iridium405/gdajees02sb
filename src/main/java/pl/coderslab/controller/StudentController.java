package pl.coderslab.controller;


import lombok.extern.java.Log;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.entity.StudentGroup;
import pl.coderslab.entity.Student;
import pl.coderslab.repository.GroupRepository;

import java.util.Arrays;
import java.util.List;

@Controller
@Log
@RequestMapping("/student")
public class StudentController {

    private final GroupRepository groupRepository;

    public StudentController(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    @ModelAttribute("languages")
    public List<String> checkOptions() {
        String a[] = new String[] {"java", "php", "ruby", "python"};
        log.info("some info");
        return Arrays.asList(a);
    }
    @ModelAttribute("groups")
    public List<StudentGroup> getGroups() {
        return groupRepository.findAll();
    }

    @GetMapping("/list")
    public String list(Model model){
        return "student/list";
    }

    @GetMapping("/add")
    public String add(Model model){
        Student student = new Student();
        student.setFirstName("name");
        model.addAttribute("student", student);
        return "student/add";
    }

    @GetMapping("/add-old")
    public String addOld(Model model){
        Student student = new Student();
        student.setFirstName("name 123");
        model.addAttribute("student", student);
        return "student/add-old";
    }

    @PostMapping("/add-old")
    @ResponseBody
    public String performOld(@RequestParam String firstName, @RequestParam String lastName){
        Student student = new Student();
        student.setFirstName(firstName);
        student.setLastName(lastName);

        System.out.println(student.getFirstName());
        System.out.println(student.getLastName() instanceof String);
        System.out.println("**" +student.getLastName()+"**");
        return "--added-old-";
    }

    @PostMapping("/add")
    @ResponseBody
    public String perform(@ModelAttribute Student student){
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        return ""+ student;
    }





}
