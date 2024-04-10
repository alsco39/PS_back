package com.example.ps_back.domain.carelog.entity

import com.example.ps_back.global.entity.BaseIdEntity
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Table
import jakarta.validation.constraints.NotNull
import org.hibernate.annotations.ColumnDefault
import org.springframework.data.annotation.CreatedDate
import java.time.LocalDate

@Table(name = "tbl_care_log")
@Entity
class CareLog (

    id: Long,

    @CreatedDate
    val createDate: LocalDate,

    @NotNull
    @ColumnDefault("''")
    @Column(columnDefinition = "VARCHAR(3000)")
    val content: String,
) : BaseIdEntity(id)