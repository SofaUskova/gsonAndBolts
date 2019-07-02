package com.example.logandpas

@Target(AnnotationTarget.PROPERTY)
@Retention(AnnotationRetention.RUNTIME)
annotation class TesterAttribute(val info: String)