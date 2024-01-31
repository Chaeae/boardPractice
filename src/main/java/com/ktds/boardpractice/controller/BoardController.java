package com.ktds.boardpractice.controller;

import com.ktds.boardpractice.dto.BoardDTO;
import com.ktds.boardpractice.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor //생성자 생성을 임의로 해줌
@RequestMapping("/board")//url관리

public class BoardController {
    private final BoardService boardService;

    //create
    @GetMapping("/save")
    public String saveForm(){
        return "save";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute BoardDTO boardDTO){
        int saveResult = boardService.save(boardDTO);
        if (saveResult > 0 ){
            return "redirect:/board/";
        }
        else{
            return "save";
        }
    }
    //read
    //전페 목록 조회
    @GetMapping("/")
    public String findAll(Model model){
        List<BoardDTO> boardDTOList = boardService.findAll();
        model.addAttribute("boardList",boardDTOList);//list로 boardDTOList전송
        return "list";//jsp화면이 보임
    }

    //하나 상세조회
    @GetMapping
    public String findById(@RequestParam("uuid") String uuid, @RequestParam("index") Long index, Model model){
        boardService.updateHits(uuid);
        //System.out.println(boardDTO.toString());
        BoardDTO boardDTO = boardService.findById(uuid);
        boardDTO.setIndex(index);
        model.addAttribute("board",boardDTO);
        return "detail";
    }

    //update
    @GetMapping("/update")
    public String updateForm(@RequestParam("uuid") String uuid, Model model){
        BoardDTO boardDTO = boardService.findById(uuid);
        model.addAttribute("board",boardDTO);
        return "detail";
    }

    @PostMapping("/update")             //수정할 내용을 가져옴
    public String update(@ModelAttribute BoardDTO boardDTO, Model model){
        boardService.update(boardDTO);//service가 수행
        BoardDTO dto = boardService.findById(boardDTO.getUuid());//수행한걸 가져옴
        model.addAttribute("board",dto);
        return "detail"; //detail화면이 보여줌
    }

    //delete
    @GetMapping("/delete")
    public String delete(@RequestParam("uuid") String uuid){
        boardService.delete(uuid);
        return "redirect:/board/";
    }
}
