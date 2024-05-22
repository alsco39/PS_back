package com.example.ps_back.domain.board.entity

import com.example.ps_back.domain.board.entity.enums.BoardType
import com.example.ps_back.domain.user.entity.User
import com.example.ps_back.global.entity.BaseIdEntity
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table
import jakarta.validation.constraints.NotNull
import org.hibernate.annotations.ColumnDefault
import org.springframework.data.annotation.CreatedDate
import java.time.LocalDate

@Table(name = "tbl_board")
@Entity
class Board (

    id: Long = 0,

    @NotNull
    @ColumnDefault("''")
    @Column(columnDefinition = "VARCHAR(50)")
    var title: String,

    @NotNull
    var endDate: LocalDate,

    @ColumnDefault("''")
    @Column(columnDefinition = "VARCHAR(500)")
    var note: String,

    @NotNull
    @ColumnDefault("'EMPLOYMENT'")
    @Column(columnDefinition = "VARCHAR(10)")
    val type: BoardType,

    @NotNull
    @Column(columnDefinition = "INT(255)")
    var money: Int,

    @NotNull
    @Column(columnDefinition = "VARCHAR(100)")
    var area: String,

    @CreatedDate
    var startDate: LocalDate,

    user: User

) : BaseIdEntity(id) {

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    var user = user
        protected set

    fun updateBoard(title: String, startDate: LocalDate, endDate: LocalDate,
                    note: String, money: Int, area: String) {

        this.title = title
        this.startDate = startDate
        this.endDate = endDate
        this.note = note
        this.money = money
        this.area = area
    }
}