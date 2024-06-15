package com.example.ps_back.domain.care.entity

import com.example.ps_back.domain.pet.entity.Pet
import com.example.ps_back.domain.user.entity.User
import com.example.ps_back.global.entity.BaseIdEntity
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table
import jakarta.validation.constraints.NotNull

@Table(name = "tbl_care")
@Entity
class Care (
    id: Long = 0,

    pet: Pet,

    user: User,

    var isTrue: Boolean,
) : BaseIdEntity(id) {

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    var user = user
        protected set

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pet_id")
    var pet = pet
        protected set
}