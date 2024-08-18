package hsu.umc.server.web.controller;

import hsu.umc.server.apipayload.ApiResponse;
import hsu.umc.server.converter.QuestionConverter;
import hsu.umc.server.entity.Question;
import hsu.umc.server.service.QuestionCommandService;
import hsu.umc.server.service.QuestionQueryService;
import hsu.umc.server.web.dto.QuestionRequestDto;
import hsu.umc.server.web.dto.QuestionResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/question")
@RequiredArgsConstructor
public class QuestionController {

    private final QuestionQueryService questionQueryService;
    private final QuestionCommandService questionCommandService;

    //질문 생성 API
    @PostMapping("")
    public ApiResponse<QuestionResponseDto.CreateResponseDto> addQuestion(@RequestBody QuestionRequestDto.CreateQuestionRequestDto requestDto) {

        Question question = questionCommandService.addQuestion(requestDto);

        return ApiResponse.onSuccess(QuestionConverter.toCreateResponseDto(question));
    }

    //질문 단건 조회 API
    @GetMapping("/{question-id}")
    public ApiResponse<QuestionResponseDto.SearchResponseDto> getQuestion(@PathVariable("question-id") Long questionId) {

        Question question = questionQueryService.searchQuestion(questionId);

        return ApiResponse.onSuccess(QuestionConverter.toSearchResponseDto(question));
    }

    @GetMapping("")
    public ApiResponse<QuestionResponseDto.findAllQuestionResponseDto> getAllQuestions(@RequestParam(name = "page") Integer page) {

        Page<Question> questions = questionQueryService.searchQuestionList(page);

        return ApiResponse.onSuccess(QuestionConverter.tofindAllQuestionResponseDto(questions));
    }

    @DeleteMapping("/admin/{question-id}")
    public ApiResponse<QuestionResponseDto.DeleteResponseDto> deleteQuestion(@PathVariable("question-id") Long questionId) {

        questionCommandService.deleteQuestion(questionId);

        return ApiResponse.onSuccess(QuestionConverter.toDeleteResponseDto(questionId));
    }
}
