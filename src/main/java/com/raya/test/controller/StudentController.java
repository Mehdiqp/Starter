package com.raya.test.controller;


import com.raya.test.model.Student;
import com.raya.test.service.StudentServiceImpl;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.net.ssl.HttpsURLConnection;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentServiceImpl studentService;


    @GetMapping("/getAll")
    public List<Student> getAllData(){

        return studentService.getAll();
    }

    @GetMapping("/updateStudent/{name}/{age}")
    public String updateStudent(@PathVariable("name") String name,@PathVariable("age") int age){

        return studentService.updateStudent(name,age);
    }


    @GetMapping("/getAll/{page}/{size}")
    public Page<Student> getAll(@PathVariable("page") int page, @PathVariable("size") int size) {

        return studentService.getAll(page, size);

    }




    @ApiOperation(value = "Add or insert student")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Added successfully"),
            @ApiResponse(code = 401, message = "You are not authorized"),
            @ApiResponse(code = 409, message = "It is duplicate"),
            @ApiResponse(code = 500, message = "Server error")
    })
    @PostMapping("/addStudent")
    public ResponseEntity<Void> addStudent(@RequestBody @Valid Student param){

        studentService.addStudent(param);

        return ResponseEntity.status(HttpsURLConnection.HTTP_CREATED).build();
    }
//
//    @PutMapping("/get")
//    public String PutMapping(){
//
//        return "PutMapping";
//    }
//
//    @PatchMapping("/get")
//    public String PatchMapping(){
//
//        return "PatchMapping";
//    }
   @GetMapping("/delete/{id}")
    public String DeleteMapping(@PathVariable("id") Long id){
       studentService.deleteStudent(id);
        return "delet shod ba in id:"+id;
    }


}
