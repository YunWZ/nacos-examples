package cn.com.yunweizhan.authplugin.server;

import com.alibaba.nacos.plugin.auth.api.IdentityContext;
import com.alibaba.nacos.plugin.auth.api.Permission;
import com.alibaba.nacos.plugin.auth.api.Resource;
import com.alibaba.nacos.plugin.auth.constant.ActionTypes;
import com.alibaba.nacos.plugin.auth.constant.SignType;
import com.alibaba.nacos.plugin.auth.exception.AccessException;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Weizhan▪Yun
 * @date 2022/6/19 20:30
 */
class MyAuthPluginTests {
	public static final MyAuthPlugin authPlugin = new MyAuthPlugin();


	@org.junit.jupiter.api.Test
	void enableAuth() {
		assertEquals(Boolean.TRUE, authPlugin.enableAuth(ActionTypes.READ, SignType.CONFIG));
		assertEquals(Boolean.TRUE, authPlugin.enableAuth(ActionTypes.READ, SignType.NAMING));

		assertEquals(Boolean.FALSE, authPlugin.enableAuth(ActionTypes.READ, SignType.CONSOLE));
		assertEquals(Boolean.FALSE, authPlugin.enableAuth(ActionTypes.READ, SignType.SPECIFIED));

		assertEquals(Boolean.FALSE, authPlugin.enableAuth(ActionTypes.WRITE, SignType.NAMING));
		assertEquals(Boolean.FALSE, authPlugin.enableAuth(ActionTypes.WRITE, SignType.CONFIG));
	}

	@org.junit.jupiter.api.Test
	void validateIdentity() throws AccessException {
		IdentityContext identityContext = buildIdentityContext("ywz-read1", "read1123");
		assertEquals(Boolean.TRUE, authPlugin.validateIdentity(identityContext, null));
	}

	private IdentityContext buildIdentityContext(String name, String passwd) {
		IdentityContext identityContext = new IdentityContext();
		identityContext.setParameter("my-username", name);
		identityContext.setParameter("my-passwd", passwd);
		return identityContext;
	}

	@org.junit.jupiter.api.Test
	void validateAuthority() throws AccessException {
		assertEquals(Boolean.TRUE, authPlugin.validateAuthority(buildIdentityContext("ywz-read2", "read2123")
				, buildPermission(SignType.CONFIG, ActionTypes.READ.toString())));
	}

	private Permission buildPermission(String type, String action) {
		return new Permission(new Resource(null, null, null, type, null), action);
	}

}