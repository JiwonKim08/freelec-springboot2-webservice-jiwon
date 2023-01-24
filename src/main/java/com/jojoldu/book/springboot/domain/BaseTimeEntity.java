package com.jojoldu.book.springboot.domain;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

//BaseTimeEntity는 모든 Entity의 상위클래스가 되어 Entity들의 CreatedDate와 ModifiedDate를 자동으로 관리한다.
@Getter
@MappedSuperclass //해당 Entity 상속시, 필드들도 칼럼으로 인식하게 한다.
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseTimeEntity {

    @CreatedDate //Entity 생성 시, 시간 자동 저장
    private LocalDateTime createdDate;

    @LastModifiedDate //Entity 수정 시, 시간 자동 저장
    private LocalDateTime modifiedDate;

}
