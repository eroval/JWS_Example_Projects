package com.informatics.cscb869f2020week4.controllers.view;

import com.informatics.cscb869f2020week4.data.entity.School;
import com.informatics.cscb869f2020week4.services.SchoolService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/schools")
public class SchoolController {

    private SchoolService schoolService;

    @GetMapping
    public String getSchools(Model model) {
        final List<School> schools = schoolService.getSchools();
        //final List<School> schools = new ArrayList<>();
        model.addAttribute("schools", schools);
        return "/schools/schools.html";
    }

    @GetMapping("/create-school")
    public String showCreateSchoolForm(Model model) {
        model.addAttribute("school", new School());
        return "/schools/create-school";
    }

    @PostMapping("/create")
    public String createSchool(@ModelAttribute School school) {
        schoolService.create(school);
        return "redirect:/schools";
    }

    @GetMapping("/edit-school/{id}")
    public String showEditSchoolForm(Model model, @PathVariable Long id) {
        model.addAttribute("school", schoolService.getSchool(id));
        return "/schools/edit-school";
    }

    @PostMapping("/update/{id}")
    public String updateSchool(Model model, @PathVariable long id, School school) {
        schoolService.updateSchool(id, school);
        return "redirect:/schools";
    }

    @GetMapping("/delete/{id}")
    public String processProgramForm(@PathVariable int id) {
        schoolService.deleteSchool(id);
        return "redirect:/schools";
    }


}
