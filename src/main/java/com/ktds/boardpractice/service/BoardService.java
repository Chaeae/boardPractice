package com.ktds.boardpractice.service;

import com.ktds.boardpractice.dto.BoardDTO;
import com.ktds.boardpractice.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;
    public int save(BoardDTO boardDTO) {
        boardDTO.setUuid(UUID.randomUUID().toString());
        return boardRepository.save(boardDTO);
    }

    public List<BoardDTO> findAll() {
        List<BoardDTO> boardDTOList = boardRepository.findAll();
        Long idx=1L;
        for(BoardDTO boardDTO : boardDTOList){//보여질때 1,2,3,4순서
            boardDTO.setIndex(idx);
            idx++;
        }
        return boardDTOList;
    }

    public void updateHits(String uuid) {
        boardRepository.updateHits(uuid);
    }

    public BoardDTO findById(String uuid) {
        return boardRepository.findById(uuid);
    }

    public void update(BoardDTO boardDTO) {
        boardRepository.update(boardDTO);
    }

    public void delete(String uuid) {
        boardRepository.delete(uuid);
    }
}
