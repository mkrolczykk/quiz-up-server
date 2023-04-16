package pl.quiz.up.quiz.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;
import java.util.Set;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "quiz_question", schema = "public", catalog = "quiz_db")
public class QuizQuestionEntity {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "question_id")
    private Long questionId;

    @Basic
    @Column(name = "type")
    private String type;

    @Basic
    @Column(name = "question")
    private String question;

    @Basic
    @Column(name = "question_image")
    private byte[] questionImage;

    @Basic
    @Column(name = "score")
    private Short score;

    @Basic
    @Column(name = "difficulty_level")
    private Short difficultyLevel;

    @Basic
    @Column(name = "visible_in_quiz")
    private Boolean visibleInQuiz;

    @Basic
    @Column(name = "created_at")
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp createdAt;

    @Basic
    @Column(name = "updated_at")
    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp updatedAt;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "quizQuestionEntity")
    private Set<QuizAnswerEntity> quizAnswerEntities;

    @ManyToOne
    @JoinColumn(name="quiz_id", nullable=false)
    private QuizEntity quizEntity;

}
