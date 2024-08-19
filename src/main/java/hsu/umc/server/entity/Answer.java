package hsu.umc.server.entity;

import hsu.umc.server.web.dto.AnswerRequestDto;
import jakarta.persistence.*;
import lombok.*;


@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Answer extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "answer_id")
    private Long answerId;

    private String content;
    public void update(AnswerRequestDto.UpdateRequestDto request){
        this.content = request.getContent();
    }
}
