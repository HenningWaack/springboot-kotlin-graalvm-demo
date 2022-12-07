package com.example.demo.basics

import org.springframework.data.annotation.Id

data class Customer(@Id val id: Long?, val name: String)