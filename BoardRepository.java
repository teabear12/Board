package com.sparta.basic_crud_10.repository;

import com.sparta.basic_crud_10.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;
//JpaRepository : 창구
public interface BoardRepository extends JpaRepository<Board, Long> {

}
