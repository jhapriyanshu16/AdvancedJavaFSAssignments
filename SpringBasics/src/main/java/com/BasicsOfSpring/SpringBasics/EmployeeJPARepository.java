package com.BasicsOfSpring.SpringBasics;

import org.jspecify.annotations.Nullable;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public interface EmployeeJPARepository extends JpaRepository<Employee, Integer> {

    public Employee getByName(String name);
    //select * from employee where name :name;
    //getBy, findby, readby

    public Employee getBySalary(double salary);
    public  Employee getByNameAndSalary(String name, double salary);
}
