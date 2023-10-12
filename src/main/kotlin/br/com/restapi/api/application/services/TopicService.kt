package br.com.restapi.api.application.services

import br.com.restapi.api.application.services.mapper.topic.NewTopicDtoToTopic
import br.com.restapi.api.application.services.mapper.topic.TopicToTopicResponseDtoMapper
import br.com.restapi.api.domain.dto.topicDTO.NewTopicDTO
import br.com.restapi.api.domain.dto.topicDTO.TopicResponseDTO
import br.com.restapi.api.domain.dto.topicDTO.UpdateTopicDTO
import br.com.restapi.api.domain.models.Course
import br.com.restapi.api.domain.models.Topic
import br.com.restapi.api.domain.models.User
import org.springframework.stereotype.Service

@Service
class TopicService(
    private var topicsStub: MutableList<Topic> = ArrayList(),
    private var topicToTopicResponseDtoMapper: TopicToTopicResponseDtoMapper,
    private var newTopicDtoToTopic: NewTopicDtoToTopic
) {
    init {
        topicsStub.add(
            Topic(
                1, "title", "message",
                Course(1, "course", "category"),
                User(1, "name", "email")
            )
        )
    }

    fun listTopics(): List<TopicResponseDTO> {
        return topicsStub.map { t -> topicToTopicResponseDtoMapper.map(t) }
    }

    fun searchTopic(id: Long): TopicResponseDTO {
        val topic = topicsStub.stream().filter { t -> t.id == id }.findFirst().get()
        return topicToTopicResponseDtoMapper.map(topic)
    }

    fun registerTopic(dto: NewTopicDTO): TopicResponseDTO {
        val topic = newTopicDtoToTopic.map(dto)
        topic.id = topicsStub.size.toLong()
        topicsStub.plus(topic)
        return topicToTopicResponseDtoMapper.map(topic)
    }

    fun updateTopic(dto: UpdateTopicDTO): TopicResponseDTO {
        val topic = topicsStub.stream().filter {t ->
            t.id == dto.id
        }.findFirst().get()

        val newTopic = Topic(
            dto.id,
            dto.title,
            dto.message,
            topic.course,
            topic.author,
            topic.creationDate,
            topic.status,
            topic.answers
        )

        topicsStub = topicsStub.minus(topic).plus(newTopic).toMutableList()

        return topicToTopicResponseDtoMapper.map(newTopic)
    }

    fun deleteTopic(topicId: Long) {
        val topic = topicsStub.stream().filter {t ->
            t.id == topicId
        }.findFirst().get()

        topicsStub = topicsStub.minus(topic).toMutableList()
    }
}