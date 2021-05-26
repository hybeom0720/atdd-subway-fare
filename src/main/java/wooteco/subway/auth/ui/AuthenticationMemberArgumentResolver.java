package wooteco.subway.auth.ui;

import org.springframework.core.MethodParameter;
import wooteco.subway.auth.application.AuthService;
import wooteco.subway.auth.domain.AuthenticationMember;
import wooteco.subway.member.domain.LoginMember;

public class AuthenticationMemberArgumentResolver extends AuthenticationArgumentResolver {

    public AuthenticationMemberArgumentResolver(AuthService authService) {
        super(authService);
    }

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.hasParameterAnnotation(AuthenticationMember.class);
    }

    @Override
    public LoginMember validMember(LoginMember member) {
        if (member.getId() == null) {
            return new LoginMember(0L, "Guest", 20);
        }
        return member;
    }
}
