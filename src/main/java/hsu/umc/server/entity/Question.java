package hsu.umc.server.entity;

import hsu.umc.server.web.dto.QuestionRequestDto;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;


@Entity
@Getter
@Builder
@DynamicUpdate
@DynamicInsert
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Question extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long QuestionId;

    @Enumerated(EnumType.STRING)
    private Category category;

    private String title;

    private String content;

    private Boolean isAnswered;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "answer_id")
    private Answer answer;

    public void update(QuestionRequestDto.CreateQuestionRequestDto request) {
        this.title = request.getTitle();
        this.content = request.getContent();
        this.category = Category.fromValue(request.getCategoryId());
    }
}
