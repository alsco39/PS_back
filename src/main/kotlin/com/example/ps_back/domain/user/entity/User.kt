package com.example.ps_back.domain.user.entity

import com.example.ps_back.global.enums.Authority
import com.example.ps_back.global.entity.BaseIdEntity
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.Table
import jakarta.validation.constraints.NotNull

@Table(name = "tbl_user")
@Entity
class User (

    id: Long,

    @NotNull
    @Column(columnDefinition = "VARCHAR(17)")
    val name: String,

    @NotNull
    @Column(columnDefinition = "CHAR(11)", unique = true)
    val phone: String,

    @NotNull
    @Column(columnDefinition = "VARCHAR(13)", unique = true)
    val accountId: String,

    @NotNull
    @Column(columnDefinition = "CHAR(60)")
    val password: String,

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(15)")
    val role: Authority,
) : BaseIdEntity(id)