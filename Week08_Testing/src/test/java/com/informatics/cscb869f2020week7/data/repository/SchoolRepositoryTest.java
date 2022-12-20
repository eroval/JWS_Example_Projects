package com.informatics.cscb869f2020week7.data.repository;

import com.informatics.cscb869f2020week7.data.entity.School;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.internal.bytebuddy.matcher.ElementMatchers.is;

@DataJpaTest
public class SchoolRepositoryTest {

    @Autowired
    private TestEntityManager testEntityManager;

    @Autowired
    private SchoolRepository schoolRepository;

    @Test
    void findAllByNameTest() {
        String name = "Hristo Botev";
        School school = new School();
        school.setName(name);
        school.setMaxNumberOfStudents(1500);
        school.setFoundationDate(LocalDate.of(2020, 10, 20));
        testEntityManager.persistAndFlush(school);

        School school2 = new School();
        school2.setName(name);
        school2.setMaxNumberOfStudents(1400);
        school2.setFoundationDate(LocalDate.of(2020, 10, 21));
        testEntityManager.persistAndFlush(school2);

        assertThat(schoolRepository.findAllByName(name).size()).isEqualTo(2);
    }

    @Test
    void findAllByEmptyNameTest() {
        String name = "Hristo Botev";
        School school = new School();
        school.setName(name);
        school.setMaxNumberOfStudents(1500);
        school.setFoundationDate(LocalDate.of(2020, 10, 20));
        name = "";
        assertThat(schoolRepository.findAllByName(name).size()).isEqualTo(0);
    }

    @Test
    void findAllByNotFoundNameTest() {
        String name = "Hristo Botev";
        School school = new School();
        school.setName(name);
        school.setMaxNumberOfStudents(1500);
        school.setFoundationDate(LocalDate.of(2020, 10, 20));
        name = "Ivan Vazov";
        assertThat(schoolRepository.findAllByName(name).size()).isEqualTo(0);
    }
}