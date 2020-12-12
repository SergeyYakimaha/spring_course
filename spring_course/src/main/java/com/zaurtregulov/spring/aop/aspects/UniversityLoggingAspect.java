package com.zaurtregulov.spring.aop.aspects;

import com.zaurtregulov.spring.aop.Student;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Aspect
public class UniversityLoggingAspect {

//    @Before("execution(* getStudents())")
//    public void beforeGetStudentsLoggingAdvice() {
//        System.out.println("beforeGetStudentsLoggingAdvice: логируем получение списка " +
//                "студентов перед методом getStudents");
//    }

//    @AfterReturning(pointcut = "execution(* getStudents())",
//                    returning = "students")
//    public void afterReturningGetStudentsLoggingAdvice(List<Student> students) {
//        students.forEach((student -> student.setAvgGrade(10)));
//
//        System.out.println("afterReturningGetStudentsLoggingAdvice: логируем получение списка " +
//                "студентов после работы метода getStudents");
//    }

//    @AfterThrowing(pointcut = "execution(* getStudents())", throwing = "exception")
//    public void afterThrowingGetStudentsLoggingAdvice(Throwable exception) {
//        System.out.println("afterThrowingGetStudentsLoggingAdvice: логируем выбром исключения " + exception);
//    }

    @After("execution(* getStudents())")
    public void afterGetStudentsLoggingAdvice(JoinPoint joinPoint) {
        System.out.println("afterGetStudentsLoggingAdvice: логируем нормальное окончание работы метода или " +
                "выбром исключения");
        System.out.println(joinPoint.getSignature().getName());
    }

}
