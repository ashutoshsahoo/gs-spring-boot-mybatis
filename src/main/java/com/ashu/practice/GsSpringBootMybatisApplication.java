package com.ashu.practice;

import com.ashu.practice.domain.Employee;
import com.ashu.practice.mapper.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashMap;
import java.util.Map;

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


    private final UserMapper userMapper;

    @Override
    public void run(String... args) throws Exception {
        log.info("City={}", this.cityMapper.findByState("CA"));
        log.info("Hotel={}", this.hotelMapper.selectByCityId(1));
        log.info("Article={}", this.articleMapper.getArticle(1L));
        runEmployeeQuery();
        log.info("UsersOrderById={}", this.userMapper.getUsers());
        log.info("User={}", this.userMapper.getUser(1000));
        Map<Integer, String> values = new HashMap<>();
        Map<Integer, Map<String, String>> users = this.userMapper.getUsersInMap();
        log.info("UsersMap={}", users);
        users.forEach((k, v) -> values.put(k, v.get("NAME")));
        log.info("Users={}", values);

    }

    private void runEmployeeQuery() {
        log.info("Inserting employee id 10011-> {}", employeeRepository.insert(new Employee(10011L, "Ashutosh", "Sahoo", "ashutosh@gmail.com")));

        log.info("Find Employee id 10011 -> {}", employeeRepository.findById(10011L));

        log.info("Update 10011 -> {}", employeeRepository.update(new Employee(10011L, "Ashu", "Sahoo", "ashu123@gmail.com")));

        log.info("Delete 10011 -> {}", employeeRepository.deleteById(10011L));

        log.info("All users -> {}", employeeRepository.findAll());
    }

}
