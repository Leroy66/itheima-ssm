package com.itheima.common.enums;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

public interface CommonEnumType {

	public enum ScopeType {
		Private(3, "私有"), Friend(2, "好友可见"), Public(1, "所有人可见"),;
		private final Integer key;
		private final String name;
		static Map<Integer, ScopeType> allScopeTypes;

		static {
			allScopeTypes = new HashMap<Integer, ScopeType>();
			ScopeType[] types = values();
			for (ScopeType type : types) {
				allScopeTypes.put(type.getKey(), type);
			}
		}
		
		private ScopeType(Integer key, String name) {
			this.key = key;
			this.name = name;
		}

		public Integer getKey() {
			return key;
		}

		public String getName() {
			return name;
		}

		public static ScopeType fromKey(Integer id) {
			return allScopeTypes.get(id);
		}

		public static ScopeType fromName(String name) {
			if (StringUtils.isEmpty(name))
				return null;
			return allScopeTypes.get(name);
		}
	}

	
	
}
