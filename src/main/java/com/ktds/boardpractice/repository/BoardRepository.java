package com.ktds.boardpractice.repository;

import com.ktds.boardpractice.dto.BoardDTO;
import lombok.RequiredArgsConstructor;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class BoardRepository {
    private final SqlSessionTemplate sql;
    public int save(BoardDTO boardDTO) {

        return sql.insert("Board.save",boardDTO);
    }

    public List<BoardDTO> findAll() {
        return sql.selectList("Board.findAll");
    }

    public void updateHits(String uuid) {
        sql.insert("Board.updateHits",uuid);
    }

    public BoardDTO findById(String uuid) {
        return sql.selectOne("Board.findById",uuid);
    }

    public void update(BoardDTO boardDTO) {
        sql.update("Board.update", boardDTO);
    }

    public void delete(String uuid) {
        sql.delete("Board.delete",uuid);
    }
}
