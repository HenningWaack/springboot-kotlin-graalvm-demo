package com.example.demo.basics

import org.springframework.boot.context.event.ApplicationReadyEvent
import org.springframework.context.ApplicationListener
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.repository.CrudRepository

@Configuration
class BasicsConfiguration {
    @Bean
    fun basicsApplicationListener(customerRepository: CustomerRepository): ApplicationListener<ApplicationReadyEvent> {
        return ApplicationListener<ApplicationReadyEvent> {
            customerRepository.saveAll(
                listOf("A", "B", "C")
                    .map { Customer(null, it) })
                .forEach {
                    println(it)
                }
        }
    }
}

interface CustomerRepository : CrudRepository<Customer, Int>
