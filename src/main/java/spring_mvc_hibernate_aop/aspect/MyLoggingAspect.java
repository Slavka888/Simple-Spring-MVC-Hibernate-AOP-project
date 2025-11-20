package spring_mvc_hibernate_aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyLoggingAspect {

    @Pointcut("execution(* spring_mvc_hibernate_aop.controller.MyController.*(..))")
    private void methodsFromController(){}

    @Before("methodsFromController()")
    public void beforeControllerMethods(JoinPoint joinPoint){
        String methodName = joinPoint.getSignature().getName();
        System.out.println("Method " + methodName + " from MyController");
    }

    @Around("execution(* spring_mvc_hibernate_aop.dao.*.*(..))")
    public Object aroundAllRepositoryMethodsAdvice(ProceedingJoinPoint joinPoint) throws Throwable{
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        String methodName = methodSignature.getName();
        System.out.println("Begin of " + methodName);
        Object targetMethodResult = joinPoint.proceed();
        System.out.println("End of " + methodName);
        return targetMethodResult;
    }
}
