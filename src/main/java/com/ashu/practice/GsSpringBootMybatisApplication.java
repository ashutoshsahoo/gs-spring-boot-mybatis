package com.ashu.practice;

import com.ashu.practice.domain.Employee;
import com.ashu.practice.mapper.ArticleMapper;
import com.ashu.practice.mapper.CityMapper;
import com.ashu.practice.mapper.EmployeeRepository;
import com.ashu.practice.mapper.HotelMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
@Slf4j
public class GsSpringBootMybatisApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(GsSpringBootMybatisApplication.class, args);
    }


    private final CityMapper cityMapper;
    private final HotelMapper hotelMapper;

    private final ArticleMapper articleMapper;

    private final EmployeeRepository employeeRepository;

    @Override
    public void run(String... args) throws Exception {
        log.info("City={}", this.cityMapper.findByState("CA"));
        log.info("Hotel={}", this.hotelMapper.selectByCityId(1));
        log.info("Article={}", this.articleMapper.getArticle(1L));
        runEmployeeQuery();
    }

    private void runEmployeeQuery() {
        log.info("Inserting employee id 10011-> {}", employeeRepository.insert(new Employee(10011L, "Ashutosh", "Sahoo", "ashutosh@gmail.com")));

        log.info("Find Employee id 10011 -> {}", employeeRepository.findById(10011L));

        log.info("Update 10011 -> {}", employeeRepository.update(new Employee(10011L, "Ashu", "Sahoo", "ashu123@gmail.com")));

        log.info("Delete 10011 -> {}", employeeRepository.deleteById(10011L));

        log.info("All users -> {}", employeeRepository.findAll());
    }
}
