package com.github.xiaosongfu.jakarta.exception

import com.github.xiaosongfu.jakarta.dto.R
import com.github.xiaosongfu.jakarta.dto.R.Companion.CODE_NOT_FOUND
import com.github.xiaosongfu.jakarta.dto.R.Companion.MSG_NOT_FOUND
import com.github.xiaosongfu.jakarta.exception.http.ResourceNotFoundException
import com.github.xiaosongfu.jakarta.exception.service.ServiceException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

/**
 * 全局异常处理器
 */
@RestControllerAdvice
class GlobalExceptionHandler {
    // service exception
    @ExceptionHandler(ServiceException::class)
    fun serviceException(e: ServiceException): R<Void> {
        e.printStackTrace()
        return R.failed(code = e.code, msg = e.msg)
    }

    // 404
    @ExceptionHandler(ResourceNotFoundException::class)
    fun resourceNotFoundException(e: ResourceNotFoundException): R<Void> {
        e.printStackTrace()
        return R.failed(code = CODE_NOT_FOUND, msg = MSG_NOT_FOUND)
    }
}
