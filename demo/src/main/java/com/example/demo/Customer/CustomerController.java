package com.example.demo.Customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(path = "api/v1/customer")
@CrossOrigin(origins = "http://localhost:3000")


public class CustomerController {
    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public List<Customer> getStudents(){
        return customerService.getStudents();
    }
    @PostMapping
    public void registerNewStudent(@RequestBody Customer customer){

        System.out.println(customer);
        customerService.addNewStudent(customer);
    }
    @DeleteMapping(path ="{studentId}" )
    public void deleteStudent(@PathVariable("studentId") String studentId){
        customerService.deleteStudnet(studentId);
}
   @PutMapping(path ="{studentId}")
    public void updateStudent(@PathVariable("studentId") String studentId,
                              @RequestParam(required = false) String name,
                              @RequestParam(required = false) String email) {
        customerService.updateStudent(studentId,name,email);
    }
}
