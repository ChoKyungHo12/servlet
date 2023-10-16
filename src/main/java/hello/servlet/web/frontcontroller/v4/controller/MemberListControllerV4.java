package hello.servlet.web.frontcontroller.v4.controller;

import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepository;
import hello.servlet.web.frontcontroller.v4.ControllerV4;

import java.util.List;
import java.util.Map;

public class MemberListControllerV4 implements ControllerV4 {
    MemberRepository repository = MemberRepository.getInstance();
    @Override
    public String process(Map<String, String> paraMap, Map<String, Object> model) {
        List<Member> members = repository.findALl();
        model.put("members", members);

        return "members";
    }
}
