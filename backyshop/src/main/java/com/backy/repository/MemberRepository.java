package com.backy.repository;

import java.util.List;
import java.util.Optional;

import com.backy.domain.Member;

public interface MemberRepository {
	Member save(Member member);
	Optional<Member> findByUserId(Long userId);
	Optional<Member> findByUserName(String userName);
	List<Member> findAll();
}
