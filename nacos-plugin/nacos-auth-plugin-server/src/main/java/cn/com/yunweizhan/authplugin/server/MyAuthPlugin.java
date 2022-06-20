package cn.com.yunweizhan.authplugin.server;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.nacos.plugin.auth.api.IdentityContext;
import com.alibaba.nacos.plugin.auth.api.Permission;
import com.alibaba.nacos.plugin.auth.api.Resource;
import com.alibaba.nacos.plugin.auth.constant.ActionTypes;
import com.alibaba.nacos.plugin.auth.constant.SignType;
import com.alibaba.nacos.plugin.auth.exception.AccessException;
import com.alibaba.nacos.plugin.auth.spi.server.AuthPluginService;

/**
 * @author Weizhan▪Yun
 * @date 2022/6/19 19:50
 */
public class MyAuthPlugin implements AuthPluginService {
	private static final List<String> IDENTITY_NAMES = Collections.unmodifiableList(Arrays.asList("my-username", "my-passwd"));

	private static final Map<String, String> USER_INFO = new HashMap<>(4);

	private static final Map<String, String> USER_AUTHORITY = new HashMap<>(4);

	static {
		USER_INFO.put("ywz-read1", "read1123");
		USER_INFO.put("ywz-read2", "read2123");

		USER_AUTHORITY.put("ywz-read1", SignType.NAMING);
		USER_AUTHORITY.put("ywz-read2", SignType.CONFIG);
	}

	@Override
	public Collection<String> identityNames() {
		return IDENTITY_NAMES;
	}

	@Override
	public boolean enableAuth(ActionTypes action, String type) {
		return ActionTypes.READ.equals(action) && (SignType.NAMING.equals(type) || SignType.CONFIG.equals(type));
	}

	@Override
	public boolean validateIdentity(IdentityContext identityContext, Resource resource) throws AccessException {
		String passwd = USER_INFO.get(getUserName(identityContext));
		if (null != passwd && passwd.equals(getPasswd(identityContext))) {
			return true;
		}
		return false;
	}

	private Object getPasswd(IdentityContext identityContext) {
		return identityContext.getParameter("my-passwd");
	}

	private Object getUserName(IdentityContext identityContext) {
		return identityContext.getParameter("my-username");
	}

	@Override
	public Boolean validateAuthority(IdentityContext identityContext, Permission permission) throws AccessException {
		if (ActionTypes.READ.toString().equals(permission.getAction())
				&& permission.getResource().getType().equals(USER_AUTHORITY.get(getUserName(identityContext)))) {
			return true;
		}
		return false;
	}

	@Override
	public String getAuthServiceName() {
		return "ywzAuthPluginService";
	}
}
