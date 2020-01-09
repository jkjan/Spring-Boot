package com.example.memo.aspect

import com.example.memo.entity.Hello
import org.aspectj.lang.ProceedingJoinPoint
import org.aspectj.lang.annotation.Around
import org.aspectj.lang.annotation.Aspect
import org.springframework.stereotype.Component
import java.lang.System.currentTimeMillis

@Aspect
@Component
class HelloAspect {
    @Around(value = "execution(* com.example.memo.service.HelloService.*(..)) and args(hello)")
    fun beforeAdvice(pjp : ProceedingJoinPoint, hello : Hello) {
        println("Start creating a hello of ${hello.id} with ${hello.point}")
        val tik = currentTimeMillis()
        try {
            pjp.proceed()
        } catch (e : Exception) {
            e.printStackTrace()
        }
        val tok = currentTimeMillis()
        println(String.format("creating a hello done in %.4f seconds", ((tok - tik).toDouble()/1000)))
    }
}