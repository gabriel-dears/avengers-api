package org.app.avengers.resource.avenger

import org.app.avengers.domain.avenger.Avenger
import org.app.avengers.domain.avenger.AvengerRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Example
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort
import org.springframework.data.repository.findByIdOrNull
import org.springframework.data.repository.query.FluentQuery
import org.springframework.stereotype.Component
import java.util.*
import java.util.function.Function

@Component
class AvengerRepositoryImpl (
        @Autowired
        private val repository: AvengerEntityRepository
) : AvengerRepository {
    override fun getDetail(id: Long): Avenger? = repository.findByIdOrNull(id)?.toAvenger()

    override fun getAvengers(): List<Avenger> =
            repository.findAll().map { it.toAvenger() }

    override fun create(avenger: Avenger): Avenger =
            repository.save(AvengerEntity.from(avenger)).toAvenger()

    override fun delete(id: Long) = repository.deleteById(id)

    override fun update(avenger: Avenger): Avenger =
            repository.save(AvengerEntity.from(avenger)).toAvenger()

}