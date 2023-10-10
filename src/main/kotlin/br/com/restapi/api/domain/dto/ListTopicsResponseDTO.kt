package br.com.restapi.api.domain.dto

import br.com.restapi.api.domain.models.Topic

data class ListTopicsResponseDTO(val topicsDTO: List<Topic>)
