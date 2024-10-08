package com.sb.studyBoard_Backend.service;

import com.sb.studyBoard_Backend.model.Postit;

import java.nio.file.AccessDeniedException;
import java.util.List;

public interface IPostitService {

    Postit createPostit(Postit postit, Long userId, Long boardId) throws AccessDeniedException;
    List<Postit> getAllPostitsByBoardId(Long boardId) throws AccessDeniedException;




}