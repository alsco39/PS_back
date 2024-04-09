package com.example.ps_back.domain.pet.entity

import com.example.ps_back.domain.pet.entity.enums.Gender
import com.example.ps_back.domain.pet.entity.enums.Tendency
import com.example.ps_back.domain.user.entity.User
import com.example.ps_back.global.entity.BaseIdEntity
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.FetchType
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table
import jakarta.validation.constraints.NotNull
import org.hibernate.annotations.ColumnDefault

@Table(name = "tbl_pet")
@Entity
class Pet (

    id: Long,

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    val user: User,

    @NotNull
    @ColumnDefault("''")
    @Column(columnDefinition = "VARCHAR(20)")
    val name: String,

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(12)")
    val gender: Gender,

    @NotNull
    @ColumnDefault("''")
    @Column(columnDefinition = "INT(256)")
    val age: Int,

    @NotNull
    @Column(columnDefinition = "VARCHAR(30)")
    val tendency: Tendency
)  : BaseIdEntity(id)