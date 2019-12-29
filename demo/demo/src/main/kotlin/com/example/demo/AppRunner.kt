package com.example.demo

import org.slf4j.LoggerFactory
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.stereotype.Component

@Component
class AppRunner : ApplicationRunner {
    private val logger = LoggerFactory.getLogger(AppRunner::class.java)
    override fun run(args: ApplicationArguments?) {
        logger.info("=========")
        logger.info("This is Spring Boot App")
        logger.info("=========")
    }

    fun log(msg : String) {
        logger.info(msg)
    }
}