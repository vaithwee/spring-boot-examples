package xyz.vaith.springbootdatajpaspecification.service;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import xyz.vaith.springbootdatajpaspecification.bean.Clazz;
import xyz.vaith.springbootdatajpaspecification.bean.Student;
import xyz.vaith.springbootdatajpaspecification.repository.ClazzRepository;
import xyz.vaith.springbootdatajpaspecification.repository.StudentRepository;

import javax.annotation.Resource;
import javax.persistence.criteria.*;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SchoolService {
    @Resource
    private StudentRepository studentRepository;

    @Resource
    private ClazzRepository clazzRepository;

    @Transactional
    public void saveClazzAll(List<Clazz> clazzes) {
        clazzRepository.saveAll(clazzes);
    }

    @Transactional
    public void saveStudentAll(List<Student> students) {
        studentRepository.saveAll(students);
    }

    @SuppressWarnings("serial")
    public List<Map<String, Object>> getStusBySex(char sex) {
        List<Student> students = studentRepository.findAll(new Specification<Student>() {
            @Override
            public Predicate toPredicate(Root<Student> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                Predicate p1 = criteriaBuilder.equal(root.get("sex"), sex);
                return p1;
            }
        });
        List<Map<String, Object>> result = new ArrayList<>();
        for (Student student : students) {
            Map<String, Object> stu = new HashMap<>();
            stu.put("name", student.getName());
            stu.put("age", student.getAge());
            stu.put("sex", student.getSex());
            result.add(stu);
        }
        return result;
    }

    @SuppressWarnings("serial")
    public List<Map<String, Object>> getStusByDynamic(Student student) {
        List<Student> students = studentRepository.findAll(new Specification<Student>() {
            @Override
            public Predicate toPredicate(Root<Student> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();
                if (student != null) {
                    if (!StringUtils.isEmpty(student.getName())) {
                        predicates.add(criteriaBuilder.like(root.<String>get("name"), "%" + student.getName() + "%"));
                    }
                    if (!StringUtils.isEmpty(student.getAddress())) {
                        predicates.add(criteriaBuilder.like(root.<String>get("address"), "%" + student.getAddress() + "%"));
                    }
                    if (student.getSex() != '\0') {
                        predicates.add(criteriaBuilder.equal(root.<String>get("sex"), student.getSex().toString()));
                    }

                    if (student.getClazz() != null && !StringUtils.isEmpty(student.getClazz().getName())) {
                        root.join("clazz", JoinType.INNER);
                        Path<String> clazzName = root.get("clazz").get("name");
                        predicates.add(criteriaBuilder.equal(clazzName, super.getClass().getName()));
                    }

                }
                return criteriaQuery.where(predicates.toArray(new Predicate[predicates.size()])).getRestriction();
            }
        });
        List<Map<String, Object>> result = new ArrayList<>();
        for (Student student1 : students) {
            Map<String, Object> stu = new HashMap<>();
            stu.put("name", student1.getName());
            stu.put("age", student1.getAge());
            stu.put("sex", student1.getSex());
            result.add(stu);
        }
        return result;
    }
}
