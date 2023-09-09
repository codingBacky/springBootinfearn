package com.backy.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.backy.domain.Member;

public class MemoryMemberRepository implements MemberRepository{

	private static Map<Long, Member> store = new HashMap<>();
	private static Long sequence = 0L;
	
	@Override
	public Member save(Member member) {
		member.setUserId(++sequence);
		store.put(member.getUserId(), member);
		return member;
	}

	@Override
	public Optional<Member> findByUserId(Long userId) {
		return Optional.ofNullable(store.get(userId));
	}

	@Override
	public Optional<Member> findByUserName(String name) {
		return store.values().stream()
			.filter(member -> member.getUserName().equals(name))
			.findAny();
	}

	@Override
	public List<Member> findAll() {

		return new ArrayList<>(store.values());
	}

}
