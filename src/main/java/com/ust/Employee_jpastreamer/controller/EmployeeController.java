package com.ust.Employee_jpastreamer.controller;

import com.ust.Employee_jpastreamer.model.Employee;
import com.ust.Employee_jpastreamer.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/v1")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @PostMapping("/save")
    public List<Employee> saveEmployee(@RequestBody List<Employee> employee){
        return employeeService.saveEmployee(employee);
    }

    @GetMapping("/groupByCity")
    public Map<String, List<Employee>> groupbyEmployeeByCity(){
        return employeeService.groupbyEmployeeByCity();
    }
    @GetMapping("/findall")
    public List<Employee> groupbyEmployeeByPaymentTier(){
        return employeeService.groupbyEmployeeByPaymentTier();
    }

    @GetMapping("/findByAgeRange/{min}/{max}")
    public List<Employee> findByAgeRange(@PathVariable int min, @PathVariable int max){
        return employeeService.findByAgeRange(min, max);
    }

    @GetMapping("/findByGender/{gender}")
    public Long findByGender(@PathVariable String gender){
        return employeeService.findByGender( gender);
    }

    @GetMapping("/findByYearJoined/{year}")
    public List<Employee> findByYearJoined(@PathVariable int year){
        return employeeService.findByYearJoined(year);
    }

    @GetMapping("maleandfemalecountinayear/{year}")
    public Map<String, Long> maleAndFemaleCountInAYear(@PathVariable int year){
        return employeeService.maleAndFemaleCountInAYear(year);
    }

    @GetMapping("/groupByEducation")
    public Map<String, List<Employee>> groupbyEmployeeByEducation(){
        return employeeService.groupbyEmployeeByEducation();
    }

    @GetMapping("/searchFilter/")
    public List<Employee> filterEmployees(
            @RequestParam(required = false) Integer id,
            @RequestParam(required = false) String education,
            @RequestParam(required = false) Integer joiningYear,
            @RequestParam(required = false) String city,
            @RequestParam(required = false) Integer paymentTier,
            @RequestParam(required = false) Integer age,
            @RequestParam(required = false) String gender,
            @RequestParam(required = false) String everBenched,
            @RequestParam(required = false) Integer experienceInCurrentDomain,
            @RequestParam(required = false) Integer leaveOrNot
    ) {
        return employeeService.filterEmployees(id, education, joiningYear, city, paymentTier,
                age, gender, everBenched, experienceInCurrentDomain, leaveOrNot);
    }

}
