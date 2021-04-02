package com.github.xiaosongfu.jakarta.exception.service

import com.github.xiaosongfu.jakarta.dto.R.Companion.CODE_SERVICE_ERROR
import com.github.xiaosongfu.jakarta.dto.R.Companion.MSG_FAILED

class ServiceException(val code: Int = CODE_SERVICE_ERROR, val msg: String = MSG_FAILED) : Exception(msg)
