package hsu.umc.server.web.controller;

import hsu.umc.server.apipayload.ApiResponse;
import hsu.umc.server.converter.QuestionConverter;
import hsu.umc.server.entity.Question;
import hsu.umc.server.service.QuestionCommandService;
import hsu.umc.server.service.QuestionQueryService;
import hsu.umc.server.web.dto.QuestionRequestDto;
import hsu.umc.server.web.dto.QuestionResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/question")
@RequiredArgsConstructor
@Tag(name="question",description = "질문 관련 API")
public class QuestionController {

    private final QuestionQueryService questionQueryService;
    private final QuestionCommandService questionCommandService;

    //질문 생성 API
    @PostMapping("")
    @Operation(summary = "질문 생성", description = "주어진 정보를 바탕으로 질문을 추가합니다.")
    public ApiResponse<QuestionResponseDto.CreateResponseDto> addQuestion(@RequestBody QuestionRequestDto.CreateQuestionRequestDto requestDto) {

        Question question = questionCommandService.addQuestion(requestDto);

        return ApiResponse.onSuccess(QuestionConverter.toCreateResponseDto(question));
    }

    //질문 단건 조회 API
    @GetMapping("/{question-id}")
    @Operation(summary = "질문 단건 조회", description = "질문 id 에 해당하는 질문의 세부 내용(답변, 내용 )을 조회합니다.")
    public ApiResponse<QuestionResponseDto.SearchResponseDto> getQuestion(@PathVariable("question-id") Long questionId) {

        Question question = questionQueryService.searchQuestion(questionId);

        return ApiResponse.onSuccess(QuestionConverter.toSearchResponseDto(question));
    }

    @GetMapping("/list")
    @Operation(summary = "질문 전체 조회 (페이징 처리 ok)", description = "페이징 처리된 질문들을 전부 조회합니다. ")
    public ApiResponse<QuestionResponseDto.findAllQuestionResponseDto> getAllQuestions(@RequestParam(name = "page") Integer page) {

        Page<Question> questions = questionQueryService.searchQuestionList(page);

        return ApiResponse.onSuccess(QuestionConverter.tofindAllQuestionResponseDto(questions));
    }
    @GetMapping("/")
    @Operation(summary = "질문 전체 조회 (페이징 처리 no)", description = "질문들을 전부 조회합니다. ")
    public ApiResponse<List<QuestionResponseDto.findAllResponseDto>> getAllQuestions(){
        List<Question> questions = questionQueryService.searchQuestions();
        return ApiResponse.onSuccess(QuestionConverter.tofindAllResponseDto(questions));
    }


    @DeleteMapping("/admin/{question-id}")
    @Operation(summary = "관리자 전용 질문 삭제", description = "질문 id 에 해당하는 질문을 삭제합니다. - 관리자 전용 기능 ")
    public ApiResponse<QuestionResponseDto.DeleteResponseDto> deleteQuestion(@PathVariable("question-id") Long questionId) {

        questionCommandService.deleteQuestion(questionId);

        return ApiResponse.onSuccess(QuestionConverter.toDeleteResponseDto(questionId));
    }

    @PatchMapping("/admin/{question-id}")
    @Operation(summary = "관리자 전용 질문 수정", description = "질문 id 에 해당하는 질문을 수정합니다.")
    public ApiResponse<QuestionResponseDto.UpdateResponseDto> updateQuestion(@PathVariable("question-id") Long questionId,
                                                                             @RequestBody QuestionRequestDto.CreateQuestionRequestDto requestDto) {

        Question question = questionCommandService.updateQuestion(questionId, requestDto);

        return ApiResponse.onSuccess(QuestionConverter.toUpdateResponseDto(question));
    }
}
