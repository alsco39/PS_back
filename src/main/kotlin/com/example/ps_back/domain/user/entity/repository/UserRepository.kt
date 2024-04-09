package com.example.ps_back.domain.user.entity.repository

import com.example.ps_back.domain.user.entity.User
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : CrudRepository<User, Long>