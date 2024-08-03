package com.fumanting.common.web.entity.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @ClassName BaseVo
 * @Description TODO
 * @Author zhang zhengdong
 * @DATE 2024/7/26 19:44
 * @Version 1.0
 */
@Data
@NoArgsConstructor
public class BaseVo implements Serializable {

	/**
	 * VO对象唯一id
	 */
	private String id;
}
