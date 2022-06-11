package com.twarre30.memberdirectoryapi.member;

import java.util.Map;
import java.util.HashMap;

import com.twarre30.memberdirectoryapi.exception.ResourceNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
@RestController
@RequestMapping("api/members")
public class MemberController {
  @Autowired
  private MemberService memberService;

  @GetMapping
  @ResponseStatus(HttpStatus.OK)
  public Map<String, Iterable<Member>> list() {
    Iterable<Member> members = memberService.list();
    return createHashPlural(members);
  }

  @GetMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public Map<String, Member> read(@PathVariable Long id) {
    Member member = memberService
        .findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("No member with that ID"));
    return createHashSingular(member);
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public Map<String, Member> create(@Validated @RequestBody Member member) {
    Member createdMember = memberService.create(member);
    return createHashSingular(createdMember);
  }

  @PutMapping("/{id}")
  @ResponseStatus(HttpStatus.CREATED)
  public Map<String, Member> update(@RequestBody Member member, @PathVariable Long id) {
    Member updatedMember = memberService
        .update(member)
        .orElseThrow(() -> new ResourceNotFoundException("No member with that ID"));

    return createHashSingular(updatedMember);
  }

  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void delete(@PathVariable Long id) {
    memberService.deleteById(id);
  }

  private Map<String, Member> createHashSingular(Member member) {
    Map<String, Member> response = new HashMap<String, Member>();
    response.put("member", member);

    return response;
  }

  private Map<String, Iterable<Member>> createHashPlural(Iterable<Member> members) {
    Map<String, Iterable<Member>> response = new HashMap<String, Iterable<Member>>();
    response.put("members", members);

    return response;
  }
}