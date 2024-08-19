package hsu.umc.server.service;

import hsu.umc.server.apipayload.code.status.ErrorStatus;
import hsu.umc.server.apipayload.exception.handler.AnswerHandler;
import hsu.umc.server.apipayload.exception.handler.QuestionHandler;
import hsu.umc.server.converter.AnswerConverter;
import hsu.umc.server.entity.Answer;
import hsu.umc.server.entity.Question;
import hsu.umc.server.repository.AnswerRepository;
import hsu.umc.server.repository.QuestionRepository;
import hsu.umc.server.web.dto.AnswerRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class AnswerCommandServiceImpl implements AnswerCommandService{
    private final AnswerRepository answerRepository;
    private final QuestionRepository questionRepository;
    @Override
    @Transactional
    public Answer addAnswer(Long questionId, AnswerRequestDto.CreateAnswerRequestDto requestDto){
        Answer newAnswer = AnswerConverter.toAnswer(requestDto);
        Question question =  questionRepository.findById(questionId)
                .orElseThrow(() -> new QuestionHandler(ErrorStatus.QUESTION_NOT_FOUND));
        question.setAnswer(newAnswer);
        question.setAnswered(true);
        return answerRepository.save(newAnswer);
    }

    @Override
    @Transactional
    public Answer updateAnswer(Long questionId, Long answerId, AnswerRequestDto.UpdateRequestDto requestDto) {
        Answer findAnswer = answerRepository.findById(answerId)
                .orElseThrow(() -> new AnswerHandler(ErrorStatus.ANSWER_NOT_FOUND));

        findAnswer.update(requestDto);
        return findAnswer;
    }

    @Override
    @Transactional
    public void deleteAnswer(Long questionId, Long answerId) {
        Answer findAnswer = answerRepository.findById(answerId)
                .orElseThrow(() -> new AnswerHandler(ErrorStatus.ANSWER_NOT_FOUND));

        Question question = questionRepository.findById(questionId)
                .orElseThrow(() -> new QuestionHandler(ErrorStatus.QUESTION_NOT_FOUND));

        if (findAnswer.equals(question.getAnswer())) {
            question.setAnswer(null);
            question.setAnswered(false);
            questionRepository.save(question);
        }

        answerRepository.delete(findAnswer);

    }

}
