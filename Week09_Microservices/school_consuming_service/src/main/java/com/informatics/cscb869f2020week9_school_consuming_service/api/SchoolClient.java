package com.informatics.cscb869f2020week9_school_consuming_service.api;


import com.informatics.cscb869f2020week9_school_consuming_service.dto.SchoolDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient("school-service")
public interface SchoolClient {

    @GetMapping("/api/schools")
    List<SchoolDTO> getSchools();
}
