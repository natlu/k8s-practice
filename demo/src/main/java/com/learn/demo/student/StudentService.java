package com.learn.demo.student;

import org.springframework.stereotype.Service;

@Service
public class StudentService {

//    private final StudentRepository studentRepository;
//
//    @Autowired
//    public StudentService(StudentRepository studentRepository) {
//        this.studentRepository = studentRepository;
//    }

//    public List<Student> getStudents() {
//        return studentRepository.findAll();
//    }
//
//    public void addNewStudent(Student student) {
//        Optional<Student> studentOptional = studentRepository.findStudentByEmail(student.getEmail());
//        if (studentOptional.isPresent()) {
//            throw new IllegalStateException("email taken");
//        }
//        studentRepository.save(student);
//    }
//
//    public void deleteStudent(Long studentId) {
//        boolean exists = studentRepository.existsById(studentId);
//        if (!exists) {
//            throw new IllegalStateException("student with id " + studentId + " does not exist");
//        }
//        studentRepository.deleteById(studentId);
//    }
//
//    @Transactional
//    public void updateStudent(Long studentId, String name, String email) {
//        Optional<Student> studentOptional = studentRepository.findById(studentId);
//        if (!studentOptional.isPresent()) {
//            throw new IllegalStateException("student with id " + studentId + " does not exist");
//        }
//
//        Student student = studentOptional.get();
//        if (name != null && name.length() > 0) {
//            student.setName(name);
//        }
//        if (email != null && email.length() > 0) {
//            Optional<Student> studentEmailOptional = studentRepository.findStudentByEmail(student.getEmail());
//            if (studentEmailOptional.isPresent()) {
//                throw new IllegalStateException("email taken");
//            }
//            student.setEmail(email);
//        }
//    }

}
