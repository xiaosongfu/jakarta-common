package com.github.xiaosongfu.jakarta.exception

import com.github.xiaosongfu.jakarta.dto.R
import com.github.xiaosongfu.jakarta.dto.R.Companion.CODE_NOT_FOUND
import com.github.xiaosongfu.jakarta.dto.R.Companion.CODE_SERVICE_ERROR
import com.github.xiaosongfu.jakarta.exception.http.ResourceNotFoundException
import com.github.xiaosongfu.jakarta.exception.service.ServiceException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

/**
 * 全局异常处理器
 */
@RestControllerAdvice
class GlobalExceptionHandler {
    // service error
    @ExceptionHandler(ServiceException::class)
    fun serviceException(e: ResourceNotFoundException): R<Void> {
        e.printStackTrace()
        return R.failed(code = CODE_SERVICE_ERROR)
    }

    // 404
    @ExceptionHandler(ResourceNotFoundException::class)
    fun resourceNotFoundException(e: ResourceNotFoundException): R<Void> {
        e.printStackTrace()
        return R.failed(code = CODE_NOT_FOUND)
    }
}
