package com.jf.xuan.api.test;

import io.swagger.annotations.ApiModel;
import lombok.Data;


@Data
@ApiModel
public class TestVo {

    private Long id;

    private String name;
}
