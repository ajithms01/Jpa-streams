package com.ust.Employee_jpastreamer.service;



import com.speedment.jpastreamer.application.JPAStreamer;
import com.ust.Employee_jpastreamer.model.Employee;
import com.ust.Employee_jpastreamer.repository.Employeerepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class EmployeeService {
    @Autowired
    private Employeerepo employeeRepository;

    private final JPAStreamer jpaStreamer;

    @Autowired
    public EmployeeService(final JPAStreamer jpaStreamer) {
        this.jpaStreamer = jpaStreamer;
    }


    public Map<String, List<Employee>> groupbyEmployeeByCity() {
        return jpaStreamer.stream(Employee.class)
                .collect(Collectors.groupingBy(Employee::getCity));
    }

    public List<Employee> groupbyEmployeeByPaymentTier() {
        return employeeRepository.findAll() ;
    }

    public List<Employee> saveEmployee(List<Employee> employee) {
        return employeeRepository.saveAll(employee);
    }

    public List<Employee> findByAgeRange(int min, int max) {
        return jpaStreamer.stream(Employee.class)
                .filter(employee -> employee.getAge() >= min&& employee.getAge() <= max)
                .collect(Collectors.toList());
    }

    public Long findByGender(String gender) {
        return jpaStreamer.stream(Employee.class)
                .filter(employee -> employee.getGender().equalsIgnoreCase(gender))
                .count();
    }

    public List<Employee> findByYearJoined(int year) {
        return jpaStreamer.stream(Employee.class)
                .filter(employee -> employee.getJoiningYear()==year)
                .collect(Collectors.toList());
    }

    public Map<String, Long> maleAndFemaleCountInAYear(int year) {
        return jpaStreamer.stream(Employee.class)
               .filter(employee -> employee.getJoiningYear()==year && employee.getGender().equalsIgnoreCase("male"))
               .collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
    }

    public Map<String, List<Employee>> groupbyEmployeeByEducation() {
        return jpaStreamer.stream(Employee.class)
                .collect(Collectors.groupingBy(Employee::getEducation));
    }

    public List<Employee> searchByValue(String value) {
        return jpaStreamer.stream(Employee.class)
               .filter(employee -> employee.getCity().equalsIgnoreCase(value) ||
                       employee.getEducation().equalsIgnoreCase(value) ||
                       employee.getJoiningYear()==Integer.parseInt(value)||
                       employee.getGender().equalsIgnoreCase(value)||
                       employee.getEverBenched().equalsIgnoreCase(value)||
                       employee.getAge()==Integer.parseInt(value)
                       )
               .collect(Collectors.toList());
    }

    public List<Employee> filterEmployees(Integer id, String education, Integer joiningYear, String city, Integer paymentTier, Integer age, String gender, String everBenched, Integer experienceInCurrentDomain, Integer leaveOrNot) {

        return jpaStreamer.stream(Employee.class)
                .filter(employee ->
                        (id == null || employee.getId() == id) &&
                                (education == null || employee.getEducation().equalsIgnoreCase(education)) &&
                                (joiningYear == null || employee.getJoiningYear() == joiningYear) &&
                                (city == null || employee.getCity().equalsIgnoreCase(city)) &&
                                (paymentTier == null || employee.getPaymentTier() == paymentTier) &&
                                (age == null || employee.getAge() == age) &&
                                (gender == null || employee.getGender().equalsIgnoreCase(gender)) &&
                                (everBenched == null || employee.getEverBenched().equalsIgnoreCase(everBenched)) &&
                                (experienceInCurrentDomain == null || employee.getExperienceInCurrentDomain() == experienceInCurrentDomain) &&
                                (leaveOrNot == null || employee.getLeaveOrNot() == leaveOrNot))
                .collect(Collectors.toList());
    }
}
