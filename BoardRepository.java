package com.sparta.basic_crud_10.repository;

import com.sparta.basic_crud_10.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;

//밑에 Board 는 어느 테이블에 연결할지 정하는 것이다.
public interface BoardRepository extends JpaRepository<Board, Long> {

}
