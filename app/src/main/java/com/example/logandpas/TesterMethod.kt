package com.example.logandpas

@Target(AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.RUNTIME)
annotation class TesterMethod(val description: String,
                              val isInner: Boolean = false)