package hsu.umc.server.service;

import hsu.umc.server.apipayload.code.status.ErrorStatus;
import hsu.umc.server.apipayload.exception.handler.QuestionHandler;
import hsu.umc.server.converter.QuestionConverter;
import hsu.umc.server.entity.Answer;
import hsu.umc.server.entity.Question;
import hsu.umc.server.repository.AnswerRepository;
import hsu.umc.server.repository.QuestionRepository;
import hsu.umc.server.web.dto.QuestionRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class QuestionCommandServiceImpl implements QuestionCommandService{

    private final QuestionRepository questionRepository;
    private final AnswerRepository answerRepository;

    @Override
    @Transactional
    public Question addQuestion(QuestionRequestDto.CreateQuestionRequestDto question) {
        Question newQuestion = QuestionConverter.toQuestion(question);
        return questionRepository.save(newQuestion);
    }

    @Override
    @Transactional
    public void deleteQuestion(Long questionId) {
        Question findQuestion = questionRepository.findById(questionId)
                .orElseThrow(() -> new QuestionHandler(ErrorStatus.QUESTION_NOT_FOUND));
        if(findQuestion.getIsAnswered()){
            Answer answer = findQuestion.getAnswer();
            answerRepository.delete(answer);
        }
        questionRepository.delete(findQuestion);
    }

    @Override
    @Transactional
    public Question updateQuestion(Long questionId, QuestionRequestDto.CreateQuestionRequestDto requestDto) {
        Question findquestion = questionRepository.findById(questionId)
                .orElseThrow(() -> new QuestionHandler(ErrorStatus.QUESTION_NOT_FOUND));

        findquestion.update(requestDto);
        return findquestion;
    }
}
