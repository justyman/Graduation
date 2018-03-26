package cn.zl.shiro;

import cn.zl.domain.Staff;
import cn.zl.service.StaffService;
import cn.zl.utils.Constants;
import cn.zl.utils.SessionUtil;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ShiroDbRealm extends AuthorizingRealm {
    @Autowired
    private StaffService staffService;

    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        return null;
    }

    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
        String username = (String) token.getPrincipal();
        String password = String.valueOf(token.getPassword());
        Staff staff = staffService.login(username, password);
        if(staff != null){
            // 登陆成功的用户存入session
            SessionUtil.setStaffSession(staff);
            return new SimpleAuthenticationInfo(staff, password, getName());
        }else{
            throw new AuthenticationException("账号或密码错误！");
        }
    }
}
