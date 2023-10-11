package br.com.restapi.api.application.services.mapper

interface Mapper<T, U> {
    fun map(t: T): U
}