package org.app.avengers.application.web.resource.response

import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotEmpty
import org.app.avengers.domain.avenger.Avenger
import org.jetbrains.annotations.NotNull

data class AvengerResponse(
        val id: Long? = null,
        val nick: String,
        val person: String,
        val description: String?,
        val history: String?
) {
        companion object {
                fun from(avenger: Avenger) = AvengerResponse(
                        id = avenger.id,
                        nick = avenger.nick,
                        person = avenger.person,
                        description = avenger.description,
                        history = avenger.history
                )
        }
}
