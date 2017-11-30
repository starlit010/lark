package com.gome.lark.role.auth;


import com.gome.lark.common.exception.RRException;
import com.gome.lark.role.auth.annotation.Login;
import com.gome.lark.role.dao.SysMenuDao;
import com.gome.lark.role.dao.SysUserDao;
import com.gome.lark.role.entity.SysUserEntity;
import com.gome.lark.role.utils.JwtUtils;
import io.jsonwebtoken.Claims;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 认证
 * 
 */
@Component
public class UserRealm extends AuthorizingRealm {
    @Autowired
    private SysUserDao sysUserDao;
    @Autowired
    private SysMenuDao sysMenuDao;
    
    /**
     * 授权(验证权限时调用)
     */
//	@Override
//	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
//		SysUserEntity user = (SysUserEntity)principals.getPrimaryPrincipal();
//		Integer userId = user.getUserId();
//
//		List<String> permsList = null;
//
//		//系统管理员，拥有最高权限
//		if(userId == 1){
//			List<SysMenuEntity> menuList = sysMenuDao.queryList(new HashMap<String, Object>());
//			permsList = new ArrayList<>(menuList.size());
//			for(SysMenuEntity menu : menuList){
//				permsList.add(menu.getPerms());
//			}
//		}else{
//			permsList = sysUserDao.queryAllPerms(userId);
//		}
//
//		//用户权限列表
//		Set<String> permsSet = new HashSet<String>();
//		for(String perms : permsList){
//			if(StringUtils.isBlank(perms)){
//				continue;
//			}
//			permsSet.addAll(Arrays.asList(perms.trim().split(",")));
//		}
//
//		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
//		info.setStringPermissions(permsSet);
//		return info;
//	}

//	/**
//	 * 认证(登录时调用)
//	 */
//	@Override
//	protected AuthenticationInfo doGetAuthenticationInfo(
//			AuthenticationToken authcToken) throws AuthenticationException {
//		UsernamePasswordToken token = (UsernamePasswordToken)authcToken;
//
//        //查询用户信息
//        SysUserEntity user = sysUserDao.queryByUserName(token.getUsername());
//
//        //账号不存在
//        if(user == null) {
//            throw new UnknownAccountException("账号或密码不正确");
//        }
//
//        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user, user.getPassword(), ByteSource.Util.bytes(user.getSalt()), getName());
//        return info;
//	}

	@Override
	public void setCredentialsMatcher(CredentialsMatcher credentialsMatcher) {
		HashedCredentialsMatcher shaCredentialsMatcher = new HashedCredentialsMatcher();
		shaCredentialsMatcher.setHashAlgorithmName(ShiroUtils.hashAlgorithmName);
		shaCredentialsMatcher.setHashIterations(ShiroUtils.hashIterations);
		super.setCredentialsMatcher(shaCredentialsMatcher);
	}

	@Autowired
	private JwtUtils jwtUtils;

	public static final String USER_KEY = "userId";

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		Login annotation;
		if (handler instanceof HandlerMethod) {
			annotation = ((HandlerMethod) handler).getMethodAnnotation(Login.class);
		} else {
			return true;
		}

		if (annotation == null) {
			return true;
		}

		//获取用户凭证
		String token = request.getHeader(jwtUtils.getHeader());
		if (StringUtils.isBlank(token)) {
			token = request.getParameter(jwtUtils.getHeader());
		}

		//凭证为空
		if (StringUtils.isBlank(token)) {
			throw new RRException(jwtUtils.getHeader() + "不能为空", HttpStatus.UNAUTHORIZED.value());
		}

		Claims claims = jwtUtils.getClaimByToken(token);
		if (claims == null || jwtUtils.isTokenExpired(claims.getExpiration())) {
			throw new RRException(jwtUtils.getHeader() + "失效，请重新登录", HttpStatus.UNAUTHORIZED.value());
		}

		//设置userId到request里，后续根据userId，获取用户信息
		request.setAttribute(USER_KEY, Long.parseLong(claims.getSubject()));

		return true;
	}


	@Override
	public boolean supports(AuthenticationToken token) {
		return true;
	}

	/**
	 * 授权(验证权限时调用)
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		SysUserEntity user = (SysUserEntity)principals.getPrimaryPrincipal();
		Integer userId = user.getUserId();

		//用户权限列表
//        Set<String> permsSet = shiroService.getUserPermissions(userId);

		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
//        info.setStringPermissions(permsSet);
		return info;
	}

	/**
	 * 认证(登录时调用)
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		String accessToken = (String) token.getPrincipal();

		//根据accessToken，查询用户信息
//        SysUserTokenEntity tokenEntity = shiroService.queryByToken(accessToken);
		//token失效
//        if(tokenEntity == null || tokenEntity.getExpireTime().getTime() < System.currentTimeMillis()){
//            throw new IncorrectCredentialsException("token失效，请重新登录");
//        }
//
//        //查询用户信息
//        SysUserEntity user = shiroService.queryUser(tokenEntity.getUserId());
		SysUserEntity user = null;
//        //账号锁定
//        if(user.getStatus() == 0){
//            throw new LockedAccountException("账号已被锁定,请联系管理员");
//        }

		SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user, accessToken, getName());
		return info;
	}
}
