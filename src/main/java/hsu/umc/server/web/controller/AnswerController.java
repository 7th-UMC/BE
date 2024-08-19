package hsu.umc.server.web.controller;

import hsu.umc.server.apipayload.ApiResponse;
import hsu.umc.server.converter.AnswerConverter;
import hsu.umc.server.entity.Answer;
import hsu.umc.server.service.AnswerCommandService;
import hsu.umc.server.web.dto.AnswerRequestDto;
import hsu.umc.server.web.dto.AnswerResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/answer/admin")
@RequiredArgsConstructor
@Tag(name="answer",description = "답변 관련 API")
public class AnswerController {
    private final AnswerCommandService answerCommandService;

    //답변 생성
    @PostMapping("/{questionId}")
    @Operation(summary = "관리자 전용 답변 생성", description = "주어진 정보를 바탕으로 답변을 추가합니다.")
    public ApiResponse<AnswerResponseDto.CreateResponseDto> addAnswer(
            @PathVariable("questionId")Long questionId,
            @RequestBody @Valid AnswerRequestDto.CreateAnswerRequestDto requestDto
    ) {
        Answer answer = answerCommandService.addAnswer(questionId, requestDto);
        return ApiResponse.onSuccess(AnswerConverter.toCreateResponseDto(answer));
    }

    //답변 수정
    @PatchMapping("/{questionId}/{answerId}")
    @Operation(summary = "관리자 전용 답변 수정", description = "질문 id에 해당하는 답변을 수정합니다.")
    public ApiResponse<Object> updateAnswer(
            @PathVariable("questionId")Long questionId,
            @PathVariable("answerId")Long answerId,
            @RequestBody AnswerRequestDto.UpdateRequestDto requestDto
    ){
        Answer updatedAnswer = answerCommandService.updateAnswer(questionId, answerId, requestDto);
        return ApiResponse.onSuccess(AnswerConverter.toUpdateResponseDto(updatedAnswer));
    }

    //답변 삭제
    @DeleteMapping("/{questionId}/{answerId}")
    @Operation(summary = "관리자 전용 답변 삭제, description", description = "답변 id에 해당하는 답변을 삭제합니다. ")
    public ApiResponse<Object> deleteAnswer(
            @PathVariable("questionId")Long questionId,
            @PathVariable("answerId") Long answerId
    ){
        answerCommandService.deleteAnswer(questionId, answerId);
        return ApiResponse.onSuccess(AnswerConverter.toDeleteResponseDto(answerId));
    }
}
