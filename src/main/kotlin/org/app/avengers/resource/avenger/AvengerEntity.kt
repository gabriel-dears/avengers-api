package org.app.avengers.resource.avenger

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import org.app.avengers.domain.avenger.Avenger
import org.jetbrains.annotations.NotNull

@Entity(name = "avenger")
//@Table(name = "avenger")
data class AvengerEntity(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long?,
        @NotNull
        val nick: String,
        @NotNull
        val person: String,
        val description: String?,
        val history: String?
) {
    fun toAvenger() = Avenger(
            id, nick, person, description, history
    )

    companion object {
        fun from(avenger: Avenger) = AvengerEntity (
                id = avenger.id,
            nick = avenger.nick,
                description = avenger.description,
                history = avenger.history,
                person = avenger.person,
                )
    }
}
