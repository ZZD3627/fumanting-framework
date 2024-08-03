package com.fumanting.boot.metadata;

/**
 * @ClassName OpensabreVersion
 * @Description 获取opensabre版本信息
 * @Author zhang zhengdong
 * @DATE 2024/7/29 16:22
 * @Version 1.0
 */
public class OpensabreVersion {
	/**
	 * 私有构造方法，不允许初使化实例
	 */
	private OpensabreVersion() {
	}

	/**
	 * 获取Opensabre版本号
	 *
	 * @return 版本号 如：1.x
	 */
	public static String getVersion() {
		return OpensabreVersion.class.getPackage().getImplementationVersion();
	}

	/**
	 * 获取Opensabre完整版本号
	 *
	 * @return 版本号，如：(v1.x.x)
	 */
	public static String getVersionString() {
		return " (v" + getVersion() + ")";
	}
}
