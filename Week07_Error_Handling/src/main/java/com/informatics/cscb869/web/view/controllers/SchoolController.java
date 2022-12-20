package com.informatics.cscb869.web.view.controllers;

import com.informatics.cscb869.dto.CreateSchoolDTO;
import com.informatics.cscb869.dto.SchoolDTO;
import com.informatics.cscb869.dto.UpdateSchoolDTO;
import com.informatics.cscb869.exceptions.SchoolNotFoundException;
import com.informatics.cscb869.exceptions.TeacherNotFoundException;
import com.informatics.cscb869.web.view.model.CreateSchoolViewModel;
import com.informatics.cscb869.services.SchoolService;
import com.informatics.cscb869.web.view.model.SchoolViewModel;
import com.informatics.cscb869.web.view.model.UpdateSchoolViewModel;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.lang.reflect.Type;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
@AllArgsConstructor
@RequestMapping("/schools")
public class SchoolController {

    private final SchoolService schoolService;
    private final ModelMapper modelMapper;

    @GetMapping
    public String getSchools(Model model) {
        final List<SchoolViewModel> schools = schoolService.getSchools()
                .stream()
                .map(this::convertToSchoolViewModel)
                .collect(Collectors.toList());
        model.addAttribute("schools", schools);
        return "/schools/schools";
    }

    @RequestMapping("/sort-by-name/{sortDirection}")
    public String getSchoolsOrderByName(Model model, @PathVariable String sortDirection) {
        final List<SchoolViewModel> schools = schoolService.getSchoolsSortedByName(sortDirection)
                .stream()
                .map(this::convertToSchoolViewModel)
                .collect(Collectors.toList());
        model.addAttribute("schools", schools);
        model.addAttribute("sortDirection", sortDirection.equals("asc") ? "desc" : "asc");
        return "/schools/schools";
    }

    @GetMapping("/pagination/page/{page}/size/{size}")
    public String getSchoolsPagination(Model model, @PathVariable int page, @PathVariable int size) {
        Type pageType = new TypeToken<Page<SchoolViewModel>>() {
        }.getType();
        final Page<SchoolViewModel> pageOfSchools =
                modelMapper.map(schoolService.getSchoolsPagination(PageRequest.of(page - 1, size)), pageType);

        model.addAttribute("pageOfSchools", pageOfSchools);
        int totalPages = pageOfSchools.getTotalPages();
        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
                    .boxed()
                    .collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }
        return "/schools/schools-pagination";
    }

    @GetMapping("/create-school")
    public String showCreateSchoolForm(Model model) {
        model.addAttribute("school", new CreateSchoolViewModel());
        return "/schools/create-school";
    }

    @PostMapping("/create")
    public String createSchool(@Valid @ModelAttribute("school") CreateSchoolViewModel school,
                               BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/schools/create-school";
        }
        schoolService.create(modelMapper.map(school, CreateSchoolDTO.class));
        return "redirect:/schools";
    }

    @GetMapping("/edit-school/{id}")
    public String showEditSchoolForm(Model model, @PathVariable Long id) {
        model.addAttribute("school", modelMapper.map(schoolService.getSchool(id),
                UpdateSchoolViewModel.class));
        return "/schools/edit-school";
    }

    @PostMapping("/update/{id}")
    public String updateSchool(@PathVariable long id, @Valid @ModelAttribute("school") UpdateSchoolViewModel school,
                               BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/schools/edit-school";
        }
        schoolService.updateSchool(id, modelMapper.map(school, UpdateSchoolDTO.class));
        return "redirect:/schools";
    }

    @GetMapping("/delete/{id}")
    public String processProgramForm(@PathVariable int id) {
        schoolService.deleteSchool(id);
        return "redirect:/schools";
    }

    // Search school by name and foundation date model mapper
    @GetMapping("/search-schools")
    public String processSearchSchoolForm() {
        return "/schools/search-schools";
    }

    // Search school by name and high school
    @GetMapping("/names-highschool")
    public String getSchoolsByNameAndIsHighSchool(Model model, @RequestParam String schoolName, @RequestParam(defaultValue = "false") boolean isHighSchool) {
        List<SchoolViewModel> schools = schoolService
                .getSchoolsByNameAndIsHighSchool(schoolName, isHighSchool)
                .stream()
                .map(this::convertToSchoolViewModel)
                .collect(Collectors.toList());

        model.addAttribute("schools", schools);
        return "/schools/schools";
    }

    @GetMapping("/search-schools-foundation-date")
    public String processSearchSchoolFoundationDateForm() {

        return "/schools/search-schools-foundation-date";
    }

    // Search school by name and founded after given date
    @GetMapping("/names-foundation-date")
    public String getSchoolsByNameAndFoundationDate(Model model, @RequestParam String schoolName,
                                                    @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate foundationDate) {
        List<SchoolViewModel> schools = schoolService
                .getSchoolsByNameAndFoundationDate(schoolName, foundationDate)
                .stream()
                .map(this::convertToSchoolViewModel)
                .collect(Collectors.toList());
        model.addAttribute("schools", schools);
        return "/schools/schools";
    }

    private SchoolViewModel convertToSchoolViewModel(SchoolDTO schoolDTO) {
        return modelMapper.map(schoolDTO, SchoolViewModel.class);
    }

    @ExceptionHandler({SchoolNotFoundException.class, TeacherNotFoundException.class})
    public String handleException(SchoolNotFoundException exception, Model model) {
        model.addAttribute("message", exception.getMessage());
        return "/errors/school-errors";
    }
}
