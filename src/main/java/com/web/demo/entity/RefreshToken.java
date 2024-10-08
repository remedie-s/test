package com.web.demo.entity;

import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class RefreshToken {
	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence_generator4")
	@SequenceGenerator(name = "sequence_generator4", sequenceName = "sequence_name4", allocationSize = 1)
	@Column(name = "id", updatable = false)
	private Long id;
	   // FIXME #REFACT: 기존은 username => 리팩토링후 userId로 대상 칼럼을 변경했음
    @Column(name = "user_id", nullable = false, unique = true)
    private Long userId;
    
    @Column(name = "refresh_token", nullable = false)
    private String refreshToken;
    
    // FIXME #REFACT: 리프레시 토큰 등록일 칼럼 추가
 	private LocalDateTime regDate;
    
    public RefreshToken(Long userId, String refreshToken) {
        this.userId = userId;
        this.refreshToken = refreshToken;
 	   // FIXME #REFACT: 리프레시 토큰 등록일 자동세팅 (현재 시간)
        this.regDate = LocalDateTime.now();
    }
    public RefreshToken update(String newRefreshToken) {
        this.refreshToken = newRefreshToken;

        return this;
    }
}