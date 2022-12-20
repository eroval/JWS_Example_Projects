package com.informatics.cscb869.web.view.controllers;

import com.informatics.cscb869.dto.CreateTeacherDTO;
import com.informatics.cscb869.dto.TeacherSchoolDTO;
import com.informatics.cscb869.web.view.model.CreateTeacherViewModel;
import com.informatics.cscb869.web.view.model.TeacherSchoolViewModel;
import com.informatics.cscb869.data.entity.Subject;
import com.informatics.cscb869.services.SchoolService;
import com.informatics.cscb869.services.TeacherService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@AllArgsConstructor
@RequestMapping("/teachers")
public class TeacherController {

    private final TeacherService teacherService;

    private final SchoolService schoolService;

    private final ModelMapper modelMapper;

    @GetMapping("/create-teacher")
    public String showCreateTeacherForm(Model model) {
        model.addAttribute("subjects", Subject.values());
        model.addAttribute("schools", schoolService.getSchools());
        model.addAttribute("teacher", new CreateTeacherViewModel());
        return "/teachers/create-teacher";
    }

    @PostMapping("/create")
    public String createTeacher(@Valid @ModelAttribute("teacher") CreateTeacherViewModel teacher,
                                BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("subjects", Subject.values());
            model.addAttribute("schools", schoolService.getSchools());
            return "/teachers/create-teacher";
        }
        teacherService.create(modelMapper.map(teacher, CreateTeacherDTO.class));
        return "redirect:/teachers";
    }

    @GetMapping
    public String getTeachersSchools(Model model) {
        final List<TeacherSchoolViewModel> teachers =
                teacherService.getAllTeachersSchools().stream()
                        .map(this::convertToTeacherSchoolViewModel)
                        .collect(Collectors.toList());
        model.addAttribute("teachers", teachers);
        return "/teachers/teachers-schools";
    }

    private TeacherSchoolViewModel convertToTeacherSchoolViewModel(TeacherSchoolDTO teacher) {
        return modelMapper.map(teacher, TeacherSchoolViewModel.class);
    }

}
