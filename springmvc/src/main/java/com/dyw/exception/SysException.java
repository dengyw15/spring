package com.dyw.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 自定义异常类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SysException extends Exception{
    private String message;
}
