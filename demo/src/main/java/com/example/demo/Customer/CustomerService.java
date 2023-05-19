package com.example.demo.Customer;


import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> getStudents(){
        return customerRepository.findAll();
    }


    public void addNewStudent (Customer student) {
        Optional<Customer> studentByEmail=
                customerRepository.findStudentByEmail(student.getEmail());

        if (studentByEmail.isPresent()){
            throw new IllegalStateException("Email Taken");
        }

        customerRepository.save(student);

    }

    public void deleteStudnet(String studentId) {
        boolean exits = customerRepository.existsById(studentId);
        if(!exits){
            throw new IllegalStateException("doesnt exits");

        }else{
            customerRepository.deleteById(studentId);
        }

    }
    @Transactional
    public void updateStudent(String studentId, String name, String email) {
        Customer student =  customerRepository.findStudentById(studentId);


      student.setFirstName(name);
      student.setEmail(email);
    }
}

