package hsu.umc.server.service;

import hsu.umc.server.entity.Answer;
import hsu.umc.server.web.dto.AnswerRequestDto;

public interface AnswerCommandService {
    Answer addAnswer(Long questionId, AnswerRequestDto.CreateAnswerRequestDto requestDto);
    Answer updateAnswer(Long questionId, Long answerId, AnswerRequestDto.UpdateRequestDto requestDto);
    void deleteAnswer(Long questionId, Long answerId);
}
