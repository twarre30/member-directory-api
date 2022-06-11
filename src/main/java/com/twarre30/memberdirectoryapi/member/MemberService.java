package com.twarre30.memberdirectoryapi.member;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
  @Autowired
  private MemberRepository memberRepository;

  public Iterable<Member> list() {
    return memberRepository.findAll();
  }

  public Optional<Member> findById(Long id) {
    return memberRepository.findById(id);
  }

  public Member create(Member member) {
    return memberRepository.save(member);
  }

  public Optional<Member> update(Member member) {
    Optional<Member> foundResource = memberRepository.findById(member.getId());

    if (foundResource.isPresent()) {
      Member updatedResource = foundResource.get();
      updatedResource.setParentName(member.getParentName());
      updatedResource.setDaughterName(member.getDaughterName());
      updatedResource.setAddress(member.getAddress());
      updatedResource.setEmail(member.getEmail());
      updatedResource.setPhoneNumber(member.getPhoneNumber());

      memberRepository.save(updatedResource);
      return Optional.of(updatedResource);
    } else {
      return Optional.empty();
    }
  }

  public void deleteById(Long id) {
    memberRepository.deleteById(id);
  }
}